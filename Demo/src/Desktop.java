import java.util.Scanner;

public class Desktop
{
    public static void main(String[] args)
    {
        try {
            Passwords.passwordProtection();
        } catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
            Passwords.passwordProtection();

        }
    }

    public static void setChoice()
    {
        System.out.println("""
                Enter number from 1 to 9 to start the action:\s
                0=> Tests\s
                1=> Calculator\s
                2=> Encryption\s
                3=> Decryption\s
                4=> Clock\s
                5=> Notepad\s
                6=> Writing \s
                8=> Settings \s
                9=> Numbers conversion \s
                _________________________________________________________""");
        try {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 0 -> {
                    Tests.testsMenu(true);
                    Helps.menuReturn(5, 0.5, true);
                }
                case 1 -> {
                    Calculator.simpleCalculator();
                    Helps.menuReturn(5, 0.5, true);
                }
                case 2 -> {
                    Encryption.typeOfCypher();
                    Helps.menuReturn(5, 0.5, true);
                }
                case 3 -> {
                    Decryption.typeOfDecrypter();
                    Helps.menuReturn(5, 0.5, true);
                }
                case 4 -> Clock.clock();
                case 5 -> {
                    Notepad.notepad();
                    Helps.menuReturn(5, 0.5, true);
                }
                case 6 -> {
                    Writing.writing();
                    Helps.menuReturn(5, 0.5, true);
                }
                case 8 -> {
                    Settings.settings();
                    Helps.menuReturn(5, 0.5, true);
                }
                case 9 -> {
                    ConversionToBinaryAndViceVersa.conversion();
                    Helps.menuReturn(5, 0.5, true);
                }
                default -> setChoice();
            }
            scanner.close();
        }
        catch (Exception exception){
            Helps.turnOff();
        }
    }
}
