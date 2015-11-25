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
 * A representation of the model object '<em><b>Rotate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.dsl.mindstorms.Rotate#getDegrees <em>Degrees</em>}</li>
 *   <li>{@link fr.obeo.dsl.mindstorms.Rotate#isRandom <em>Random</em>}</li>
 * </ul>
 *
 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getRotate()
 * @model
 * @generated
 */
public interface Rotate extends Action {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2015 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Degrees</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Degrees</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Degrees</em>' attribute.
	 * @see #setDegrees(int)
	 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getRotate_Degrees()
	 * @model
	 * @generated
	 */
	int getDegrees();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.mindstorms.Rotate#getDegrees <em>Degrees</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Degrees</em>' attribute.
	 * @see #getDegrees()
	 * @generated
	 */
	void setDegrees(int value);

	/**
	 * Returns the value of the '<em><b>Random</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Random</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Random</em>' attribute.
	 * @see #setRandom(boolean)
	 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getRotate_Random()
	 * @model
	 * @generated
	 */
	boolean isRandom();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.mindstorms.Rotate#isRandom <em>Random</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Random</em>' attribute.
	 * @see #isRandom()
	 * @generated
	 */
	void setRandom(boolean value);

} // Rotate
