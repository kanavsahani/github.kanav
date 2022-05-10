package Dijkstras;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Map.Entry;

import KevinBaconGame.LabeledGraph;
import graphMap.Graph;
import huffpuff.PriorityQueue.node;

public class PQ <E> extends Distancegraph{
	// List to help set up queue
	private final List<node> queue;
    public class node {
    	// variables to set us up for later
        private E data1;
        private int priority;
        // node constructor to initialize variables
        public node(E branch, int priority) {
            data1 = branch;
            this.priority = priority;
        }
        // gets the data
        public E getData() {
            return data1;
        }
        // gets the priority
        public int getPriority() {
            return this.priority;
        }
        // turns it into a string
        public String toString() {
            return data1.toString();
        }
        
        public boolean equals(Object o) {
        	node other = (node)o;
        	if (other.data1 == data1)
        		return true;
        	return false;
        }
    }
    public boolean isEmpty() {
    	return queue.size() == 0;
    }
    // used for adding a branch. inputs a branch and its priority
    public E add(E branch, int priority) {
    	// node with the inputs
        node node = new node(branch, priority);
        // adds the branch
        this.queue.add(node);
        // sorts it by priority
        this.sort();
        // returns the final product
        return node.getData();
    }
    public void put(E branch, int priority) {
    	node node = new node(branch, priority);
    	if (!queue.contains(node)) {
    		add(branch, priority);
    	} 
    	else {
    		queue.remove(node);
    		add(branch, priority);
    	}
    }
    public E pop() {
    	// pop method used a ton in the Compressor
    	if(this.size() < 1) 
    		// helps catch errors
        	throw new IndexOutOfBoundsException();
    	// helps remove data as its used up
        node firstData = this.queue.remove(0);
        // sorts when its been dealt with
        this.sort();
        // returns the final product
        return firstData.getData();
    }
    // constructor for setting up the queue
    public PQ() {
        this.queue = new ArrayList<>();
    }
    // displays queue size
    public int size() {
        return this.queue.size();
    }
    // sorts by priority
    private void sort() {
        this.queue.sort(Comparator.comparingInt(node::getPriority));
    }
    // turns queue into a string (easier to print)
    public String toString() {
        return this.queue.toString();
    }
    // gets the priority
    public int getPriority() {
    	return queue.get(0).getPriority();
    }
	public static void main(String[] args) {
		PQ<String> pq = new PQ();
		pq.add("nigeria", 15);
		pq.add("mozambique", 5);
		pq.add("zimbabwe", 7);
		pq.add("morocco", 12);
		pq.put("nigeria", 0);
		
		System.out.println(pq);
    }
}
