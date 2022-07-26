import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        boolean doBreak = false;
        int iterator = 1000;

        while(!doBreak && iterator > 0){

            MPriorityQueue  mPriorityQueue = new MPriorityQueue();

            Random random = new Random();

            int size = random.nextInt(5, 200);

            ArrayList<Integer>priorities = new ArrayList<>();

            for(int i = 0; i < size; i++) {
//                mPriorityQueue.insert(new Node(random.nextInt(0, 20000), random.nextInt(0,10)));
                mPriorityQueue.insert(new Node(random.nextInt(0, 20000)));
            }

            mPriorityQueue.designQueue();
            mPriorityQueue.display();
            System.out.println();

            for(int i = 0; i < size; i++) {
                Node currentPoll = mPriorityQueue.poll();
                priorities.add(currentPoll.priority);
                System.out.println(currentPoll.value);
            }

            for(int i = 0; i < size - 1; i++) {
                if(priorities.get(i) < priorities.get(i + 1)) {
                    doBreak = true;
                    break;
                }
            }

            iterator--;
        }
        if(!doBreak) {
            System.out.println("All samples positive.");
        }
        else {
            System.out.println("Something's wrong!!");
        }
    }
}
