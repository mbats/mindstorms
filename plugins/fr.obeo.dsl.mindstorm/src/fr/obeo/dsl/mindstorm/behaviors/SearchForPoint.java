package fr.obeo.dsl.mindstorm.behaviors;

import java.util.concurrent.ThreadLocalRandom;

import fr.obeo.dsl.mindstorm.AbstractRobot;

public class SearchForPoint extends RobotBehavior {
	public SearchForPoint(AbstractRobot robot) {
		super(robot);
	}

	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		suppressed = false;
		double distance = ThreadLocalRandom.current().nextDouble(100, 1000 + 1);
		double angle = ThreadLocalRandom.current().nextDouble(100, 1000 + 1);
		robot.explore(distance, angle);
		while (robot.isMoving() && !suppressed) {
			Thread.yield();
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
