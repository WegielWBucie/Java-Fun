
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Tests
{
    public static void testsMenu(boolean execute)
    {
        test1(false);
        test2(false);
        test3(false);
        test4(false);
        transpositionRework(false);
        codeTest(false);
        otherApps(false);
        mathTest(false);
        fileTest(false);
        containTest(false);
        renameTest(false);
        renameTestNo2(false);
        gimmiePath(false);
        fileWriterTest(false);
        executability(false, true, false);
        loopsTests(false);
        splittingTest(false);
        exceptions();
    }
    private static void test1(boolean execute)
    {
        if(execute)
        {
            int ints[] = new int[10];
            for(int i=0; i<10; i++)
                ints[i] = i+1;
            for(int i: ints) {
                System.out.println(i);
            }
        }
    }
    private static void test2(boolean execute)
    {
        if(execute)
        {
            int a = -27;
            int b = 27;
            System.out.println(a%26);
            System.out.println(b%26);
        }
    }
    private static void test3(boolean execute)
    {
        if(execute)
        {
            String test[] = {"", " ", "a", "\n"};
            for(int i=0; i<test.length; i++)
            {
                if(test[i].isEmpty())
                    System.out.println("It's empty");
                else
                    System.out.println("It's NOT empty");
            }
        }
    }
    private static void test4(boolean execute)
    {
        if(execute)
        {
            String tekst = "JakiesMegaDlugieZdanieDoPrzyciecia";
            String temp;
            temp = tekst.substring(0, 15);
            System.out.println(temp);
        }
    }
    private static void fileTest(boolean execute)
    {
        if(execute)
        {
            try {
                File file = new File("Test.txt");
                if(file.exists())
                    file.deleteOnExit();
            }
            catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }
    private static void codeTest(boolean execute)
    {
        if(execute)
        {
            String text = "OnlyForExample";
            String text2 = "Only For Example";
            List<Integer> key = new ArrayList<>(); for(int i = 1; i<50; i=i+3) key.add(i);
            System.out.println(key);
            System.out.println(EncryptersAndDecrypters.transpositionEncrypter(text, key));
            System.out.println(EncryptersAndDecrypters.transpositionDecrypter(EncryptersAndDecrypters.transpositionEncrypter(text, key), key));
            System.out.println(EncryptersAndDecrypters.transpositionDecrypter(EncryptersAndDecrypters.transpositionEncrypter(text2, key), key));
        }
    }
    private static void containTest(boolean execute)
    {
        if(execute)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Type the sentence");
            String sentence = scanner.nextLine().trim();
            System.out.println("Type the sequence to check if its contained: ");
            String sequence = scanner.nextLine();
            if(sentence.contains(sequence))
                System.out.println("Your sequence is contained in your sentence.");
            else
                System.out.println("Your sequence IS NOT contained in your sentence.");
        }
    }
    private static void fileWriterTest(boolean execute)
    {
        if(execute)
        {
            try {
                File file = new File("Test.txt");
            }
            catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }
    private static void gimmiePath(boolean execute)
    {
        if(execute)
        {
            File file = new File("PassFiles");
            System.out.println(file.getAbsolutePath());
            String pathname = file.getAbsolutePath().replace((char)(92), '/');
            System.out.println(pathname);
        }
    }
    private static void pathTest(String pathname)
    {
        File file = new File(pathname);
        if(file.exists())
            System.out.println("File exists");
        else
            System.out.println("File not exists");
        File file1 = new File("C:/Users/pondr/OneDrive/Desktop/JV/Cypher/Users.txt");
        if(file1.exists())
            System.out.println("File exists");
        else
            System.out.println("File not exists");
    }
    private static void renameTest(boolean execute)
    {
        if(execute)
        {
            try {
                File file1 = new File("Test1.txt");
                FileWriter fileWriter1 = new FileWriter(file1);
                File file2 = new File("Test2.txt");
                FileWriter fileWriter2 = new FileWriter(file2);
                fileWriter1.close(); fileWriter2.close();

                //Files.move(file1.toPath(), file2.toPath(), new StandardCopyOption[]{StandardCopyOption.REPLACE_EXISTING});
                if(file1.renameTo(file2))
                    System.out.println("YUP");
                else
                    System.out.println("NOPE");
            }
            catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }
    private static void renameTestNo2(boolean execute)
    {
        if(execute)
        {
            File sourceFile = new File("Dupa.txt");
            File destFile = new File("TestOnly123.txt");
            System.out.println(sourceFile.getName());
            System.out.println(destFile.getName());
            if (sourceFile.renameTo(destFile)) {
                System.out.println("File renamed successfully");
            } else {
                System.out.println("Failed to rename file");
            }
        }
    }
    private static void transpositionRework(boolean execute)
    {
        if(execute)
        {
            Random random = new Random();
            int length = random.nextInt(300);
            int limit = random.nextInt(300);
            List<Integer>key = Helps.randoms(50, 100);
            List<Integer>key2 = Helps.randoms(5, 10);
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine().trim();
            //System.out.println(text);
            System.out.println(EncryptersAndDecrypters.transpositionEncrypter(text, key));
            System.out.println(EncryptersAndDecrypters.transpositionDecrypter(EncryptersAndDecrypters.transpositionEncrypter(text, key), key));
        }
    }
    private static void mathTest(boolean execute)
    {
        if(execute)
        {
            String shorter = "shorter";
            String longer = "longer phrase 123";
            int asd = Math.max(shorter.length(), longer.length());
            System.out.println(asd);
        }
    }
    private static void otherApps(boolean execute)
    {
        if(execute)
        {
            File file = new File("C:/Program Files/Google/Chrome/Application/chrome.exe");
            if(file.exists())
                System.out.println("File exists");
            else
                System.out.println("File don't exists");
        }
    }
    private static void executability(boolean execute, boolean executable, boolean ownerOnly)
    {
        if(execute)
        {
            File file = new File("Code.txt");
            if(file.setExecutable(executable, ownerOnly))
                System.out.println("Executable permission is set");
        }
    }
    private static void loopsTests(boolean execute)
    {
        if(execute)
        {
            ArrayList<Integer>myList = new ArrayList<>();
            int[] myArray = new int[100];
            for(int i=0; i<100; i++) {
                myList.add(i);
                myArray[i] = i;
            }
            for(int element: myList) {
                System.out.println(myList.indexOf(element));
//                System.out.println(myArray.index);        //no function to show current index
            }
        }
    }
    private static void splittingTest(boolean execute)
    {
        if(execute)
        {
            Scanner scanner = new Scanner(System.in);
            String string = scanner.nextLine();
            String[] parts = string.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        }
    }
    private static void exceptions()
    {
        try {
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
        }
        catch (InputMismatchException inputMismatchException)
        {
            System.err.println(inputMismatchException.getLocalizedMessage());
        }
    }
    private static void binaryTries()
    {
        int numberLength = 0;
        while (numberLength == 0) {
            Random random = new Random();
            numberLength = random.nextInt(10);
        }
        StringBuilder binaryNumber = new StringBuilder();
        for (int i = 0; i < numberLength; i++) {
            Random binRandom = new Random();
            binaryNumber.append(binRandom.nextInt(2));
        }
        while (binaryNumber.charAt(0) == '0') {
            binaryNumber.deleteCharAt(0);
        }
        if(binaryNumber.equals("")) {
            System.out.println("Empty");
        }
        else {
            System.out.println(binaryNumber);
        }
    }
}