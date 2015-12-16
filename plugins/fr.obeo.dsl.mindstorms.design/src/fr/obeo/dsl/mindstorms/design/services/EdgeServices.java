/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.obeo.dsl.mindstorms.design.services;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import fr.obeo.dsl.mindstorms.Behavior;
import fr.obeo.dsl.mindstorms.Block;
import fr.obeo.dsl.mindstorms.If;
import fr.obeo.dsl.mindstorms.Instruction;
import fr.obeo.dsl.mindstorms.Main;
import fr.obeo.dsl.mindstorms.Procedure;
import fr.obeo.dsl.mindstorms.While;

@SuppressWarnings({"rawtypes", "unchecked"})
public class EdgeServices {

	public Instruction getNextInstruction(Instruction element) {
		EObject container = element.eContainer();
		if (container instanceof Main) {
			Object blocks = container.eGet(element.eContainingFeature());
			if (blocks instanceof List) {
				int size = ((List) blocks).size();
				int objectIndex = ((List)blocks).indexOf(element);
				if (objectIndex < size - 1) {
					Object nextElement = ((List) blocks).get(objectIndex+1);
					if (nextElement instanceof Instruction) {
						return (Instruction) nextElement;
					}
				}
			}
		}
		return null;
	}
	
	public Block getNextBlock(Block element) {
		EObject container = element.eContainer();
		if (container instanceof Procedure || container instanceof Behavior || container instanceof While || container instanceof If) {
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
	
	public void reconnectInstructionSource(Instruction current, Instruction newPrev) {
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
	
	public void reconnectInstructionTarget(Instruction current, Instruction newNext) {
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
