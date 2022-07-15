import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueue {

    ArrayList<Node>queue;
    private int sizeOfHeap;
    private static final int FRONT = 1;

    public PriorityQueue() {
        queue = new ArrayList<>(1);
        queue.add(0, new Node(Integer.MAX_VALUE, ""));
        this.sizeOfHeap = 0;
    }

    public PriorityQueue(Integer minCapacity) {
        queue = new ArrayList<>(minCapacity + 1);
        queue.add(0, new Node(Integer.MAX_VALUE, ""));
        this.sizeOfHeap = 0;
    }

    protected boolean notLeaf(int position) {
        return position < ((sizeOfHeap + 1) / 2) || position > sizeOfHeap;
    }

    public void heapify(Integer position) {
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
        for(int position = sizeOfHeap / 2; position >= 1; position--) {
            heapify(position);
        }
    }

    protected int getParentPosition(int position) {
        return position / 2;
    }
    protected int getLeftChildPosition(int position) {
        return 2 * position;
    }
    protected int getRightChildPosition(int position) {
        return 2 * position + 1;
    }

    public void swapNodes(int firstNode, int secondNode) {
        Collections.swap(queue, firstNode, secondNode);
    }

    public void enqueue(Node node) {
        queue.add(node);
        sizeOfHeap++;
        while(queue.get(sizeOfHeap).priority < queue.get(getParentPosition(sizeOfHeap)).priority) {
            swapNodes(sizeOfHeap, getParentPosition(sizeOfHeap));
        }
    }

    public void delete(int indexToRemove) {
        if(!queue.isEmpty()) {
            queue.remove(indexToRemove);
        }
    }

    public Object peek() {
        return queue.get(0);
    }

    public void dequeue() {
        try {
            Object value = peek();
            delete(0);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("Underflow");
        }
        catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
        }
    }
}
