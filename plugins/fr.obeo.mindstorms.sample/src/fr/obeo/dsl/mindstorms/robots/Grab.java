package fr.obeo.dsl.mindstorms.robots;

import fr.obeo.dsl.mindstorms.AbstractRobot;
import lejos.hardware.Button;

public class Grab extends AbstractRobot {

	final static Grab robot = new Grab();
	private static final int squareSize = 0;
	private static final int wheelCircunference = 0;
	private static final double wheelBase = 0;

	public static void main(String[] args) {
		robot.run();
	}

	@Override
	public void execute() {
		System.out.println("CW Run");
		Button.waitForAnyPress();

		for (int j = 0; j < 3; j++) {
				robot.goForward(50);
				robot.rotate(-90);
				robot.goForward(50);
				robot.rotate(-90);
				robot.goForward(50);
				robot.rotate(-90);
				robot.goForward(50);
				robot.rotate(-90);

			System.out.println("CW: " + (j + 1) + "/5");
			Button.waitForAnyPress();
		}

		// robot.goTo(50, 50);
		// List<Behavior> behaviors = new ArrayList<Behavior>();
		// behaviors.add(new Explore(robot));
		// // behaviors.add(new Reward(robot));
		// // behaviors.add(new AvoidObstacle(robot));
		// behaviors.add(new StayInTheLimits(robot));
		// Arbitrator arbitrator = new Arbitrator((Behavior[])
		// behaviors.toArray(new Behavior[behaviors.size()]));
		// arbitrator.start();

		// robot.goForward(50);
		// robot.grab();
		// robot.goBackward(50);
		// robot.release();
		// while (true) {
		// System.out.println(robot.getColor());
		// }

		// robot.goTo(50, 0);
		// robot.grab();
		// robot.goTo(0, 0);
		// robot.release();
		// robot.goBackward(20);
		// robot.goTo(50,40);
		// robot.grab();
		// robot.goTo(0, 0);
		// robot.release();
		// robot.goBackward(20);

		// robot.goToPoint();
		// robot.grab();
		// robot.goTo(0, 0);
		// robot.release();
		// robot.goBackward(20);

		// robot.goTo(50, 0);
		// robot.goTo(50, 50);
		// robot.goTo(0, 50);
		// robot.goTo(0, 0);
		// robot.goForward(50);
		// robot.rotate(90);
		// robot.goForward(50);
		// robot.rotate(90);
		// robot.goForward(50);
		// robot.rotate(90);
		// robot.goForward(50);
		// robot.rotate(90);
	}

	private void goToPoint() {
		int distance = Math.round(robot.getDistance());
		if (distance < 100) {
			robot.goForward(distance);
		} else {
			robot.goForwardSlowly(10);
			robot.rotate(10);
			goToPoint();
		}
	}

}
