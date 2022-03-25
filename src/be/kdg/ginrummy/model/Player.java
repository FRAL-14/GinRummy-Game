package be.kdg.ginrummy.model;

public class Player {

    private final String NAME;
    private int score;
    private boolean isPlayerTurn; // Defines who begins the round and is the dealer
    private final Hand HAND = new Hand(); // Can be final, as the hand itself doesn't change, but the cards do


    public Player(String NAME, int score, boolean isPlayerTurn) {
        this.NAME = NAME;
        this.score = score;
        this.isPlayerTurn = isPlayerTurn;
    }

    /*public void dealCards(Deck deck) {
        HAND.deal(deck);
    }*/

   /* public void printCards() {
        HAND.printPlayerCards();
    }*/

   /* protected void addCard(Card card) {
        HAND.addCard(card);
    }*/

    protected Card discardCard(int i) {
        Card card = HAND.getCardAt(i);
        HAND.removeCard(i);
        return card;
    }

    public int getDeadWoodCount() {
        return HAND.calculateDeadwood();
    }

    protected Card getCardAt(int i) {
        return HAND.getCardAt(i);
    }

    public String getNAME() {
        return NAME;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean getIsPlayerTurn() {
        return isPlayerTurn;
    }

    public void setIsPlayerTurn(boolean playerTurn) {
        isPlayerTurn = playerTurn;
    }

    public void sortCards() {
        HAND.sortPlayerCards();
    }

    public Hand getHAND() {
        return HAND;
    }

    public boolean canKnock() {
        return getHAND().calculateDeadwood() <= 10; // change to 60 if you want to see the knock functionality for now
    }

}
