import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Encryption
{
    public static void typeOfCypher()
    {
        int type = 0;
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("""
                    Choose the type of encryption: \s
                     1=> Transposition encryption\s
                     2=> Affine encryption\s
                     3=> Vigenere encryption""");
            type = scanner.nextInt();
        }
        catch (Exception exception){
            System.err.println("Error 2");
        }
        switch (type) {
            case 1 -> transpositionEncryption(Helps.input());
            case 2 -> affineEncryption(Helps.input());
            case 3 -> VigenereEncryption(Helps.input());
        }
    }
    public static void transpositionEncryption(String text)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter key consisted of numbers");
        List<Integer> key = new ArrayList<>();
        while(scanner.hasNextInt())
            key.add(scanner.nextInt());
        System.out.println(EncryptersAndDecrypters.transpositionEncrypter(text, key));
    }
    public static void affineEncryption(String text)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter key consisted of 2 numbers");
        int[] key = new int[2];
        for(int i=0; i<2; i++)
            key[i] = scanner.nextInt();
        System.out.println(EncryptersAndDecrypters.affineEncrypter(text, key));
    }
    public static void VigenereEncryption(String text)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter key: ");
        String key = scanner.nextLine();
        System.out.println(EncryptersAndDecrypters.VigenereEncrypter(text, key));
    }
}

