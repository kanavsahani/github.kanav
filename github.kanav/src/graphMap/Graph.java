package graphMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Graph<E> {
	HashMap<E, Vertex> vertices;
	
	public Graph() {
		vertices = new HashMap<E, Vertex>();
	}
	public void connect (E info1, E info2) {
		Vertex v1 = vertices.get(info1);
		Vertex v2 = vertices.get(info2);
		
		if (v1 == null || v2 == null) {
			throw (new NullPointerException());
		}
		v1.neighbors.add(v2);
		v2.neighbors.add(v1);
	}
	public void addVertex(E info) {
		vertices.put(info, new Vertex(info));
	}
	private class Vertex {
		E info;
		HashSet<Vertex> neighbors;
		
		public Vertex (E info) {
			this.info = info;
		}
	}
	public static void main(String[] args) {
		
		Graph<String> mygraph = new Graph<String>();
		mygraph.addVertex("sammy");
		mygraph.addVertex("tammy");
		mygraph.addVertex("grammy");
		mygraph.addVertex("tyler");
		mygraph.addVertex("Mila");
		mygraph.addVertex("CECE");
		mygraph.addVertex("CHAPMAN");
		System.out.println(mygraph);
	}
}
