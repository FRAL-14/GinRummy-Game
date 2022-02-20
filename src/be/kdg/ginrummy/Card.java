package be.kdg.ginrummy;

public class Card {

    private final Suit SUIT;
    private final Rank RANK;

    public Card(Suit suit, Rank rank) {
        SUIT = suit;
        RANK = rank;
    }

    public Suit getSUIT() {
        return SUIT;
    }

    public Rank getRANK() {
        return RANK;
    }

    public int getVALUE() {
        return RANK.getVALUE();
    }

}
