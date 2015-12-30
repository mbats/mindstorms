package fr.obeo.dsl.mindstorms.ui.command;

import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.tools.api.project.ModelingProjectManager;
import org.eclipse.sirius.viewpoint.DRepresentation;

public class OpenHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("Open");
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
			e.printStackTrace();
		}
		return null;
	}

}
