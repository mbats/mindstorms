package fr.obeo.dsl.mindstorm;

import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.Color;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.robotics.geometry.Point;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.MoveController;
import lejos.robotics.navigation.Pose;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Timer;
import lejos.utility.TimerListener;

public abstract class AbstractRobot {
	private static final int TIMER = 30000;
	private static final int TRACK_WIDTH = 120;
	private static final int WHEEL_DIAMETER = 56;

	private RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	private RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	private RegulatedMotor grabMotor = new EV3LargeRegulatedMotor(MotorPort.D);
	private EV3UltrasonicSensor sonar = new EV3UltrasonicSensor(SensorPort.S4);
	private EV3TouchSensor touch = new EV3TouchSensor(SensorPort.S3);
	private EV3ColorSensor color = new EV3ColorSensor(SensorPort.S2);
	private DifferentialPilot pilot = new DifferentialPilot(WHEEL_DIAMETER, TRACK_WIDTH, leftMotor, rightMotor);
	private OdometryPoseProvider poseProvider = new OdometryPoseProvider(pilot);
	private Pose goal;

	public enum PlaygroundArea {
		BASE, NEUTRAL, OPPONENT_BASE
	}

	public abstract void execute();

	public void waitForStartSignal() {
		System.out.println("Ready...");
		Button.waitForAnyPress();
	}

	public void run() {
		// Wait for start signal
		this.waitForStartSignal();

		// Initialize timer
		Timer timer = new Timer(TIMER, new TimerListener() {
			@Override
			public void timedOut() {
				System.out.println("Stop");
				pilot.stop();
				leftMotor.close();
				rightMotor.close();
				sonar.close();
				System.exit(0);
			}
		});

		// Start timer
		timer.start();

		// Launch robot execution
		try {
			this.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		timer.stop();
	}

	public void explore(double distance, double angle) {
		pilot.rotate(angle);
		pilot.travel(distance);
	}

	public void goForward() {
		pilot.forward();
	}

	public Behavior detectObstacle() {
		return null;
		// TODO if obstacle detected stop
	}

	public int getColor() {
		// TODO Detect color
		return Color.BLACK;
	}

	public void returnToBase() {
		goTo(0, 0);
	}

	public void goTo(float x, float y) {
		Pose currentPose = poseProvider.getPose();
		float heading = currentPose.relativeBearing(new Point(x, y));
		float distance = currentPose.distanceTo(new Point(x, y));
		pilot.rotate(heading);
		pilot.travel(distance);
	}

	public void stop() {
		pilot.stop();
	}

	public MoveController getPilot() {
		return pilot;
	}

	public Pose getGoal() {
		return goal;
	}

	public Pose getCurrentPosition() {
		return poseProvider.getPose();
	}

	public boolean touchSensorIsPressed() {
		try {
			SampleProvider sampleProvider = touch.getTouchMode();
			float[] sample = new float[1];
			sampleProvider.fetchSample(sample, 0);
			return sample[0] == 1;
		} catch (IndexOutOfBoundsException ex) {
			return false;
		}
	}

	public void release() {
		grabMotor.backward();
		while (!grabMotor.isStalled())
			Thread.yield();
	}

	public void grab() {
		grabMotor.forward();
		while (!grabMotor.isStalled())
			Thread.yield();
	}

	public boolean isMoving() {
		return pilot.isMoving();
	}

	public float getColoredPoint() {
		try {
			SampleProvider sampleProvider = color.getColorIDMode();
			float[] sample = new float[1];
			sampleProvider.fetchSample(sample, 0);
			return sample[0];
		} catch (IndexOutOfBoundsException ex) {
			return Color.NONE;
		}
	}
}
