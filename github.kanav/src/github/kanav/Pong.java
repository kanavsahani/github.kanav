package github.kanav;
// filler code for pong provided by Mr. David

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

public class Pong extends JPanel implements KeyListener {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 600, HEIGHT = 600, WINDOW_HEIGHT = 650;
	private final int PADDLE_WIDTH = 20, DIAM = 20, PADDLE_HEIGHT = 100;
	private final int PADDLE_SPEED = 10;
	private int x = WIDTH/2, y = HEIGHT/2, speedX = 2, speedY = 2, PADDLE_LOCATION = 0, PADDLE_LOCATION2 = 0, x3 = 0, x4 = 0;

	
	// your instance variables here, I've given you a few 
	private boolean solo = false;
	
	
	// this method moves the ball at each timestep
	public void move_ball() {

		x += speedX;
		y += speedY;
		
		
		// this tells the random speed of the ball in each direction
	}
	
	// this method moves the paddles at each timestep
	public void move_paddles() {
		if (PADDLE_LOCATION <= 0) {
			PADDLE_LOCATION = 0;
		}
		if (PADDLE_LOCATION >= HEIGHT-PADDLE_HEIGHT) {
			PADDLE_LOCATION = HEIGHT-PADDLE_HEIGHT;
		}
		if (PADDLE_LOCATION2 <= 0) {
			PADDLE_LOCATION2 = 0;
		}
		if (PADDLE_LOCATION2 >= HEIGHT-PADDLE_HEIGHT) {
			PADDLE_LOCATION2 = HEIGHT-PADDLE_HEIGHT;
		}
		// your code here // 
	}
	
	// this method checks if there are any bounces to take care of,
	// and if the ball has reached a left/right wall it adds to 
	// the corresponding player's score
	public void check_collisions() {
		
		if (x <= 0) {
			x = 0;
			speedX = (int)(Math.random()*3)+2;
			x3++;
		}
		if(y >= HEIGHT-35) {
			speedY = (int)(Math.random()*3)-5;
		}
		
		if(y <= 0) {
			speedY = (int)(Math.random()*3)+2;
		}
		if (x >= WIDTH-35) {
			speedX = (int)(Math.random()*3)-5;
			x4++;
		}
		if(x <= PADDLE_WIDTH && y+DIAM <= PADDLE_LOCATION+PADDLE_HEIGHT && y >= PADDLE_LOCATION ) {
			speedX = (int)(Math.random()*3)+2;
		}
		// ONE X AND 2 Y's
		if(x+DIAM >= WIDTH-35 && y <= PADDLE_LOCATION2+PADDLE_HEIGHT && y >= PADDLE_LOCATION2) {
			speedX = (int)(Math.random()*3)-5;
		}
	}
	

	// defines what we want to happen anytime we draw the game
	// you simply need to fill in a few parameters here
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(new Color(109,233,249));
		g.fillOval(x, y, DIAM, DIAM);
		g.fillRect(WIDTH-600,PADDLE_LOCATION,PADDLE_WIDTH,PADDLE_HEIGHT);
		g.setColor(new Color(109,233,249));
		g.fillRect(WIDTH-35,PADDLE_LOCATION2,PADDLE_WIDTH,PADDLE_HEIGHT);
		// draw your rectangles and circles here
		// .......
		
		// writes the score of the game - you just need to fill the scores in
		Font f = new Font("Arial", Font.BOLD, 14);
		g.setFont(f);
		g.setColor(Color.red);
		g.drawString("P1 Score: " + x3, WIDTH/5, 20);
		g.drawString("P2 Score: " + x4, WIDTH*3/5, 20);
	}

	// defines what we want to happen if a keyboard button has 
	// been pressed - you need to complete this
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// changes paddle direction based on what button is pressed
		if (keyCode == KeyEvent.VK_DOWN) 
			PADDLE_LOCATION2 += PADDLE_SPEED;
		
		if (keyCode == KeyEvent.VK_UP) 
			PADDLE_LOCATION2 -= PADDLE_SPEED;

		if (e.getKeyChar() == 'w')
			PADDLE_LOCATION -= PADDLE_SPEED;
		
		if (e.getKeyChar() =='s')
			PADDLE_LOCATION += PADDLE_SPEED;
			
		// turn 1-player mode on
		if (e.getKeyChar() == '1')
			solo = true;
			
		// turn 2-player mode on
		if (e.getKeyChar() == '2') 
			solo = false;
	}

	// defines what we want to happen if a keyboard button
	// has been released - you need to complete this
	public void keyReleased(KeyEvent e) {	
	}
	
	// restarts the game, including scores
	public void restart() {

		
			x3 = 0;
			x4 = 0;
			
		
	}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual game.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws the game
			repaint();
			
			// we move the ball, paddle, and check for collisions
			// every hundredth of a second
			move_ball();
			move_paddles();
			check_collisions();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new Pong();
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public Pong() {
		JFrame frame = new JFrame();
		JButton button = new JButton("restart");
		frame.setSize(WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.add(button, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
				Pong.this.requestFocus();
			}
		});
		this.addKeyListener(this);
		this.setFocusable(true);
		
		run();
	}
	
	// method does nothing
	public void keyTyped(KeyEvent e) {}
}