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


import fr.obeo.dsl.mindstorms.BinaryCondition;
import fr.obeo.dsl.mindstorms.MindstormsFactory;
import fr.obeo.dsl.mindstorms.MindstormsPackage;
import fr.obeo.dsl.mindstorms.OperatorKind;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link fr.obeo.dsl.mindstorms.BinaryCondition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BinaryConditionItemProvider extends ConditionItemProvider {
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
	public BinaryConditionItemProvider(AdapterFactory adapterFactory) {
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

			addOpPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Op feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOpPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BinaryCondition_op_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BinaryCondition_op_feature", "_UI_BinaryCondition_type"),
				 MindstormsPackage.Literals.BINARY_CONDITION__OP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(MindstormsPackage.Literals.BINARY_CONDITION__LEFT);
			childrenFeatures.add(MindstormsPackage.Literals.BINARY_CONDITION__RIGHT);
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
	 * This returns BinaryCondition.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BinaryCondition"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		OperatorKind labelValue = ((BinaryCondition)object).getOp();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_BinaryCondition_type") :
			getString("_UI_BinaryCondition_type") + " " + label;
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

		switch (notification.getFeatureID(BinaryCondition.class)) {
			case MindstormsPackage.BINARY_CONDITION__OP:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case MindstormsPackage.BINARY_CONDITION__LEFT:
			case MindstormsPackage.BINARY_CONDITION__RIGHT:
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
				(MindstormsPackage.Literals.BINARY_CONDITION__LEFT,
				 MindstormsFactory.eINSTANCE.createCondition()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.BINARY_CONDITION__LEFT,
				 MindstormsFactory.eINSTANCE.createBinaryCondition()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.BINARY_CONDITION__LEFT,
				 MindstormsFactory.eINSTANCE.createUnaryCondition()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.BINARY_CONDITION__LEFT,
				 MindstormsFactory.eINSTANCE.createTouchSensor()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.BINARY_CONDITION__LEFT,
				 MindstormsFactory.eINSTANCE.createUltrasonicSensor()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.BINARY_CONDITION__LEFT,
				 MindstormsFactory.eINSTANCE.createTimer()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.BINARY_CONDITION__LEFT,
				 MindstormsFactory.eINSTANCE.createColorSensor()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.BINARY_CONDITION__RIGHT,
				 MindstormsFactory.eINSTANCE.createCondition()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.BINARY_CONDITION__RIGHT,
				 MindstormsFactory.eINSTANCE.createBinaryCondition()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.BINARY_CONDITION__RIGHT,
				 MindstormsFactory.eINSTANCE.createUnaryCondition()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.BINARY_CONDITION__RIGHT,
				 MindstormsFactory.eINSTANCE.createTouchSensor()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.BINARY_CONDITION__RIGHT,
				 MindstormsFactory.eINSTANCE.createUltrasonicSensor()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.BINARY_CONDITION__RIGHT,
				 MindstormsFactory.eINSTANCE.createTimer()));

		newChildDescriptors.add
			(createChildParameter
				(MindstormsPackage.Literals.BINARY_CONDITION__RIGHT,
				 MindstormsFactory.eINSTANCE.createColorSensor()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == MindstormsPackage.Literals.BINARY_CONDITION__LEFT ||
			childFeature == MindstormsPackage.Literals.BINARY_CONDITION__RIGHT;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
