package fr.obeo.dsl.mindstorm.behaviors;

import java.util.concurrent.ThreadLocalRandom;

import fr.obeo.dsl.mindstorm.AbstractRobot;

public class AvoidObstacle extends RobotBehavior {

	public AvoidObstacle(AbstractRobot robot) {
		super(robot);
	}

	@Override
	public boolean takeControl() {
		return stop == false && robot.obstacleDetected();
	}

	@Override
	public void action() {
		suppressed = false;
		robot.travel(-20);
		robot.rotate(ThreadLocalRandom.current().nextDouble(0, 360 + 1));
		while (robot.isMoving() && !suppressed) {
			Thread.yield();
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
}