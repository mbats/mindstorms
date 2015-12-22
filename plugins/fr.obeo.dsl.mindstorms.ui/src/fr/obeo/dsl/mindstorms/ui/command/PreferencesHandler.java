package fr.obeo.dsl.mindstorms.ui.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.handlers.HandlerUtil;

public class PreferencesHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("Preferences");
		Shell shell = HandlerUtil.getActiveWorkbenchWindowChecked(event).getShell();
		PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(shell,
				"org.lejos.ev3.ldt.preferences.leJOSEV3PreferencePage", new String[] {}, null);
		if (dialog != null)
			dialog.open();
		return null;
	}

}
