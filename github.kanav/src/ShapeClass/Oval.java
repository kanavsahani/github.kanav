package ShapeClass;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Rect{
	private int OvalWidth;
	private int OvalHeight;
	
	public Oval (int OvalWidth, int OvalHeight) {
		super(50, 200);
		this.OvalWidth = OvalWidth;
		this.OvalHeight = OvalHeight;
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval(getX(), getY(), OvalWidth, OvalHeight);
	}
}
