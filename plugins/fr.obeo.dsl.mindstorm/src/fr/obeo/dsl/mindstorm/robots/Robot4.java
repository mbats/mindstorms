package fr.obeo.dsl.mindstorm.robots;

import java.util.ArrayList;
import java.util.List;

import fr.obeo.dsl.mindstorm.AbstractRobot;
import fr.obeo.dsl.mindstorm.behaviors.AvoidObstacle;
import fr.obeo.dsl.mindstorm.behaviors.GrabBottle;
import fr.obeo.dsl.mindstorm.behaviors.GoForward;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/**
 * Full behavior robot.
 */
public class Robot4 extends AbstractRobot {
	final static AbstractRobot robot = new Robot4(120000); // 2 minutes game time 

	public Robot4(int gameTime) {
		super(gameTime);
	}

	public static void main(String[] args) {
		robot.run();
	}

	@Override
	public void execute() {
		List<Behavior> behaviors = new ArrayList<Behavior>();
		behaviors.add(new GoForward(robot));
		behaviors.add(new GrabBottle(robot));
		behaviors.add(new AvoidObstacle(robot));
		Arbitrator arbitrator = new Arbitrator((Behavior[]) behaviors.toArray(new Behavior[behaviors.size()]));
		arbitrator.start();
		
	}
}
