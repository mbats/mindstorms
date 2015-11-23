package fr.obeo.dsl.mindstorm.behaviors;

import java.util.concurrent.ThreadLocalRandom;

import fr.obeo.dsl.mindstorm.AbstractRobot;
import lejos.robotics.Color;

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
		// If the color of the grabbed object is BLUE, then returns it to the base.
		// Else release it, backward on 20 cm and then rotate randomly between 0 to 360 degrees.
		if (Color.BLUE == robot.getColor()) {			
			robot.returnToBase();
			while (robot.isMoving() && !suppressed) {
				Thread.yield();
			}
			
			robot.release();
			// End of all behaviors
			stop = true;
		} else {
			robot.release();
			robot.travel(-20);
			robot.rotate(ThreadLocalRandom.current().nextDouble(0, 360 + 1));
			while (robot.isMoving() && !suppressed) {
				Thread.yield();
			}
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
