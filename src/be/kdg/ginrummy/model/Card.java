package be.kdg.ginrummy.model;

import java.util.Locale;

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

    @Override
    public String toString() {
        return this.RANK + " of " + this.SUIT;
    }

    @Override
    public int compareTo(Card other) {
        return this.getRank().getORDER() - other.getRank().getORDER();
    }

    public enum Rank {
        ACE(1, 1),
        TWO(2, 2),
        THREE(3, 3),
        FOUR(4, 4),
        FIVE(5, 5),
        SIX(6, 6),
        SEVEN(7, 7),
        EIGHT(8, 8),
        NINE(9, 9),
        TEN(10, 10),
        JACK(10, 11),
        QUEEN(10, 12),
        KING(10, 13);

        private final int VALUE;
        private final int ORDER;

        Rank(int value, int order) {
            this.VALUE = value;
            this.ORDER = order;
        }

        public int getVALUE() {
            return VALUE;
        }

        public int getORDER() {
            return ORDER;
        }

        @Override
        public String toString() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

    public enum Suit {
        SPADE,
        HEART,
        CLUB,
        DIAMOND;

        @Override
        public String toString() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

}
