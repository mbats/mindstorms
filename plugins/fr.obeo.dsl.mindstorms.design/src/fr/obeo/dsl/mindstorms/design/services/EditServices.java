/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.obeo.dsl.mindstorms.design.services;

import org.eclipse.emf.ecore.EObject;

import fr.obeo.dsl.mindstorms.Color;
import fr.obeo.dsl.mindstorms.ColorSensor;
import fr.obeo.dsl.mindstorms.Delay;
import fr.obeo.dsl.mindstorms.Flow;
import fr.obeo.dsl.mindstorms.GoBackward;
import fr.obeo.dsl.mindstorms.GoForward;
import fr.obeo.dsl.mindstorms.GoTo;
import fr.obeo.dsl.mindstorms.MindstormsFactory;
import fr.obeo.dsl.mindstorms.NamedElement;
import fr.obeo.dsl.mindstorms.OperatorKind;
import fr.obeo.dsl.mindstorms.Rotate;
import fr.obeo.dsl.mindstorms.TouchSensor;
import fr.obeo.dsl.mindstorms.UltrasonicSensor;

public class EditServices {

	public void editElement(EObject object, String value) {
		// Do nothing
	}

	public void editElement(NamedElement object, String value) {
		if (value != null && value.matches("[a-zA-Z]+[a-zA-Z0-9]*")) {
			object.setName(value);
		}
	}

	public void editElement(GoForward travel, String value) {
		String valueOf = String.valueOf(value);
		try {
			int parseInt = Integer.parseInt(valueOf);
			travel.setCm(Math.abs(parseInt));
		} catch (NumberFormatException e) {
			// Do nothing
		}
		if ("infinite".equalsIgnoreCase(valueOf)) {
			travel.setInfinite(true);
		} else if ("*".equalsIgnoreCase(valueOf)) {
			travel.setInfinite(true);
		} else {
			travel.setInfinite(false);
		}
	}

	public void editElement(GoBackward travel, String value) {
		String valueOf = String.valueOf(value);
		try {
			int parseInt = Integer.parseInt(valueOf);
			travel.setCm(Math.abs(parseInt));
		} catch (NumberFormatException e) {
			// Do nothing
		}
		if ("infinite".equalsIgnoreCase(valueOf)) {
			travel.setInfinite(true);
		} else if ("*".equalsIgnoreCase(valueOf)) {
			travel.setInfinite(true);
		} else {
			travel.setInfinite(false);
		}
	}

	public void editElement(Rotate rotate, String value) {
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
		} else {
			rotate.setRandom(false);
		}
	}

	public void editElement(GoTo gt, String value) {
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

	public void editElement(Delay delay, String value) {
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

	public void editElement(Flow f, String value) {
		String condition = value;
		if (value == null || value.isEmpty()) {
			condition = "";
		} else if (value.startsWith("While") || value.startsWith("while")) {
			condition = value.substring(5, value.length()).trim();
		}

		if (condition.startsWith("Color is") || condition.startsWith("color is")) {
			String newColor = condition.substring(8, condition.length()).trim();
			setColorSensorCondition(f, newColor);
		} else if (condition.startsWith("Distance") || condition.startsWith("distance")) {
			String newValue = condition.substring(8, condition.length()).trim();
			setUltrasonicSensorCondition(f, newValue);
		} else if (condition.startsWith("is press") || condition.startsWith("Is press")
				|| condition.startsWith("press") || condition.startsWith("Press")
				|| condition.startsWith("is touch") || condition.startsWith("Is touch")
				|| condition.startsWith("touch") || condition.startsWith("Touch")) {
			setTouchSensorCondition(f);
		} else {
			String trimmedCondition = condition.trim();
			boolean setSuccessful = setColorSensorCondition(f, trimmedCondition);
			if (!setSuccessful) {
				setSuccessful = setUltrasonicSensorCondition(f, trimmedCondition);
			}
		}
	}

	private boolean setUltrasonicSensorCondition(Flow f, String newValue) {
		OperatorKind newOperator = null;
		if (newValue.startsWith(">=")) {
			newOperator = OperatorKind.UPPER_OR_EQUAL;
		} else if (newValue.startsWith("<=")) {
			newOperator = OperatorKind.LOWER_OR_EQUAL;
		} else if (newValue.startsWith("==")) {
			newOperator = OperatorKind.EQUAL;
		} else if (newValue.startsWith("!=")) {
			newOperator = OperatorKind.NOT_EQUAL;
		}

		if (newOperator != null) {
			String nextPart = newValue.substring(2, newValue.length()).trim();
			String[] parts = nextPart.split("\\s");
			String newDistance = "";
			if (parts.length > 0) {
				newDistance = parts[0];
			} else {
				newDistance = nextPart;
			}
			try {
				int parseInt = Integer.parseInt(newDistance);
				UltrasonicSensor sensor = MindstormsFactory.eINSTANCE.createUltrasonicSensor();
				sensor.setOperator(newOperator);
				sensor.setValue(parseInt);
				f.setCondition(sensor);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return false;
	}

	private boolean setColorSensorCondition(Flow f, String newColor) {
		for (Color color : Color.VALUES) {
			if (color.getLiteral().equalsIgnoreCase(newColor)) {
				ColorSensor sensor = MindstormsFactory.eINSTANCE.createColorSensor();
				sensor.setColor(color);
				f.setCondition(sensor);
				return true;
			}
		}
		return false;
	}
	
	private boolean setTouchSensorCondition(Flow f) {
		TouchSensor sensor = MindstormsFactory.eINSTANCE.createTouchSensor();
		sensor.setIsPressed(true);
		f.setCondition(sensor);
		return true;
	}
	
	public boolean isColor(ColorSensor sensor, Color color) {
		return color == sensor.getColor();
	}
}
