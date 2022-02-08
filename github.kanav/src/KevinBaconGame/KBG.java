package KevinBaconGame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class KBG extends JPanel {
	HashMap<Integer, String> movies;
	HashMap<Integer, String> actors;
	HashMap<Integer, Integer> movieWithActors;
	LabeledGraph<String, String> connections;
	private final int WIDTH = 600, HEIGHT = 600;
	private String content;
	public KBG() throws FileNotFoundException {
		this.movies = new HashMap();
		this.actors = new HashMap();
		this.connections = new LabeledGraph();		
		// the main container
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// the inner container
		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		panel.setBorder(BorderFactory.createTitledBorder("KevinBaconGame"));
		// text container
		JTextArea displayarea = new JTextArea();
		displayarea.setText("Welcome to the Kevin Bacon Game! "
				+ "\nClick on one of the buttons to see any of the special features "
				+ "\nor choose to type in two separate actor names and see their connection through the use of BFS!");
		displayarea.setEditable(false);
		// create and add listeners to the buttons
		final JTextArea inputAreaOne = new JTextArea();
        inputAreaOne.setPreferredSize(new Dimension(237, 25));
        inputAreaOne.setEditable(true);
        final JTextArea inputAreaTwo = new JTextArea();
        inputAreaTwo.setPreferredSize(new Dimension(237, 25));
        inputAreaTwo.setEditable(true);
        final JTextArea responseArea = new JTextArea();
        responseArea.setPreferredSize(new Dimension(525, 600));
        responseArea.setEditable(false);
        final ArrayList<String> path = connections.BFS(inputAreaOne.getText().toLowerCase(), inputAreaTwo.getText().toLowerCase());
        if(path == null) {
            responseArea.setText("Could not find any connections");
            return;
        }
        responseArea.setText(inputAreaOne.getText().toLowerCase() + " is connected to " + inputAreaTwo.getText().toLowerCase() + " by " + path);
		JButton mostCommonActorButton = new JButton("Most Common Actor");
		mostCommonActorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = null;
				try {
					output = "Most common actor is " + mostCommonActor(movieWithActors);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton MovieWithMostActorButton = new JButton("Movie With Most Actors");
		MovieWithMostActorButton.addActionListener(new ActionListener() {
			BufferedReader CR = new BufferedReader(new FileReader("movie-actors.txt"));
			public void actionPerformed(ActionEvent e) {
				HashMap<Integer, Integer> movieActor = new HashMap<Integer, Integer>();
				
				String line;
				String[] split;
				try {
					split = CR.readLine().split("~");
				} catch (IOException e2) {
				
					e2.printStackTrace();
				}
				try {
					while((line = CR.readLine())!= null){
						split = line.split("~");
						movieActor.put(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
					}
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				String output = "";
				String common = MovieWithMostActor(movieActor);
				output += "Movie with most actors is"+common+". ";
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton longestMovieNameButton = new JButton("Longest Movie Name");
		longestMovieNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "\n   Longest movie name is "+longestMovieName(movies)+".";
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayarea.setText("");
				
			}
		});
		// add a scroll bar to the text area
		JScrollPane scroll = new JScrollPane (displayarea);
		scroll.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(400,475));
		panel.add(scroll);
		
		// create three containers for the three button rows 
		JPanel innerPanel = new JPanel(), innerPane2 = new JPanel();
		innerPanel.add(mostCommonActorButton);
		innerPanel.add(MovieWithMostActorButton);
		innerPane2.add(longestMovieNameButton);
		innerPane2.add(clearButton);
		panel.add(innerPanel);
		panel.add(innerPane2);
		panel.add(inputAreaOne);
		panel.add(inputAreaTwo);
		// final setup on the frame
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		// beginning text display
	}
	public void FileReader() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("actors.txt"));
			String line;
			while ((line = in.readLine())!= null) {
					String[] split = line.split("~");
					actors.put(Integer.parseInt(split[0]), split[1]);
					connections.addVertex(split[1]);
				}
			BufferedReader out = new BufferedReader(new FileReader("movies.txt"));
			String line1;
			
			while ((line1 = out.readLine())!= null) {
				String[] split1 = line1.split("~");
				movies.put(Integer.parseInt(split1[0]), split1[1]);
			}
			BufferedReader CR = new BufferedReader(new FileReader("movie-actors.txt")); // CR = connection reader
			String line2;
			ArrayList<Integer> actorConnector = new ArrayList<Integer>();
			String[] split = CR.readLine().split("~");
			int currentMovie = Integer.parseInt(split[0]);
			actorConnector.add(Integer.parseInt(split[1]));
			while((line2 = CR.readLine())!= null){
				split = line2.split("~");
				if (Integer.parseInt(split[0]) != currentMovie) {
					actorConnector.clear();
					currentMovie = Integer.parseInt(split[0]);
				}
				for (int i = 0; i < actorConnector.size(); i++) {
					String currActor = actors.get(actorConnector.get(i));
					String currentActor = actors.get(Integer.parseInt(split[1]));
					connections.connect(currActor, currentActor, movies.get(currentMovie));					
				}
				actorConnector.add(Integer.parseInt(split[1]));				
			}
		} catch (FileNotFoundException e1) {
			System.out.println("File not found :(");
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
	public String mostCommonActor(HashMap<Integer, Integer> actorConnection) throws IOException {
		String line, word = "";    
        int count = 0, maxCount = 0;    
        ArrayList<String> words = new ArrayList<String>();  
        BufferedReader CR = new BufferedReader(new FileReader("movie-actors.txt"));
        while((line = CR.readLine()) != null) {    
            String string[] = line.toLowerCase().split("([,.\\s]+) ");    
            //Adding all words generated in previous step into words    
            for(String s : string){    
                words.add(s);    
            }
        }
        for(int i = 0; i < words.size(); i++){    
            count = 1;    
            //Count each word in the file and store it in variable count    
            for(int j = i+1; j < words.size(); j++){    
                if(words.get(i).equals(words.get(j))){    
                    count++;    
                }     
            }    
            //If maxCount is less than count then store value of count in maxCount     
            //and corresponding word to variable word    
            if(count > maxCount){    
                maxCount = count;    
                word = words.get(i);    
            }
            
        }    
		//possibly make an array for each actor name and add one once each actor pops up and print the highest value
        return "Most repeated word: " + word;
	}
	public String MovieWithMostActor(HashMap<Integer, Integer> movieConnection) {
		int[] numberOfConnections = null;
		int i = 0;
			for (Integer key:movieConnection.values()) {
				numberOfConnections[i]+=1;
				if (key != key-1) {
					i++;
				}
			}
			int max = numberOfConnections[0];
			 for (i = 1; i < numberOfConnections.length; i++) {
				 if (numberOfConnections[i] > max) {
	            	 max = numberOfConnections[i];
	             } 
			 }     
			return max + "";
		}
	public String longestMovieName(HashMap<Integer, String> name) {
		String longest = ""; // iterating through values not keys
		for (String key: name.values()) {
			if (key.length() > longest.length()) {
				longest = key;
			}
		}
		return longest;
	}
	
	public static void main(String[] args) {
		try {
			new KBG().FileReader();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
