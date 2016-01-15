package fr.obeo.dsl.mindstorms.behaviors;

import fr.obeo.dsl.mindstorms.AbstractRobot;

public class StayInTheLimits extends RobotBehavior {

	private static final int minX = 0;
	private static final int minY = 0;
	private static final int maxX = 100;
	private static final int maxY = 100;

	public StayInTheLimits(AbstractRobot robot) {
		super(robot);
	}

	@Override
	public boolean takeControl() {
		float x = robot.getXPosition();
		float y = robot.getYPosition();
		System.out.println(x + "," + y + "<" + maxX + "," + maxY);
		return x > maxX || y > maxY || x < minX || y < minY;
	}

	@Override
	public void action() {
		suppressed = false;
		robot.stop();
		robot.goTo(50,50);
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
