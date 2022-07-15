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
            if(queue.get(position).priority < queue.get(getLeftChildPosition(position)).priority ||
                    queue.get(position).priority < queue.get(getRightChildPosition(position)).priority) {

                if(queue.get(getLeftChildPosition(position)).priority > queue.get(getRightChildPosition(position)).priority) {
                    swapNodes(position, getLeftChildPosition(position));
                    heapify(position);
                }
                else {
                    swapNodes(position, getRightChildPosition(position));
                    heapify(position);
                }
            }
        }
    }

    public void designQueue() {
        for(int position = (sizeOfHeap - 1) / 2; position >= 1; position--) {
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
        while(queue.get(sizeOfHeap).priority > queue.get(getParentPosition(sizeOfHeap)).priority) {
            swapNodes(sizeOfHeap, getParentPosition(sizeOfHeap));
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


    public void poll() {
        try {
            Object value = peek();
            Integer key = queue.get(FRONT).priority;
            remove(FRONT);
            System.out.println(key);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("Underflow");
        }
        catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
        }
    }
}
