
public class GuessNumberTest {

    public static void main(String[] args) {

        int limitOfNumbers;
        int numberOfPlayers;

        print("Добро пожаловать в угадайку.\n");
        print("Я загадаю число от 0 до того, которое вы введете.");
        print("(можно вводить от 10 до 100):");
        while (true) {
            limitOfNumbers = Player.readNumberFromConsole();
            if (limitOfNumbers < 10) {
                print("Вы ввели слишком маленькое число");
            } else if (limitOfNumbers > 100) {
                print("Вы ввели слишком большое число");
            } else {
                print("Я загадал число от 0 до " + limitOfNumbers);
                break;
            }
        }


        //Запрашиваем количество игроков
        //не заношу в класс Player, так как в другой игре нам может потребоваться,
        // к примеру, четко 2 игрока или наоборот 15.
        print("Введите количество игроков (от 1 до 10)");
        while (true) {
            numberOfPlayers = Player.readNumberFromConsole();
            if (numberOfPlayers < 1) {
                print("А играть кто будет?");
            } else if (numberOfPlayers > 10) {
                print("Нет уж, вас слишком много! Играйте по очереди.");
            } else {
                break;
            }
        }
        // ===================================================================== //

        GuessNumber game = new GuessNumber(limitOfNumbers, Player.createStackOfPlayers(numberOfPlayers));
        do {
            game.start();
        } while (game.wantToPlayAgain());
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }

}
