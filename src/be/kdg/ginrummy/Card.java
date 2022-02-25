package be.kdg.ginrummy;

public class Card {

    public enum Rank {
        ACE(1),TWO(2), THREE(3), FOUR(4), FIVE(5),
        SIX(6), SEVEN(7), EIGHT(8), NINE(9),
        TEN(10),
        JACK(10), QUEEN(10), KING(10);
        int value;

        Rank(int value) { this.value = value; }
        public int getValue() { return value; }
    }

    public enum Suit {
        SPADES("black"),
        HEARTS("red"),
        CLUBS("black"),
        DIAMONDS("red");

        private final String COLOUR;

        Suit(String colour) {
            this.COLOUR = colour;
        }

        public String getCOLOUR() {
            return COLOUR;
        }
    }

    private final Rank rank;
    private final Suit suit;
    private boolean isInMeld;


    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public boolean isInMeld() { return isInMeld;}
    public void setInMeld(boolean isInMeld) { this.isInMeld = isInMeld;}
    public Rank getRank() { return rank; }
    public Suit getSuit() { return suit; }
    public int getValue(){ return rank.getValue();}

    public String toString(){
        return this.rank+ " of " +this.suit;
    }
}
