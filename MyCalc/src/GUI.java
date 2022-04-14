import javax.swing.*;
import java.awt.*;

public class GUI implements frameRecipe, fontsRecipes, otherInstances
{
    public GUI() {
        setFrame();
    }
    StringBuilder equationBuilder = new StringBuilder();
    private static double result = 0;
    private void setFrame()
    {
        frame.setTitle("Calc");

        int width = 400, height = 640;
        frame.setSize(width,height);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(7,1));

        int currentButtonValue = 6, mathSignTableID = -1;
        for (int i = 0; i < 7; i++) {
            JPanel framePanels = new JPanel();
            frame.add(framePanels);

            if(i>1) {
                framePanels.setLayout(new GridLayout());
                for (int j = 0; j < 4 ; j++) {
                    JButton button = new JButton();
                    button.setBackground(Color.darkGray.darker().darker());
                    button.setForeground(Color.white);
                    framePanels.add(button);
                    button.setFont(buttonsFont);

                    button.addActionListener(actionEvent -> {
                        if(!lowerScreenLabel.getText().isEmpty())
                            Calculator.clear();
                        switch (button.getText())
                        {
                            case "⌫" -> {
                                if(equationBuilder.length() >= 1) {
                                    equationBuilder.deleteCharAt(equationBuilder.length()-1);
                                }
                            }
                            case "=" -> {
                                Calculator.createEquation(equationBuilder, button.getText());
                                equationBuilder.delete(0, equationBuilder.length());
                            }
                            case "C" -> {
                                if(equationBuilder.length() >= 1) {
                                    equationBuilder.delete(0,equationBuilder.length());
                                }
                            }
                            default -> Calculator.createEquation(equationBuilder, button.getText());
                        }
                        result = Calculator.result;
                        if(result != 0 && !Calculator.signs.isEmpty()) {
                            if(result % 1 == 0) {
                                lowerScreenLabel.setText(" = " + (int)result + " ");
                            }
                            else {
                                lowerScreenLabel.setText(" = " + result + " ");
                            }
                        }
                        else if(Calculator.divisionBy0 || Calculator.sqrtOfNegative) {
                            lowerScreenLabel.setFont(lowerScreenFont);
                            lowerScreenLabel.setText("Error");
                            Calculator.divisionBy0 = false;
                            Calculator.sqrtOfNegative = false;
                        }
                        else if(result == 0 && Calculator.signs.size() >= 1 &&
                                Calculator.signs.get(Calculator.signs.size()-1) == '=') {
                            lowerScreenLabel.setText(" = " + 0 + " ");
                        }
                        lowerScreenLabel.setFont(lowerScreenFont);

                        mainScreenLabel.setFont(mainScreenFont);
                        mainScreenLabel.setText(" " + equationBuilder + " ");
                    });
                    if(i >= 3 && i <= 5 && j < 3) {
                        currentButtonValue++;
                        button.setText(String.valueOf(currentButtonValue));
                        button.setName(String.valueOf(currentButtonValue));
                        if(j==2)
                            currentButtonValue-=6;
                    }
                    else {
                        try {
                            mathSignTableID++;
                            button.setText(String.valueOf(mathSigns[mathSignTableID]));
                            button.setName(String.valueOf(mathSigns[mathSignTableID]));
                        }
                        catch (Exception exception) {
                            System.out.println(exception.getLocalizedMessage());
                        }
                    }
                }
            }
            else {
                if(i==0) {
                    framePanels.add(mainScreenLabel);
                }
                else {
                    framePanels.add(lowerScreenLabel);
                }
            }
        }
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}