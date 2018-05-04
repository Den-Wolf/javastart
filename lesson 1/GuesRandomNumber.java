import java.io.*;
import java.util.*;

public class GuesRandomNumber {
    static int randomNumber;
    public static void main(String args[]) throws Exception {
        System.setProperty("console.encoding","UTF-8");

        print("Добро пожаловать в угадайку.\n(Для выхода введите exit)\n");

        do {
            randomNumber = getRandomNumber();
            print("Привет! Я загадал число от 0 до 100. Угадай какое?");
            game();
        } while (wantToPlayAgain());

    }

    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static int getRandomNumber() {
        Long seed = new Date().getTime();
        Random random = new Random(seed);
        return random.nextInt(100);
    }

    public static void game() throws Exception {
        while(!checkUserNumberAnswer(inputRequest())) {
        }
    }

    public static boolean checkUserNumberAnswer (int answer) {
        if (answer > randomNumber) {
            print("Нет, я загадал число поменьше.");
        } else if (answer < randomNumber) {
            print("Нет, я загадал число побольше.");
        } else if (answer == randomNumber) {
            print("Ух-Ты! Ты угадал моё число!!!");
            return true;
        }
        return false;
    } 

    public static int inputRequest() throws Exception {
        String input = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        if (input.equalsIgnoreCase("exit")) {
            System.exit(0);
        } else {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException nfex) {
                return inputRequest();
            }
        }
        return 0;
    }

    public static boolean wantToPlayAgain () throws Exception {
        print("Хочешь сыграть ещё раз?");
        print("Введи \"да\", если хочешь");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine().equalsIgnoreCase("да");
    }

}