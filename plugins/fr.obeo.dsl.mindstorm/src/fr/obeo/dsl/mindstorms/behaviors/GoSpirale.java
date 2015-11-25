package fr.obeo.dsl.mindstorms.behaviors;

import fr.obeo.dsl.mindstorms.AbstractRobot;

public class GoSpirale extends RobotBehavior {

	private int d;
	
	public GoSpirale(AbstractRobot robot) {
		super(robot);
		d = 10;
	}

	@Override
	public boolean takeControl() {
		return stop == false && true;
	}

	@Override
	public void action() {
		suppressed = false;
		while (d < 200) {			
			robot.travel(d);
			while (robot.isMoving() && !suppressed)Thread.yield();
			robot.rotate(-90);
			robot.travel(d);
			while (robot.isMoving() && !suppressed)Thread.yield();
			robot.rotate(-90);
			robot.travel(d);
			while (robot.isMoving() && !suppressed)Thread.yield();
			robot.rotate(-90);
			robot.travel(d);
			while (robot.isMoving() && !suppressed)Thread.yield();
			robot.rotate(-90);
			d += 10;
		}
		d = 10;
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
