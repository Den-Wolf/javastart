
public class GuessNumberTest {

    public static void main(String[] args) {

        System.out.println("Добро пожаловать в угадайку.\n");

        GuessNumber game = new GuessNumber();
        do {
            game.start();
        } while (game.wantToPlayAgain());
    }

}
