package fr.obeo.dsl.mindstorms.ui.testers;

import java.util.Collection;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.lejos.ev3.ldt.LeJOSEV3Plugin;
import org.lejos.ev3.ldt.preferences.PreferenceConstants;

public class MindstormsPropertyTester extends PropertyTester {

	public MindstormsPropertyTester() {
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if ("validSession".equals(property)) {
			Collection<Session> sessions = SessionManager.INSTANCE.getSessions();
			return sessions.size() > 0;
		}
		if ("isDirty".equals(property)) {
			IEditorReference[] editors = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.getEditorReferences();
			for (IEditorReference editor : editors) {
				if (editor.isDirty()) {
					return true;
				}
			}
		}
		if ("isNotDirty".equals(property)) {
			IEditorReference[] editors = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.getEditorReferences();
			for (IEditorReference editor : editors) {
				if (editor.isDirty()) {
					return false;
				}
			}
			return true;
		}
		if ("validEV3Home".equals(property)) {
			String ev3Home = LeJOSEV3Plugin.getDefault().getPreferenceStore()
					.getString(PreferenceConstants.KEY_EV3_HOME);
			return ev3Home != null && !ev3Home.isEmpty();
		}
		return false;
	}

}
