package SpaceInvaders;

// Space Invaders Filler Code by Mr. David

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class SpaceInvadersFiller {
	
	// constants for various aspects of the game
	// feel free to change them to make the game harder/easier
	private final int WIDTH = 1000, HEIGHT = 700, NUMALIENS = 20, ALIENSPEED = 4, LASERSPEED = 7, PLAYERSPEED = 6,
			LASERWIDTH = 8, LASERHEIGHT = 25, PLAYERENEMYWIDTH = 50, PLAYERENEMYHEIGHT = 35;
	
	// determines the difficulty. The closer to 1.0, the easier the game 
	private final double DIFFICULTY = .99;
	
	// our list of aliens
	private ArrayList<SpaceThing> aliens = new ArrayList<SpaceThing>();
	
	// our list of list of lasers for both the player and the aliens
	private ArrayList<Laser> alienLasers = new ArrayList<Laser>();
	private ArrayList<Laser> playerLasers = new ArrayList<Laser>();
	
	// the player
	private SpaceThing player;
	
	// the current speed of the player as well as their remaining lives
	private int lives = 3, playerSpeed = 0;
	
	// booleans to keep track of the game's progress
	private boolean lost = false, paused = true;
	private boolean won = false;
	
	
	// move the aliens, the lasers, and the player. Loops aliens when necessary, 
	// and randomly shoots lasers from the aliens
	public void move() {
		player.moveX(playerSpeed);
		if ( player.x >= WIDTH-PLAYERENEMYWIDTH) {
			player.x = 1;
		}
		if (player.x <= 0) {
			player.x = WIDTH - PLAYERENEMYWIDTH;
		}
		for ( int i = 0; i < playerLasers.size(); i++) {
			playerLasers.get(i).moveY(-LASERSPEED);
		}
		for ( int i = 0; i < aliens.size(); i++) {
			aliens.get(i).moveX(ALIENSPEED);
		}
		
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).x > WIDTH) {
				aliens.get(i).x = 0;
				aliens.get(i).y += 40;
			}
			if (Math.random() > DIFFICULTY) {
				alienLasers.add(new Laser(aliens.get(i).x+PLAYERENEMYWIDTH/2, aliens.get(i).y+PLAYERENEMYHEIGHT/2, LASERWIDTH, LASERHEIGHT, "Images/lasa.png"));
			}
		}
		for ( int i = 0; i < alienLasers.size(); i++) {
			alienLasers.get(i).y += LASERSPEED;
		}
		if (aliens.size() == 0) {
			won = true;
		}
		if (lives == 0) {
			lost = true;
		}
			
		
	}
	
	// check for collisions between alien lasers and the player
	// and between player lasers and the aliens
	// check if the aliens have reached the ground
	public void checkCollisions() {
		
		for ( int i = 0; i < alienLasers.size(); i++) {
			if (player.intersects(alienLasers.get(i))) {
				lives--;
				alienLasers.remove(i);
			}
//			for ( int j = 0; i < playerLasers.size(); j ++) {
//				if (playerLasers.get(j).intersects(alienLasers.get(i))) {
//					playerLasers.remove(j);
//					alienLasers.remove(i);
//				}
//			}
		}
		for ( int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).y >= HEIGHT) {
				lost = true;
			}
			for (int j = 0; j < playerLasers.size(); j++)
				if (playerLasers.get(j).intersects(aliens.get(i))) {
					aliens.remove(i);
					playerLasers.remove(j);
					break;
				}
			}
		}	
	
	// set up your variables, lists, etc here
	public void setup() {
		int alienX = 10;
		int alienY = 50;
		int playerX = WIDTH/2;
		int playerY = HEIGHT-100;
		for (int i = 0; i < NUMALIENS; i++) {
			if (alienX > WIDTH-50) {
				alienX = 10;
				alienY += 50;
			}
			aliens.add(i, new SpaceThing(alienX, alienY, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/alien.png"));
			alienX += ALIENSPEED*15;
		}
		player = new SpaceThing(playerX, playerY, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/playerCannon.jpg");

	}
	
	// fires a player laser. if there are currently less than 4 lasers on the screen,
	// adds to the list. if there are 4 lasers on the screen, removes a laser and 
	// replaces it with this new one
	public void fireLaser() {
			playerLasers.add(new Laser(player.x+10, player.y-PLAYERENEMYHEIGHT, LASERWIDTH, LASERHEIGHT, "Images/lasa.png"));
			if (playerLasers.size() > 4) {
				playerLasers.remove(0);
			}
	}
	
	// draw a black background along with your lasers, aliens, and player here
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		for ( int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		player.draw(g);
		for ( int i = 0; i < playerLasers.size(); i++) {
			playerLasers.get(i).draw(g);
		}
		for ( int i = 0; i < alienLasers.size(); i++) {
			alienLasers.get(i).draw(g);
		}
		
		// your code here
		

		g.setColor(Color.red);
		g.drawString("Lives: "+lives, 15, 15);
		
		if (lost) 
			g.drawString("You lose", WIDTH/2-25, HEIGHT/2);
		if (won) 
			g.drawString("You win!", WIDTH/2-25, HEIGHT/2);
	}
	
	// ******* DON'T TOUCH BELOW CODE ************//
	
	public SpaceInvadersFiller() {
		setup();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {draw(g);}
		};
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Left");
		canvas.getActionMap().put("Left", new LeftAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "LeftRelease");
		canvas.getActionMap().put("LeftRelease", new LeftReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), " ");
		canvas.getActionMap().put(" ", new SpaceAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Right");
		canvas.getActionMap().put("Right", new RightAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "RightRelease");
		canvas.getActionMap().put("RightRelease", new RightReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0, false), "Pause");
		canvas.getActionMap().put("Pause", new PauseAction());
		frame.add(canvas);
		frame.setVisible(true);
		
		while (true) {
			if (!paused && !lost && !won) {
				move();
				checkCollisions();
				frame.getContentPane().repaint();
			}
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {}
		}
	}
	
	private class RightAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = PLAYERSPEED;
		}
	}
	private class LeftAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = -PLAYERSPEED;
		}
	}
	private class LeftReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = 0;
		}
	}
	private class RightReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = 0;
		}
	}
	private class SpaceAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			fireLaser();
		}
	}
	private class PauseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			paused = !paused;
		}
	}
	
	public static void main(String[] args) {
		new SpaceInvadersFiller();
	}
}
