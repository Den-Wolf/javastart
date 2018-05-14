import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class GuessNumber {

    private static final int MAX_NUMBER_OF_PLAYERS = 10;
    private static final int MIN_NUMBER_OF_PLAYERS = 2;

    private static final int MAX_RANDOM_RANGE = 100;
    private static final int MIN_RANDOM_RANGE = 10;

    private int limitOfNumbers;
    private int randomNumber;

    private int numberOfPlayers;
    private Player[] players;


    void setNumberOfPlayers() {
        print("Введите количество игроков (от 1 до 10)");
        while (true) {
            int numberOfPlayers = Players.readNumberFromConsole();
            if (numberOfPlayers < MIN_NUMBER_OF_PLAYERS) {
                print("А что так мало?");
            } else if (numberOfPlayers > MAX_NUMBER_OF_PLAYERS) {
                print("Нет уж, вас слишком много! Играйте по очереди.");
            } else {
                this.numberOfPlayers = numberOfPlayers;
                break;
            }
        }
    }

    void setPlayers() {
        players = Players.createStackOfPlayers(numberOfPlayers);
    }

    void setLimitOfNumbers(int limitOfNumbers) {
        if (limitOfNumbers < MIN_RANDOM_RANGE) {
            print("Вы ввели слишком маленькое число");
            setLimitOfNumbers(Players.readNumberFromConsole());
        } else if (limitOfNumbers > MAX_RANDOM_RANGE) {
            print("Вы ввели слишком большое число");
            setLimitOfNumbers(Players.readNumberFromConsole());
        } else {
            print("Я загадал число от 0 до " + limitOfNumbers);
            this.limitOfNumbers = limitOfNumbers;
        }
    }


    void start() {
        setNewRandomNumber(limitOfNumbers);
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
        if (wantToPlayAgain()) {
            start();
        }
    }

    private void setNewRandomNumber(int bound) {
        long seed = new Date().getTime();
        Random random = new Random(seed);
        randomNumber = random.nextInt(bound);
    }

    private boolean wantToPlayAgain() {
        print("Хотите сыграть ещё раз?\nВведите номер ответа:\n1 - да\n2 - нет");
        int answer = Players.readNumberFromConsole();
        if (answer == 1) {
            print("Я загадал новое число от 0 до " + limitOfNumbers + "\nПоробуйте отгадать\n");
            return true;
        } else if (answer == 2) {
            print("Приходите поиграть ещё! Удачного дня!");
            return false;
        } else {
            return wantToPlayAgain();

        }
    }

    private void print(Object obj) {
        System.out.println(obj);
    }

}
