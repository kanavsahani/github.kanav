package github.kanav;
import java.awt.BorderLayout;

// give my own description Angry Birds template provided by Mr. David
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AngryBirds extends JPanel {
	
	// the width/height of the window
	private final int W_WIDTH = 900, W_HEIGHT = 600;	
	// a constant for the gravitational pull on our 'bird'
	private final double GRAVITY = .4;
	private final int ENEMYDIAM = 25, LAUNCHERDIAM = 40;
	//variables used to determine details on the enemy positions and if they are dead or not
	private int[] enemyX = {W_WIDTH-560,W_WIDTH-420, W_WIDTH-300, W_WIDTH-200, W_WIDTH-100};
	private int[] enemyY = {W_HEIGHT/2, W_HEIGHT/2+50, W_HEIGHT/2-90, W_HEIGHT/2+150, W_HEIGHT/2-100}; // ASSIGN VALUES
	private boolean[] dead = {false, false, false, false, false};
	//variables for the images
	private Image background;	
	private Image enemies;
	private Image bird;
	private Image explosion;
	//instance variables for setting up the whole game
	private int startX, startY;
	private double speedX = 0, speedY = 0;
	private double birdX = 100, birdY = 400;
	private boolean isGravityOn = false;
	private int score = 0;
	private int ENEMYANDBIRDSIZE = 80;
	//variables for hit detection and also for running specific frames multiple times
	private int move = 20;
	private int explosionX, explosionY;
	
	// this method is for setting up any arrays that need filling in and loading images. 
	// This method will run once at the start of the game.
	public void setup() {

		// Below are a few images I used
		try {
			background = ImageIO.read(new File("the jungle.jpg"));
			enemies = ImageIO.read(new File("monke-removebg-preview.png"));
			bird = ImageIO.read(new File("banana-removebg-preview.png"));
			explosion = ImageIO.read(new File("explosion1-removebg-preview.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	// move your 'bird' and apply any gravitational pull 
	public void moveBird() {
		birdX += speedX;
		birdY += speedY;
		if(isGravityOn) {
			speedY += GRAVITY;
		}
		if (birdY >= W_HEIGHT) {
			birdY = 400;
			birdX = 100;
			isGravityOn = false;
			speedX = 0;
			speedY = 0;
		}
	}
	
	// check for any collisions between your 'bird' and the background.
	// if there is a collision, it is addressed
	public void checkHits() {
		for (int i = 0; i < enemyX.length; i++) {
			if (distance(birdX, birdY, enemyX[i],enemyY[i]) <= ENEMYDIAM/2 + LAUNCHERDIAM/2 && dead[i] == false ) {
				dead[i] = true;
				score++;
				speedX *= -0.8; 
				move = 0;
				explosionX = enemyX[i];
				explosionY = enemyY[i];
			}		
			
		}	
	}
	//distance formula below
	private double distance (double x1, double y1, double x2, double y2) {
		double dist = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));		
		return dist;
	}
	
	// what you want to happen at the moment when the 
	// mouse is first pressed down.
	public void mousePressed(int mouseX, int mouseY) {
		startX = mouseX;
		startY = mouseY;	
	}
	
	// what you want to happen when the mouse button is released
	public void mouseReleased(int mouseX, int mouseY) {
		int distDraggedX = mouseX - startX;
		int distDraggedY = mouseY - startY;
		speedX = -distDraggedX/10.0;
		speedY = -distDraggedY/10.0;
		isGravityOn = true;
	}
	// draws everything in our project - the background, your 'bird', 
	// and anything else that is present in the game
	public void paint(Graphics g) {
		// draws a white window
		g.setColor(Color.white);
		g.fillRect(0, 0, W_WIDTH, W_HEIGHT);
		
		// draws everything in the game
		g.drawImage(background, 0,0, W_WIDTH, W_HEIGHT, null);
		for (int i = 0; i < enemyX.length; i++) {
			if (dead[i] != true)
			g.drawImage(enemies, enemyX[i],enemyY[i], ENEMYANDBIRDSIZE, ENEMYANDBIRDSIZE, null);
		}
		// basically in the below statements, I use my special ability to create explosions
		// with the move variable, I manage to set a timer that allows to run these explosions for more
		// FPS which makes it visible to the human eye
		g.drawImage(bird,(int)birdX,(int)birdY, ENEMYANDBIRDSIZE, ENEMYANDBIRDSIZE, null);
		if (move < 20)
			g.drawImage(explosion, explosionX, explosionY, 100, 100, null);
		move++;
		g.drawString("Score: " + score, WIDTH/5, 20);
	}
	public void restart() {
		score = 0;
		for (int i = 0; i < enemyY.length; i++) {
			dead[i] = false;
		}
	}
	// ************** DON'T TOUCH THE BELOW CODE ********************** //
	
	public void run() {
		while (true) {
			moveBird();
			checkHits();
			repaint();
			
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {}
		}
	}
	
	public AngryBirds() {
		setup();
		
		JFrame frame = new JFrame();
		JButton button = new JButton("restart");
		frame.setSize(W_WIDTH,W_HEIGHT);
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				AngryBirds.this.mousePressed(e.getX(),e.getY());	
			}
			public void mouseReleased(MouseEvent e) {
				AngryBirds.this.mouseReleased(e.getX(),e.getY());
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		frame.add(this);
		frame.add(button, BorderLayout.SOUTH);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
				AngryBirds.this.requestFocus();
			}
		});
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		run();
	}
	public static void main(String[] args) {
		new AngryBirds();
	}
}
