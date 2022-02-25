package be.kdg.ginrummy;

public class Runner {

    private static Game game;

    public static void main(String[] args) {

        game = new Game("Leo");

        //testing
        Deck deck = new Deck();
        //deck.print(); full 52 cards set

        Player playerOne = new Player("Bear",0,false);
        playerOne.dealCards(deck);
        //playerOne.printCards();

        Player playerTwo = new Player("Bear2",0,false);
        playerTwo.dealCards(deck);
        //playerTwo.printCards();

        //deck.print(); //the first 20 cards are gone
    }

    public static Game getGame() {
        return game;
    }

}
