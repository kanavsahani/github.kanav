package ShapeClass;

import java.awt.Color;
import java.awt.Graphics;

public class Arc extends Oval{
	private int ArcWidth;
	private int ArcHeight;
	private int startAngle;
	private int arcAngle;
	
	public Arc (int ArcWidth, int ArcHeight, int startAngle, int arcAngle) {
		super(300, 500);
		this.ArcWidth = ArcWidth;
		this.ArcHeight = ArcHeight;
		this.startAngle = startAngle;
		this.arcAngle = arcAngle;
	}
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawArc(getX(), getY(), ArcWidth, ArcHeight, startAngle, arcAngle);
	}
}
