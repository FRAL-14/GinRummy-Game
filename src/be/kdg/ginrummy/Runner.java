package be.kdg.ginrummy;

public class Runner {

    private static Game game;

    public static void main(String[] args) {

        game = new Game("Leo");

        Deck deck = new Deck();
        //deck.print(); full 52 cards set

        Player playerOne = new Player("Bear",0,false);
        playerOne.dealCards(deck);
        //playerOne.printCards(); //10 set of cards

        Player playerTwo = new Player("Bear2",0,false);
        playerTwo.dealCards(deck);
        //playerTwo.printCards();
        //System.out.println("Deadwood: "+playerTwo.getDeadWoodCount());
        //deck.print();

        playerTwo.sortCards();
        //playerTwo.printCards();

    }

    public static Game getGame() {
        return game;
    }

}
