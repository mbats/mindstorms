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


import fr.obeo.dsl.mindstorms.Arbitrator;
import fr.obeo.dsl.mindstorms.MindstormsFactory;
import fr.obeo.dsl.mindstorms.MindstormsPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link fr.obeo.dsl.mindstorms.Arbitrator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ArbitratorItemProvider extends InstructionItemProvider {
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
	public ArbitratorItemProvider(AdapterFactory adapterFactory) {
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

			addBehaviorsPropertyDescriptor(object);
			addReusePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Behaviors feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBehaviorsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Arbitrator_behaviors_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Arbitrator_behaviors_feature", "_UI_Arbitrator_type"),
				 MindstormsPackage.Literals.ARBITRATOR__BEHAVIORS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Reuse feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReusePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Arbitrator_reuse_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Arbitrator_reuse_feature", "_UI_Arbitrator_type"),
				 MindstormsPackage.Literals.ARBITRATOR__REUSE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
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
			childrenFeatures.add(MindstormsPackage.Literals.CONDITION_CONTAINER__CONDITION);
			childrenFeatures.add(MindstormsPackage.Literals.ARBITRATOR__BEHAVIORS);
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
	 * This returns Arbitrator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Arbitrator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Arbitrator)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Arbitrator_type") :
			getString("_UI_Arbitrator_type") + " " + label;
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

		switch (notification.getFeatureID(Arbitrator.class)) {
			case MindstormsPackage.ARBITRATOR__CONDITION:
			case MindstormsPackage.ARBITRATOR__BEHAVIORS:
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
				(MindstormsPackage.Literals.CONDITION_CONTAINER__CONDITION,
				 MindstormsFactory.eINSTANCE.createTouchSensor()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.CONDITION_CONTAINER__CONDITION,
				 MindstormsFactory.eINSTANCE.createUltrasonicSensor()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.CONDITION_CONTAINER__CONDITION,
				 MindstormsFactory.eINSTANCE.createColorSensor()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.ARBITRATOR__BEHAVIORS,
				 MindstormsFactory.eINSTANCE.createBehavior()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.ARBITRATOR__BEHAVIORS,
				 MindstormsFactory.eINSTANCE.createAvoidObstacle()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.ARBITRATOR__BEHAVIORS,
				 MindstormsFactory.eINSTANCE.createReturnBottleToBase()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.ARBITRATOR__BEHAVIORS,
				 MindstormsFactory.eINSTANCE.createExploreForward()));
	}

}
