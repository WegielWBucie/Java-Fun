import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Decryption
{

    public static void typeOfDecrypter()
    {
        int type;
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("""
                    Choose the type of decryption:\s
                     1=> Transposition decryption\s
                     2=> Affine decryption\s
                     3=> Vigenere decryption""");
            type = scanner.nextInt();
            switch (type) {
                case 1 -> transpositionDecryption(Helps.input());
                case 2 -> affineDecryption(Helps.input());
                case 3 -> VigenereDecryption(Helps.input());
                default -> Desktop.setChoice();
            }
        }
        catch (InputMismatchException inputMismatchException) {
            Desktop.setChoice();
        }
        catch (Exception exception){
            System.out.println(exception.getLocalizedMessage());
        }
    }
    public static void transpositionDecryption(String text)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter key consisted of numbers");
        List<Integer> key = new ArrayList<>();
        while(scanner.hasNextInt())
            key.add(scanner.nextInt());
        System.out.println(EncryptersAndDecrypters.transpositionDecrypter(text, key));
    }
    public static void affineDecryption(String text)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter key consisted of 2 numbers");
        int[] key = new int[2];
        for(int i=0; i<2; i++)
            key[i] = scanner.nextInt();
        System.out.println(EncryptersAndDecrypters.affineDecrypter(text, key));
    }
    public static void VigenereDecryption(String text)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter key: ");
        String key = scanner.nextLine();
        System.out.println(EncryptersAndDecrypters.VigenereDecrypter(text, key));
    }
}
