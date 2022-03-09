package be.kdg.ginrummy.model;

public class Player {

    private final String NAME;
    private int score;
    private boolean isPlayerTurn;
    private Hand hand = new Hand();


    public Player(String NAME, int score, boolean isPlayerTurn) {
        this.NAME = NAME;
        this.score = score;
        this.isPlayerTurn = isPlayerTurn;
    }

    public void dealCards(Deck deck) {
        hand.deal(deck);
    }

    public void printCards() {
        hand.printPlayerCards();
    }

    protected void addCard(Card card) {
        hand.addCard(card);
    }

    protected Card discardCard(int i) {
        Card card = hand.getCardAt(i);
        hand.removeCard(i);
        return card;
    }

    public int getDeadWoodCount() {
        return hand.calculateDeadwood();
    }

    protected Card getCardAt(int i) {
        return hand.getCardAt(i);
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
        hand.sortPlayerCards();
    }

    public Hand getHand() {
        return hand;
    }

    public boolean canKnock() {
        return getHand().calculateDeadwood() <= 10; // change to 60 if you want to see the knock functionality
    }

}
