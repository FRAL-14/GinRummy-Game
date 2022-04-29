package model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
    private List<Card> deck;

    public Deck() {
        resetDeck();
    }

    public void resetDeck() {
        deck = new LinkedList<>();
        for (int suit = 0; suit < Card.Suit.values().length; suit++) {
            for (int rank = 0; rank < Card.Rank.values().length; rank++) {
                deck.add(0, new Card(Card.Rank.values()[rank], Card.Suit.values()[suit]));
            }
        }
        Collections.shuffle(deck);
    }

    public void printDeck() {
        for (Card card : deck) {
            System.out.println(card);
        }
    }

    public List<Card> getDeckOfCards() {
        return deck;
    }

    protected void setDeckOfCards(List<Card> updatedDeckOfCards) {
        this.deck = new LinkedList<>(updatedDeckOfCards);
    }

    public Card getCardAt(int i) {
        return deck.get(i);
    }

    protected void removeCard(int i) {
        deck.remove(i);
    }

    public void drawCardFor(Player player) {
        player.getHAND().addCard(getCardAt(0));
        removeCard(0);
    }

    public Card getNextCard() {
        final Card temp = getCardAt(0);
        removeCard(0);
        return temp;
    }

}
