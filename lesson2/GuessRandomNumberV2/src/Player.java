class Player {

    private String name;

    Player(String name) {
        this.name = name;
    }

    int tryToGuess() {
        System.out.print(this.name + ", введите ваш вариант: ");
        return Players.readInt();
    }

    String getName() {
        return name;
    }

}

