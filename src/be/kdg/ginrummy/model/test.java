package be.kdg.ginrummy.model;

public class test {
    public static void main(String[] args){
        //starting the game
        //dealing cards to the 2 players
        //in the view, display the card of player 1.

        Game game = new Game("noura");

        Player playerTwo = new Player("Lolo", 0, true);

        //the code u need:
        Player playerOne = new Player("salma", 0, false);
        Deck deck = new Deck();
        playerOne.getHAND().deal(deck);
        playerOne.getHAND().printPlayerCards();




    }




}
