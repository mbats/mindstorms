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

import fr.obeo.dsl.mindstorms.util.MindstormsAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MindstormsItemProviderAdapterFactory extends MindstormsAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2015 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MindstormsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.Main} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MainItemProvider mainItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.Main}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMainAdapter() {
		if (mainItemProvider == null) {
			mainItemProvider = new MainItemProvider(this);
		}

		return mainItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.Procedure} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcedureItemProvider procedureItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.Procedure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProcedureAdapter() {
		if (procedureItemProvider == null) {
			procedureItemProvider = new ProcedureItemProvider(this);
		}

		return procedureItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.Arbitrator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArbitratorItemProvider arbitratorItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.Arbitrator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createArbitratorAdapter() {
		if (arbitratorItemProvider == null) {
			arbitratorItemProvider = new ArbitratorItemProvider(this);
		}

		return arbitratorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.Behavior} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorItemProvider behaviorItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.Behavior}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBehaviorAdapter() {
		if (behaviorItemProvider == null) {
			behaviorItemProvider = new BehaviorItemProvider(this);
		}

		return behaviorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.ReuseInstruction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReuseInstructionItemProvider reuseInstructionItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.ReuseInstruction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReuseInstructionAdapter() {
		if (reuseInstructionItemProvider == null) {
			reuseInstructionItemProvider = new ReuseInstructionItemProvider(this);
		}

		return reuseInstructionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.If} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfItemProvider ifItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.If}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIfAdapter() {
		if (ifItemProvider == null) {
			ifItemProvider = new IfItemProvider(this);
		}

		return ifItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.While} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WhileItemProvider whileItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.While}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWhileAdapter() {
		if (whileItemProvider == null) {
			whileItemProvider = new WhileItemProvider(this);
		}

		return whileItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.GoForward} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GoForwardItemProvider goForwardItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.GoForward}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGoForwardAdapter() {
		if (goForwardItemProvider == null) {
			goForwardItemProvider = new GoForwardItemProvider(this);
		}

		return goForwardItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.GoBackward} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GoBackwardItemProvider goBackwardItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.GoBackward}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGoBackwardAdapter() {
		if (goBackwardItemProvider == null) {
			goBackwardItemProvider = new GoBackwardItemProvider(this);
		}

		return goBackwardItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.Rotate} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RotateItemProvider rotateItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.Rotate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRotateAdapter() {
		if (rotateItemProvider == null) {
			rotateItemProvider = new RotateItemProvider(this);
		}

		return rotateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.GoTo} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GoToItemProvider goToItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.GoTo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGoToAdapter() {
		if (goToItemProvider == null) {
			goToItemProvider = new GoToItemProvider(this);
		}

		return goToItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.ReturnToBase} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReturnToBaseItemProvider returnToBaseItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.ReturnToBase}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReturnToBaseAdapter() {
		if (returnToBaseItemProvider == null) {
			returnToBaseItemProvider = new ReturnToBaseItemProvider(this);
		}

		return returnToBaseItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.Grab} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GrabItemProvider grabItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.Grab}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGrabAdapter() {
		if (grabItemProvider == null) {
			grabItemProvider = new GrabItemProvider(this);
		}

		return grabItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.Release} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReleaseItemProvider releaseItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.Release}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReleaseAdapter() {
		if (releaseItemProvider == null) {
			releaseItemProvider = new ReleaseItemProvider(this);
		}

		return releaseItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.Delay} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DelayItemProvider delayItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.Delay}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDelayAdapter() {
		if (delayItemProvider == null) {
			delayItemProvider = new DelayItemProvider(this);
		}

		return delayItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.AvoidObstacle} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AvoidObstacleItemProvider avoidObstacleItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.AvoidObstacle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAvoidObstacleAdapter() {
		if (avoidObstacleItemProvider == null) {
			avoidObstacleItemProvider = new AvoidObstacleItemProvider(this);
		}

		return avoidObstacleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.ReturnBottleToBase} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReturnBottleToBaseItemProvider returnBottleToBaseItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.ReturnBottleToBase}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReturnBottleToBaseAdapter() {
		if (returnBottleToBaseItemProvider == null) {
			returnBottleToBaseItemProvider = new ReturnBottleToBaseItemProvider(this);
		}

		return returnBottleToBaseItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.ExploreForward} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExploreForwardItemProvider exploreForwardItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.ExploreForward}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExploreForwardAdapter() {
		if (exploreForwardItemProvider == null) {
			exploreForwardItemProvider = new ExploreForwardItemProvider(this);
		}

		return exploreForwardItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.TouchSensor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TouchSensorItemProvider touchSensorItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.TouchSensor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTouchSensorAdapter() {
		if (touchSensorItemProvider == null) {
			touchSensorItemProvider = new TouchSensorItemProvider(this);
		}

		return touchSensorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.UltrasonicSensor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UltrasonicSensorItemProvider ultrasonicSensorItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.UltrasonicSensor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUltrasonicSensorAdapter() {
		if (ultrasonicSensorItemProvider == null) {
			ultrasonicSensorItemProvider = new UltrasonicSensorItemProvider(this);
		}

		return ultrasonicSensorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.Timer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimerItemProvider timerItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.Timer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTimerAdapter() {
		if (timerItemProvider == null) {
			timerItemProvider = new TimerItemProvider(this);
		}

		return timerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link fr.obeo.dsl.mindstorms.ColorSensor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColorSensorItemProvider colorSensorItemProvider;

	/**
	 * This creates an adapter for a {@link fr.obeo.dsl.mindstorms.ColorSensor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createColorSensorAdapter() {
		if (colorSensorItemProvider == null) {
			colorSensorItemProvider = new ColorSensorItemProvider(this);
		}

		return colorSensorItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (mainItemProvider != null) mainItemProvider.dispose();
		if (procedureItemProvider != null) procedureItemProvider.dispose();
		if (arbitratorItemProvider != null) arbitratorItemProvider.dispose();
		if (behaviorItemProvider != null) behaviorItemProvider.dispose();
		if (reuseInstructionItemProvider != null) reuseInstructionItemProvider.dispose();
		if (ifItemProvider != null) ifItemProvider.dispose();
		if (whileItemProvider != null) whileItemProvider.dispose();
		if (goForwardItemProvider != null) goForwardItemProvider.dispose();
		if (goBackwardItemProvider != null) goBackwardItemProvider.dispose();
		if (rotateItemProvider != null) rotateItemProvider.dispose();
		if (goToItemProvider != null) goToItemProvider.dispose();
		if (returnToBaseItemProvider != null) returnToBaseItemProvider.dispose();
		if (grabItemProvider != null) grabItemProvider.dispose();
		if (releaseItemProvider != null) releaseItemProvider.dispose();
		if (delayItemProvider != null) delayItemProvider.dispose();
		if (avoidObstacleItemProvider != null) avoidObstacleItemProvider.dispose();
		if (returnBottleToBaseItemProvider != null) returnBottleToBaseItemProvider.dispose();
		if (exploreForwardItemProvider != null) exploreForwardItemProvider.dispose();
		if (touchSensorItemProvider != null) touchSensorItemProvider.dispose();
		if (ultrasonicSensorItemProvider != null) ultrasonicSensorItemProvider.dispose();
		if (timerItemProvider != null) timerItemProvider.dispose();
		if (colorSensorItemProvider != null) colorSensorItemProvider.dispose();
	}

}
