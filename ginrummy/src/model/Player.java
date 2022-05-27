package model;

import java.sql.SQLException;

public class Player {

    private String NAME;
    private int score;
    private boolean isPlayerTurn; // Defines who begins the round and is the dealer
    private Hand HAND = new Hand();

    public Player(boolean isPlayerTurn) {
        this.isPlayerTurn = isPlayerTurn;
    }

    public Player(String NAME, boolean isPlayerTurn) {
        this.NAME = NAME;
        this.isPlayerTurn = isPlayerTurn;
    }



    public Card discardCard(int i) {
        Card card = HAND.getCardAt(i);
        HAND.removeCard(i);
        return card;
    }

    public String getNAME() {
        return NAME;
    }
    public void setNAME(String name)  {
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
