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
package fr.obeo.dsl.mindstorms.impl;

import fr.obeo.dsl.mindstorms.Instruction;
import fr.obeo.dsl.mindstorms.MindstormsPackage;
import fr.obeo.dsl.mindstorms.ReuseInstruction;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reuse Instruction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.dsl.mindstorms.impl.ReuseInstructionImpl#getReuse <em>Reuse</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReuseInstructionImpl extends InstructionImpl implements ReuseInstruction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2015 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The cached value of the '{@link #getReuse() <em>Reuse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReuse()
	 * @generated
	 * @ordered
	 */
	protected Instruction reuse;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReuseInstructionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MindstormsPackage.Literals.REUSE_INSTRUCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Instruction getReuse() {
		if (reuse != null && reuse.eIsProxy()) {
			InternalEObject oldReuse = (InternalEObject)reuse;
			reuse = (Instruction)eResolveProxy(oldReuse);
			if (reuse != oldReuse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MindstormsPackage.REUSE_INSTRUCTION__REUSE, oldReuse, reuse));
			}
		}
		return reuse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Instruction basicGetReuse() {
		return reuse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReuse(Instruction newReuse) {
		Instruction oldReuse = reuse;
		reuse = newReuse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindstormsPackage.REUSE_INSTRUCTION__REUSE, oldReuse, reuse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MindstormsPackage.REUSE_INSTRUCTION__REUSE:
				if (resolve) return getReuse();
				return basicGetReuse();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MindstormsPackage.REUSE_INSTRUCTION__REUSE:
				setReuse((Instruction)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MindstormsPackage.REUSE_INSTRUCTION__REUSE:
				setReuse((Instruction)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MindstormsPackage.REUSE_INSTRUCTION__REUSE:
				return reuse != null;
		}
		return super.eIsSet(featureID);
	}

} //ReuseInstructionImpl
