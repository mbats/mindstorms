package fr.obeo.dsl.mindstorms.behaviors;

import java.util.ArrayList;
import java.util.Collection;

import fr.obeo.dsl.mindstorms.AbstractRobot;
import lejos.robotics.navigation.NavigationListener;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Pose;
import lejos.robotics.navigation.Waypoint;

public class GoWaypoints extends RobotBehavior {

	private Navigator navigator;
	private Collection<Waypoint> waypoints;
	private Collection<Waypoint> reachedWaypoints;
	NavigationListener nl = new NavigationListener() {

		@Override
		public void pathInterrupted(Waypoint waypoint, Pose pose, int sequence) {
			// TODO Auto-generated method stub

		}

		@Override
		public void pathComplete(Waypoint waypoint, Pose pose, int sequence) {
			// TODO Auto-generated method stub

		}

		@Override
		public void atWaypoint(Waypoint waypoint, Pose pose, int sequence) {
			reachedWaypoints.add(waypoint);
		}
	};

	public GoWaypoints(AbstractRobot robot, final Collection<Waypoint> waypoints) {
		super(robot);
		navigator = robot.getNavigator();
		this.waypoints = waypoints;
		this.reachedWaypoints = new ArrayList<Waypoint>();
		for (Waypoint waypoint : waypoints) {
			navigator.addWaypoint(waypoint);
		}
		navigator.addNavigationListener(nl);
	}

	@Override
	public boolean takeControl() {
		return stop == false && true;
	}

	@Override
	public void action() {
		suppressed = false;
		for (Waypoint waypoint : waypoints) {	
			if (!reachedWaypoints.contains(waypoint)) {				
				navigator.goTo(waypoint);
				while (robot.isMoving() && !suppressed) {
					Thread.yield();
				}
			}
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
