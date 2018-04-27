import java.io.*;
import java.util.*;

public class GuesRandomNumber {
    public static void main(String args[]) throws Exception {
        System.setProperty("console.encoding","UTF-8");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        print("Добро пожаловать в угадайку. Для выхода введите exit");

        Integer input;
        Boolean play = true;
        while (play) {
            Integer randomNumber = setRandomNumber();
            print("Привет! Я загадал число от 0 до 100. Угадай какое?");
            while (true) {
                String temp = reader.readLine();
                if (temp.equalsIgnoreCase("exit")) {
                    break;
                }
                try {
                    input = Integer.parseInt(temp);
                } catch (Exception ex) {
                    continue;
                }
                if (input > randomNumber) {
                    print("Нет, я загадал число поменьше.");
                } else if (input < randomNumber) {
                    print("Нет, я загадал число побольше.");
                } else if (input == randomNumber) {
                    print("Ух-Ты! Ты угадал моё число!!!");
                    print("Хочешь сыграть ещё раз?");
                    print("Введи \"yes\", если хочешь");
                    play = reader.readLine().equalsIgnoreCase("yes");
                    break;
                }
            }
        }

    }

    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static Integer setRandomNumber() {
        Long seed = new Date().getTime();
        Random random = new Random(seed);
        return random.nextInt(100);
    }

}