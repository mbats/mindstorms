package fr.obeo.dsl.mindstorms.behaviors;

import fr.obeo.dsl.mindstorms.AbstractRobot;
import lejos.hardware.Button;

public class StopBehaviors extends RobotBehavior {

	public StopBehaviors(AbstractRobot robot) {
		super(robot);
	}

	@Override
	public boolean takeControl() {
		return stop == false;
	}

	@Override
	public void action() {
		if(Button.waitForAnyPress(1000) != 0){
			stop = true;			
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
}
