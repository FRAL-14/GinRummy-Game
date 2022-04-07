package be.kdg.ginrummy.model;

import java.util.LinkedList;
import java.util.List;

public class DiscardPile {
    private List<Card> discardedCards;
    private int size = 0;

    public DiscardPile() {
        discardedCards = new LinkedList<>();
    }

    public void addCard(Card card) {
        discardedCards.add(card);
    }

    public void drawCardFor(Player player) {
        size = discardedCards.size();
        player.getHAND().addCard(discardedCards.get(size - 1));
        discardedCards.remove(size - 1);
    }

    public void printDiscardPile() {
        for (Card card : discardedCards) {
            System.out.print(card + " - ");
        }
        System.out.println();
    }

}
