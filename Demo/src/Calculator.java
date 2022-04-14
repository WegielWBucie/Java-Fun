import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator
{
    private static String equation;
    private static double generalResult;
    private static final List<Double>numbers = new ArrayList<>();
    private static final List<Character>signs = new ArrayList<>();
    private static final char[] examples = {'+', '-', '*', '/', '%', '!', '^'};

    public static void simpleCalculator()
    {
        try {
            generalResult = 0;
            //numbers.clear(); signs.clear();
            System.out.println("Enter equation: ");
            simpleCalcRecursive();
        }
        catch (Exception exception) {
            System.out.println("General result: " + generalResult);
            System.out.println("Equation: " + equation);
            System.out.println("Signs " + signs);
            System.out.println("Numbers " + numbers);
            System.err.println(exception.getLocalizedMessage());
        }
    }
    private static void simpleCalcRecursive()
    {
        numbers.clear(); signs.clear();
        Scanner scanner = new Scanner(System.in);
        equation = scanner.nextLine().trim();
        for(int i=0; i<equation.length(); i++)
        {
            if(equation.charAt(i) == '=')
                equation = equation.substring(0, i);
        }
        boolean back = true;
        for(int i=0; i<equation.length(); i++)
        {
            if (equation.charAt(i) >= 48 && equation.charAt(i) <= 57) {
                back = false;
                break;
            }
        }
        if(back){
            Helps.menuReturn(5, 0.5, true);
            Desktop.setChoice();
        }
        else
        {
            for(int i=0; i<equation.length(); i++)
            {
                if(equation.charAt(i) >=48 && equation.charAt(i) <= 57)
                {
                    int j = i;
                    while (equation.charAt(i) >= 48 && equation.charAt(i) <= 57 || equation.charAt(i) == '.')
                        i++;
                    numbers.add(Double.parseDouble(equation.substring(j, i)));
                }
                else {
                    for (char example : examples) {
                        if (equation.charAt(i) == example)
                            signs.add(equation.charAt(i));
                    }
                }
            }
            calcCases();
            simpleCalcRecursive();
        }
    }
    private static void calcCases()
    {
        boolean signFirst = false;
        for (char example : examples) {
            if (equation.charAt(0) == example) {
                signFirst = true;
                break;
            }
        }
        double result;
        if(signFirst)
            result = generalResult;
        else
            result = numbers.get(0);
        for(int i=0; i<signs.size(); i++)
        {
            int j;
            if(signFirst)
                j= i;
            else
                j = i+1;
            result = switch (signs.get(i)) {
                case '+' -> addition(result, numbers.get(j));
                case '-' -> subtraction(result, numbers.get(j));
                case '*' -> multiplication(result, numbers.get(j));
                case '/' -> division(result, numbers.get(j));
                case '%' -> modulo(result, numbers.get(j));
                case '^' -> power(result, numbers.get(j));
                default -> result;
            };
        }
        generalResult = result;
        if((int)result == result)
            System.out.println(equation + " = " + (int)(result));
        else
            System.out.println(equation + " = " + result);
    }
    private static double addition(double a, double b) { return a+b; }
    private static double subtraction(double a, double b) { return a-b; }
    private static double multiplication(double a, double b) { return a*b; }
    private static double division(double a, double b) { return a/b; }
    private static double modulo(double a, double b) { return a%b; }
    private static double power(double a, double power)
    {
        int result = 1;
        for(int i=0; i<power; i++)
            result *= a;
        return result;
    }
    private static int factorial(int a)
    {
        int res = a;
        for(int i=1; i<a; i++)
        {
            res *= i;
        }
        return res;
    }
    public static void solver()
    {
        System.out.println("Enter equation: ");
        Scanner scanner = new Scanner(System.in);
        String equation1 = scanner.nextLine().trim();
        String equation2 = scanner.nextLine().trim();

        for (int i = 0; i < equation1.length(); i++) {
            if(equation1.charAt(i) == '=')
                equation1 = equation1.substring(0,i);
        }
        for (int i = 0; i < equation2.length(); i++) {
            if(equation2.charAt(i) == '=')
                equation2 = equation2.substring(0,i);
        }
        String[] parts1 = equation1.split(" ");
        //System.out.println(part);
        String[] parts2 = equation2.split(" ");
        //System.out.println(part);

        ArrayList<Double>variables = new ArrayList<>();

        for (int i = 0; i < parts1.length; i++) {
            if(ifSign(parts1[i]))
                i++;
            else {
                for (int j = 0; j < parts2.length; j++) {
                    variables.add(Double.parseDouble(parts1[i].substring(0, parts1.length-1)));
                }
            }
        }
        System.out.println(variables);
        //ax + by + c = 0
        solver();

    }
    private static boolean ifSign(String position)
    {
        try {
            for (char example : examples)
                if (position.equals(String.valueOf(example)))
                    return true;
            return false;
        }
        catch (Exception exception) {
            return false;
        }
    }
}