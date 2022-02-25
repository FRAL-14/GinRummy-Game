package be.kdg.ginrummy;

import java.util.Locale;

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

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }

}
