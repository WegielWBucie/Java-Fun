import java.util.ArrayList;
import java.util.Collections;

public class MPriorityQueue {

    private ArrayList<Node>queue;
    private int sizeOfHeap;
    private static final int FRONT = 1;

    public MPriorityQueue() {
        queue = new ArrayList<>(1);
        queue.add(0, new Node(Integer.MAX_VALUE, ""));
        this.sizeOfHeap = 0;
    }

    public MPriorityQueue(Integer minCapacity) {
        queue = new ArrayList<>(minCapacity + 1);
        queue.add(0, new Node(Integer.MAX_VALUE, ""));
        this.sizeOfHeap = 0;
    }

    private boolean notLeaf(int position) {
        return position <= (sizeOfHeap / 2);
    }

    private void heapify(Integer position) {
        if(notLeaf(position)) {
            try {
                if(queue.get(position).priority < queue.get(getLeftChildPosition(position)).priority ||
                        queue.get(position).priority < queue.get(getRightChildPosition(position)).priority) {

                    if(queue.get(getLeftChildPosition(position)).priority > queue.get(getRightChildPosition(position)).priority) {
                        swapNodes(position, getLeftChildPosition(position));
                        heapify(getLeftChildPosition(position));
                        heapify(getRightChildPosition(position));
                    }
                    else {
                        swapNodes(position, getRightChildPosition(position));
                        heapify(getLeftChildPosition(position));
                        heapify(getRightChildPosition(position));
                    }
                }
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException) {
                if(queue.get(position).priority < queue.get(getLeftChildPosition(position)).priority) {
                    swapNodes(position, getLeftChildPosition(position));
                }
            }
        }
    }

    public void designQueue() {
        for(int position = sizeOfHeap / 2; position >= 1; position--) {
            heapify(position);
        }
    }

    private int getParentPosition(int position) {
        return position / 2;
    }
    private int getLeftChildPosition(int position) {
        return 2 * position;
    }
    private int getRightChildPosition(int position) {
        return 2 * position + 1;
    }

    private void swapNodes(int firstNode, int secondNode) {
        Collections.swap(queue, firstNode, secondNode);
    }

    public void insert(Node node) {
        queue.add(node);
        sizeOfHeap++;
        int temporary = sizeOfHeap;
        while(queue.get(temporary).priority > queue.get(getParentPosition(temporary)).priority) {
            swapNodes(temporary, getParentPosition(temporary));
            temporary = getParentPosition(temporary);
        }
    }

    public void remove(int indexToRemove) {
        try {
            swapNodes(indexToRemove, sizeOfHeap);
            queue.remove(sizeOfHeap);
            sizeOfHeap--;
            designQueue();
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("Wrong index!");
        }
    }

    public Object peek() {
        return queue.get(FRONT);
    }

    public void display() {
        for(Node node : queue) {
            System.out.print(node.priority + " ");
        }
        System.out.println();
    }


    public int poll() {
        try {
            Object value = peek();
            Integer key = queue.get(FRONT).priority;
            remove(FRONT);
            System.out.println(key);
            return key;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("Underflow");
        }
        catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return 0;
    }
}
