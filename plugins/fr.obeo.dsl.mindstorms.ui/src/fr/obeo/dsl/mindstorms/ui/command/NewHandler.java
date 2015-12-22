package fr.obeo.dsl.mindstorms.ui.command;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallback;
import org.eclipse.sirius.ui.tools.api.project.ModelingProjectManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

import com.google.common.collect.Maps;

import fr.obeo.dsl.mindstorms.Main;
import fr.obeo.dsl.mindstorms.MindstormsFactory;

public class NewHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("New");
		try {
			final IProject project = ModelingProjectManager.INSTANCE.createNewModelingProject("MindstormsProject", true,
					new NullProgressMonitor());

			Option<ModelingProject> modelingProjectOption = ModelingProject.asModelingProject(project);
			if (modelingProjectOption.some()) {
				ModelingProject modelingProject = modelingProjectOption.get();
				final Session session = modelingProject.getSession();
				session.getTransactionalEditingDomain().getCommandStack()
						.execute(new RecordingCommand(session.getTransactionalEditingDomain()) {
							@Override
							protected void doExecute() {

								String semanticModelPath = project.getProject().getFullPath().toOSString()
										+ IPath.SEPARATOR + "robot.mindstorms";
								final URI semanticModelURI = URI.createPlatformResourceURI(semanticModelPath, true);
								Resource res = new ResourceSetImpl().createResource(semanticModelURI);
								// Add the initial model object to the contents.
								final Main rootObject = MindstormsFactory.eINSTANCE.createMain();

								if (rootObject != null) {
									res.getContents().add(rootObject);
								}
								try {
									res.save(Maps.newHashMap());
								} catch (IOException e) {
									e.printStackTrace();
								}

								session.addSemanticResource(semanticModelURI, new NullProgressMonitor());

								enableViewpoints(session, "MindstormsViewpoint");

								session.save(new NullProgressMonitor());

								Collection<DRepresentation> representations = DialectManager.INSTANCE
										.getAllRepresentations(session);
								for (DRepresentation representation : representations) {
									if ("Mindstorms Diagram".equals(representation.getName())) {
										DialectUIManager.INSTANCE.openEditor(session, representation,
												new NullProgressMonitor());
										return;
									}
								}

							}
						});
			}

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static void enableViewpoints(final Session session, final String... viewpointsToActivate) {
		if (session != null) {
			session.getTransactionalEditingDomain().getCommandStack()
					.execute(new RecordingCommand(session.getTransactionalEditingDomain()) {
						@Override
						protected void doExecute() {
							ViewpointSelectionCallback callback = new ViewpointSelectionCallback();

							for (Viewpoint vp : ViewpointRegistry.getInstance().getViewpoints()) {
								for (String viewpoint : viewpointsToActivate) {
									if (viewpoint.equals(vp.getName()))
										callback.selectViewpoint(vp, session, new NullProgressMonitor());
								}
							}
						}
					});
		}
	}

}
