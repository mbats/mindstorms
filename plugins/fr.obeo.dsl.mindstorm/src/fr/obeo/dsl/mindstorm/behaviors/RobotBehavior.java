package fr.obeo.dsl.mindstorm.behaviors;

import fr.obeo.dsl.mindstorm.AbstractRobot;
import lejos.robotics.subsumption.Behavior;

public abstract class RobotBehavior implements Behavior {
	protected AbstractRobot robot;
	protected boolean suppressed = false;
	protected boolean stop = false;
	
	public RobotBehavior(AbstractRobot robot) {
		this.robot = robot;
	}
}
