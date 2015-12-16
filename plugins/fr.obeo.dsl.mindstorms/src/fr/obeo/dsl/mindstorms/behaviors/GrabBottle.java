package fr.obeo.dsl.mindstorms.behaviors;

import fr.obeo.dsl.mindstorms.AbstractRobot;

public class GrabBottle extends RobotBehavior {

	public GrabBottle(AbstractRobot robot) {
		super(robot);
	}

	@Override
	public boolean takeControl() {
		return stop == false && robot.touchSensorIsPressed();
	}

	@Override
	public void action() {
		suppressed = false;
		// Grab the detected object.
		robot.grab();
		// If the color of the grabbed object is BLUE or BROWN, then returns it to the
		// base.
		// Else release it, backward on 20 cm and then rotate randomly between 0
		// to 360 degrees.
		
		//int color = robot.getColor();
		//System.out.println("Color : " + color);
		//if (Color.BLUE == color || Color.BROWN == color) {
			robot.returnToBase();
			while (robot.isMoving() && !suppressed) {
				Thread.yield();
			}

			// End of all behaviors
			// stop = true;
		//}
		robot.release();
		robot.goBackward(20);
		robot.rotateRandomly();
		while (robot.isMoving() && !suppressed) {
			Thread.yield();
		}

	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
