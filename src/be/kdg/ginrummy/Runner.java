package be.kdg.ginrummy;

public class Runner {

    private static Game game;

    public static void main(String[] args) {

        game = new Game("Leo");

        //testing
        Deck deck = new Deck();
        deck.print();

        //testing
        Hand playerOne = new Hand(deck);
        playerOne.printPlayerCards();
    }

    public static Game getGame() {
        return game;
    }

}
