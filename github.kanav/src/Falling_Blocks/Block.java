package Falling_Blocks;

import java.awt.Color;
import java.awt.Graphics;

public class Block {
	private int x, y, speed;
	private Color color;
	
	public Block(int x, int y, Color color, int speed) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.speed = speed;
	}
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 10, 10);
	}
	public void move() {
		y+= speed;
	}
	public int getY() {
		return y;
	}
	
}
