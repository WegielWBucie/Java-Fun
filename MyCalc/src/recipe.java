import javax.swing.*;
import java.awt.*;

interface frameRecipe
{
    JFrame frame = new JFrame();
    JLabel mainScreenLabel = new JLabel();
    JLabel lowerScreenLabel = new JLabel();
}
interface fontsRecipes
{
    Font buttonsFont = new Font("serif", Font.PLAIN, 45);
    Font mainScreenFont = new Font("serif", Font.PLAIN, 75);
    Font lowerScreenFont = mainScreenFont.deriveFont(50F);
}
interface otherInstances
{
    char[] mathSigns = {
            'C','÷','×','⌫', //first row
            '-','+','√',      //almost entirely right column
            '%', '0', '.','=' //last row
    };
}