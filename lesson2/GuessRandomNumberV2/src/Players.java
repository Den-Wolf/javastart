import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Players {
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

    static Player[] createStackOfPlayers(int numberOfPlayers) {
        Player[] players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Введите имя игрока " + (i + 1));
            players[i] = new Player(readFromConsole());
        }
        return players;
    }
}
