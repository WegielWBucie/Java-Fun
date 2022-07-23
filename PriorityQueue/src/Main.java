import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        MPriorityQueue  mPriorityQueue = new MPriorityQueue();

        Random random = new Random();

        int size = random.nextInt(5, 20);


        for(int i = 0; i < size; i++) {
            mPriorityQueue.insert(new Node(random.nextInt(0, 20000), random.nextInt(0,10)));
        }

        mPriorityQueue.designQueue();
        mPriorityQueue.display();

        for(int i = 0; i < size; i++) {
            mPriorityQueue.poll();
        }


    }
}
