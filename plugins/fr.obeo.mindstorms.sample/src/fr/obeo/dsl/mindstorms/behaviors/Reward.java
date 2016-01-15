package fr.obeo.dsl.mindstorms.behaviors;

import fr.obeo.dsl.mindstorms.AbstractRobot;

public class Reward extends RobotBehavior {

	public Reward(AbstractRobot robot) {
		super(robot);
	}

	@Override
	public boolean takeControl() {
		return robot.obstacleDetected(30);
	}

	@Override
	public void action() {
		suppressed = false;
		robot.goForwardSlowly(35);
		while (robot.isMoving() && !suppressed) {
			Thread.yield();
		}
		robot.grab();
		robot.goTo(0, 0);
		robot.release();
		robot.goBackward(15);
		robot.rotate(180);
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
