package be.kdg.ginrummy;

import be.kdg.ginrummy.view.Game;

public class Runner {

    private static Game game;

    public static void main(String[] args) {

        game = new Game("Leo");

//        //testing
//        Deck deck = new Deck();
//        //deck.print(); full 52 cards set
//
//        Player playerOne = new Player("Bear",0,false);
//        playerOne.dealCards(deck);
//        //playerOne.printCards();
//
//        Player playerTwo = new Player("Bear2",0,false);
//        playerTwo.dealCards(deck);
//        playerTwo.printCards();
//        System.out.println(playerTwo.getDeadWoodCount());//works
//        deck.print(); //the first 20 cards are gone

        game.printDeck();

       // game.getCOMPUTER_PLAYER().dealCards(game.getDECK());
        //game.getHUMAN_PLAYER().dealCards(game.getDECK());
        //game.getHUMAN_PLAYER().printCards();
        //System.out.println(game.getHUMAN_PLAYER().getDeadWoodCount());

        //System.out.println(game.getDECK().getDeckOfCards());

       // game.regularGameChecks();
       // game.getHUMAN_PLAYER().printCards();
       // System.out.println(game.getHUMAN_PLAYER().getDeadWoodCount());
       // game.getDISCARD_PILE().printDiscardPile();
    }

    public static Game getGame() {
        return game;
    }

}
