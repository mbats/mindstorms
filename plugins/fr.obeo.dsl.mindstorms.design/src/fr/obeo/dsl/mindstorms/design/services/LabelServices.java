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

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import fr.obeo.dsl.mindstorms.Arbitrator;
import fr.obeo.dsl.mindstorms.AvoidObstacle;
import fr.obeo.dsl.mindstorms.Behavior;
import fr.obeo.dsl.mindstorms.Color;
import fr.obeo.dsl.mindstorms.ColorSensor;
import fr.obeo.dsl.mindstorms.Condition;
import fr.obeo.dsl.mindstorms.ConditionContainer;
import fr.obeo.dsl.mindstorms.Delay;
import fr.obeo.dsl.mindstorms.ExploreForward;
import fr.obeo.dsl.mindstorms.GoBackward;
import fr.obeo.dsl.mindstorms.GoForward;
import fr.obeo.dsl.mindstorms.GoTo;
import fr.obeo.dsl.mindstorms.If;
import fr.obeo.dsl.mindstorms.Instruction;
import fr.obeo.dsl.mindstorms.Main;
import fr.obeo.dsl.mindstorms.NamedElement;
import fr.obeo.dsl.mindstorms.Procedure;
import fr.obeo.dsl.mindstorms.ReturnBottleToBase;
import fr.obeo.dsl.mindstorms.ReuseInstruction;
import fr.obeo.dsl.mindstorms.Rotate;
import fr.obeo.dsl.mindstorms.TouchSensor;
import fr.obeo.dsl.mindstorms.UltrasonicSensor;
import fr.obeo.dsl.mindstorms.While;

public class LabelServices {

	public static boolean nameInError(NamedElement element) {
		return nameIsInvalid(element) || nameIsDuplicated(element);
	}

	public static boolean nameIsInvalid(NamedElement element) {
		String name = element.getName();
		if (name != null && name.matches("[a-zA-Z]+[a-zA-Z0-9]*")) {
			return false;
		}
		return true;
	}

	public static boolean nameIsDuplicated(NamedElement element) {
		String name = element.getName();
		if (name == null) {
			return false;
		} else if (element instanceof AvoidObstacle || element instanceof ExploreForward
				|| element instanceof ReturnBottleToBase || element instanceof ReuseInstruction) {
			return false;
		}
		Main main = getMain(element);
		if (main != null) {
			TreeIterator<EObject> eAllContents = main.eAllContents();
			while (eAllContents.hasNext()) {
				EObject next = (EObject) eAllContents.next();
				if (next instanceof NamedElement && !(next instanceof ReuseInstruction) && !next.equals(element)) {
					String nextName = ((NamedElement) next).getName();
					if (name.equals(nextName)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static Main getMain(NamedElement element) {
		EObject container = element.eContainer();
		while (container != null) {
			if (container instanceof Main) {
				return (Main) container;
			} else {
				container = container.eContainer();
			}
		}
		return null;
	}

	public String computeLabel(EObject object) {
		return "";
	}

	public String computeLabel(ConditionContainer object) {
		if (object instanceof Arbitrator) {
			return computeLabel((Arbitrator) object);
		} else if (object instanceof Behavior) {
			return computeLabel((Behavior) object);
		} else if (object instanceof If) {
			return computeLabel((If) object);
		} else if (object instanceof While) {
			return computeLabel((While) object);
		}
		return "";
	}

	public String computeLabel(While object) {
		String label = "While";
		Condition condition = object.getCondition();
		String conditionLabel = computeLabel(condition);
		if (conditionLabel.isEmpty()) {
			label += " <insert condition>";
		} else {
			label += conditionLabel;
		}
		return label;
	}

	public String computeLabel(If object) {
		String label = "If";
		Condition condition = object.getCondition();
		String conditionLabel = computeLabel(condition);
		if (conditionLabel.isEmpty()) {
			label += " <insert condition>";
		} else {
			label += conditionLabel;
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

		label += " " + Math.round(sensor.getValue()) + " cm";

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
		String label = object.getName();
		Condition condition = object.getCondition();
		label += computeLabel(condition);
		return label;
	}

	private String computeLabel(Condition condition) {
		String label = "";
		if (condition instanceof ColorSensor) {
			label += " : " + computeLabel((ColorSensor) condition);
		} else if (condition instanceof UltrasonicSensor) {
			label += " : " + computeLabel((UltrasonicSensor) condition);
		} else if (condition instanceof TouchSensor) {
			label += " : " + computeLabel((TouchSensor) condition);
		}
		return label;
	}

	public String computeLabel(Arbitrator object) {
		String label = object.getName();
		Condition condition = object.getCondition();
		label += computeLabel(condition);
		return label;
	}

	public String computeLabel(ReuseInstruction instruction) {
		Instruction reuse = instruction.getReuse();
		if (reuse instanceof Procedure) {
			return computeLabel((Procedure) reuse);
		} else if (reuse instanceof Behavior) {
			return computeLabel((Behavior) reuse);
		}

		return reuse.getName();
	}

	public String getEditLabel(EObject object) {
		String editLabel = "";
		if (object instanceof Delay) {
			editLabel += ((Delay) object).getMs();
		} else if (object instanceof GoForward) {
			editLabel += ((GoForward) object).getCm();
		} else if (object instanceof GoBackward) {
			editLabel += ((GoBackward) object).getCm();
		} else if (object instanceof GoTo) {
			editLabel += computeLabel((GoTo) object);
		} else if (object instanceof Rotate) {
			editLabel += ((Rotate) object).getDegrees();
		} else if (object instanceof ConditionContainer) {
			editLabel += computeLabel((ConditionContainer) object);
		} else if (object instanceof ReuseInstruction) {
			editLabel += computeLabel((ReuseInstruction) object);
		}else if (object instanceof Procedure) {
			editLabel += computeLabel((Procedure) object);
		}else if (object instanceof Arbitrator) {
			editLabel += computeLabel((Arbitrator) object);
		}else if (object instanceof Behavior) {
			editLabel += computeLabel((Behavior) object);
		}else {
			editLabel += computeLabel(object);
		}
		return editLabel;
	}
}
