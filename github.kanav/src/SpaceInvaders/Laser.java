package SpaceInvaders;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Laser extends Rectangle {
	
	private Image img;
	
	public Laser(int x, int y, int w, int h, String imgName) {
		super(x, y, w, h);
		try {
			img = ImageIO.read(new File(imgName)).getScaledInstance(w, h, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.out.println("Image file not found");
		}
	}
	
	public void moveY(int dY) {
		y += dY;
	}
	
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	
}
