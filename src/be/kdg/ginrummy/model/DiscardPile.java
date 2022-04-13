package be.kdg.ginrummy.model;

import java.util.LinkedList;
import java.util.List;

public class DiscardPile {
    private List<Card> discardedCards;

    public DiscardPile() {
        discardedCards = new LinkedList<>();
    }

    public void addCard(Card card) {
        discardedCards.add(0, card); //
    }

    public void drawCardFor(Player player) {
        player.getHAND().addCard(getNextCard());
        discardedCards.remove(0);
    }

    public Card getNextCard() {
        return discardedCards.get(0);
    }

    public void printDiscardPile() {
        for (Card card : discardedCards) {
            System.out.print(card + " - ");
        }
        System.out.println();
    }

}
