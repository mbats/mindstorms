package fr.obeo.dsl.mindstorms.application;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimElement;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.eclipse.ui.progress.UIJob;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.setInitialSize(new Point(1024, 768));
		configurer.setShowCoolBar(true);
		configurer.setShowStatusLine(false);
		configurer.setTitle("Mindstorms Designer"); //$NON-NLS-1$
		hideQuickAccess();
	}

	@Override
	public void postWindowOpen() {
		super.postWindowOpen();

		IWorkbenchWindowConfigurer workbenchWindowConfigurer = getWindowConfigurer();
		IActionBarConfigurer actionBarConfigurer = workbenchWindowConfigurer.getActionBarConfigurer();
		IMenuManager menuManager = actionBarConfigurer.getMenuManager();

		IContributionItem[] menuItems = menuManager.getItems();
		for (int i = 0; i < menuItems.length; i++) {
			IContributionItem menuItem = menuItems[i];

			// Hack to remove the Run menu - it seems you cannot do this using
			// the "org.eclipse.ui.activities" extension
			if ("org.eclipse.ui.run".equals(menuItem.getId())) {
				menuManager.remove(menuItem);
			}
		}
		menuManager.update(true);
	}

	private void hideQuickAccess() {
		UIJob job = new UIJob("hide quick access") {
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				if (window instanceof WorkbenchWindow) {
					MTrimBar topTrim = ((WorkbenchWindow) window).getTopTrim();
					for (MTrimElement element : topTrim.getChildren()) {
						if ("SearchField".equals(element.getElementId())) {
							((Control) element.getWidget()).dispose();
							break;
						}
					}
				}
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}
}
