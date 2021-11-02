package robot;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import github.kanav.BasicGraphics;

public class Robot extends JPanel{
	public int x = 50, y = 50;
	public Robot() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final double height = screenSize.getHeight(), width = screenSize.getWidth();
		JFrame window = new JFrame();
		window.setSize((int)width, (int)height);
		Image img = Toolkit.getDefaultToolkit().getImage("fnaf.jpg");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		JPanel container = new JPanel() {
			public void paint (Graphics g) {
				super.paint(g);
				g.drawImage(img, x, y, 50,50, this);
			}
		};
		container.setPreferredSize(new Dimension((int)width, (int)height/2));
		container.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					x-=50;
					if (x > (int)width-70) {
						x = 0;
					}
					if (x < 0) {
						x = (int) width-70;
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					x+=50;
					if (x > (int)width-70) {
						x = 0;
					}
					if (x < 0) {
						x = (int) width-70;
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					y-=50;
					if (y > (int)height-70) {
						y = 0;
					}
					if (y < 0) {
						y = (int) height-70;
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					y+=50;
					if (y > (int)height-70) {
						y = 0;
					}
					if (y < 0) {
						y = (int) height-70;
					}
				}
				window.getContentPane().repaint();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		
		});
		container.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
					x = e.getXOnScreen()-30;
					y = e.getYOnScreen()-50;
					container.repaint();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		window.add(container);
		window.setVisible(true);
		container.requestFocus();
	}
	public static void main (String[] args) {
		new Robot();
	}
}
