package KevinBaconGame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import graphMap.Graph;

public class LabeledGraph<E, T> {
	
	HashMap<E, Vertex> vertices;
	
	public LabeledGraph() {
		vertices = new HashMap<E, Vertex>();
	}
	
	public void addVertex(E info) {
		vertices.put(info, new Vertex(info));
	}
	
	public void connect(E info1, E info2, T label) {
		Vertex v1 = vertices.get(info1);
		Vertex v2 = vertices.get(info2);
		
		if (v1 == null || v2 == null) {
			System.out.println("Vertex " + (v1==null? v1:v2).toString() + " not found");
			return;
		}
		
		Edge e = new Edge(label, v1, v2);
		
		v1.edges.add(e);
		v2.edges.add(e);
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
		public String toString() {
			String output = "";
			output += label.toString();
			return output;
		}
	}
	
	private class Vertex {
		E info;
		HashSet<Edge> edges;
		
		public Vertex(E info) {
			this.info = info;
			edges = new HashSet<Edge>();
		}
		public String toString() {
			String output = "";
			output += info.toString();
			return output;
		}
	}
	public String toString() {
		String output = "";
		
		for (Vertex s: vertices.values()) {
			output += " " + s.toString() +  s.edges;
		}
		return output;
		
	}
	public ArrayList<E> BFS(E start, E target) {
		if (vertices.get(start) == null) {
			System.out.println("Vertex " + start.toString() + " not found");
			return null;
		}
		if (vertices.get(target) == null) {
			System.out.println("Vertex " + target.toString() + " not found");
			return null;
		}
		
		ArrayList<Vertex> toVisit = new ArrayList<Vertex>();
		toVisit.add(vertices.get(start));
		HashMap<Vertex, Vertex> leadsTo = new HashMap<Vertex, Vertex>();
		String Desired = target.toString();
		Vertex curr = vertices.get(start);
		toVisit.add(vertices.get(start));
		leadsTo.put(curr, null);
		while (!toVisit.isEmpty()) {
			curr = toVisit.remove(0);
			for (Edge Edge: curr.edges) {
				if (leadsTo.containsKey(Edge.getNeighbor(curr))) {
					continue;
				}
				leadsTo.put(Edge.getNeighbor(curr), curr);
				if(Edge.getNeighbor(curr).info .equals(Desired)) {
					
					return backtrace(vertices.get(start),vertices.get(Desired), leadsTo);
					
				}
				else {
					toVisit.add(Edge.getNeighbor(curr));
				}
			}
		}
		
		return null;
	}
	public ArrayList<E> backtrace(Vertex start, Vertex target, HashMap<Vertex, Vertex> leadsTo) {
		
		Vertex curr = target;
		ArrayList<E> path = new ArrayList<E>();
		
		while (curr != null) {
			path.add(0, curr.info);
			curr = leadsTo.get(curr);
		}
		return path;
		
	}
	
	public static void main(String[] args) {
		
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
