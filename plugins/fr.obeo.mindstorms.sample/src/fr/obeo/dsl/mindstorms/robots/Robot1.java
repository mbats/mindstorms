package fr.obeo.dsl.mindstorms.robots;

import java.util.ArrayList;
import java.util.List;

import fr.obeo.dsl.mindstorms.AbstractRobot;
import fr.obeo.dsl.mindstorms.behaviors.AvoidObstacle;
import fr.obeo.dsl.mindstorms.behaviors.GoForward;
import fr.obeo.dsl.mindstorms.behaviors.GrabBottle;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Robot1 extends AbstractRobot {
	final static Robot1 robot = new Robot1();

	public static void main(String[] args) {
		robot.init();
		robot.run();
	}

	private void init() {
		robot.release();
	}

	@Override
	public void execute() {
		List<Behavior> behaviors = new ArrayList<Behavior>();
		behaviors.add(new GoForward(robot));
		behaviors.add(new AvoidObstacle(robot));
		behaviors.add(new GrabBottle(robot));
		Arbitrator arbitrator = new Arbitrator((Behavior[]) behaviors.toArray(new Behavior[behaviors.size()]));
		arbitrator.start();
	}
}
