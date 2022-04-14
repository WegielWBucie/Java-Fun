
import java.util.Random;
import java.util.Scanner;

public class ConversionToBinaryAndViceVersa
{
    public static void conversion()
    {
        try {
            System.out.println("""
                    Which side would u like to study?\s
                    1. Binary => Decimal\s
                    2. Decimal => Binary""");
            Scanner choice = new Scanner(System.in);
            switch (choice.nextInt()) {
                case 1 -> binaryToDecimal();
                case 2 -> decimalToBinary();
                default -> Desktop.setChoice();
            }
        }
        catch (Exception exception) {
            Desktop.setChoice();
        }
    }
    private static int getLengthOfActivity()
    {
        int length = 0;
        try {
            System.out.println("Type length of activity: ");
            Scanner lengthScanner = new Scanner(System.in);
            length = lengthScanner.nextInt();
        }
        catch (Exception exception) {
            getLengthOfActivity();
        }
        return length;
    }
    private static void binaryToDecimal()
    {
        int exLength = getLengthOfActivity();
        for (int l = 0; l < exLength; l++)
        {
            Random random = new Random();
            int requiredNumber = random.nextInt(256);
            System.out.println(Integer.toBinaryString(requiredNumber));

            Scanner userScanner = new Scanner(System.in);
            int inputNumber = userScanner.nextInt();

            if(inputNumber == requiredNumber)
                System.out.println("Goooooood");
            else
                System.out.println("Mistake, it equals : " + requiredNumber);
        }
        conversion();
    }
    private static void decimalToBinary()
    {
        int exLength = getLengthOfActivity();
        for (int l = 0; l < exLength; l++)
        {
            Random random = new Random();
            int requiredNumber = (random.nextInt(256));
            System.out.println(requiredNumber);

            Scanner userScanner = new Scanner(System.in);
            String inputNumber = userScanner.next();

            if(inputNumber.equals(Integer.toBinaryString(requiredNumber)))
                System.out.println("Goooooood");
            else
                System.out.println("Mistake, it equals : " + Integer.toBinaryString(requiredNumber));
        }
        conversion();
    }
}
