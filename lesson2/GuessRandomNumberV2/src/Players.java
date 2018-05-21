import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Players {
    public static String readText() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            return readText();
        }
    }

    public static int readInt() {
        try {
            return Integer.parseInt(readText());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка");
            return readInt();
        }
    }

    public static Player[] createStackOfPlayers(int numberOfPlayers) {
        Player[] players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Введите имя игрока " + (i + 1));
            players[i] = new Player(readText());
        }
        return players;
    }
}
