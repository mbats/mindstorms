package fr.obeo.dsl.mindstorms.design.services;

import java.util.ArrayList;
import java.util.List;

import fr.obeo.dsl.mindstorms.Arbitrator;
import fr.obeo.dsl.mindstorms.Behavior;
import fr.obeo.dsl.mindstorms.Instruction;
import fr.obeo.dsl.mindstorms.Main;
import fr.obeo.dsl.mindstorms.MindstormsFactory;
import fr.obeo.dsl.mindstorms.Procedure;

public class CreateServices {
	public void createProcedure(Arbitrator arbitrator) {
		Behavior behavior = MindstormsFactory.eINSTANCE.createBehavior();
		behavior.setName("New Behavior");
		arbitrator.getBehaviors().add(behavior);
	}

	public void createProcedure(Main main) {
		Procedure procedure = MindstormsFactory.eINSTANCE.createProcedure();
		procedure.setName("New Procedure");
		main.getInstructions().add(procedure);
	}

	public List<Procedure> getExistingProcedures(Main main) {
		List<Procedure> procedures = new ArrayList<Procedure>();
		for (Instruction instruction : main.getInstructions()) {
			if (instruction instanceof Procedure) {
				procedures.add((Procedure) instruction);
			}
		}
		return procedures;
	}

	public List<Behavior> getExistingProcedures(Arbitrator arbitrator) {
		List<Behavior> procedures = new ArrayList<Behavior>();
		Main main = (Main) arbitrator.eContainer();
		for (Instruction instruction : main.getInstructions()) {
			if (instruction instanceof Arbitrator) {
				if (!instruction.equals(arbitrator)) {
					for (Behavior behavior : ((Arbitrator) instruction).getBehaviors()) {
						if (!arbitrator.getReuse().contains(behavior)) {
							procedures.add((Behavior) behavior);
						}
					}
				}
			}
		}
		return procedures;
	}
}
