import java.util.InputMismatchException;
import java.util.Scanner;

public class Settings
{
    public static void settings()
    {
        try {
            System.out.println("""
                    Enter number to start the action:\s
                    1=> Passwords\s
                    2=> Time\s
                    3=> Accounts\s
                    _________________________________________________________""");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice)
            {
                case 0: break;
                case 1: Passwords.passwordsSettings(); break;
                case 2: Clock.clock(); break;
                case 3: Users.users(); break;

                default: Desktop.setChoice(); break;
            }
        }
        catch (InputMismatchException inputMismatchException) {
            Desktop.setChoice();
        }
        catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
    }
}