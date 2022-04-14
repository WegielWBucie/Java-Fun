import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrialGUI implements ActionListener
{
    int counter = 0;
    private JFrame frame;
    private JButton button;
    private JPanel panel;
    private JLabel buttonLabel;
    public TrialGUI()
    {
        try {
            frame = new JFrame();
            frame.setSize(500, 500);
            frame.setResizable(true);
            frame.setTitle("Frame");

            panel = new JPanel();
            panel.setLayout(null);

            JLabel label = new JLabel("Label");
            label.setBounds(20,40, 80, 25);
            panel.add(label);

            JTextField textField = new JTextField(40);
            textField.setBounds(100, 40, 200, 25);
            panel.add(textField);

            JLabel secondLabel = new JLabel("Label");
            secondLabel.setBounds(20,80, 80, 25);
            panel.add(secondLabel);

            JPasswordField passwordField = new JPasswordField(40);
            passwordField.setBounds(100, 80, 200, 25);
            panel.add(passwordField);

            button = new JButton("Click me one more time! " + counter);
            button.setBounds(100, 110, 200, 25);
            button.addActionListener(this::actionPerformed);
            panel.add(button);

            buttonLabel = new JLabel("Button clicked: " + counter + " times.");
            buttonLabel.setBounds(100, 150, 200,  25);
            panel.add(buttonLabel);

            frame.add(panel, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.pack();
            frame.setVisible(true);
        }
        catch (Exception exception) {
            System.err.println(exception.getLocalizedMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        //System.out.println("Works! " + counter);
        button.setText("Click me one more time! " + counter);
        buttonLabel.setText("Button clicked: " + counter + " times.");
    }
}
