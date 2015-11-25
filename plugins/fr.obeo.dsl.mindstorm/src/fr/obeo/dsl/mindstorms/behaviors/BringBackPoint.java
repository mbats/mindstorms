package fr.obeo.dsl.mindstorms.behaviors;

import fr.obeo.dsl.mindstorms.AbstractRobot;

public class BringBackPoint extends RobotBehavior {

	public BringBackPoint(AbstractRobot robot) {
		super(robot);
	}

	@Override
	public boolean takeControl() {
		return robot.touchSensorIsPressed();
	}

	@Override
	public void action() {
		suppressed = false;
		robot.returnToBase();
		while (robot.isMoving() && !suppressed) {
			Thread.yield();
		}

		robot.release();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
