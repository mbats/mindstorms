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

import fr.obeo.dsl.mindstorms.Behavior;
import fr.obeo.dsl.mindstorms.Block;
import fr.obeo.dsl.mindstorms.BlockContainer;
import fr.obeo.dsl.mindstorms.Condition;
import fr.obeo.dsl.mindstorms.MindstormsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.dsl.mindstorms.impl.BehaviorImpl#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link fr.obeo.dsl.mindstorms.impl.BehaviorImpl#getTakeControl <em>Take Control</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorImpl extends NamedElementImpl implements Behavior {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2015 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The cached value of the '{@link #getBlocks() <em>Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<Block> blocks;

	/**
	 * The cached value of the '{@link #getTakeControl() <em>Take Control</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTakeControl()
	 * @generated
	 * @ordered
	 */
	protected Condition takeControl;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MindstormsPackage.Literals.BEHAVIOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getTakeControl() {
		return takeControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTakeControl(Condition newTakeControl, NotificationChain msgs) {
		Condition oldTakeControl = takeControl;
		takeControl = newTakeControl;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MindstormsPackage.BEHAVIOR__TAKE_CONTROL, oldTakeControl, newTakeControl);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTakeControl(Condition newTakeControl) {
		if (newTakeControl != takeControl) {
			NotificationChain msgs = null;
			if (takeControl != null)
				msgs = ((InternalEObject)takeControl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MindstormsPackage.BEHAVIOR__TAKE_CONTROL, null, msgs);
			if (newTakeControl != null)
				msgs = ((InternalEObject)newTakeControl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MindstormsPackage.BEHAVIOR__TAKE_CONTROL, null, msgs);
			msgs = basicSetTakeControl(newTakeControl, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindstormsPackage.BEHAVIOR__TAKE_CONTROL, newTakeControl, newTakeControl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Block> getBlocks() {
		if (blocks == null) {
			blocks = new EObjectContainmentEList<Block>(Block.class, this, MindstormsPackage.BEHAVIOR__BLOCKS);
		}
		return blocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MindstormsPackage.BEHAVIOR__BLOCKS:
				return ((InternalEList<?>)getBlocks()).basicRemove(otherEnd, msgs);
			case MindstormsPackage.BEHAVIOR__TAKE_CONTROL:
				return basicSetTakeControl(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MindstormsPackage.BEHAVIOR__BLOCKS:
				return getBlocks();
			case MindstormsPackage.BEHAVIOR__TAKE_CONTROL:
				return getTakeControl();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MindstormsPackage.BEHAVIOR__BLOCKS:
				getBlocks().clear();
				getBlocks().addAll((Collection<? extends Block>)newValue);
				return;
			case MindstormsPackage.BEHAVIOR__TAKE_CONTROL:
				setTakeControl((Condition)newValue);
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
			case MindstormsPackage.BEHAVIOR__BLOCKS:
				getBlocks().clear();
				return;
			case MindstormsPackage.BEHAVIOR__TAKE_CONTROL:
				setTakeControl((Condition)null);
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
			case MindstormsPackage.BEHAVIOR__BLOCKS:
				return blocks != null && !blocks.isEmpty();
			case MindstormsPackage.BEHAVIOR__TAKE_CONTROL:
				return takeControl != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == BlockContainer.class) {
			switch (derivedFeatureID) {
				case MindstormsPackage.BEHAVIOR__BLOCKS: return MindstormsPackage.BLOCK_CONTAINER__BLOCKS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == BlockContainer.class) {
			switch (baseFeatureID) {
				case MindstormsPackage.BLOCK_CONTAINER__BLOCKS: return MindstormsPackage.BEHAVIOR__BLOCKS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //BehaviorImpl
