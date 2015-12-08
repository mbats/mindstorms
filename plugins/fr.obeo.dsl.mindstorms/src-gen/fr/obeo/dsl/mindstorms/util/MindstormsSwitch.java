/**
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.obeo.dsl.mindstorms.util;

import fr.obeo.dsl.mindstorms.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see fr.obeo.dsl.mindstorms.MindstormsPackage
 * @generated
 */
public class MindstormsSwitch<T> extends Switch<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2015 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MindstormsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MindstormsSwitch() {
		if (modelPackage == null) {
			modelPackage = MindstormsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MindstormsPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.MAIN: {
				Main main = (Main)theEObject;
				T result = caseMain(main);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.INSTRUCTION: {
				Instruction instruction = (Instruction)theEObject;
				T result = caseInstruction(instruction);
				if (result == null) result = caseNamedElement(instruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.PROCEDURE: {
				Procedure procedure = (Procedure)theEObject;
				T result = caseProcedure(procedure);
				if (result == null) result = caseInstruction(procedure);
				if (result == null) result = caseNamedElement(procedure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.ARBITRATOR: {
				Arbitrator arbitrator = (Arbitrator)theEObject;
				T result = caseArbitrator(arbitrator);
				if (result == null) result = caseInstruction(arbitrator);
				if (result == null) result = caseNamedElement(arbitrator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.BEHAVIOR: {
				Behavior behavior = (Behavior)theEObject;
				T result = caseBehavior(behavior);
				if (result == null) result = caseNamedElement(behavior);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.REUSE_INSTRUCTION: {
				ReuseInstruction reuseInstruction = (ReuseInstruction)theEObject;
				T result = caseReuseInstruction(reuseInstruction);
				if (result == null) result = caseInstruction(reuseInstruction);
				if (result == null) result = caseNamedElement(reuseInstruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.BLOCK: {
				Block block = (Block)theEObject;
				T result = caseBlock(block);
				if (result == null) result = caseInstruction(block);
				if (result == null) result = caseNamedElement(block);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = caseBlock(action);
				if (result == null) result = caseInstruction(action);
				if (result == null) result = caseNamedElement(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.FLOW: {
				Flow flow = (Flow)theEObject;
				T result = caseFlow(flow);
				if (result == null) result = caseBlock(flow);
				if (result == null) result = caseInstruction(flow);
				if (result == null) result = caseNamedElement(flow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.SENSOR: {
				Sensor sensor = (Sensor)theEObject;
				T result = caseSensor(sensor);
				if (result == null) result = caseNamedElement(sensor);
				if (result == null) result = caseCondition(sensor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.CONDITION: {
				Condition condition = (Condition)theEObject;
				T result = caseCondition(condition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.BINARY_CONDITION: {
				BinaryCondition binaryCondition = (BinaryCondition)theEObject;
				T result = caseBinaryCondition(binaryCondition);
				if (result == null) result = caseCondition(binaryCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.UNARY_CONDITION: {
				UnaryCondition unaryCondition = (UnaryCondition)theEObject;
				T result = caseUnaryCondition(unaryCondition);
				if (result == null) result = caseCondition(unaryCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.IF: {
				If if_ = (If)theEObject;
				T result = caseIf(if_);
				if (result == null) result = caseFlow(if_);
				if (result == null) result = caseBlock(if_);
				if (result == null) result = caseInstruction(if_);
				if (result == null) result = caseNamedElement(if_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.WHILE: {
				While while_ = (While)theEObject;
				T result = caseWhile(while_);
				if (result == null) result = caseFlow(while_);
				if (result == null) result = caseBlock(while_);
				if (result == null) result = caseInstruction(while_);
				if (result == null) result = caseNamedElement(while_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.TRAVEL: {
				Travel travel = (Travel)theEObject;
				T result = caseTravel(travel);
				if (result == null) result = caseAction(travel);
				if (result == null) result = caseBlock(travel);
				if (result == null) result = caseInstruction(travel);
				if (result == null) result = caseNamedElement(travel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.GO_FORWARD: {
				GoForward goForward = (GoForward)theEObject;
				T result = caseGoForward(goForward);
				if (result == null) result = caseAction(goForward);
				if (result == null) result = caseBlock(goForward);
				if (result == null) result = caseInstruction(goForward);
				if (result == null) result = caseNamedElement(goForward);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.GO_BACKWARD: {
				GoBackward goBackward = (GoBackward)theEObject;
				T result = caseGoBackward(goBackward);
				if (result == null) result = caseAction(goBackward);
				if (result == null) result = caseBlock(goBackward);
				if (result == null) result = caseInstruction(goBackward);
				if (result == null) result = caseNamedElement(goBackward);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.ROTATE: {
				Rotate rotate = (Rotate)theEObject;
				T result = caseRotate(rotate);
				if (result == null) result = caseAction(rotate);
				if (result == null) result = caseBlock(rotate);
				if (result == null) result = caseInstruction(rotate);
				if (result == null) result = caseNamedElement(rotate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.GO_TO: {
				GoTo goTo = (GoTo)theEObject;
				T result = caseGoTo(goTo);
				if (result == null) result = caseAction(goTo);
				if (result == null) result = caseBlock(goTo);
				if (result == null) result = caseInstruction(goTo);
				if (result == null) result = caseNamedElement(goTo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.RETURN_TO_BASE: {
				ReturnToBase returnToBase = (ReturnToBase)theEObject;
				T result = caseReturnToBase(returnToBase);
				if (result == null) result = caseAction(returnToBase);
				if (result == null) result = caseBlock(returnToBase);
				if (result == null) result = caseInstruction(returnToBase);
				if (result == null) result = caseNamedElement(returnToBase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.GRAB: {
				Grab grab = (Grab)theEObject;
				T result = caseGrab(grab);
				if (result == null) result = caseAction(grab);
				if (result == null) result = caseBlock(grab);
				if (result == null) result = caseInstruction(grab);
				if (result == null) result = caseNamedElement(grab);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.RELEASE: {
				Release release = (Release)theEObject;
				T result = caseRelease(release);
				if (result == null) result = caseAction(release);
				if (result == null) result = caseBlock(release);
				if (result == null) result = caseInstruction(release);
				if (result == null) result = caseNamedElement(release);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.DELAY: {
				Delay delay = (Delay)theEObject;
				T result = caseDelay(delay);
				if (result == null) result = caseAction(delay);
				if (result == null) result = caseBlock(delay);
				if (result == null) result = caseInstruction(delay);
				if (result == null) result = caseNamedElement(delay);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.AVOID_OBSTACLE: {
				AvoidObstacle avoidObstacle = (AvoidObstacle)theEObject;
				T result = caseAvoidObstacle(avoidObstacle);
				if (result == null) result = caseBehavior(avoidObstacle);
				if (result == null) result = caseNamedElement(avoidObstacle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.RETURN_BOTTLE_TO_BASE: {
				ReturnBottleToBase returnBottleToBase = (ReturnBottleToBase)theEObject;
				T result = caseReturnBottleToBase(returnBottleToBase);
				if (result == null) result = caseBehavior(returnBottleToBase);
				if (result == null) result = caseNamedElement(returnBottleToBase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.EXPLORE_FORWARD: {
				ExploreForward exploreForward = (ExploreForward)theEObject;
				T result = caseExploreForward(exploreForward);
				if (result == null) result = caseBehavior(exploreForward);
				if (result == null) result = caseNamedElement(exploreForward);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.TOUCH_SENSOR: {
				TouchSensor touchSensor = (TouchSensor)theEObject;
				T result = caseTouchSensor(touchSensor);
				if (result == null) result = caseSensor(touchSensor);
				if (result == null) result = caseNamedElement(touchSensor);
				if (result == null) result = caseCondition(touchSensor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.ULTRASONIC_SENSOR: {
				UltrasonicSensor ultrasonicSensor = (UltrasonicSensor)theEObject;
				T result = caseUltrasonicSensor(ultrasonicSensor);
				if (result == null) result = caseSensor(ultrasonicSensor);
				if (result == null) result = caseNamedElement(ultrasonicSensor);
				if (result == null) result = caseCondition(ultrasonicSensor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.TIMER: {
				Timer timer = (Timer)theEObject;
				T result = caseTimer(timer);
				if (result == null) result = caseSensor(timer);
				if (result == null) result = caseNamedElement(timer);
				if (result == null) result = caseCondition(timer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MindstormsPackage.COLOR_SENSOR: {
				ColorSensor colorSensor = (ColorSensor)theEObject;
				T result = caseColorSensor(colorSensor);
				if (result == null) result = caseSensor(colorSensor);
				if (result == null) result = caseNamedElement(colorSensor);
				if (result == null) result = caseCondition(colorSensor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Main</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Main</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMain(Main object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstruction(Instruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Procedure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Procedure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcedure(Procedure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arbitrator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arbitrator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArbitrator(Arbitrator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehavior(Behavior object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reuse Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reuse Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReuseInstruction(ReuseInstruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlock(Block object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlow(Flow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sensor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSensor(Sensor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCondition(Condition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryCondition(BinaryCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryCondition(UnaryCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIf(If object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhile(While object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Travel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Travel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTravel(Travel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Go Forward</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Go Forward</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGoForward(GoForward object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Go Backward</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Go Backward</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGoBackward(GoBackward object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rotate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rotate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRotate(Rotate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Go To</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Go To</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGoTo(GoTo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return To Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return To Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturnToBase(ReturnToBase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grab</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grab</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGrab(Grab object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Release</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Release</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelease(Release object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delay</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delay</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDelay(Delay object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Avoid Obstacle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Avoid Obstacle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAvoidObstacle(AvoidObstacle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return Bottle To Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return Bottle To Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturnBottleToBase(ReturnBottleToBase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Explore Forward</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Explore Forward</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExploreForward(ExploreForward object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Touch Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Touch Sensor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTouchSensor(TouchSensor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ultrasonic Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ultrasonic Sensor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUltrasonicSensor(UltrasonicSensor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimer(Timer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Color Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Color Sensor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColorSensor(ColorSensor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MindstormsSwitch
