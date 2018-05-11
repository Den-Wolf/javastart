

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Player {

    private String name;

    Player() {
        System.out.println("Введите имя игрока");
        name = readFromConsole();
    }

    static String readFromConsole() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException ioEx) {
            return readFromConsole();
        }
    }

    static int readNumberFromConsole() {
        try {
            return Integer.parseInt(readFromConsole());
        } catch (NumberFormatException nfEx) {
            System.out.println("Ошибка");
            return readNumberFromConsole();
        }
    }

    int tryToGuess() {
        System.out.print(this.name + ", введите ваш вариант: ");
        return readNumberFromConsole();
    }

    String getName() {
        return name;
    }

}

