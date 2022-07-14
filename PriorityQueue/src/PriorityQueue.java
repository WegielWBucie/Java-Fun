import java.util.ArrayList;
import java.util.LinkedList;

public class PriorityQueue {

    ArrayList<Node> queue;

    public PriorityQueue() {
        queue = new ArrayList<>();
    }

    public PriorityQueue(Integer minCapacity) {
        queue = new ArrayList<>();
        queue.ensureCapacity(minCapacity);
    }


    public void heapify(Integer position) {

    }

    public void enqueue() {

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
