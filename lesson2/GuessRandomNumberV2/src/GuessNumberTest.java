public class GuessNumberTest {

    public static void main(String[] args) {

        print("Добро пожаловать в угадайку.\n");

        GuessNumber game = new GuessNumber();
        game.setNumberOfPlayers();
        game.setPlayers();

        print("Я загадаю число от 0 до того, которое вы введете.");
        print("(можно вводить от 10 до 100):");
        game.setLimitOfNumbers(Players.readNumberFromConsole());


        game.start();
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }

}
