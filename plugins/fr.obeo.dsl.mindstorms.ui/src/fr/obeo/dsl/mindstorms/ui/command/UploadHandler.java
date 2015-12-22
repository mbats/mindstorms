package fr.obeo.dsl.mindstorms.ui.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.Naming;
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
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
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
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.ext.base.Option;
import org.lejos.ev3.ldt.actions.ConvertToLeJOSEV3ProjectAction;
import org.lejos.ev3.ldt.container.LeJOSEV3LibContainer;
import org.lejos.ev3.ldt.util.BrickInfo;
import org.lejos.ev3.ldt.util.Discover;
import org.lejos.ev3.ldt.util.LeJOSEV3Util;
import org.lejos.ev3.ldt.util.ToolStarter;

import fr.obeo.dsl.mindstorms.gen.java.main.Main;
import lejos.remote.ev3.RMIMenu;

public class UploadHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("Generate");
		IJavaProject lejosProject = generateCode();

		System.out.println("Upload");
		try {
			upload(lejosProject);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("Run program");
		// run(lejosProject);

		return null;
	}

	private void run(IJavaProject lejosProject) {
		String appName = "Robot";
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

		// IFile iFile = lejosProject.getProject().getFile("Robot.jar");
		// uploadFile(new NullProgressMonitor(),
		// iFile.getRawLocation().makeAbsolute().toFile());
	}

	private void uploadFile(IProgressMonitor progressMonitor, File file) {
		try {
			progressMonitor.beginTask("Uploading files...", IProgressMonitor.UNKNOWN);
			try {
				ToolStarter starter = LeJOSEV3Util.getCachedToolStarter();

				ArrayList<String> args = new ArrayList<String>();
				LeJOSEV3Util.getUploadOpts(args);

				BrickInfo[] bricks = Discover.discover(null);

				if (bricks.length == 0) {
					LeJOSEV3Util.error("No EV3 Found");
				} else {

					RMIMenu menu = (RMIMenu) Naming.lookup("//" + bricks[0].getIPAddress() + "/RemoteMenu");

					args.add(file.getAbsolutePath());

					FileInputStream in = new FileInputStream(file);
					byte[] data = new byte[(int) file.length()];
					in.read(data);
					in.close();
					menu.uploadFile("/home/lejos/programs/" + file.getName(), data);

					LeJOSEV3Util.message("Files have been uploaded successfully");
				}

			} finally {
				progressMonitor.done();
			}
		} catch (Throwable t) {
			if (t instanceof InvocationTargetException)
				t = ((InvocationTargetException) t).getTargetException();

			// log
			LeJOSEV3Util.error("upload of " + file + " failed", t);
		}
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
			e.printStackTrace();
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

	// public static void addLeJOSEV3Nature(IProject project) throws
	// CoreException {
	// IProjectDescription description = project.getDescription();
	//
	// LinkedHashSet<String> newNatures = new LinkedHashSet<String>();
	// newNatures.add(LeJOSEV3Nature.ID);
	// newNatures.addAll(Arrays.asList(description.getNatureIds()));
	//
	// String[] tmp = new String[newNatures.size()];
	// newNatures.toArray(tmp);
	// description.setNatureIds(tmp);
	// project.setDescription(description, null);
	// }
	//
	// private void setEV3Home() {
	// IEclipsePreferences store = new
	// DefaultScope().getNode(LeJOSEV3Plugin.ID);
	// // TODO MEB Get from mindstorm preference
	// String ev3Home =
	// "/home/melanie/Obeo/dev/programs/lejos/leJOS_EV3_0.9.0-beta";
	// if (ev3Home != null)
	// store.put(PreferenceConstants.KEY_EV3_HOME, ev3Home);
	// }
	//
	// /**
	// * update the project's classpath with additional leJOS libraries.
	// *
	// * @param aProject
	// * a java project
	// */
	// private void updateClasspath(IJavaProject project) throws
	// JavaModelException, LeJOSEV3Exception {
	// File ev3Home = LeJOSEV3Util.getEV3Home();
	// ArrayList<File> tmp = new ArrayList<File>();
	// LeJOSEV3Util.buildEV3Classpath(ev3Home, tmp);
	// LinkedHashSet<IPath> ev3Files = new LinkedHashSet<IPath>();
	// for (File e : tmp)
	// ev3Files.add(LeJOSEV3Util.toPath(e));
	//
	// ev3Files.add(LeJOSEV3Util.toPath(new File(ev3Home, LeJOSEV3Util.LIBDIR +
	// "/ev3classes.jar")));
	// ev3Files.add(LeJOSEV3Util.toPath(new File(ev3Home, LeJOSEV3Util.LIBDIR +
	// "/dbusjava.jar")));
	//
	// // create new classpath with additional leJOS libraries last
	// ArrayList<IClasspathEntry> newClasspath = new
	// ArrayList<IClasspathEntry>();
	// Path lcp = new Path(LeJOSEV3LibContainer.ID);
	// IClasspathEntry lc = JavaCore.newContainerEntry(lcp);
	//
	// // get existing classpath
	// IClasspathEntry[] existingClasspath = project.getRawClasspath();
	// for (IClasspathEntry cpEntry : existingClasspath) {
	// boolean skip = false;
	// boolean insertBefore = false;
	// switch (cpEntry.getEntryKind()) {
	// case IClasspathEntry.CPE_CONTAINER:
	// IPath p = cpEntry.getPath();
	// if (p != null && p.segmentCount() > 0) {
	// String s = p.segment(0);
	// if (s.equals(LeJOSEV3LibContainer.ID)) {
	// // skip leJOS container
	// skip = true;
	// }
	// }
	// insertBefore = true;
	// break;
	// case IClasspathEntry.CPE_LIBRARY:
	// if (ev3Files.contains(cpEntry.getPath().makeAbsolute())) {
	// skip = true;
	// }
	// insertBefore = true;
	// break;
	// case IClasspathEntry.CPE_PROJECT:
	// case IClasspathEntry.CPE_VARIABLE:
	// insertBefore = true;
	// default:
	// skip = false;
	//
	// }
	//
	// if (insertBefore && lc != null) {
	// newClasspath.add(lc);
	// lc = null;
	// }
	// if (!skip) {
	// newClasspath.add(cpEntry);
	// }
	// }
	//
	// if (lc != null)
	// newClasspath.add(lc);
	//
	// // set new classpath to project
	// IClasspathEntry[] cpEntries = newClasspath.toArray(new
	// IClasspathEntry[newClasspath.size()]);
	// project.setRawClasspath(cpEntries, null);
	// }

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
					e.printStackTrace();
				}
			}
		}
		// Reactivate acceleo notificaitons
		AcceleoPreferences.switchForceDeactivationNotifications(oldNotificationsPref);

		// Refresh project
		try {
			lejosProject.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return lejosProject;
	}

}