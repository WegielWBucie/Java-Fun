import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Helps
{
    public static String input()
    {
        String text = "";
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter text");
            text = scanner.nextLine().trim();
        }
        catch (Exception exception) {
            System.err.println("Error");
        }
        return text;
    }
    public static void menuReturn(int duration, double frequency, boolean display)
    {
        try {
            Scanner scanner = new Scanner(System.in);
            if(display)
                System.out.println("Comeback to menu in: ");
            countingDown(duration, frequency, display);
            Thread.sleep((long) (frequency * 1000));
            Desktop.setChoice();
        }
        catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
    }
    public static void countingDown(int duration, double frequency, boolean display)
    {
        try {
            while (duration>=0)
            {
                Thread.sleep((long)(frequency * 1000));
                if(display)
                    System.out.println(duration);
                duration--;
            }
        }
        catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
    }
    public static void turnOff()
    {
        System.out.println("Turning off in: ");
        countingDown(3, 0.5, true);
        System.out.println("Adios!");
        System.exit(0);
    }
    public static List<Integer> randoms(int length, int limit)
    {
        List<Integer>randoms = new ArrayList<>();
        Random random = new Random();
        for(int i=0; i<random.nextInt(100); i++)
        {
            randoms.add(random.nextInt(101));
        }
        return randoms;
    }
}
