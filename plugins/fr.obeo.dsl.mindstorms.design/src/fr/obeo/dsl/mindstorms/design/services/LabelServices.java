package fr.obeo.dsl.mindstorms.design.services;

import org.eclipse.emf.ecore.EObject;

import fr.obeo.dsl.mindstorms.Color;
import fr.obeo.dsl.mindstorms.ColorSensor;
import fr.obeo.dsl.mindstorms.Condition;
import fr.obeo.dsl.mindstorms.Delay;
import fr.obeo.dsl.mindstorms.GoBackward;
import fr.obeo.dsl.mindstorms.GoForward;
import fr.obeo.dsl.mindstorms.GoTo;
import fr.obeo.dsl.mindstorms.Grab;
import fr.obeo.dsl.mindstorms.If;
import fr.obeo.dsl.mindstorms.NamedElement;
import fr.obeo.dsl.mindstorms.Release;
import fr.obeo.dsl.mindstorms.ReturnToBase;
import fr.obeo.dsl.mindstorms.Rotate;
import fr.obeo.dsl.mindstorms.Travel;
import fr.obeo.dsl.mindstorms.UltrasonicSensor;
import fr.obeo.dsl.mindstorms.While;

public class LabelServices {

	public String computeLabel(EObject object) {
		return "";
	}
	
	public String computeLabel(NamedElement object) {
		return object.getName();
	}
	
	public String computeLabel(While object) {
		String label = "While";
		Condition condition = object.getCondition();
		if (condition != null) {
			label +=  " " + computeLabel(condition);
		}
		return label;
	}
	
	public String computeLabel(If object) {
		return "If";
	}
	
	public String computeLabel(Delay object) {
		return "Delay of " + object.getMs() + " ms";
	}

	public String computeLabel(GoBackward object) {
		return "Go backward";
	}

	public String computeLabel(GoForward block) {
		return "Go forward";
	}
	
	public String computeLabel(GoTo block) {
		return "Go to (" + block.getX() + " ; " + block.getY() + ')';
	}
	
	public String computeLabel(Grab block) {
		return "Grab";
	}
	
	public String computeLabel(Release block) {
		return "Release";
	}
	
	public String computeLabel(ReturnToBase block) {
		return "Return to base";
	}
	
	public String computeLabel(Rotate block) {
		if (block.isRandom()) {
			return "Rotate randomly between 0 and 360°";
		}
		return "Rotate of " + block.getDegrees() + "°";
	}
	
	public String computeLabel(Travel block) {
		return "Travel " + block.getCm() + " cm";
	}
	
	public String computeLabel(UltrasonicSensor sensor) {
		String label = "Distance ";
		switch (sensor.getOperator()) {
		case EQUAL:
			label += "==";
			break;
		case LOWER_OR_EQUAL:
			label += "<=";
			break;
		case UPPER_OR_EQUAL:
			label += ">=";
			break;
		case NOT_EQUAL:
			label += "!=";
			break;
		default:
			label += "";
			break;
		}
		
		label += " " + sensor.getValue() + " cm";
		
		return label;
	}
	
	public String computeLabel(ColorSensor sensor) {
		String label = "Color is ";
		Color color = sensor.getColor();
		if (color != null) {
			label += color.getLiteral().toLowerCase();
		}
		return label;
	}
}
