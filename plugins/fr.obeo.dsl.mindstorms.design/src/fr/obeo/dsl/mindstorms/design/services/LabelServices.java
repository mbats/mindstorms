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
import fr.obeo.dsl.mindstorms.If;
import fr.obeo.dsl.mindstorms.Instruction;
import fr.obeo.dsl.mindstorms.Procedure;
import fr.obeo.dsl.mindstorms.ReuseInstruction;
import fr.obeo.dsl.mindstorms.Rotate;
import fr.obeo.dsl.mindstorms.Timer;
import fr.obeo.dsl.mindstorms.TouchSensor;
import fr.obeo.dsl.mindstorms.UltrasonicSensor;
import fr.obeo.dsl.mindstorms.While;

public class LabelServices {

	public String computeLabel(EObject object) {
		return "";
	}
	
	public String computeLabel(While object) {
		String label = "While";
		Condition condition = object.getCondition();
		if (condition instanceof Timer) {
			label +=  " " + computeLabel((Timer)condition);
		} else if (condition instanceof ColorSensor) {
			label +=  " " + computeLabel((ColorSensor)condition);
		} else if (condition instanceof UltrasonicSensor) {
			label +=  " " + computeLabel((UltrasonicSensor)condition);
		} else if (condition instanceof TouchSensor) {
			label +=  " " + computeLabel((TouchSensor)condition);
		} else {
			label += " <insert condition>";
		}
		return label;
	}
	
	public String computeLabel(If object) {
		String label = "If";
		Condition condition = object.getCondition();
		if (condition instanceof Timer) {
			label +=  " " + computeLabel((Timer)condition);
		} else if (condition instanceof ColorSensor) {
			label +=  " " + computeLabel((ColorSensor)condition);
		} else if (condition instanceof UltrasonicSensor) {
			label +=  " " + computeLabel((UltrasonicSensor)condition);
		} else if (condition instanceof TouchSensor) {
			label +=  " " + computeLabel((TouchSensor)condition);
		} else {
			label += " <insert condition>";
		}
		return label;
	}
	
	public String computeLabel(Delay delay) {
		return "" + delay.getMs() + " ms";
	}
	
	public String computeLabel(GoTo block) {
		return block.getX() + " ; " + block.getY();
	}
	
	public String computeLabel(Rotate block) {
		if (block.isRandom()) {
			return "?";
		}
		return "" + block.getDegrees() + "°";
	}
	
	public String computeLabel(GoForward block) {
		if (block.isInfinite()) {
			return "\u221e";
		}
		return "" + block.getCm() + " cm";
	}
	
	public String computeLabel(GoBackward block) {
		if (block.isInfinite()) {
			return "\u221e";
		}
		return "-" + block.getCm() + " cm";
	}
	
	public String computeLabel(Timer timer) {
		return "Timer : " + timer.getValue() + " ms";
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
	
	public String computeLabel(TouchSensor sensor) {
		return "touch sensor is pressed";
	}
	
	public String computeLabel(Procedure object) {
		return object.getName();
	}
	
	public String computeLabel(Behavior object) {
		return object.getName();
	}
	
	public String computeLabel(ReuseInstruction instruction) {
		Instruction reuse = instruction.getReuse();
		if (reuse instanceof Procedure) {			
			return "Reuse " + computeLabel((Procedure)reuse);
		} else if (reuse instanceof Behavior) {			
			return "Reuse " + computeLabel((Behavior)reuse);
		}
		
		return "Reuse " + reuse.getName();
	}
}
