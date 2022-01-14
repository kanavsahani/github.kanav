package Mazechecker;

import java.awt.Color;
import java.util.Random;

public class nav extends Bot{
String mode = "forward";
 // The solution to the maze
int startX, startY; // Starting X and Y values of maze
int endX, endY;     // Ending X and Y values of maze

	boolean pen = false;
	Random random;
	public nav(MazeRunner mr, Color c) {
		super(mr,c);
		random = new Random();
		
	}

	public void move() {
		pen = random.nextBoolean();
		if(pen)
			moveForward();
		else
			turnLeft();
	}
}

