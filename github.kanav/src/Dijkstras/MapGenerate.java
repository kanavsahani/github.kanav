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
Boolean Generator = false;
	
	public MapGenerate() {
		img = Toolkit.getDefaultToolkit().getImage("Images/US.jpg"); // variable for the image
		JFrame frame = new JFrame();
		JPanel paintPanel = new JPanel() { // paint panel
			 public void paint(Graphics g) { // paint method
				g.setColor(Color.gray); // sets the color of background
				g.drawImage(img, 0, 0, MapGenerate.this.WIDTH, MapGenerate.this.HEIGHT, this); // draw the 1st gif	
				
			 } // closing bracket
		 }; // closing bracket
		 Writer fileWriter = null;
		 JButton RouteFindingMode = new JButton();
		 RouteFindingMode.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e) {
				Generator = true;
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
							drawPoints.connect(s.info, temp.info, null);
							drawPoints.paint(paintPanel.getGraphics());
						}

						temp = s;
						counter++;
					}
				}
					if (counter == 0) {
						String value = JOptionPane.showInputDialog("Type in the name of the state you clicked on.");
						drawPoints.add(value, e.getX(), e.getY());
						drawPoints.paint(paintPanel.getGraphics());
						System.out.println(value);
						try { // try catch method for catching errors
							writer.write(value + "\n"); // write the String with the result
//							writer.write(value + "is connected to" + value-1);
						}catch(Exception ex) { // catch errors
							ex.printStackTrace();
						}
					}


			}
			if (Generator == false) {
				JList list = new JList((ListModel) drawPoints.vertices.values()); //data has type Object[]
				list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
				list.setVisibleRowCount(-1);
				JScrollPane listScroller = new JScrollPane(list);
				listScroller.setPreferredSize(new Dimension(250, 80));
				Vertex start = list.clicked(#1);
				Vertex target = list.clicked(#2);
				HashMap<Vertex, Integer> distances = new HashMap();
				HashMap<Vertex, Boolean> visited = new HashMap();
				HashMap<Vertex, Edge> leadsTo = new HashMap();
				Vertex curr = vertices.get(start);
				PQ<Vertex> toVisit = new PQ();
				HashSet<Edge> edges;
				int distance = Integer.MAX_VALUE;
				toVisit.add(start, 0);
				leadsTo.put(start, null);
				for (Vertex v: vertices.values()) {
					distances.put(v, distance);
				}
				distances.put(start, 0);
				 while(!toVisit.isEmpty()) {
			            curr = toVisit.pop();
			            for (Edge String: curr.edges) {
			            	Vertex neighbor = String.getNeighbor(curr);
			            	if(distances.get(neighbor) > distances.get(curr) + (int) String.label) {
			            		distances.put(neighbor, distances.get(curr) + (int) String.label);
			            		toVisit.add(neighbor, 0);
			            	}
			            	if (neighbor.equals(finale)) {
			            		System.out.println("found");
			            	}
				Generator = true;
			}
			}

			// create a pixel range. point has to be within 10 pixels in order to say that a point was "clicked" on

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
		paintPanel.setPreferredSize(new Dimension(WIDTH-50, HEIGHT-50));
		RouteFindingMode.setPreferredSize(new Dimension(50,50));
		frame.setSize(WIDTH, HEIGHT);
		frame.add(paintPanel);
		frame.add(RouteFindingMode);
		frame.setVisible(true);


	}
	public static void main(String[] args) {
		new MapGenerate();
	}
}
