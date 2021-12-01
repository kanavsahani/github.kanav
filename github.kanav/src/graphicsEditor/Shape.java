package graphicsEditor;
import java.awt.Color;
import java.awt.Graphics;	
public abstract class Shape {
	protected int x, y, width, height;
	protected Color c;
	protected String type;
	// shape class with instance variables to determine different important parts of the shape
	// example: x coordinate, y coordinate, width, height, color
	public Shape(int x,int y, int w, int h, Color c) {
		// constructor used to define all the inputs and important instance variables (and make them usable)
		this.x = x; this.y = y;
		width = w; height = h;
		this.c = c;
	}
	public void move(int x1, int y1, int x2, int y2) {
		// calculate the width and height basically (looks similar to slope formula for a reason)
		x = x2-x1; y = y2-y1;
	}
	public abstract Shape copy(); // (I didn't get advanced enough in the program to use this but I didn't want to delete it because I did not want to tamper with the given methods)
	public abstract void draw(Graphics g);
	public abstract boolean isOn(int x, int y);
	public abstract void resize(int x1, int y1, int x2, int y2);
	// defining classes that will be used in the extended shape classes (circle, rectangle, text, etc.)
}

