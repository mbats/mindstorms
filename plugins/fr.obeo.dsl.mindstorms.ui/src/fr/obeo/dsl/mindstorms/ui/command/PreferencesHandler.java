package fr.obeo.dsl.mindstorms.ui.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.handlers.HandlerUtil;
import org.lejos.ev3.ldt.LeJOSEV3Plugin;
import org.lejos.ev3.ldt.preferences.PreferenceConstants;

public class PreferencesHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("Preferences");
		// Set EV3 default properties
		IPreferenceStore preferenceStore = LeJOSEV3Plugin.getDefault().getPreferenceStore();
		preferenceStore.setDefault(PreferenceConstants.KEY_SEPARATE_JVM, true);
		preferenceStore.setDefault(PreferenceConstants.KEY_NORMAL_RUN_AFTER_UPLOAD, true);
		preferenceStore.setDefault(PreferenceConstants.KEY_TARGET_CONNECT_BY_NAME, true);
		preferenceStore.setDefault(PreferenceConstants.KEY_TARGET_BRICK_NAME, "10.0.1.1");
		
		Shell shell = HandlerUtil.getActiveWorkbenchWindowChecked(event).getShell();
		PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(shell,
				"org.lejos.ev3.ldt.preferences.leJOSEV3PreferencePage", new String[] {}, null);
		if (dialog != null)
			dialog.open();
		return null;
	}

}
