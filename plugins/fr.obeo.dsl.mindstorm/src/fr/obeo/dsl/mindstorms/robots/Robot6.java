package fr.obeo.dsl.mindstorms.robots;

import java.util.ArrayList;
import java.util.List;

import fr.obeo.dsl.mindstorms.AbstractRobot;
import fr.obeo.dsl.mindstorms.behaviors.AvoidObstacle;
import fr.obeo.dsl.mindstorms.behaviors.GoWaypoints;
import fr.obeo.dsl.mindstorms.behaviors.GrabBottle;
import lejos.robotics.geometry.Point;
import lejos.robotics.navigation.Waypoint;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/**
 * Full behavior robot.
 */
public class Robot6 extends AbstractRobot {
	final static AbstractRobot robot = new Robot6(120000); // 2 minutes game time 

	public Robot6(int gameTime) {
		super(gameTime);
	}

	public static void main(String[] args) {
		robot.run();
	}

	@Override
	public void execute() {
		List<Waypoint> waypoints = new ArrayList<Waypoint>();
		Waypoint w1 = new Waypoint(new Point(1000, 0));
		Waypoint w2 = new Waypoint(new Point(0, 1000));
		Waypoint w3 = new Waypoint(new Point(-1000, 0));
		Waypoint w4 = new Waypoint(new Point(0, -1000));
		waypoints.add(w1);
		waypoints.add(w2);
		waypoints.add(w3);
		waypoints.add(w4);
		List<Behavior> behaviors = new ArrayList<Behavior>();
		behaviors.add(new GoWaypoints(robot, waypoints));
		behaviors.add(new GrabBottle(robot));
		behaviors.add(new AvoidObstacle(robot));
		Arbitrator arbitrator = new Arbitrator((Behavior[]) behaviors.toArray(new Behavior[behaviors.size()]));
		arbitrator.start();
		
	}
}
