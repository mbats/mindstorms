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
 * A representation of the model object '<em><b>Binary Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.dsl.mindstorms.BinaryCondition#getLeft <em>Left</em>}</li>
 *   <li>{@link fr.obeo.dsl.mindstorms.BinaryCondition#getOp <em>Op</em>}</li>
 *   <li>{@link fr.obeo.dsl.mindstorms.BinaryCondition#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getBinaryCondition()
 * @model
 * @generated
 */
public interface BinaryCondition extends Condition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2015 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Condition)
	 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getBinaryCondition_Left()
	 * @model containment="true"
	 * @generated
	 */
	Condition getLeft();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.mindstorms.BinaryCondition#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Condition value);

	/**
	 * Returns the value of the '<em><b>Op</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.obeo.dsl.mindstorms.OperatorKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Op</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op</em>' attribute.
	 * @see fr.obeo.dsl.mindstorms.OperatorKind
	 * @see #setOp(OperatorKind)
	 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getBinaryCondition_Op()
	 * @model
	 * @generated
	 */
	OperatorKind getOp();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.mindstorms.BinaryCondition#getOp <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' attribute.
	 * @see fr.obeo.dsl.mindstorms.OperatorKind
	 * @see #getOp()
	 * @generated
	 */
	void setOp(OperatorKind value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Condition)
	 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getBinaryCondition_Right()
	 * @model containment="true"
	 * @generated
	 */
	Condition getRight();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.mindstorms.BinaryCondition#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Condition value);

} // BinaryCondition
