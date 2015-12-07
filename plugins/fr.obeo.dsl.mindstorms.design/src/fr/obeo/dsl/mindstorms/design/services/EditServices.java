package fr.obeo.dsl.mindstorms.design.services;

import fr.obeo.dsl.mindstorms.Delay;
import fr.obeo.dsl.mindstorms.GoTo;
import fr.obeo.dsl.mindstorms.Rotate;
import fr.obeo.dsl.mindstorms.Travel;

public class EditServices {

	public void editTravel(Travel travel, Object value) {
		String valueOf = String.valueOf(value);
		try {
			int parseInt = Integer.parseInt(valueOf);
			travel.setCm(parseInt);
		} catch (NumberFormatException e) {
			// Do nothing
		}
	}
	
	public void editRotate(Rotate rotate, Object value) {
		String valueOf = String.valueOf(value);
		try {
			int parseInt = Integer.parseInt(valueOf);
			if (parseInt < 360 && parseInt > -360) {
				rotate.setDegrees(parseInt);
				rotate.setRandom(false);
				return;
			}
		} catch (NumberFormatException e) {
			// Do nothing
		}
		if ("random".equalsIgnoreCase(valueOf)) {
			rotate.setRandom(true);
		} else if ("*".equalsIgnoreCase(valueOf)) {
			rotate.setRandom(true);
		}
	}
	
	public void editGoto(GoTo gt, Object value) {
		String valueOf = String.valueOf(value);
		if (valueOf == null) {
			return;
		}
		String[] strings = valueOf.split("\\s");
		try {
			for (int i = 0; i < strings.length; i++) {
				String string = strings[i];
				int parseInt = Integer.parseInt(string);
				if (i == 0) {					
					gt.setX(parseInt);
				} else if (i == 1) {
					gt.setY(parseInt);
				}
				
			}
		} catch (NumberFormatException e) {
			// Do nothing
		}
	}
	
	public void editDelay(Delay delay, Object value) {
		String valueOf = String.valueOf(value);
		try {
			int parseInt = Integer.parseInt(valueOf);
			delay.setMs(parseInt);
		} catch (NumberFormatException e) {
			// Do nothing
		}
	}
}
