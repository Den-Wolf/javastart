
public class GuessRandomNumberTest {

    public static void main(String[] args) {

        System.out.println("Добро пожаловать в угадайку.\n");

        GuessRandomNumber game = new GuessRandomNumber();
        do {
            game.start();
        } while (game.wantToPlayAgain());
    }

}
