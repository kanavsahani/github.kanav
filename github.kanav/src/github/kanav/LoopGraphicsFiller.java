package github.kanav;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*
;public class LoopGraphicsFiller extends JPanel {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 1000, HEIGHT = 590;
	private int n = 10, e = 10, ee = 200;
	// defines what we want to happen anytime we draw the graphics
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		drawCircles(g, n);
		drawBigCircles(g, n);
		drawTriangles(g);
		tenbyten(g);
		checkerboarded(g);
		
	}
	
		// call your methods here
		public void drawCircles(Graphics g, int n) {
			
			g.setColor(Color.red);
			for(int i = 0; i < n; i++) {
				g.fillOval(i*20 +600, (int)(Math.random()*5), 20, 20);
			}
			}
		public void drawBigCircles(Graphics g, int n) {
				
			g.setColor(Color.BLUE);
			for(int i = 1; i < n; i+= 1) {
					g.fillOval(i*50, 20, e, e);
				e += 10;
				}
			for(int i = 1; i < n; i+= 1) {
				g.fillOval((i+10)*50, 20, e, e);
			e -= 10;
			}
		}
		public void tenbyten(Graphics g) {
			g.setColor(Color.pink);
			      
			for ( int row = 0;  row < 10;  row++ ) {
	               for ( int col = 0;  col < 10;  col++ ) {
	                   int x = 20*col;
	                   int y = 20*row;
	                   
	                   g.fillOval(x+300,y+100,20,20);
	               }
		}
		}
			
		public void checkerboarded(Graphics g) {
			for ( int row = 0;  row < 8;  row++ ) {
	               for ( int col = 0;  col < 8;  col++ ) {
	                   int x = 20*col;
	                   int y = 20*row;
	                   if ( (row % 2) == (col % 2) )
	                      g.setColor(Color.red);
	                   else
	                      g.setColor(Color.black);
	                   g.fillRect(x+500,y+300,20,20);
	               }
	            }
			}
		
		
		    
			
		
		public void drawTriangles(Graphics g) {
			
			g.setColor(Color.green);
			
			for(int i = 0; i < 20; i++) {
				
				for (int j = 0; j <= i; j++) {
	
					g.fillOval(j*20,  i*20,  20,  20);
				}
			}
			
		}
		public void drawallthree(Graphics g) {
			g.setColor(Color.yellow);
			int x = 50, y = 50;
			g.fillRect(x,y,200,200);
			x+=5;
			
		}
		
	

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual program.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws
			//repaint();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new LoopGraphicsFiller();
		
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public LoopGraphicsFiller() {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		this.setFocusable(true);
		
		run();
	}
}
