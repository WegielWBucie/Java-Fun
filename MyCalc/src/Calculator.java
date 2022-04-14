import java.util.ArrayList;

public class Calculator implements otherInstances, frameRecipe, fontsRecipes
{
    public static String equation;
    public static double result;
    private static final ArrayList<Double> numbers = new ArrayList<>();
    public static final ArrayList<Character> signs = new ArrayList<>();

    public static void createEquation(StringBuilder equationBuilder, String charPressed)
    {
        equationBuilder.append(charPressed);
        for (char mathSign: mathSigns) {
            if(equationBuilder.length() == 1 && equationBuilder.charAt(0) == mathSign
                    && equationBuilder.charAt(0) != '0' && equationBuilder.charAt(0) != '-')
                equationBuilder.deleteCharAt(0);
            else for (char otherMathSign : mathSigns) {
                if(equationBuilder.length() >= 2 && otherMathSign != '√' &&
                        equationBuilder.charAt(equationBuilder.length()-1) != '0' &&
                        equationBuilder.charAt(equationBuilder.length()-2) != '0' &&
                        equationBuilder.charAt(equationBuilder.length()-1) == mathSign &&
                        equationBuilder.charAt(equationBuilder.length()-2) == otherMathSign)
                    equationBuilder.deleteCharAt(equationBuilder.length()-2);
            }
        }
        if(equationBuilder.length() > 0 &&
                equationBuilder.charAt(equationBuilder.length()-1) == '=')
            solveEquation(equationBuilder);
    }
    public static void solveEquation(StringBuilder equation)
    {
        numbers.clear(); signs.clear();
        for(int i=0; i<equation.length(); i++)
        {
            if(i == 0 && equation.charAt(0) == '-') {
                int j = 0;
                i++;
                while (equation.charAt(i) >=48 && equation.charAt(i) <= 57
                        || equation.charAt(i) == '.')
                    i++;
                numbers.add(Double.parseDouble(equation.substring(j, i)));
            }
            if(equation.charAt(i) >=48 && equation.charAt(i) <= 57) {
                int j = i;
                while (equation.charAt(i) >=48 && equation.charAt(i) <= 57
                        || equation.charAt(i) == '.')
                    i++;
                numbers.add(Double.parseDouble(equation.substring(j, i)));
                i--; //substring does take chars until "i-1", therefore "i" has to be reduced
            }
            else for (char mathSign : mathSigns) {
                if (equation.charAt(i) == mathSign) {
                    signs.add(equation.charAt(i));
                }
            }
        }
        result = numbers.get(0);
        for (int i = 0; i < signs.size(); i++) {
            int j = i+1;
            result = switch (signs.get(i)) {
                case '+' -> addition(result, numbers.get(j));
                case '-' -> subtraction(result, numbers.get(j));
                case '×' -> multiplication(result, numbers.get(j));
                case '÷' -> division(result, numbers.get(j));
                case '√' -> root(result);
                case '%' -> percent(result, numbers.get(j));
                case 'C' -> clear();
                case '=' -> result;
                default -> 1;
            };
        }
    }
    private static double addition(double a, double b) { return a+b; }
    private static double subtraction(double a, double b) { return a-b; }
    private static double multiplication(double a, double b) { return a*b; }
    public static boolean divisionBy0 = false;
    private static double division(double a, double b) {
        if(b == 0) {
            divisionBy0 = true;
            return 0;
        }
        else {
            divisionBy0 = false;
            return a/b;
        }
    }
    public static boolean sqrtOfNegative = false;
    private static double root(double a) {
        if(a < 0) {
            sqrtOfNegative = true;
            return 0;
        }
        else {
            return Math.sqrt(a);
        }
    }
    private static double percent (double a, double b) { return a/100 * b; }
    public static double clear() {
        equation = "";
        signs.clear(); numbers.clear();
        lowerScreenLabel.setText("");
        result = 0;
        return 0;
    }
}