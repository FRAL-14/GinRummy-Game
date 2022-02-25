package be.kdg.ginrummy;

public class Player {

    private final String NAME;
    private int score;
    private boolean isPlayerTurn;
    Hand cards;

    public Player(String NAME, int score, Deck deck, boolean isPlayerTurn) {
        this.NAME = NAME;
        this.score = score;
        this.isPlayerTurn = isPlayerTurn;
        this.cards = new Hand(deck);
    }

    protected void printCards(){
        cards.printPlayerCards();
    }
    protected void addCard(Card card){cards.addCard(card);}
    protected Card discardCard(int i){
        Card card = cards.getCardAt(i);
        cards.removeCard(i);
        return card;
    }
    protected Card getCardAt(int i){return cards.getCardAt(i);}


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

}
