package be.kdg.ginrummy;

public class Player {

    private final String NAME;
    private int score;
    private boolean isPlayerTurn;
    Hand hands = new Hand();


    public Player(String NAME, int score, boolean isPlayerTurn){
        this.NAME = NAME;
        this.score = score;
        this.isPlayerTurn = isPlayerTurn;
    }

    public void dealCards(Deck deck){
        hands.deal(deck);
    }

    protected void printCards(){
        hands.printPlayerCards();
    }
    protected void addCard(Card card){hands.addCard(card);}
    protected Card discardCard(int i){
        Card card = hands.getCardAt(i);
        hands.removeCard(i);
        return card;
    }
    protected int getDeadWoodCount(){return hands.calculateDeadwood();}
    protected Card getCardAt(int i){return hands.getCardAt(i);}

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
