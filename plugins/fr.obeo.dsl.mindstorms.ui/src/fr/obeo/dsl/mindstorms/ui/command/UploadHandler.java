package fr.obeo.dsl.mindstorms.ui.command;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.acceleo.common.preference.AcceleoPreferences;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.environments.IExecutionEnvironment;
import org.eclipse.jdt.launching.environments.IExecutionEnvironmentsManager;
import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.ui.PlatformUI;
import org.lejos.ev3.ldt.actions.ConvertToLeJOSEV3ProjectAction;
import org.lejos.ev3.ldt.container.LeJOSEV3LibContainer;

import fr.obeo.dsl.mindstorms.gen.java.main.Main;
import fr.obeo.dsl.mindstorms.ui.MindstormsUiActivator;

public class UploadHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		try {
			dialog.run(true, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) {
					monitor.beginTask("Upload the code to the robot...", 100);
					monitor.subTask("Generate");
					IJavaProject lejosProject = generateCode();
					monitor.worked(33);
					// Build
					monitor.subTask("Build");
					try {
						ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.FULL_BUILD,
								new NullProgressMonitor());
					} catch (CoreException e) {
						MindstormsUiActivator.log(Status.ERROR, "Build failed", e);
					}
					monitor.worked(33);

					monitor.subTask("Upload");
					try {
						upload(lejosProject);
					} catch (CoreException e) {
						MindstormsUiActivator.log(Status.ERROR, "Upload failed", e);
					}
					monitor.done();
				}
			});
		} catch (InvocationTargetException e) {
			MindstormsUiActivator.log(Status.ERROR, "Upload cannot be invoked", e);
		} catch (InterruptedException e) {
			MindstormsUiActivator.log(Status.ERROR, "Upload was interrupted", e);
		}

		return null;
	}

	private void upload(IJavaProject lejosProject) throws CoreException {
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = manager.getLaunchConfigurationType("org.lejos.ev3.ldt.LaunchType");
		ILaunchConfiguration[] configurations = manager.getLaunchConfigurations(type);
		for (int i = 0; i < configurations.length; i++) {
			ILaunchConfiguration configuration = configurations[i];
			if (configuration.getName().equals("Start Robot")) {
				configuration.delete();
				break;
			}
		}
		ILaunchConfigurationWorkingCopy wc = type.newInstance(null, "Start Robot");
		wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME, lejosProject.getElementName());
		wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, "fr.obeo.dsl.mindstorms.robot.Robot");
		ILaunchConfiguration config = wc.doSave();
		config.launch(ILaunchManager.RUN_MODE, null);
	}

	private IJavaProject createLejosProject() {
		IProgressMonitor progressMonitor = new NullProgressMonitor();
		IJavaProject javaProject = null;
		try {
			javaProject = createJavaProject(progressMonitor);

			IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
			Path lcp = new Path(LeJOSEV3LibContainer.ID);
			int len = oldEntries.length;
			IClasspathEntry[] newEntries = new IClasspathEntry[len + 1];
			System.arraycopy(oldEntries, 0, newEntries, 0, len);
			newEntries[len] = JavaCore.newContainerEntry(lcp);
			javaProject.setRawClasspath(newEntries, progressMonitor);

			ConvertToLeJOSEV3ProjectAction.addLeJOSEV3Nature(javaProject.getProject());
		} catch (CoreException e) {
			MindstormsUiActivator.log(Status.ERROR, "Lejos project creation failed", e);
		}

		return javaProject;
	}

	@SuppressWarnings("unchecked")
	private IJavaProject createJavaProject(IProgressMonitor progressMonitor) throws CoreException, JavaModelException {
		// Create an IProject
		IWorkspaceRoot wsRoot = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = wsRoot.getProject("LejosProject");
		if (!project.exists()) {
			project.create(progressMonitor);
		}
		project.open(null);

		// Create source folder
		IPath srcPath = new Path("src");
		IFolder srcFolder = project.getFolder(srcPath);
		if (!srcFolder.exists()) {
			srcFolder.create(true, true, null);
		}

		// Configure the classpath entries
		List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
		entries.add(JavaCore.newSourceEntry(project.getFullPath().append(srcPath)));
		// Let's add JavaSE-1.7 to our classpath
		IExecutionEnvironmentsManager executionEnvironmentsManager = JavaRuntime.getExecutionEnvironmentsManager();
		IExecutionEnvironment[] executionEnvironments = executionEnvironmentsManager.getExecutionEnvironments();
		for (IExecutionEnvironment iExecutionEnvironment : executionEnvironments) {
			// We will look for JavaSE-1.7 as the JRE container to add to our
			// classpath
			if ("JavaSE-1.7".equals(iExecutionEnvironment.getId())) {
				entries.add(JavaCore.newContainerEntry(JavaRuntime.newJREContainerPath(iExecutionEnvironment)));
				break;
			}
		}

		// Convert to Java project
		IJavaProject javaProject = JavaCore.create(project);

		// Set Java nature
		IProjectDescription description = project.getDescription();
		description.setNatureIds(new String[] { JavaCore.NATURE_ID });
		project.setDescription(description, null);

		// Create output folder
		IPath binPath = new Path(
				PreferenceConstants.getPreferenceStore().getString(PreferenceConstants.SRCBIN_BINNAME));
		IFolder binFolder = project.getFolder(binPath);
		if (!binFolder.exists()) {
			binFolder.create(IResource.FORCE | IResource.DERIVED, true, null);
		}
		binFolder.setDerived(true, progressMonitor);

		// Refresh project
		project.refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);

		// Set the classpath on the java project
		javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), progressMonitor);

		@SuppressWarnings("rawtypes")
		Map javaOptions = javaProject.getOptions(false);
		javaOptions.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_7);
		javaOptions.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_7);
		javaOptions.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_7);
		javaOptions.put(JavaCore.COMPILER_PB_ASSERT_IDENTIFIER, JavaCore.ERROR);
		javaOptions.put(JavaCore.COMPILER_PB_ENUM_IDENTIFIER, JavaCore.ERROR);
		javaProject.setOptions(javaOptions);

		return javaProject;
	}

	private IJavaProject generateCode() {
		// Create lejos project
		IJavaProject lejosProject = createLejosProject();

		// Get src folder
		IFolder iSrcFolder = lejosProject.getProject().getFolder("src");
		File srcFolder = iSrcFolder.getRawLocation().makeAbsolute().toFile();

		IWorkspaceRoot wsRoot = ResourcesPlugin.getWorkspace().getRoot();
		IProject modelProject = wsRoot.getProject("MindstormsProject");

		// Unactivate acceleo notifications
		boolean oldNotificationsPref = AcceleoPreferences.areNotificationsForcedDisabled();
		AcceleoPreferences.switchForceDeactivationNotifications(true);
		Option<ModelingProject> modelingProjectOption = ModelingProject.asModelingProject(modelProject);
		if (modelingProjectOption.some()) {
			// Get main
			ModelingProject modelingProject = modelingProjectOption.get();
			Collection<Resource> semanticResources = modelingProject.getSession().getSemanticResources();
			for (Resource semanticResource : semanticResources) {
				try {
					Main generator = new Main(semanticResource.getURI(), srcFolder, new ArrayList<Object>());
					// Run generation
					generator.doGenerate(new BasicMonitor());
					break;
				} catch (IOException e) {
					MindstormsUiActivator.log(Status.ERROR, "Code generation failed", e);
				}
			}
		}
		// Reactivate acceleo notificaitons
		AcceleoPreferences.switchForceDeactivationNotifications(oldNotificationsPref);

		// Refresh project
		try {
			lejosProject.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			MindstormsUiActivator.log(Status.ERROR, "Refresh project failed", e);
		}
		return lejosProject;
	}

}