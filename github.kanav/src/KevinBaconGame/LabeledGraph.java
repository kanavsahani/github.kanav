package KevinBaconGame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import graphMap.Graph;
//all imports
// LabeledGraph for my KBG by Kanav Sahani with Help from Mr. Friedman
public class LabeledGraph<E, T> {
	// set up hashmap for each vertex
	HashMap<E, Vertex> vertices;
	
	public LabeledGraph() {
		vertices = new HashMap<E, Vertex>();
		//constructor for declaring the HashMap
	}
	
	public void addVertex(E info) {
		vertices.put(info, new Vertex(info));
		// needed for adding vertices
	}
	
	public void connect(E info1, E info2, T label) {
		Vertex v1 = vertices.get(info1);
		Vertex v2 = vertices.get(info2);
		//connects the two vertices
		if (v1 == null || v2 == null) {
			System.out.println("Vertex " + (v1==null? v1:v2).toString() + " not found");
			return;
			// edge case
		}
		
		Edge e = new Edge(label, v1, v2);
		//create a new edge and add the two vertices to the edge (neighbor equivalent)
		v1.edges.add(e);
		v2.edges.add(e);
	}

	private class Edge {
		T label;
		Vertex v1, v2;
		//defining edge and creating two vertices and a label for the edge
		public Edge(T label, Vertex v1, Vertex v2) {
			this.label = label; this.v1 = v1; this.v2 = v2;
			//constructor to declare caches
		}
		
		public Vertex getNeighbor(Vertex v) {
			if (v.info.equals(v1.info)) {
				return v2;
			}
			return v1;
			//used for getting neighbor
		}
		public String toString() {
			String output = "";
			output += label.toString();
			return output;
			//toString is essential for testing to see if it works
		}
	}
	
	private class Vertex {
		E info;
		HashSet<Edge> edges;
		//vertex class to define a vertex with variables here
		public Vertex(E info) {
			this.info = info;
			edges = new HashSet<Edge>();
			//constructor for defining variables
		}
		public String toString() {
			String output = "";
			output += info.toString();
			return output;
			//toString is essential for testing to see if it works
		}
	}
	public String toString() {
		String output = "";
		
		for (Vertex s: vertices.values()) {
			output += " " + s.toString() +  s.edges;
		}
		return output;
		//toString is essential for testing to see if it works
	}
	public ArrayList<E> BFS(E start, E target) {
		//the ultimate breadth-first search with input of a start and ending vertex
		if (vertices.get(start) == null) {
			System.out.println("Vertex " + start.toString() + " not found");
			return null; //edge case
		}
		if (vertices.get(target) == null) {
			System.out.println("Vertex " + target.toString() + " not found");
			return null; //edge case
		}
		
		ArrayList<Vertex> toVisit = new ArrayList<Vertex>(); // array list of vertices
		toVisit.add(vertices.get(start));// need to add the start
		HashMap<Vertex, Vertex> leadsTo = new HashMap<Vertex, Vertex>(); // leads to creates the path from one to the other
		String Desired = target.toString(); //desired is the target
		Vertex curr = vertices.get(start); // current vertex (this changes over time though)
		leadsTo.put(curr, null); // add current vertex to array list
		while (!toVisit.isEmpty()) {// keep going until its empty
			curr = toVisit.remove(0); // remove as you use them
			for (Edge Edge: curr.edges) { // for each loop to go through the whole list
				if (leadsTo.containsKey(Edge.getNeighbor(curr))) {
					continue; // keep going if the curr is in the leadsto
				}
				leadsTo.put(Edge.getNeighbor(curr), curr); // add vertex to the hashmap
				if(Edge.getNeighbor(curr).info.equals(Desired)) { // if you get desired result, do the backtrace to retun the path
					
					return backtrace(vertices.get(start),vertices.get(Desired), leadsTo);
					
				}
				else {
					toVisit.add(Edge.getNeighbor(curr)); // if not, ust keep adding to it
				}
			}
		}
		
		return null; // needs some type of output
	}
	public ArrayList<E> backtrace(Vertex start, Vertex target, HashMap<Vertex, Vertex> leadsTo) {
		// the mighty backtrace method for finding the path from start to target
		Vertex curr = target; // start at target
		ArrayList<E> path = new ArrayList<E>(); // make a path
		
		while (curr != null) {
			path.add(0, curr.info); // go backwards until curr runs out
			curr = leadsTo.get(curr);
		}
		return path; // return the final path
		
	}
	
	public static void main(String[] args) {
		// main method that is only used by me for testing. not essential to the project I could delete this too if I wanted
		// wanted to show my work though
		LabeledGraph<String, String> g = new LabeledGraph<String, String>();
		g.addVertex("Bob");
		g.addVertex("Sue");
		g.addVertex("Jim");
		g.addVertex("Bill");
		g.connect("Bob", "Sue", "friends");
		g.connect("Sue", "Jim", "friends");
		g.connect("Sue", "Bill", "friends");
		System.out.println(g.BFS("Bob","Jim"));
		
	}
}
