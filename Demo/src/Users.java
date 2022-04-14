import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Users
{
    public static ArrayList<String>users = new ArrayList<>();
    public static void users()
    {
        try {
            //" \n" +
            System.out.println("""
                    Enter number to start the action:\s
                    1: Add users\s
                    2: Delete users\s
                    3: Preview users\s
                    4: Change user's name\s
                    _________________________________________________________""");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    addUser();
                    users();
                }
                case 2 -> {
                    deleteUser(IDToRemoveOrLoad());
                    users();
                }
                case 3 -> {
                    previewUser();
                    users();
                }
                case 4 -> {
                    nicknameChange(IDToRemoveOrLoad());
                    users();
                }
                default -> Desktop.setChoice();
            }
        }
        catch (InputMismatchException inputMismatchException) {
            Desktop.setChoice();
        }
        catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
        }
    }
    public static String userIn() throws FileNotFoundException {
        int id = 0;
        try {
            users.clear();
            Scanner scanner = new Scanner(new File("Users.txt"));
            while (scanner.hasNextLine())
                users.add(scanner.nextLine());
            if (users.isEmpty())
                addUser();
            else {
                Collections.sort(users);
                System.out.println("Choose the user: ");
                Scanner scannerID = new Scanner(System.in);
                for (int i = 0; i < users.size(); i++)
                    System.out.println(i + 1 + ": " + users.get(i));
                System.out.print("\n" + (users.size()+1) + ": Add user" + "        ");
                System.out.println((users.size()+2) + ": Turn off");
                id = scannerID.nextInt() - 1;
            }
        }
        catch (Exception exception) {
            PrintWriter file = new PrintWriter("Users.txt");
            Users.userIn();
        }
        if(id > users.size())
            return "turnOff";
        else if(id == users.size())
            return "add";
        else
            return (users.get(id) + ".txt");
    }
    public static void addUser()
    {
        try {
            System.out.println("Enter your name: ");
            Scanner scanner = new Scanner(System.in);
            String newUser = scanner.nextLine();
            users.add(newUser);
            FileOutputStream fileOutputStream = new FileOutputStream(newUser + ".txt");
            fileOutputStream.close();
            usersOut();
            Desktop.setChoice();
        }
        catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
        }
    }
    public static void deleteUser(int ID)
    {
        try {
            File file = new File(users.get(ID) + ".txt");
            file.delete();
            users.remove(ID);
            //needs to be finished
            usersOut();
        }
        catch (InputMismatchException inputMismatchException) {
            System.out.println("You didn't delete any user.");
            Helps.countingDown(1,1,false);
            users();
        }
        catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
    }
    public static void previewUser()
    {
        try {
            for (String user : users) {
                System.out.println(users.indexOf(user)+1 + ": " + user);
            }
            Helps.countingDown(3,1, false);
            usersOut();
            users();
        }
        catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
    }
    public static void usersOut()
    {
        try {
            PrintWriter printWriter = new PrintWriter("Users.txt");
            for (String user : users) {
                printWriter.println(user);
            }
            printWriter.close();
        }
        catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
    }
    public static void nicknameChange(int id)
    {
        try {
            System.out.println("Current name is: \n" + users.get(id));
            System.out.println("Enter new one: ");
            Scanner scanner = new Scanner(System.in);
            String newName = scanner.nextLine().trim();
            File sourceFile = new File((users.get(id) + ".txt"));
            //System.out.println(sourceFile.getName());
            File destFile = new File((newName + ".txt"));
            //System.out.println(destFile.getName());

            if(sourceFile.renameTo(destFile)) {
                System.out.println("File renamed successfully");
                users.remove(id);
                users.add(newName);
                Collections.sort(users);
                usersOut();
            } else {
                System.out.println("Failed to rename file");
            }
        }
        catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
            nicknameChange(id);
        }
    }
    public static int IDToRemoveOrLoad()
    {
        int id = 0;
        try {
            System.out.println("Choose the user: ");
            Scanner scannerID = new Scanner(System.in);
            for (String user : users) {
                System.out.println(users.indexOf(user)+1 + ": " + user);
            }
            id = scannerID.nextInt()-1;
        }
        catch (Exception exception) {
            users();
        }
        return id;
    }
    private void usersAmountCheck()
    {
        try {
            for (int i = 0; i < users.size(); i++)
            {
                users.clear();
                Scanner scanner = new Scanner(new File("Users.txt"));
                while (scanner.hasNextLine())
                    users.add(scanner.nextLine());

            }
        }
        catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
        }
    }
}
