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
 * A representation of the model object '<em><b>Go Backward</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.dsl.mindstorms.GoBackward#getCm <em>Cm</em>}</li>
 *   <li>{@link fr.obeo.dsl.mindstorms.GoBackward#isInfinite <em>Infinite</em>}</li>
 * </ul>
 *
 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getGoBackward()
 * @model
 * @generated
 */
public interface GoBackward extends Action {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2015 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Cm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cm</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cm</em>' attribute.
	 * @see #setCm(int)
	 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getGoBackward_Cm()
	 * @model
	 * @generated
	 */
	int getCm();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.mindstorms.GoBackward#getCm <em>Cm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cm</em>' attribute.
	 * @see #getCm()
	 * @generated
	 */
	void setCm(int value);

	/**
	 * Returns the value of the '<em><b>Infinite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infinite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infinite</em>' attribute.
	 * @see #setInfinite(boolean)
	 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getGoBackward_Infinite()
	 * @model
	 * @generated
	 */
	boolean isInfinite();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.mindstorms.GoBackward#isInfinite <em>Infinite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infinite</em>' attribute.
	 * @see #isInfinite()
	 * @generated
	 */
	void setInfinite(boolean value);

} // GoBackward
