package be.kdg.ginrummy;

public class Runner {

    private static Game game;

    public static void main(String[] args) {

        game = new Game("Leo");

    }

    public static Game getGame() {
        return game;
    }

}
