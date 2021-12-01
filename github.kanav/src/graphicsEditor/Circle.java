package graphicsEditor;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
// extended shape class to help draw a circle
	public Circle(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
		// constructor to inherit variables from shape class
	}

	public Shape copy() {
		// not used but needed in order to implement all the methods from the shape class
		return null;
	}

	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, width, height);
		// draws the shape with the indicated dimensions
	}

	@Override
	public boolean isOn(int x, int y) {
		if (x >= this.x && x <= this.x+width && y >= this.y && y <= this.y+height) {
		// if statement determines whether the mouse is in a circle or not
			// if true, return true
			return true;
		}
		// if false, then return false
		return false;
	}

	@Override
	public void resize(int x1, int y1, int x2, int y2) {
		// used for resizing a shape. if statements are there for determining if the mouse is to 
		// the left of the starting coordinate or above the starting coordinate
		// defining variables here (width defined, x defined, height defined, y defined)
		if (x2-x1 < 0) {
			width = Math.abs(x2-x1);
			x = x2;
		}
		else {
			width = x2-x1;
		}
		if (y2-y1 < 0) {
			height = Math.abs(y2-y1);
			y = y2;
		}
		else {
			height = y2-y1;
		}
		
	}

}
