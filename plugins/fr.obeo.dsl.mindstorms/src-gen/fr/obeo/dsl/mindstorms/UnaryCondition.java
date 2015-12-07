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
 * A representation of the model object '<em><b>Unary Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.dsl.mindstorms.UnaryCondition#getNot <em>Not</em>}</li>
 *   <li>{@link fr.obeo.dsl.mindstorms.UnaryCondition#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getUnaryCondition()
 * @model
 * @generated
 */
public interface UnaryCondition extends Condition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2015 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Not</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.obeo.dsl.mindstorms.OperatorKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not</em>' attribute.
	 * @see fr.obeo.dsl.mindstorms.OperatorKind
	 * @see #setNot(OperatorKind)
	 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getUnaryCondition_Not()
	 * @model
	 * @generated
	 */
	OperatorKind getNot();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.mindstorms.UnaryCondition#getNot <em>Not</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not</em>' attribute.
	 * @see fr.obeo.dsl.mindstorms.OperatorKind
	 * @see #getNot()
	 * @generated
	 */
	void setNot(OperatorKind value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' reference.
	 * @see #setCondition(Condition)
	 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getUnaryCondition_Condition()
	 * @model
	 * @generated
	 */
	Condition getCondition();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.mindstorms.UnaryCondition#getCondition <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Condition value);

} // UnaryCondition
