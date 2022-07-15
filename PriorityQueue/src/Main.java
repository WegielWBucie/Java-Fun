import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        MPriorityQueue  mPriorityQueue = new MPriorityQueue();

        mPriorityQueue.display();

        mPriorityQueue.insert(new Node(10, 10));
        mPriorityQueue.display();

        mPriorityQueue.insert(new Node(9, 10));
        mPriorityQueue.display();

        mPriorityQueue.insert(new Node(8, 10));
        mPriorityQueue.display();

        mPriorityQueue.insert(new Node(2, 10));
        mPriorityQueue.display();

        mPriorityQueue.insert(new Node(4, 10));
        mPriorityQueue.display();

        mPriorityQueue.insert(new Node(10, 10));
        mPriorityQueue.display();

        mPriorityQueue.insert(new Node(1, 10));
        mPriorityQueue.display();

        mPriorityQueue.poll();
        mPriorityQueue.display();

        mPriorityQueue.poll();
        mPriorityQueue.display();

        mPriorityQueue.poll();
        mPriorityQueue.display();

        mPriorityQueue.poll();
        mPriorityQueue.display();

        mPriorityQueue.poll();
        mPriorityQueue.display();

        mPriorityQueue.poll();
        mPriorityQueue.display();


    }
}
