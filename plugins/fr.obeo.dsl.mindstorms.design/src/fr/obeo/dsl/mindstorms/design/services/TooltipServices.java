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

import fr.obeo.dsl.mindstorms.Behavior;
import fr.obeo.dsl.mindstorms.Color;
import fr.obeo.dsl.mindstorms.ColorSensor;
import fr.obeo.dsl.mindstorms.Condition;
import fr.obeo.dsl.mindstorms.Delay;
import fr.obeo.dsl.mindstorms.GoBackward;
import fr.obeo.dsl.mindstorms.GoForward;
import fr.obeo.dsl.mindstorms.GoTo;
import fr.obeo.dsl.mindstorms.Grab;
import fr.obeo.dsl.mindstorms.If;
import fr.obeo.dsl.mindstorms.Instruction;
import fr.obeo.dsl.mindstorms.NamedElement;
import fr.obeo.dsl.mindstorms.Procedure;
import fr.obeo.dsl.mindstorms.Release;
import fr.obeo.dsl.mindstorms.ReturnToBase;
import fr.obeo.dsl.mindstorms.ReuseInstruction;
import fr.obeo.dsl.mindstorms.Rotate;
import fr.obeo.dsl.mindstorms.TouchSensor;
import fr.obeo.dsl.mindstorms.UltrasonicSensor;
import fr.obeo.dsl.mindstorms.While;

public class TooltipServices {

	public String computeTooltip(EObject object) {
		return "";
	}
	
	public String computeTooltip(NamedElement object) {
		String tooltip = object.getName();
		if (LabelServices.nameIsInvalid(object)) {
			tooltip += " : Invalid name !";
		} else if (LabelServices.nameIsDuplicated(object)) {
			tooltip += " : Duplicated name !";
		}
		return tooltip;
	}
	
	public String computeTooltip(While object) {
		String label = "While";
		Condition condition = object.getCondition();
		if (condition instanceof ColorSensor) {
			label +=  " " + computeTooltip((ColorSensor)condition);
		} else if (condition instanceof UltrasonicSensor) {
			label +=  " " + computeTooltip((UltrasonicSensor)condition);
		} else if (condition instanceof TouchSensor) {
			label +=  " " + computeTooltip((TouchSensor)condition);
		} else {
			label += " <insert condition>";
		}
		return label;
	}
	
	public String computeTooltip(If object) {
		String label = "If";
		Condition condition = object.getCondition();
		if (condition instanceof ColorSensor) {
			label +=  " " + computeTooltip((ColorSensor)condition);
		} else if (condition instanceof UltrasonicSensor) {
			label +=  " " + computeTooltip((UltrasonicSensor)condition);
		} else if (condition instanceof TouchSensor) {
			label +=  " " + computeTooltip((TouchSensor)condition);
		} else {
			label += " <insert condition>";
		}
		return label;
	}
	
	public String computeTooltip(Delay object) {
		return "Delay of " + object.getMs() + " ms";
	}

	public String computeTooltip(GoTo block) {
		return "Go to (" + block.getX() + " ; " + block.getY() + ")";
	}
	
	public String computeTooltip(Grab block) {
		return "Grab";
	}
	
	public String computeTooltip(Release block) {
		return "Release";
	}
	
	public String computeTooltip(ReturnToBase block) {
		return "Return to base";
	}
	
	public String computeTooltip(Rotate block) {
		if (block.isRandom()) {
			return "Rotate randomly between 0 and 360°";
		}
		return "Rotate of " + block.getDegrees() + "°";
	}
	
	public String computeTooltip(GoForward block) {
		if (block.isInfinite()) {
			return "Go forward indefinitely";
		}
		return "Go forward on " + block.getCm() + " cm";
	}
	
	public String computeTooltip(GoBackward block) {
		if (block.isInfinite()) {
			return "Go backward indefinitely";
		}
		return "Go backward on " + block.getCm() + " cm";
	}
	
	public String computeTooltip(UltrasonicSensor sensor) {
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
	
	public String computeTooltip(ColorSensor sensor) {
		String label = "Color is ";
		Color color = sensor.getColor();
		if (color != null) {
			label += color.getLiteral().toLowerCase();
		}
		return label;
	}
	
	public String computeTooltip(TouchSensor sensor) {
		return "touch sensor is pressed";
	}
	
	public String computeTooltip(ReuseInstruction instruction) {
		Instruction reuse = instruction.getReuse();
		if (reuse instanceof Procedure) {			
			return "Reuse " + computeTooltip((Procedure)reuse);
		} else if (reuse instanceof Behavior) {			
			return "Reuse " + computeTooltip((Behavior)reuse);
		}
		
		return "Reuse " + reuse.getName();
	}
}
