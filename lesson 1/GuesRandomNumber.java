import java.io.*;
import java.util.*;

public class GuesRandomNumber {
    
    private static int randomNumber;
    private static boolean isStopped = false;


    public static void main(String args[]) throws Exception {
        //System.setProperty("console.encoding","UTF-8");

        print("Добро пожаловать в угадайку.\n(Для выхода введите exit)\n");

        while (!isStopped) {
            randomNumber = getRandomNumber();
            print("Привет! Я загадал число от 0 до 100. Угадай какое?");
            play();
            wantToPlayAgain();
        }

    }

    private static void print(Object obj) {
        System.out.println(obj);
    }

    private static String takeUserInput() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputData = reader.readLine();
        if (inputData.equalsIgnoreCase("exit")) {
            isStopped = true;
            print("Приходи ещё! Я буду тебя ждать)")
        }
        return  inputData;
    }

    private static int getRandomNumber() {
        long seed = new Date().getTime();
        Random random = new Random(seed);
        return random.nextInt(100);
    }

    private static void play() throws Exception {
        while(!isStopped) {
            if(checkUserNumberAnswer(numberRequest())) {
                break;
            }
        }
    }

    private static boolean checkUserNumberAnswer (int answer) {
        if (isStopped) {
            return false;
        } else {
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
    }

    private static int numberRequest() throws Exception {
        if (isStopped) {
            return -1;
        } else {
            try {
                return Integer.parseInt(takeUserInput());
            } catch (NumberFormatException nfex) {
                return numberRequest();
            }
        }
    }

    private static void wantToPlayAgain () throws Exception {
        if (!isStopped) {
            print("Хочешь сыграть ещё раз?");
            print("Введи \"yes\", если хочешь");
            isStopped = !(takeUserInput().equalsIgnoreCase("yes"));
        }
    }

}