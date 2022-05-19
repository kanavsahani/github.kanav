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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Dijkstras.Distancegraph.Edge;
import Dijkstras.Distancegraph.Vertex;

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
				for(Vertex V: drawPoints.vertices.values()) { //make a for loop going through all the vertices and draw them all
					g.setColor(Color.BLUE);
					g.fillOval(V.x, V.y, 10, 10);
					g.setColor(Color.BLACK);
					g.drawString((String) V.info, V.x+5, V.y+5);
				for (Edge String: V.edges) {
					Vertex neighbor = String.getNeighbor(V);
					g.drawLine(V.x, V.y, neighbor.x, neighbor.y);
				}
				}
			 } // closing bracket
		 }; // closing bracket
		 load();
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
			            save();
//			            System.exit(0);
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
		drawPoints.paint(paintPanel.getGraphics());
	}
	public void save() {
		try {
			Writer writer = null; {
				try {
					writer = new FileWriter("UserInputs.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // create a new file for holding the data
				BufferedWriter Filewriter = new BufferedWriter(writer);} // new writer to write in the data
			for (Vertex v: drawPoints.vertices.values()) {
				writer.write(v.info + " " + v.x + " " + v.y + "\n");
				
			}
			writer.close();
			BufferedWriter bw = new BufferedWriter(new FileWriter("PointConnections2.txt"));
			for (Vertex v: drawPoints.vertices.values()) {
				for (Edge e: v.edges) {
					bw.write(e.v1.x + " " + e.v1.y + " " + e.v1.info + " " + e.v2.x + " " + e.v2.y + " " +e.v2.info + " " + "\n");
				}
				
			}
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void load()	{
		try {
			BufferedReader reader = new BufferedReader(new FileReader("UserInputs.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split(" ");
				
				drawPoints.add(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]));
				
			}
			reader.close();
			BufferedReader reader2 = new BufferedReader(new FileReader("PointConnections2.txt"));
			String line2 = null;
			while ((line2 = reader2.readLine()) != null) {
				String[] split = line2.split(" ");
				double y1 = Double.parseDouble(split[1]);
				double y2 = Double.parseDouble(split[4]);
				double x1 = Double.parseDouble(split[0]);
				double x2 = Double.parseDouble(split[3]);
				int distance = (int) Math.sqrt((y1 - y2) * (y1 - y2) + (x1 - x2) * (x1 - x2));
				drawPoints.connect(split[2], split[5], distance);
			}
			reader.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new MapGenerate();
	}
}
