package fr.obeo.dsl.mindstorms.design.services;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import fr.obeo.dsl.mindstorms.Behavior;
import fr.obeo.dsl.mindstorms.Block;
import fr.obeo.dsl.mindstorms.InstructionCall;
import fr.obeo.dsl.mindstorms.Main;
import fr.obeo.dsl.mindstorms.Procedure;

@SuppressWarnings({"rawtypes", "unchecked"})
public class EdgeServices {

	public InstructionCall getNextInstructionCall(InstructionCall element) {
		EObject container = element.eContainer();
		if (container instanceof Main) {
			Object calls = container.eGet(element.eContainingFeature());
			if (calls instanceof List) {
				int size = ((List) calls).size();
				int objectIndex = ((List)calls).indexOf(element);
				if (objectIndex < size - 1) {
					Object nextElement = ((List) calls).get(objectIndex+1);
					if (nextElement instanceof InstructionCall) {
						return (InstructionCall) nextElement;
					}
				}
			}
		}
		return null;
	}
	
	public Block getNextBlock(Block element) {
		EObject container = element.eContainer();
		if (container instanceof Procedure || container instanceof Behavior) {
			Object blocks = container.eGet(element.eContainingFeature());
			if (blocks instanceof List) {
				int size = ((List) blocks).size();
				int objectIndex = ((List)blocks).indexOf(element);
				if (objectIndex < size - 1) {
					Object nextElement = ((List) blocks).get(objectIndex+1);
					if (nextElement instanceof Block) {
						return (Block) nextElement;
					}
				}
			}
		}
		return null;
	}
	
	public void reconnectInstructionCallSource(InstructionCall current, InstructionCall newPrev) {
		EObject container = current.eContainer();
		if (container instanceof Main) {
			Object calls = container.eGet(current.eContainingFeature());
			if (calls instanceof EList) {
				int currentIndex = ((EList)calls).indexOf(current);
				if (currentIndex > 1) {
					((EList) calls).move(currentIndex - 1, newPrev);
				} else if (currentIndex == 1) {
					((EList) calls).move(1, newPrev);
				} else {
					((EList) calls).move(0, newPrev);
				}
			}
		}
	}
	
	public void reconnectInstructionCallTarget(InstructionCall current, InstructionCall newNext) {
		EObject container = current.eContainer();
		if (container instanceof Main) {
			Object calls = container.eGet(current.eContainingFeature());
			if (calls instanceof EList) {
				int currentIndex = ((EList)calls).indexOf(current);
				int newNextIndex = ((EList)calls).indexOf(newNext);
				if (currentIndex < newNextIndex) {
					((EList) calls).move(currentIndex + 1, newNext);
				} else {
					((EList) calls).move(currentIndex, newNext);
				}
			}
		}
	}
	
	public void reconnectBlockSource(Block current, Block newPrev) {
		EObject container = current.eContainer();
		if (container instanceof Procedure || container instanceof Behavior) {
			Object calls = container.eGet(current.eContainingFeature());
			if (calls instanceof EList) {
				int currentIndex = ((EList)calls).indexOf(current);
				if (currentIndex > 1) {
					((EList) calls).move(currentIndex - 1, newPrev);
				} else if (currentIndex == 1) {
					((EList) calls).move(1, newPrev);
				} else {
					((EList) calls).move(0, newPrev);
				}
			}
		}
	}
	
	public void reconnectBlockTarget(Block current, Block newNext) {
		EObject container = current.eContainer();
		if (container instanceof Procedure || container instanceof Behavior) {
			Object calls = container.eGet(current.eContainingFeature());
			if (calls instanceof EList) {
				int currentIndex = ((EList)calls).indexOf(current);
				int newNextIndex = ((EList)calls).indexOf(newNext);
				if (currentIndex < newNextIndex) {
					((EList) calls).move(currentIndex + 1, newNext);
				} else {
					((EList) calls).move(currentIndex, newNext);
				}
			}
		}
	}
}
