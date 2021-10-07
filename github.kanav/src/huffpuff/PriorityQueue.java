package huffpuff;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<E> {
	private final List<node> queue;

    public class node {
        private final E data1;
        private final int priority;
        public node(E data, int priority) {
            data1 = data;
            this.priority = priority;
        }

        public E getData() {
            return data1;
        }

        public int getPriority() {
            return this.priority;
        }
        public String toString() {
            return data1.toString();
        }
    }
    public E add(E data, int priority) {
        node node = new node(data, priority);
        this.queue.add(node);
        this.sort();
        return node.getData();
    }
    public E pop() {
    	if(this.size() < 1) 
        	throw new IndexOutOfBoundsException();
        node firstData = this.queue.remove(0);
        this.sort();
        return firstData.getData();
    }
    public PriorityQueue() {
        this.queue = new ArrayList<>();
    }
    public int size() {
        return this.queue.size();
    }
    private void sort() {
        this.queue.sort(Comparator.comparingInt(node::getPriority));
    }
    public String toString() {
        return this.queue.toString();
    }
}