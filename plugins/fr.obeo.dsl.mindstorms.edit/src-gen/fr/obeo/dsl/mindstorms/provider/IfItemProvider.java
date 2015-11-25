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
package fr.obeo.dsl.mindstorms.provider;


import fr.obeo.dsl.mindstorms.If;
import fr.obeo.dsl.mindstorms.MindstormsFactory;
import fr.obeo.dsl.mindstorms.MindstormsPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link fr.obeo.dsl.mindstorms.If} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IfItemProvider extends FlowItemProvider {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2015 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(MindstormsPackage.Literals.IF__CONDITION);
			childrenFeatures.add(MindstormsPackage.Literals.IF__BLOCKS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns If.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/If"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((If)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_If_type") :
			getString("_UI_If_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(If.class)) {
			case MindstormsPackage.IF__CONDITION:
			case MindstormsPackage.IF__BLOCKS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.IF__CONDITION,
				 MindstormsFactory.eINSTANCE.createCondition()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.IF__CONDITION,
				 MindstormsFactory.eINSTANCE.createTouchSensor()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.IF__CONDITION,
				 MindstormsFactory.eINSTANCE.createUltrasonicSensor()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.IF__CONDITION,
				 MindstormsFactory.eINSTANCE.createTimer()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.IF__CONDITION,
				 MindstormsFactory.eINSTANCE.createColorSensor()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.IF__BLOCKS,
				 MindstormsFactory.eINSTANCE.createIf()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.IF__BLOCKS,
				 MindstormsFactory.eINSTANCE.createWhile()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.IF__BLOCKS,
				 MindstormsFactory.eINSTANCE.createTravel()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.IF__BLOCKS,
				 MindstormsFactory.eINSTANCE.createGoForward()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.IF__BLOCKS,
				 MindstormsFactory.eINSTANCE.createGoBackward()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.IF__BLOCKS,
				 MindstormsFactory.eINSTANCE.createRotate()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.IF__BLOCKS,
				 MindstormsFactory.eINSTANCE.createGoTo()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.IF__BLOCKS,
				 MindstormsFactory.eINSTANCE.createReturnToBase()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.IF__BLOCKS,
				 MindstormsFactory.eINSTANCE.createGrab()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.IF__BLOCKS,
				 MindstormsFactory.eINSTANCE.createRelease()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.IF__BLOCKS,
				 MindstormsFactory.eINSTANCE.createDelay()));
	}

}
