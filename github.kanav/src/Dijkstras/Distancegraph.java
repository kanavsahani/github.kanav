package Dijkstras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Set;


public class Distancegraph<E, T> { //use pseudocode
	HashMap<E, Vertex> vertices;
	public void search(Vertex start, PQ pq) {
		PQ<String> toVisit = new PQ();
		toVisit.add((String) start.info, pq.getPriority());
		HashMap<Boolean, Vertex> visited = new HashMap();
		HashMap<Vertex, Integer> leadsTo = new HashMap();
	}
	 public E add(E info) {
	        Vertex vertex = new Vertex(info);
	        this.vertices.put(info, vertex);
	        return info;
	    }
	public void connect (E info1, E info2, int length) {
		Vertex v1 = vertices.get(info1);
		Vertex v2 = vertices.get(info2);
		
		if (v1 == null || v2 == null) {
			throw (new NullPointerException());
		}
		v1.neighbors.add(v2);
		v2.neighbors.add(v1);
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
	private class Edge{
		T info;
		HashSet<Vertex> neighbors1;
		public Edge(T info) {
			this.info = info;
			neighbors1 = new HashSet();
		}
	}
	private class Vertex {
		E info;
		HashSet<Edge> neighbors;
		
		public Vertex (E info) {
			this.info = info;
			neighbors = new HashSet();
		}
		
		public String toString() {
			return info.toString();
		}
	}
	public String toString() {
		String output = "";
		
		for (Distancegraph<E, T>.Vertex s: vertices.values()) {
			output += " " + s.toString() +  s.neighbors;
		}
		System.out.println(output);
		return output;
	}
}
