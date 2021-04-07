package BallClass;

import java.awt.Color;

public class ShrinkingBall extends ColorBall{
	int count1 = 0;
	int count2;
	public ShrinkingBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color color) {
		super(startx, starty, startrad, startxspeed, startyspeed, color);
		count2 = getRad();
	}
	public void move() {
		super.move();
		
		int count = getRad() - 5;
		
		count1++;
		if (count1 % 15 == 0)
			setRad(count);
		if (count == 0) {
			setRad(count2);
		}
	}
}
