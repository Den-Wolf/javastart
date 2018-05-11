import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class GuessNumber {

    private int randomNumber;
    private Player[] players;
    private int boundOfNumbers = 10;

    GuessNumber() {
        setNewRandomNumber(boundOfNumbers);
        print("Я загадал число от 0 до " + boundOfNumbers);
        int numberOfPlayers = 0;

        print("Введите количество игроков (от 1 до 10)");
        do {
            try {
                numberOfPlayers = Integer.parseInt(Player.readFromConsole());
            } catch (NumberFormatException nfEx) {
                print("Ошибка");
            }
        } while (numberOfPlayers > 10 || numberOfPlayers < 1);
        players = new Player[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player();
        }
    }

    void start() {
        boolean haveWinner = false;
        while (!haveWinner) {
            HashMap<Player, Boolean> usersAnswers = new HashMap<>();

            for (Player player : players) {
                if (player.tryToGuess() == randomNumber) {
                    usersAnswers.put(player, true);
                    haveWinner = true;
                } else {
                    usersAnswers.put(player, false);
                }
            }

            for (Map.Entry<Player, Boolean> entry : usersAnswers.entrySet()) {
                if (entry.getValue()) {
                    print(entry.getKey().getName() + " угадал! Мои поздравления!!!");
                } else {
                    print(entry.getKey().getName() + " не угадал.");
                }
            }
        }
    }

    private void setNewRandomNumber(int bound) {
        long seed = new Date().getTime();
        Random random = new Random(seed);
        randomNumber = random.nextInt(bound);
    }

    boolean wantToPlayAgain() {
        print("Хотите сыграть ещё раз?\nВведите номер ответа:\n1 - да\n2 - нет");
        while (true) {
            int answer = Player.readNumberFromConsole();
            if (answer == 1) {
                setNewRandomNumber(boundOfNumbers);
                print("Я загадал новое число\nПоробуйте отгадать\n");
                return true;
            } else if (answer == 2) {
                print("Приходите поиграть ещё! Удачного дня!");
                return false;
            }

        }
    }

    private void print(Object obj) {
        System.out.println(obj);
    }

}
