package ShapeClass;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends Shape{
	private int rectWidth;
	private int rectHeight;
	public Rect (int rectWidth, int rectHeight){
		super(40, 30);
		this.rectWidth = rectWidth;
		this.rectHeight = rectHeight;
	}
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(getX(), getY(), rectWidth, rectHeight);
	}
}
