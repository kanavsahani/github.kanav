package Dijkstras;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import Dijkstras.Distancegraph.Vertex;
import graphMap.Graph;

public class MapGenerate {

Image img;
public static final int WIDTH = 1200, HEIGHT = 1000;
public Distancegraph drawPoints = new Distancegraph();
Vertex temp;
Boolean Generator = true;
Vertex v1;
Vertex v2;
String modeChoice = "Point Making Mode";
	
	public MapGenerate() {
		img = Toolkit.getDefaultToolkit().getImage("Images/US.jpg"); // variable for the image
		JFrame frame = new JFrame();
		JPanel containerPanel = new JPanel();
		JPanel paintPanel = new JPanel() { // paint panel
			 public void paint(Graphics g) { // paint method
				g.setColor(Color.gray); // sets the color of background
				g.drawImage(img, 0, 0, MapGenerate.this.WIDTH, MapGenerate.this.HEIGHT, this); // draw the 1st gif	
				
			 } // closing bracket
		 }; // closing bracket
		 Writer fileWriter = null;
		 JButton RouteFindingMode = new JButton();
		 
		 frame.repaint();
		 RouteFindingMode.setText("Change Mode" +  " " + modeChoice);
		 RouteFindingMode.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e) {
				Generator = !Generator;
				if (Generator == true) {
					 modeChoice = "Point Making Mode";
				 }
				 else {
					 modeChoice = "Route Finding Mode";
				 }
				RouteFindingMode.setText("Change Mode" +  " " + modeChoice);
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
			int counter = 0;
			
		// if in generator Mode (making vertices) do all this. if False, do route finding mode (finding shortest route) create a new button and give it an action listener. if pressed, make a boolean that changes to false, adn then inside current mouse listener, amke a route listener

			if (Generator == true) {
				for (Vertex s: drawPoints.vertices.values()) {
					int distance = (int) Math.sqrt((s.y - e.getY()) * (s.y - e.getY()) + (s.x - e.getX()) * (s.x - e.getX()));
					if (distance < 50) {// if cursor equals x value from the distancegraph
						if (temp != null) {
							drawPoints.connect(s.info, temp.info, distance);
							drawPoints.paint(paintPanel.getGraphics());
						}

						temp = s;
						counter++;
					}
				}
					if (counter == 0) {
						String value = JOptionPane.showInputDialog("Type in the name of the state you clicked on.");
						while (value == null || value.equals("")) {
							value = JOptionPane.showInputDialog("Type in the name of the state you clicked on.");
						}
						
						
						drawPoints.add(value, e.getX(), e.getY());
						drawPoints.paint(paintPanel.getGraphics());
						System.out.println(value);
						try { // try catch method for catching errors
							writer.write(value + "\n"); // write the String with the result
						}catch(Exception ex) { // catch errors
							ex.printStackTrace();
						}
					}


			}
			if (Generator == false) {
				
				for (Vertex s: drawPoints.vertices.values()) {
					int distance = (int) Math.sqrt((s.y - e.getY()) * (s.y - e.getY()) + (s.x - e.getX()) * (s.x - e.getX()));
					if (distance > 50) { continue; }
						if(v1 == null) {
							v1 = s;
						}else if(v2 == null) {
							v2 = s;
						}				
					}
				
				if (v1 != null && v2 != null) {
					System.out.println(v1.toString());
					System.out.println(v2.toString());
					JOptionPane.showMessageDialog(paintPanel, drawPoints.search(v1, v2));
					v1 = null;
					v2 = null;
				}
				
			}
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
		paintPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT-50));
		containerPanel.setPreferredSize(new Dimension(WIDTH-50, HEIGHT-(HEIGHT-50)));
		frame.setSize(WIDTH, HEIGHT);
		containerPanel.add(RouteFindingMode);
		containerPanel.add(paintPanel);
		frame.add(containerPanel);
		frame.setVisible(true);


	}
	public static void main(String[] args) {
		new MapGenerate();
	}
}
