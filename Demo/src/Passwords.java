import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Passwords
{
    public static void passwordsSettings()
    {
        //" \n" +
        System.out.println("""
                Enter number to start the action:\s
                1: Change password\s
                2: Delete password\s
                _________________________________________________________""");
        try {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    changePassword();
                    passwordsSettings();
                }
                case 2 -> {
                    deletePassword();
                    passwordsSettings();
                }
                default -> Desktop.setChoice();

            }
            //Desktop.countingDown(3, 0.5, true);
        }
        catch (InputMismatchException inputMismatchException) {
            //System.out.println(inputMismatchException);
            Desktop.setChoice();
        }
        catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
    }

    public static int attemptsLeft = 5;
    public static void passwordProtection()
    {
        try {
            currentPasswordInput();
            if(passwords.isEmpty() || passwords.get(0).isEmpty())
                Desktop.setChoice();
            else
            {
                while (attemptsLeft > 0)
                {
                    System.out.println("Enter the password: ");
                    Scanner scanner = new Scanner(System.in);
                    String attempt = scanner.nextLine().trim();

                    if (attempt.equals(passwords.get(0))) {
                        Desktop.setChoice();
                        break;
                    } else {
                        attemptsLeft--;
                        System.out.println("You've got " + attemptsLeft + " attempts left.");
                    }
                }
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
        }
    }
    public static List<String> passwords = new ArrayList<>();
    public static void codeInput()
    {
        try {
            Scanner scanner = new Scanner(new File("Code.txt"));
            String code = scanner.next().trim();
        } catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
    }
    public static String pathname;

    static {
        try {
            pathname = Users.userIn();
        } catch (FileNotFoundException e) {

            Helps.turnOff();
        }
    }

    public static void currentPasswordInput()
    {
        try {
            if(pathname.contains(".txt"))
            {
                passwords.clear();
                File file = new File(pathname);
                if(file.exists())
                {
                    int circles = 0;
                    Scanner scanner = new Scanner(file);
                    while(scanner.hasNextLine() && circles < 5) {
                        passwords.add(EncryptersAndDecrypters.VigenereDecrypter(scanner.nextLine(), "WoooAleBubel"));
                        circles++;
                    }
                    scanner.close();
                }
            }
            else if(pathname.equals("turnOff"))
                Helps.turnOff();
            else if(pathname.equals("add"))
                Users.addUser();
        } catch (Exception exception) {
            Helps.turnOff();
        }
    }
    public static void changePassword()
    {
        try {
            System.out.println("Enter new password: ");
            Scanner newPassScanner = new Scanner(System.in);
            String newPassword = newPassScanner.nextLine().trim();
            boolean ifRepeated = false;
            setMaxSize(passwords, 5);
            for (String password : passwords) {
                if (newPassword.equals(password)) {
                    ifRepeated = true;
                    break;
                }
            }
            if(!ifRepeated)
            {
                PrintWriter printWriter = new PrintWriter(pathname);
                Collections.reverse(passwords);
                passwords.add(newPassword);
                Collections.reverse(passwords);
                setMaxSize(passwords, 5);
                for (String password : passwords) {
                    printWriter.println(EncryptersAndDecrypters.VigenereEncrypter(password, "WoooAleBubel"));
                }
                printWriter.close();
                System.out.println("New password set successfully !");
            }
            else {
                System.out.println("You can not repeat any of your last 5 passwords !!");
                changePassword();
            }
        }
        catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
    }
    public static void deletePassword()
    {
        try {
            System.out.println(passwords);
            passwords.remove(0);
            passwords.add(0, "");
            System.out.println(passwords);
            setMaxSize(passwords, 5);
            PrintWriter printWriter = new PrintWriter(pathname);
            for (String password : passwords) {
                printWriter.println(EncryptersAndDecrypters.VigenereEncrypter(password, "WoooAleBubel"));
            }
            printWriter.close();
        }
        catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
        }
    }
    public static void setMaxSize(List<String>list, int size)
    {
        while (list.size() > size)
            list.remove(list.size()-1);
    }
}
