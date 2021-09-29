package LinkedList;

import java.util.ArrayList;

import SpaceInvaders.SpaceThing;

public class LinkedList<E> {

    private class Node {

        Node next;
        E data;

        public Node(E data) {
            this.data = data;
        }

    }

    private Node first;
    private int sized;

    public void add(E info, int i) {
        Node node = new Node(info);
        
        if(this.first == null) {
        
            this.first = node;
            this.sized++;
            return;
        }
        
        if(i == 0) {
            node.next = this.first;
            this.first = node;
            this.sized++;
            return;
        }
        
        try {
            Node prev = getnode(i-1);
            if(i < this.sized) {
            	node.next = prev.next;
            }
            prev.next = node;
            this.sized++;
        } catch(NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }
    public void add(E info) {
    	this.add(info, this.size());
    }
    public E get(int indice) {
    	try {
    			Node curr = first;
        		for(int x = 0; x < indice; x++) {
        			curr = curr.next;
        		}
    	return curr.data;
    }
    	catch(NullPointerException e) {
            throw new IndexOutOfBoundsException();
    	}
    }
    public Node getnode(int indice) {
    	try {
    			Node curr = first;
        		for(int x = 0; x < indice; x++) {
        			curr = curr.next;
        		}
    	return curr;
    }
    	catch(NullPointerException e) {
            throw new IndexOutOfBoundsException();
    	}
    }
    public E remove(int i) {
    	Node curr = first;
    	
    	if (i == 0) {
    		curr.next = curr.next.next;
    		this.sized--;
    		return null;
    	}
    
    	for(int x = 0; x < i-1; x++) {
    		curr = curr.next;
            
        }
    	curr.next=curr.next.next;

    	this.sized--;
    	return curr.data;
    }
    public int size() {
    	return sized;
    }
    public static void main(String[] args) {
    	LinkedList<String> nodes = new LinkedList<String>();
    	nodes.add("4",0);
    	nodes.add("e",1);
    	nodes.add("5", 2);
    	nodes.add("y", 3);
    	nodes.add("g", 4);
    	nodes.add("her", 5);

    	System.out.println(nodes.get(0));
    	System.out.println(nodes.get(1));
    	System.out.println(nodes.get(2));
    	System.out.println(nodes.get(3));
    	System.out.println(nodes.get(4));
    	System.out.println(nodes.get(5));
    	nodes.add("3",6);
    	System.out.println(nodes.get(6));
    	nodes.remove(5);
    	System.out.println(nodes.get(5));

    	System.out.println("size"+nodes.sized);
    	nodes.add("3");
    	System.out.println(nodes.get(nodes.sized-1));
    	System.out.println(nodes.size());
    }
}