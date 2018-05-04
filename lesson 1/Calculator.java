import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Calculator {
    public static void main(String args[]) throws Exception {
        System.setProperty("console.encoding","UTF-8");
        print("\nВведите выражение для обработки (\"например 24 * 12\") и нажмите Enter");
        print("Доступные действия: +, -, *, /, %(остаток от деления), ^(возвести в степень)");
        print("Не забывайте отделять операторы от чисел пробелами.");
        print("Либо введите \"exit\" для выхода\n");
        while (true) {
            String setOfActions[] = readExpression();
            calculateExpression(Double.parseDouble(setOfActions[0]), setOfActions[1], Double.parseDouble(setOfActions[2]));
        }
    }

    public static void print(Object obj) {
        if (obj instanceof Double) {
            double temp = Double.parseDouble(obj.toString());
            if (temp % 1.0 == 0) {
                System.out.format("%.0f%n", Double.parseDouble(obj.toString()));    
            } else {
                System.out.println(temp);
            }
        } else {
            System.out.println(obj);
        }
    }

    public static String[] readExpression () throws Exception {
        while (true) {
            String query = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            String splittedExpression[] = query.split(" ");
            if(isExpressionCorrect(splittedExpression)) {
                return splittedExpression;
            }
        } 
    }

    public static boolean isExpressionCorrect (String splittedExpression[]) {
        if (splittedExpression.length == 1 && splittedExpression[0].equalsIgnoreCase("exit")) {
            System.exit(0);
        } else if (
            splittedExpression.length == 3
            && splittedExpression[1].matches("\\+|\\-|\\*|\\/|\\%|\\^")
            && splittedExpression[0].matches("(-|\\+)?[0-9]+(\\.[0-9]+)?")
            && splittedExpression[2].matches("(-|\\+)?[0-9]+(\\.[0-9]+)?")
        ) {
            return true;
        }
        return false;
    }

    public static void calculateExpression (Double firstNumber, String sign, Double secondNumber) {
        switch (sign) {
            case "+":
                print(firstNumber + secondNumber);
                break;
            case "-":
                print(firstNumber - secondNumber);
                break;
            case "*":
                print(firstNumber * secondNumber);
                break;
            case "/":
                print(firstNumber / secondNumber);
                break;
            case "%":
                print(firstNumber % secondNumber);
                break;
            case "^":
                print(Math.pow(firstNumber, secondNumber));
            default:
                break;
        }
        print("");
    }
}
