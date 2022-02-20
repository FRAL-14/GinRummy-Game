package be.kdg.ginrummy;

import java.util.Locale;

public enum Suit {

    SPADES("black"),
    HEARTS("red"),
    CLUBS("black"),
    DIAMONDS("red");

    private final String colour;

    Suit(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }

}
