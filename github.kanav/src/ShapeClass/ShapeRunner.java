package ShapeClass;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class ShapeRunner {
	
	private Shape[] shapes = new Shape[4];
	
	// this method should move all the shapes in the list
	public void moveShapes() {
		for (int i = 0; i < shapes.length; i++)
		shapes[i].move(5, 5);
		// your code here
	}
	
	// fill in your shape list here
	public void setup() {
		Shape myShape = new Shape(50, 200);
		Shape myRect = new Rect(100, 100);
		Shape myOval = new Oval(200, 40);
		Shape myArc = new Arc(300, 50, 135, 50);
		shapes[0] = myShape;
		shapes[1] = myRect;
		shapes[2] = myOval;
		shapes[3] = myArc;
		
		// your code here
	}
	
	// DON'T TOUCH BELOW CODE
	
	public void run() {
		while (true ) {
			moveShapes();
			frame.repaint();
			try {
				Thread.sleep(75);
			} catch (Exception ex) {}
		}
	}
	
	public static void main(String[] args) {
		new ShapeRunner(); 
	}
	private JFrame frame;
	public ShapeRunner() {
		setup();
		frame = new JFrame() {
			public void paint(Graphics g) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, 600, 600);
				
				for (Shape s: shapes)
					s.draw(g);
			}
		};
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		run();
	}
}