package github.kanav;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<E> {
	private final List<PriorityData> queue;

    public class PriorityData {
        private final E data1;
        private final int priority;
        public PriorityData(E data, int priority) {
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
        PriorityData priorityData = new PriorityData(data, priority);
        this.queue.add(priorityData);
        this.recalculateSort();
        return priorityData.getData();
    }
    public E pop() {
        return this.popData().getData();
    }
    public PriorityData popData() {
        if(this.size() < 1) 
        	throw new IndexOutOfBoundsException();
        PriorityData firstData = this.queue.remove(0);
        this.recalculateSort();
        return firstData;
    }
    public PriorityQueue() {
        this.queue = new ArrayList<>();
    }
    public int size() {
        return this.queue.size();
    }
    private void recalculateSort() {
        this.queue.sort(Comparator.comparingInt(PriorityData::getPriority));
    }
    public String toString() {
        return this.queue.toString();
    }
}
