import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Calculator {
    public static void main(String args[]) throws Exception {
        print("\nВведите выражение для обработки (Например \"5 * 10\") и нажмите Enter");
        print("Либо введите \"exit\" для выхода\n");
        while (true) {
            String setOfActions[] = readExpression();
            didExpression(Double.parseDouble(setOfActions[0]), setOfActions[1], Double.parseDouble(setOfActions[2]));
        }
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static String[] readExpression () throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String query = reader.readLine();
            String splittedQuery[] = query.split(" ");

            if (splittedQuery.length == 1 && splittedQuery[0].equalsIgnoreCase("exit")) {
                reader.close();
                System.exit(0);
            } else if (
                    splittedQuery.length == 3
                            && splittedQuery[1].matches("\\+|\\-|\\*|\\/|\\%|\\^")
                            && splittedQuery[0].matches("(-|\\+)?[0-9]+(\\.[0-9]+)?")
                            && splittedQuery[2].matches("(-|\\+)?[0-9]+(\\.[0-9]+)?")
                    ) {
                return splittedQuery;
            }
        }
    }

    public static void didExpression (Double firstNumber, String sign, Double secondNumber) {
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
                print(Math.pow(firstNumber * 1.0, secondNumber * 1.0));
            default:
                break;
        }
        print("");
    }
}
