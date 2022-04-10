package be.kdg.ginrummy.model;

public class Player {

    private String NAME;
    private int score;
    private boolean isPlayerTurn; // Defines who begins the round and is the dealer
    private Hand HAND = new Hand();


    public Player(String NAME, int score, boolean isPlayerTurn) {
        this.NAME = NAME;
        this.score = score;
        this.isPlayerTurn = isPlayerTurn;
    }



    protected Card discardCard(int i) {
        Card card = HAND.getCardAt(i);
        HAND.removeCard(i);
        return card;
    }


    public String getNAME() {
        return NAME;
    }
    public void setNAME(String name) {
        this.NAME = name;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int score) {
        this.score += score;
    }

    public boolean getIsPlayerTurn() {
        return isPlayerTurn;
    }

    public void setIsPlayerTurn(boolean playerTurn) {
        isPlayerTurn = playerTurn;
    }


    public Hand getHAND() {
        return HAND;
    }


    public boolean canKnock() {
        return getHAND().calculateDeadwood() <= 10; // change to 60 if you want to see the knock functionality for now
    }

}
