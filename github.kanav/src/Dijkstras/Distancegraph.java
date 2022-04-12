package Dijkstras;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Distancegraph<E, T> { //use pseudocode
	HashMap<E, Vertex> vertices;

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
	            for (Edge e: curr.edges) {
	            	Vertex neighbor = e.getNeighbor(curr);
	            	if(distances.get(neighbor) > distances.get(curr) + (int) e.label) {
	            		distances.put(neighbor, distances.get(curr) + (int) e.label);
	            		toVisit.add(neighbor, 0);
	            	}
	            	if (neighbor.equals(finale)) {
	            		System.out.println("found");
	            	}
	            }
	            
		 }	
	}
	 public E add(E info, int x, int y) {
	        Vertex vertex = new Vertex(info, x, y);
	        this.vertices.put(info, vertex);
	        return info;
	    }
	 
	 public void connect(E info1, E info2, T label) {
		 Vertex v1 = vertices.get(info1);
		 Vertex v2 = vertices.get(info2);
		 if (v1 == null || v2 == null) {
		 System.out.println("Vertex " + (v1==null? v1:v2).toString() + "not found");
		 return;
		 }
		 Edge e = new Edge(label, v1, v2);
		 v1.edges.add(e);
		 v2.edges.add(e);
		 }
	public ArrayList<E> backtrace(Vertex target, HashMap<Vertex, Vertex> leadsTo) {
		
		Vertex curr = target;
		ArrayList<E> path = new ArrayList<E>();
		
		while (curr != null) {
			path.add(0, curr.info);
			curr = leadsTo.get(curr);
		}
		return path;
		
	}
	private class Edge {
		T label;
		Vertex v1, v2;
		public Edge(T label, Vertex v1, Vertex v2) {
			this.label = label; this.v1 = v1; this.v2 = v2;
		}
		public Vertex getNeighbor(Vertex v) {
			if (v.info.equals(v1.info)) {
			return v2;
			}
			return v1;
		}
	}
	private class Vertex {
		E info;
		int x; int y;
		HashSet<Edge> edges;
		public Vertex(E info, int x, int y) {
			this.info = info;
			this.x = x;
			this.y = y;
			edges = new HashSet<Edge>();
		}
	}
	public void paint (Graphics G) {
		for (Vertex V: vertices.values())
			G.drawOval(V.x, V.y, 10, 10);
		
	}
}
