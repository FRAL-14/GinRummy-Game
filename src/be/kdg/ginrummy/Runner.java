package be.kdg.ginrummy;

public class Runner {

    private static Game game;

    public static void main(String[] args) {

        game = new Game("Leo");

        //testing
        Deck deck = new Deck();
        //deck.print(); full 52 cards set

        //testing
        Player playerOne = new Player("noura",0, deck,false);
        //playerOne.printCards(); //player 1 draws the first 10 cards

        Player playerTwo = new Player("sarah",0, deck,false);
        //playerTwo.printCards(); //player 1 draws the next 10 cards

        //deck.print(); //the first 20 cards are gone
    }

    public static Game getGame() {
        return game;
    }

}
