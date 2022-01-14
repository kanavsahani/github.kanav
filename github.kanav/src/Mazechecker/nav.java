package Mazechecker;

import java.awt.Color;

public class nav extends Bot{
String mode = "forward";
 // The solution to the maze
int startX, startY; // Starting X and Y values of maze
int endX, endY;     // Ending X and Y values of maze

	
	public nav(MazeRunner mr, Color c) {
		super(mr,c);
		
	}

	public void move() {

		if (mode.equals("forward")) {
			moveForward();
			mode = "left";
			
		}		
		else {
			turnLeft();
			mode = "forward";
		}
	}
}

