package fr.obeo.dsl.mindstorms.robots;

import java.util.ArrayList;
import java.util.List;

import fr.obeo.dsl.mindstorms.AbstractRobot;
import fr.obeo.dsl.mindstorms.behaviors.BringBackColoredPoint;
import fr.obeo.dsl.mindstorms.behaviors.SearchForPoint;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Robot2 extends AbstractRobot {
	final static Robot2 robot = new Robot2();

	public static void main(String[] args) {
		robot.run();
	}

	@Override
	public void execute() {
		List<Behavior> behaviors = new ArrayList<Behavior>();
		behaviors.add(new SearchForPoint(robot));
		behaviors.add(new BringBackColoredPoint(robot));
		Arbitrator arbitrator = new Arbitrator((Behavior[]) behaviors.toArray(new Behavior[behaviors.size()]));
		arbitrator.start();
	}
}
