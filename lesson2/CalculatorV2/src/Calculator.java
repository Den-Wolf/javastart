import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class Calculator {

    private boolean isRunning = true;
    private String splittedExpression[] = new String[3];

    void start () {
        printInfo();
        while (isRunning) {
            Arrays.fill(splittedExpression, "");
            String setOfActions[] = readExpression();
            if (setOfActions[0].equalsIgnoreCase("exit")) {
                break;
            } else {
                calculateExpression(Double.parseDouble(setOfActions[0]), setOfActions[1], Double.parseDouble(setOfActions[2]));
            }
        }
    }

    private String[] readExpression() {
        while (true) {
            char[] query;
            try {
                query = ((new BufferedReader(new InputStreamReader(System.in))).readLine()).toCharArray();
            } catch (IOException ioEx) {
                continue;
            }

            if (isExpressionCorrect(query)) {
                return splittedExpression;
            }
        }
    }

    private boolean isExpressionCorrect(char[] query) {
        splitExpression(query);
        if (splittedExpression[0].equalsIgnoreCase("exit")) {
            isRunning = false;
            return true;
        } else if (
                   splittedExpression[0].matches("(-|\\+)?[0-9]+(\\.[0-9]+)?")
                && splittedExpression[2].matches("(-|\\+)?[0-9]+(\\.[0-9]+)?")
                ) {
            return true;
        } else {
            print("Ошибка!");
            return false;
        }
    }

    private void splitExpression (char[] query) {
            int i = 0;
            for (Character element : query) {
                if (element != ' ') {
                    if (i < 2 && (element.toString().matches("[+*\\-/^%]") || i == 1)) {
                        i++;
                    }
                    splittedExpression[i] += element;
                }
            }
    }

    private void calculateExpression(Double firstNumber, String sign, Double secondNumber) {
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

    /////////////////// Cлужебные методы вывода //////////////////

    private void printInfo() {
        print("\nВведите выражение для обработки (\"например 24 * 12\") и нажмите Enter");
        print("Доступные действия: +, -, *, /, %(остаток от деления), ^(возвести в степень)");
        print("Либо введите \"exit\" для выхода\n");
    }

    private void print(Object obj) {
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
}
