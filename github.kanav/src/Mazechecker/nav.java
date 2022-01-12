package Mazechecker;

import java.awt.Color;

public class nav extends Bot{
String mode = "forward";
	
	public nav(MazeRunner mr, Color c) {
		super(mr,c);
		
	}

	public void move() {
		if (mode.equals("forward")) {
			if (this.moveForward() == true) {
				mode = "left";
			}		
			else if (mode.equals("left")) {
				turnLeft();
				mode = "forward";
			}
		else {
			turnLeft();	
		}
	}
	}
}

