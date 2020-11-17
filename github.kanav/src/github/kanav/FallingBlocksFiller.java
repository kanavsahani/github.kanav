package github.kanav;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FallingBlocksFiller extends JPanel {
	
	private int WIDTH = 800, HEIGHT = 600, NUMBLOCKS = 50, DIAM = 20;

	// instance variables (what kind of data structure should we use?)
	private int[] y = new int[NUMBLOCKS], x = new int[NUMBLOCKS],
			yVel = new int[NUMBLOCKS];
	
	
	// your code here
	
	// fills in your arrays with random x and y values
	public void initializeArrays() {
		
		for (int i = 0; i < x.length; i++) {
			x[i] = (int)(Math.random()*WIDTH-DIAM);
			yVel[i] = (int)(Math.random()*10) + 2;
		}
	}
	
	// change your arrays here to make the blocks move
	public void moveblocks() {

		for ( int i = 0; i < y.length; i++) {
			
			y[i] += yVel[i];
			if (y[i] > HEIGHT) {
				y[i] = 0;
			}
		}
		
		// your code here
	}
	
	// change the last part of this method!
	public void paint(Graphics g) {
		// give a white background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// color the rectangles blue - you can change this
		
		
		for (int i = 0; i < NUMBLOCKS; i++) {
			g.setColor(new Color(((int)(Math.random() *255)), ((int)(Math.random() *255)), ((int)(Math.random() *255))));
			g.fillRect(x[i], y[i], DIAM, DIAM);
			
		}
		// draw your rectangles here! 
		
	}
	
	// ******** DON'T TOUCH BELOW CODE ***************
	
	// don't touch this method!
	public FallingBlocksFiller() {
		initializeArrays();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);

		while (true) {
			moveblocks();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			WIDTH = frame.getSize().width;
			HEIGHT = frame.getSize().height;
		}
	}

	// don't touch this method!
	public static void main(String[] args) {
		new FallingBlocksFiller();
	}

}