import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        boolean doBreak = false;
        int iterator = 100;

        while(!doBreak && iterator > 0){

            MPriorityQueue  mPriorityQueue = new MPriorityQueue();

            Random random = new Random();

            int size = random.nextInt(5, 20);

            ArrayList<Integer>priorities = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                mPriorityQueue.insert(new Node(random.nextInt(0, 20000), random.nextInt(0,10)));
            }

            mPriorityQueue.designQueue();
            mPriorityQueue.display();

            for(int i = 0; i < size; i++) {
                priorities.add(mPriorityQueue.poll());
            }

            for(int i = 0; i < size - 1; i++) {
                if(priorities.get(i) < priorities.get(i + 1)) {
                    System.out.println("ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
                    doBreak = true;
                    break;
                }
            }
            iterator--;

            System.out.println();
        }
    }
}
