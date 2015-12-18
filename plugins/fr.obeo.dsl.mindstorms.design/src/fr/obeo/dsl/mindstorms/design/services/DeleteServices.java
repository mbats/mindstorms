package fr.obeo.dsl.mindstorms.design.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import fr.obeo.dsl.mindstorms.Arbitrator;
import fr.obeo.dsl.mindstorms.Behavior;

public class DeleteServices {
	
	public void deleteElement(EObject object, EObject container) {
		EcoreUtil.delete(object, true);
	}
	
	public void deleteElement(Behavior object, Arbitrator container) {
		if (container.getReuse().contains(object)) {
			container.getReuse().remove(object);
		} else if (container.getBehaviors().contains(object)) {
			EcoreUtil.delete(object, true);
		}
	}
}
