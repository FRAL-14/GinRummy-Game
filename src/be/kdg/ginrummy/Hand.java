package be.kdg.ginrummy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Hand extends Deck {
    protected List<Card> updatedCardList;
    protected LinkedList<Card> playerCards;
    private int deadWoodCount = 0;
    private List<Card> meld;

    public Hand() {
    }


    public void deal(Deck deck) {
        updatedCardList = new LinkedList<>(deck.getDeckOfCards());
        playerCards = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            playerCards.add(deck.getCardAt(i));
            updatedCardList.remove(0);
        }
        deck.setDeckOfCards(updatedCardList);
    }

    public int calculateDeadwood() {
        //Run: 3 or more cards of the same suit
        //Set: 3 or more cards of the same number

        //Run
        for (Card card : playerCards) {
            if (Collections.frequency(playerCards, card.getValue()) > 3) {
                card.setInMeld(true);
            }
        }
        //Set
        for (Card card : playerCards) {
            if (Collections.frequency(playerCards, card.getSuit()) > 3) {

                card.setInMeld(true);
            }
        }

        deadWoodCount = 0;

        for (Card card : playerCards) {
            if (!card.isInMeld()) {
                deadWoodCount += card.getValue();
            }
        }

        return deadWoodCount;

    }

    public void clear() {
    }

    public int getCardCount() {
        return 0;
    }


    public void printPlayerCards() {
        for (Card card : playerCards) {
            System.out.print(card + " - ");
        }
    }

    public void removeCard(int i) {
        playerCards.remove(i);
    }

    public Card removeLastCard() {
        return playerCards.removeLast();
    }

    public void addCard(Card card) {
        playerCards.add(card);
    }

    protected Card getCardAt(int i) {
        return playerCards.get(i);
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public void sortPlayerCards() {
        Collections.sort(playerCards);
    }

}
