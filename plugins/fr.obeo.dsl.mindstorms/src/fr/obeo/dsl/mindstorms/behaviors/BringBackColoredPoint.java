package fr.obeo.dsl.mindstorms.behaviors;

import java.awt.Color;

import fr.obeo.dsl.mindstorms.AbstractRobot;

public class BringBackColoredPoint extends RobotBehavior {

	public BringBackColoredPoint(AbstractRobot robot) {
		super(robot);
	}

	@Override
	public boolean takeControl() {
		return robot.touchSensorIsPressed()
				&& (Color.RED.equals(robot.getColoredPoint()) || Color.GREEN.equals(robot.getColoredPoint()));
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
