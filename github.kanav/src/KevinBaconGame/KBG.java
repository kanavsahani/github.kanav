package KevinBaconGame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
//all imports
// Kevin Bacon Game By Kanav Sahani with help from mr. Friedman
public class KBG extends JPanel {
	HashMap<Integer, String> movies;
	HashMap<Integer, String> actors;
	HashMap<Integer, Integer> movieWithActors;
	
	HashMap<Integer, List<Integer>> movieActors;
	LabeledGraph<String, String> connections;
	//caches created to hold information from the files and hold the connections
	private final int WIDTH = 600, HEIGHT = 600; // fixed variables for the screening
	public KBG() {
		this.movies = new HashMap();
		this.actors = new HashMap();
		this.connections = new LabeledGraph(); // initiate the caches in the constructor	
		this.movieActors = new HashMap();
		
		FileReader();
		
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
		// add containers for text inputs
		final JTextArea inputAreaOne = new JTextArea();
        inputAreaOne.setPreferredSize(new Dimension(237, 25));
        inputAreaOne.setEditable(true);
        final JTextArea inputAreaTwo = new JTextArea();
        inputAreaTwo.setPreferredSize(new Dimension(237, 25));
        inputAreaTwo.setEditable(true);
       // run the BFS to find the path between the two inputs from the user
       
		//print out connection
        
     // create and add listeners to the buttons
      
		JButton BFSButton = new JButton("BFS"); // button for BFS
		BFSButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					final ArrayList<String> path = connections.BFS(inputAreaOne.getText(), inputAreaTwo.getText());
			        if(path == null) {
			            displayarea.setText("Could not find any connections"); //edge case
			            return;
			        }
			        displayarea.setText(inputAreaOne.getText().toLowerCase() + " is connected to " + inputAreaTwo.getText().toLowerCase() + " by " + path);
				}
		        
		});
		JButton MovieWithMostActorButton = new JButton("Movie With Most Actors"); //special feature		
		try {
			MovieWithMostActorButton.addActionListener(new ActionListener() {
				BufferedReader CR = new BufferedReader(new FileReader("movie-actors.txt"));
				public void actionPerformed(ActionEvent e) {
					HashMap<Integer, Integer> movieActor = new HashMap<Integer, Integer>();
					// hashmap for movie-actors
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
							List<Integer> list = new ArrayList<>();
							if(movieActors.containsKey(Integer.parseInt(split[0]))) {
								list.addAll(movieActors.get(Integer.parseInt(split[0])));
							}
							list.add(Integer.parseInt(split[1]));
							movieActors.put(Integer.parseInt(split[0]), list);
							movieActor.put(Integer.parseInt(split[0]), Integer.parseInt(split[1])); // fill the hashmap
						}
					} catch (NumberFormatException | IOException e1) {
						e1.printStackTrace();
					}
					String output = "";
					String common = MovieWithMostActor();
					output += "Movie with most actors is "+common+". ";
					displayarea.setText(displayarea.getText()+"\n"+output+"\n"); //print out answer for special feature
				}
			});
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JButton longestMovieNameButton = new JButton("Longest Movie Name"); //special feature
		longestMovieNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "\n   Longest movie name is "+longestMovieName(movies)+".";
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");// print out answer
			}
		});
		JButton clearButton = new JButton("Clear"); // button for clearing everything
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayarea.setText("");
				
			}
		});
		
		// add a scroll bar to the text area
		JScrollPane scroll = new JScrollPane (displayarea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(400,475));
		panel.add(scroll);
		
		// create three containers for the three button rows 
		JPanel innerPanel = new JPanel(), innerPane2 = new JPanel();
		innerPanel.add(MovieWithMostActorButton);
		innerPanel.add(BFSButton);
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
			BufferedReader in = new BufferedReader(new FileReader("actors.txt")); //read the actors.txt file
			String line;
			while ((line = in.readLine())!= null) {  // read until the file ends
					String[] split = line.split("~"); // split by the ~
					actors.put(Integer.parseInt(split[0]), split[1]); // fill the cache
					connections.addVertex(split[1]); // create vertices for connections
				}
			BufferedReader out = new BufferedReader(new FileReader("movies.txt")); // read the movies.txt file
			
			 String line1;
	            while((line1 = out.readLine()) != null) {// read until the file ends
	                String[] split = line1.split("~");// split by the ~
	                this.movies.put(Integer.parseInt(split[0]), split[1]);// fill the cache
	                
	            }
			
			BufferedReader CR = new BufferedReader(new FileReader("movie-actors.txt")); // CR = connection reader
			String line2;
			ArrayList<Integer> actorConnector = new ArrayList<Integer>(); // new array list for the actors and movie connections
			String[] split = CR.readLine().split("~"); // split by the ~
			int currentMovie = Integer.parseInt(split[0]); // split by the ~
			actorConnector.add(Integer.parseInt(split[1])); // split by the ~
			while((line2 = CR.readLine())!= null){ // read until the file ends
				split = line2.split("~"); // same split
				if (Integer.parseInt(split[0]) != currentMovie) {
					actorConnector.clear(); // clear if it is wrong
					currentMovie = Integer.parseInt(split[0]); // and keep changing the current movie
				}
				for (int i = 0; i < actorConnector.size(); i++) {
					String currActor = actors.get(actorConnector.get(i)); 
					String currentActor = actors.get(Integer.parseInt(split[1]));
					connections.connect(currActor, currentActor, movies.get(currentMovie));	// connect everything with the for loop				
				}
				actorConnector.add(Integer.parseInt(split[1]));	// add the final one			
			}
		} catch (FileNotFoundException e1) {
			System.out.println("File not found :("); // edge case catch
			return;
		} catch (IOException e1) { // edge case catch
			e1.printStackTrace();
		}
		
		
	}
	public String mostCommonActor(HashMap<Integer, Integer> actorConnection) throws IOException { // special feature that finds the most common actor
		String line, word = "";    
        int count = 0, maxCount = 0;    
        ArrayList<String> numbers = new ArrayList<String>();  
        BufferedReader CR = new BufferedReader(new FileReader("movie-actors.txt"));
        while((line = CR.readLine()) != null) {    
            String string[] = line.toLowerCase().split("([,.\\s]+) ");    
            //Adding all words generated in previous step into words    
            for(String s : string){    
                numbers.add(s);    
            }
        }
        for(int i = 0; i < numbers.size(); i++){    
            count = 1;    
            //Count each number in the file and store it in variable count    
            for(int j = i+1; j < numbers.size(); j++){    
                if(numbers.get(i).equals(numbers.get(j))){    
                    count++;    
                }     
            }    
            //If maxCount is less than count then store value of count in maxCount     
            //and corresponding word to variable word    
            if(count > maxCount){    
                maxCount = count;    
                word = numbers.get(i);    
            }
            
        }
        return "Most common actor: " + word;
	}
	public String MovieWithMostActor() { // special feature that finds movie with the most actors
		int longestId = 0;
		int amt = 0;
		
		for(Entry entry : movieActors.entrySet()) {
			List<Integer> actors = (List) entry.getValue();
			if(actors.size() > amt) {
				longestId = (int) entry.getKey();
				amt = actors.size();
			}
		}
		
		return movies.get(longestId);
	}
	public String longestMovieName(HashMap<Integer, String> name) { // special feature that finds the longest movie name
		String longest = ""; // iterating through values not keys
		for (String key: name.values()) {
			if (key.length() > longest.length()) { // run through everything and keep changing depending on length
				longest = key;
			}
		}
		return longest;
	}
	
	public static void main(String[] args) { // main method for running the whole game
		new KBG();
		
	}
}
