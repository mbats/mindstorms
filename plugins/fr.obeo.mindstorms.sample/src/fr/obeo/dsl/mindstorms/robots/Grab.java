package fr.obeo.dsl.mindstorms.robots;

import fr.obeo.dsl.mindstorms.AbstractRobot;
import lejos.robotics.navigation.Pose;

public class Grab extends AbstractRobot {

	final static Grab robot = new Grab();

	public static void main(String[] args) {
		robot.run();
	}

	@Override
	public void execute() {
		robot.getPoseProvider().setPose(new Pose(0, 0, 0));
		robot.goTo(0, 1000);
		robot.goTo(500, 1000);
		robot.goTo(500, 0);
		robot.goTo(0, 0);
	}

}
