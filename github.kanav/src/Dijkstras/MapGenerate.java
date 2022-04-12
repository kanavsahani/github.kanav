package Dijkstras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import graphMap.Graph;

public class MapGenerate {

Image img;
public static final int WIDTH = 1200, HEIGHT = 1000;
public Distancegraph<String, Integer[]> drawPoints = new Distancegraph();

	
	public MapGenerate() {
		img = Toolkit.getDefaultToolkit().getImage("/Images/US.jpg"); // variable for the image
		JFrame frame = new JFrame();
		JPanel paintPanel = new JPanel() { // paint panel
			 public void paint(Graphics g) { // paint method
				g.setColor(Color.gray); // sets the color of background
				g.drawImage(img, 0, 0, MapGenerate.this.WIDTH, MapGenerate.this.HEIGHT, this); // draw the 1st gif		
				drawPoints.paint(g);
			 } // closing bracket
		 }; // closing bracket
		 Writer fileWriter = null;
		 JButton finishVertices = new JButton();
		 finishVertices.addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
//				paintPanel.// remove mouse listener and add a new one for the paint panel that will create lines between the two vertices that are clicked
				// add the names to the text files of which vertices are connected by lines
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		 });
		try {
			fileWriter = new FileWriter("UserInputs.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // create a new file for holding the data
		BufferedWriter writer = new BufferedWriter(fileWriter); // new writer to write in the data
		 paintPanel.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				String value = JOptionPane.showInputDialog("Type in the name of the state you clicked on.");
				drawPoints.add(value, e.getX(), e.getY());
				System.out.println(value);
				try { // try catch method for catching errors
					writer.write(value + "\n"); // write the String with the result
//					writer.write(value + "is connected to" + value-1);
				}catch(Exception ex) { // catch errors
					ex.printStackTrace();
				} //ALSO STORE ITS NEIGHBORS/CONNECTIONS
			}
			public void mousePressed(MouseEvent e) {}public void mouseReleased(MouseEvent e) {}public void mouseEntered(MouseEvent e) {}public void mouseExited(MouseEvent e) {}
		 });
		 frame.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			        if (JOptionPane.showConfirmDialog(frame, 
			            "Are you sure you want to close this window?", "Close Window?", 
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			            try {
							writer.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
			            System.exit(0);
			        }
			            else {
			            	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			            }
			        }
			});
		frame.setSize(WIDTH, HEIGHT);
		frame.add(paintPanel);
//		frame.add(finishVertices);
		frame.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new MapGenerate();
	}
}
