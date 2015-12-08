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
 * A representation of the model object '<em><b>Reuse Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.dsl.mindstorms.ReuseInstruction#getReuse <em>Reuse</em>}</li>
 * </ul>
 *
 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getReuseInstruction()
 * @model
 * @generated
 */
public interface ReuseInstruction extends Instruction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2015 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Reuse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reuse</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reuse</em>' reference.
	 * @see #setReuse(Instruction)
	 * @see fr.obeo.dsl.mindstorms.MindstormsPackage#getReuseInstruction_Reuse()
	 * @model
	 * @generated
	 */
	Instruction getReuse();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.mindstorms.ReuseInstruction#getReuse <em>Reuse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reuse</em>' reference.
	 * @see #getReuse()
	 * @generated
	 */
	void setReuse(Instruction value);

} // ReuseInstruction
