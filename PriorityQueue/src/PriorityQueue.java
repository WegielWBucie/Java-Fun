import java.util.ArrayList;
import java.util.LinkedList;

public class PriorityQueue {

    ArrayList<Node>queue;
    private int filledElements;
    private static final int FRONT = 1;

    public PriorityQueue() {
        queue = new ArrayList<>();
        this.filledElements = 0;
    }

    public PriorityQueue(Integer minCapacity) {
        queue = new ArrayList<>();
        queue.ensureCapacity(minCapacity);
        this.filledElements = 0;
    }

    protected boolean notLeaf(int position) {
        return position < (filledElements / 2) || position > filledElements;
    }

    public void heapify(Integer position) {

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

    public void enqueue(Node node) {
        queue.add(node);
        filledElements++;
        while(queue.get(filledElements++).priority )
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
