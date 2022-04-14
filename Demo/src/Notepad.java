import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Notepad
{
    public static List<String>notes = new ArrayList<>();
    public static void notepad()
    {
        try {
            notesReading();
            notesActions();
            notesSave();
        }
        catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
        //System.out.println(notes);
    }
    public static void notesReading()
    {
        try {
            notes.clear();
            Scanner scanner = new Scanner(new File("C:/Users/pondr/OneDrive/Desktop/Notepad.txt"));
            while (scanner.hasNextLine())
                notes.add(scanner.nextLine());
            if(!(notes.isEmpty()))
                System.out.println(notes);
        }
        catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
    }
    public static void notesActions()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What now: ");
        String choice = scanner.next().toLowerCase().trim();
        if(choice.contains("add")) {
            System.out.println("Type new note: ");
            Scanner scannerInside = new Scanner(System.in);
            String newNote = scannerInside.nextLine();
            notes.add(newNote);
            notesActions();
        }
        else if((choice.contains("del"))){
            System.out.println("Which note do u want to delete? ");
            int toRemove = scanner.nextInt()-1;
            System.out.println(notes.get(toRemove) +"\nAre you sure? ");
            String choiceInside = scanner.next();
            int res = 0;
            for(int i=0; i<choiceInside.length(); i++)
                if(choiceInside.charAt(i) == 'n')
                    res++;
            if(choiceInside.equals("nom"))
                res = 0;
            if(res == 0)
                notes.remove(notes.get(toRemove));
            System.out.println(notes);
            notesActions();
        }
        else if((choice.contains("edi"))) {
            System.out.println("Which note do u want to edit? ");
            Scanner scannerInside = new Scanner(System.in);
            int toEdit = scanner.nextInt()-1;
            System.out.println(notes.get(toEdit));
            System.out.println("Enter new version: ");
            notes.remove(notes.get(toEdit));
            String newNote = scannerInside.nextLine();
            notes.add(newNote);
            notesActions();
        }
        else if((choice.contains("back"))) {
            Desktop.setChoice();
        }
        else {
            System.out.println("Add / delete / edit / back: ");
            notesActions();
        }
    }
    public static void notesSave()
    {
        try {
            //File file = new File("C:/Users/pondr/OneDrive/Desktop/Notepad.txt")
            PrintWriter printWriter = new PrintWriter("C:/Users/pondr/OneDrive/Desktop/Notepad.txt");
            for (String note : notes) {
                printWriter.println(note);
            }
            printWriter.close();
        }
        catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
    }
}
