
import javax.swing.*;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Writing
{
    public static void writing()
    {
        ArrayList<String>words = new ArrayList<>();
        ArrayList<String>mistakenWords = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("Old_Man_And_The_Sea.txt");
            Scanner fileScanner = new Scanner(fileInputStream);
            while (fileScanner.hasNext()) {
                String currentWord = fileScanner.next().replace((char) 34,' ').trim();
                    if (currentWord.length() >= 3)
                        words.add(currentWord);
            }
            fileScanner.close();
            fileInputStream.close();

            int exerciseLength = lengthDeclaration();

            System.out.println("Starting in: ");
            Helps.countingDown(5,1,true);

            Random random = new Random();
            int wordsMistakenCounter = 0;
            int lettersMistakenCounter = 0;

            long startTimeMillis = 0;

            for (int i = 0; i < exerciseLength; i++)
            {
                String requiredWord = words.get(random.nextInt(words.size()));
                System.out.println(requiredWord);
                Scanner scanner = new Scanner(System.in);
                if(i == 0)
                {
                    startTimeMillis = System.currentTimeMillis();
                }
                String inputWord = scanner.nextLine().trim();
                if(!(inputWord.equals(requiredWord)))
                {
                    wordsMistakenCounter++;
                    mistakenWords.add(requiredWord);
                    while (!(inputWord.equals(requiredWord)))
                    {
                        System.err.println("Wrong !!!");
                        if(inputWord.length() == requiredWord.length()){
                            for (int j = 0; j < requiredWord.length(); j++) {
                                if(inputWord.charAt(j) != requiredWord.charAt(j))
                                    lettersMistakenCounter++;
                            }
                        }
                        else {
                            lettersMistakenCounter+= Math.abs(requiredWord.length() - inputWord.length());
                        }
                        inputWord = scanner.next();
                    }
                }
            }
            NumberFormat numberFormat = new DecimalFormat("#0.00");
            long endTimeMillis = System.currentTimeMillis();
            System.out.println("Time: " + (numberFormat.format
                    ((endTimeMillis - startTimeMillis)/1000)) + " seconds.");
            if(wordsMistakenCounter > 0)
            {
                System.out.println("You've mistaken " + wordsMistakenCounter + " words with " +
                        lettersMistakenCounter + " letter by that.");
                System.out.println("Words that You've written not properly: ");
                for (String mistakenWord : mistakenWords) {
                    System.out.print(mistakenWord + " ");
                }
            }
            else
                System.out.println("Congratulations, You have not mistaken any word !!!");
            System.out.println();

            continuationPossibility();
        }
        catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
        }
    }
    public static void continuationPossibility()
    {
        JFrame continuationFrame = new JFrame("Continuation");
        JPanel continuationPanel = new JPanel();

        continuationFrame.add(continuationPanel);
        continuationFrame.setLocationRelativeTo(null);
        continuationFrame.setSize(160,120);
        continuationFrame.setVisible(true);
        continuationFrame.setResizable(false);
        continuationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        continuationPanel.setBounds(0,0,160,120);

        JLabel question = new JLabel();
        question.setText("Do u wanna play again ? ");
        continuationPanel.add(question);

        JButton yesButton = new JButton();
        yesButton.setText("Yes");
        yesButton.setBounds(10, 50, 60, 25);
        yesButton.addActionListener(e -> {
            continuationFrame.dispose();
            Writing.writing();
        });
        JButton noButton = new JButton();
        noButton.setText("No");
        noButton.setBounds(80, 50, 60, 25);
        noButton.addActionListener(e -> continuationFrame.dispose());
        continuationPanel.add(yesButton); continuationPanel.add(noButton);
    }
    private static int lengthDeclaration()
    {
        try {
            System.out.println("Choose the length");
            Scanner lengthScanner = new Scanner(System.in);

            return lengthScanner.nextInt();
        }
        catch (Exception exception) {
            lengthDeclaration();
            return 0;
        }
    }
}
