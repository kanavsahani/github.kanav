package BallClass;

import java.awt.Color;

public class ColorBall extends BouncingBall {
	int count;
	Color[] colorList = {Color.BLUE, Color.RED,Color.ORANGE, Color.MAGENTA,
            Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.CYAN, 
            Color.DARK_GRAY, Color.LIGHT_GRAY};
	public ColorBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color color) {
		super(startx, starty, startrad, startxspeed, startyspeed, Color.GRAY);
	}
	public void setColor() {
		super.setColor(colorList[(int)(Math.random()*11)]);
		
	}
	public void move() {
		super.move();
		count++;
		if (count%15 == 0)
		setColor();
	}
}
