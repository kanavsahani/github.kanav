package BallClass;
import java.awt.Color;

public class BouncingBall extends Ball{
	public BouncingBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}
	public void move() {
		super.move();
			if (getX() + getRad() > WIDTH || getX() <= 0) {
				setXSpeed(-getXSpeed());
			}
			if (getY() + getRad() > WIDTH || getY() <= 0) {
				setYSpeed(-getYSpeed());
			}
	}
	
}
