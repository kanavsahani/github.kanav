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
            Node curr = first;
            for(int x = 0; x < i-1; x++) {
                curr = curr.next;
            }
            
            node.next = curr.next;
            curr.next = node;
        } catch(NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
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
    public LinkedList<E>.Node remove(int i) {
    	Node curr = first;
    	for(int x = 0; x < i-1; x++) {
            if (x == i) {
            	curr = curr.next;
            	this.sized--;
            }
    		curr = curr.next;
            
        }
    	curr.next=curr.next.next;
    	
    	return curr;
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
    }
}