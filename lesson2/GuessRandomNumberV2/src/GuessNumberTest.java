public class GuessNumberTest {

    public static void main(String[] args) {

        print("Добро пожаловать в угадайку.\n");

        GuessNumber game = new GuessNumber();
        game.startGame();
    }

    private static void print(Object obj) {
        System.out.println(obj);
    }

}
