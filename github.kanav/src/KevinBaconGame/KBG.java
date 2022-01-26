package KevinBaconGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JFileChooser;

public class KBG {
	HashMap<Integer, String> movies;
	HashMap<Integer, String> actors;
	LabeledGraph<String, String> connections;
	public KBG() {
		this.movies = new HashMap();
		this.actors = new HashMap();
		this.connections = new LabeledGraph();
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
//			System.out.println(actors);
			BufferedReader out = new BufferedReader(new FileReader("movies.txt"));
			String line1;
			while ((line1 = out.readLine())!= null) {
				String[] split1 = line1.split("~");
				movies.put(Integer.parseInt(split1[0]), split1[1]);
			}
//			System.out.println(movies);
			BufferedReader CR = new BufferedReader(new FileReader("movie-actors.txt")); // CR = connection reader
			String line2;
			ArrayList<Integer> actorConnector = new ArrayList<Integer>();
			//create a list
			String[] split = CR.readLine().split("~");
			int currentMovie = Integer.parseInt(split[0]);
			actorConnector.add(Integer.parseInt(split[1]));
			int count = 0;
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
					count++;
					
				}
				actorConnector.add(Integer.parseInt(split[1]));
			
				// connect current actor to all actors in our list
				
				// add actor to our list
			
			}
			System.out.println(count);
			System.out.println(connections);
			
		} catch (FileNotFoundException e1) {
			System.out.println("File not found :(");
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new KBG().FileReader();
	}
}
