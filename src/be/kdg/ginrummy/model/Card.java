package be.kdg.ginrummy.model;

public class Card implements Comparable<Card> {

    private final Rank RANK;
    private final Suit SUIT;
    private boolean isInMeld;

    public Card(Rank rank, Suit suit) {
        this.RANK = rank;
        this.SUIT = suit;
    }

    public boolean isInMeld() {
        return isInMeld;
    }

    public void setInMeld(boolean isInMeld) {
        this.isInMeld = isInMeld;
    }

    public Rank getRank() {
        return RANK;
    }

    public Suit getSuit() {
        return SUIT;
    }

    public int getValue() {
        return RANK.getVALUE();
    }

    public String toString() {
        return this.RANK + " of " + this.SUIT;
    }

    @Override
    public int compareTo(Card other) {
        return this.getValue() - other.getValue();
    }

    public enum Rank {
        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10),
        QUEEN(10),
        KING(10);
        private final int VALUE;

        Rank(int value) {
            this.VALUE = value;
        }

        public int getVALUE() {
            return VALUE;
        }
    }

    public enum Suit {
        SPADES,
        HEARTS,
        CLUBS,
        DIAMONDS;
    }

}
