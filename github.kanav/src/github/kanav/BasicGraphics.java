package github.kanav;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BasicGraphics extends JPanel{
	public BasicGraphics() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final double height = screenSize.getHeight(), width = screenSize.getWidth();
		JFrame window = new JFrame();
		window.setSize((int)width, (int)height);
		Image img;
		img = Toolkit.getDefaultToolkit().getImage("Krusty.jpg");
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		JPanel container = new JPanel();
		JPanel canvas = new JPanel() {
			public void paint (Graphics G) {
				
				super.paint(G);
				G.setColor(Color.cyan);
				G.fillRect(0, 0, (int)width, (int)height/2);
				G.drawImage(img, 50, 50, (int)width, (int)height/2, this);
			}
			
		};
		canvas.setPreferredSize(new Dimension((int)width, (int)height/2));
		container.add(canvas);
		JPanel canvas2 = new JPanel() {
			public void paint (Graphics g) {
				super.paint(g);
				g.setColor(Color.red);
				g.fillRect(0, 0, (int)width, (int)height/2);
				g.drawImage(img, 50, 50, (int)width, (int)height/2, this);
			}
		};
		canvas2.setPreferredSize(new Dimension((int)width, (int)height/2));
		container.add(canvas2);
		window.add(container);
		
		window.setVisible(true);
	}
	
	public static void main (String[] args) {
		new BasicGraphics();
	}
}
