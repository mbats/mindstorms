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
package fr.obeo.dsl.mindstorms;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ultrasonic Sensor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.dsl.mindstorms.UltrasonicSensor#getOperator <em>Operator</em>}</li>
 *   <li>{@link fr.obeo.dsl.mindstorms.UltrasonicSensor#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getUltrasonicSensor()
 * @model
 * @generated
 */
public interface UltrasonicSensor extends Sensor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2015 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.obeo.dsl.mindstorms.OperatorKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see fr.obeo.dsl.mindstorms.OperatorKind
	 * @see #setOperator(OperatorKind)
	 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getUltrasonicSensor_Operator()
	 * @model
	 * @generated
	 */
	OperatorKind getOperator();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.mindstorms.UltrasonicSensor#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see fr.obeo.dsl.mindstorms.OperatorKind
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(OperatorKind value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(float)
	 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getUltrasonicSensor_Value()
	 * @model
	 * @generated
	 */
	float getValue();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.mindstorms.UltrasonicSensor#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(float value);

} // UltrasonicSensor
