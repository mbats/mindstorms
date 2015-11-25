package fr.obeo.dsl.mindstorms.robots;


import fr.obeo.dsl.mindstorms.AbstractRobot;
import lejos.utility.Delay;

public class Robot0 extends AbstractRobot {
	final static Robot0 robot = new Robot0();

	public static void main(String[] args) {
		robot.run();
	}

	@Override
	public void execute() {
		
		while (true) {			
			if (robot.touchSensorIsPressed()) {
				robot.grab();
				Delay.msDelay(500);
				robot.release();
			}
			Delay.msDelay(1000);
		}
		
		
//		while (true) {
//			
//			EV3ColorSensor colorSensor = robot.getColorSensor();
//			int colorID = colorSensor.getColorID();
//			switch (colorID) {
//			case Color.BLACK:
//				System.out.println("ColorID BLACK");
//				break;
//			case Color.BLUE:
//				System.out.println("ColorID BLUE");
//				break;
//			case Color.GREEN:
//				System.out.println("ColorID GREEN");
//				break;
//			case Color.RED:
//				System.out.println("ColorID RED");
//				break;
//			case Color.BROWN:
//				System.out.println("ColorID BROWN");
//				break;
//			case Color.GRAY:
//				System.out.println("ColorID GRAY");
//				break;
//			case Color.CYAN:
//				System.out.println("ColorID CYAN");
//				break;
//			case Color.ORANGE:
//				System.out.println("ColorID ORANGE");
//				break;
//			case Color.MAGENTA:
//				System.out.println("ColorID MAGENTA");
//				break;
//			case Color.PINK:
//				System.out.println("ColorID PINK");
//				break;
//			case Color.YELLOW:
//				System.out.println("ColorID YELLOW");
//				break;
//			case Color.DARK_GRAY:
//				System.out.println("ColorID DARK GRAY");
//				break;
//			case Color.LIGHT_GRAY:
//				System.out.println("ColorID LIGHT GRAY");
//				break;
//			case Color.WHITE:
//				System.out.println("ColorID WHITE");
//				break;
//			case Color.NONE:
//				System.out.println("ColorID NONE");
//				break;
//			default:
//				System.out.println("ColorID UNKNOWN");
//				break;
//			}
//			System.out.println("-----------");
//			Delay.msDelay(3000);
//		}

	}
}
