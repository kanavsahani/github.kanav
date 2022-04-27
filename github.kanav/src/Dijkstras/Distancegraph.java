package Dijkstras;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Distancegraph { //use pseudocode
	HashMap<String, Vertex> vertices;
	public Distancegraph() {
		vertices = new HashMap<String, Vertex>();
	}
	
	public void search(Vertex start, Vertex finale) {	
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
	            }
	            
		 }	
	}
	 public String add(String info, int x, int y) {
	        Vertex vertex = new Vertex(info, x, y);
	        this.vertices.put(info, vertex);
	        return info;
	    }
	 
	 public void connect(String info1, String info2, Integer label) {
		 Vertex v1 = vertices.get(info1);
		 Vertex v2 = vertices.get(info2);
		 if (v1 == null || v2 == null) {
		 System.out.println("Vertex " + (v1==null? v1:v2).toString() + "not found");
		 return;
		 }
		 Edge String = new Edge(label, v1, v2);
		 v1.edges.add(String);
		 v2.edges.add(String);
		 }
	public ArrayList<String> backtrace(Vertex target, HashMap<Vertex, Vertex> leadsTo) {
		
		Vertex curr = target;
		ArrayList<String> path = new ArrayList<String>();
		
		while (curr != null) {
			path.add(0, curr.info);
			curr = leadsTo.get(curr);
		}
		return path;
		
	}
	private class Edge {
		Integer label;
		Vertex v1, v2;
		public Edge(Integer label, Vertex v1, Vertex v2) {
			this.label = label; this.v1 = v1; this.v2 = v2;
		}
		public Vertex getNeighbor(Vertex v) {
			if (v.info.equals(v1.info)) {
			return v2;
			}
			return v1;
		}
	}
	public class Vertex {
		String info;
		int x; int y;
		HashSet<Edge> edges;
		public Vertex(String info, int x, int y) {
			this.info = info;
			this.x = x;
			this.y = y;
			edges = new HashSet<Edge>();
		}
	}
	public void paint (Graphics G) {
		for (Vertex V: vertices.values()) {
			G.setColor(Color.BLUE);
			G.fillOval(V.x, V.y, 10, 10);
			G.setColor(Color.RED);
			G.drawString((String) V.info, V.x+5, V.y+5);
			for (Edge String: V.edges) {
				Vertex neighbor = String.getNeighbor(V);
				G.drawLine(V.x, V.y, neighbor.x, neighbor.y);
			}
		}
		
			
		
			
			
	}
}
