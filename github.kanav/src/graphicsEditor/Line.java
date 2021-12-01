package graphicsEditor;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
// extended shape class to help draw Line
	public Line(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
		// constructor to inherit variables from shape class
	}

	
	public Shape copy() {
		// not used but needed in order to implement all the methods from the shape class
		return null;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		g.drawLine(x, y, width, height);
		// draws the shape with the indicated dimensions
	}

	@Override
	public boolean isOn(int x, int y) {
		if (x >= this.x && x <= this.x+width && y >= this.y && y <= this.y+height) {
			// if statement determines whether the mouse is on a line or not
				// if true, return true
				return true;
			}
			// if false, then return false
			return false;
	}

	@Override
	public void resize(int x1, int y1, int x2, int y2) {
	// used for resizing a line
		width = x2;
		height = y2;
		// used for defining endpoint of a line
	}
	
		
	}
