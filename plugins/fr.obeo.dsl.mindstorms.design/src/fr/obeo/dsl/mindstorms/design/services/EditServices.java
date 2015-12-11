package fr.obeo.dsl.mindstorms.design.services;

import org.eclipse.emf.ecore.EObject;

import fr.obeo.dsl.mindstorms.Color;
import fr.obeo.dsl.mindstorms.ColorSensor;
import fr.obeo.dsl.mindstorms.Delay;
import fr.obeo.dsl.mindstorms.GoTo;
import fr.obeo.dsl.mindstorms.NamedElement;
import fr.obeo.dsl.mindstorms.Rotate;
import fr.obeo.dsl.mindstorms.Travel;

public class EditServices {

	public void editElement(EObject object, Object value) {
		// Do nothing
	}
	
	public void editElement(NamedElement object, String value) {
		object.setName(value);
	}
	
	public void editElement(Travel travel, Object value) {
		String valueOf = String.valueOf(value);
		try {
			int parseInt = Integer.parseInt(valueOf);
			travel.setCm(parseInt);
		} catch (NumberFormatException e) {
			// Do nothing
		}
	}
	
	public void editElement(Rotate rotate, Object value) {
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
	
	public void editElement(GoTo gt, Object value) {
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
	
	public void editElement(Delay delay, Object value) {
		String valueOf = String.valueOf(value);
		try {
			int parseInt = Integer.parseInt(valueOf);
			delay.setMs(parseInt);
		} catch (NumberFormatException e) {
			// Do nothing
		}
	}
	
	public void editElement(ColorSensor sensor, String value) {
		String colorPart = "";
		String[] valueParts = value.split("\\s");
		if (valueParts.length > 0) {			
			colorPart = valueParts[valueParts.length - 1];
		} else {
			colorPart = value;
		}
		for (Color color : Color.VALUES) {
			if (color.getLiteral().equalsIgnoreCase(colorPart)) {
				sensor.setColor(color);
				break;
			}
		}
	}
}
