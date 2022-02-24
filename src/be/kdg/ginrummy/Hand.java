package be.kdg.ginrummy;

import java.util.ArrayList;
import java.util.List;

public class Hand extends Deck {
    protected List<Card> updatedCardList;
    protected List<Card> playerCards;
    private int deadWoodCount = 0;
    private List<Card> meld;

    public Hand(Deck deck) {
        updatedCardList = new ArrayList<>(deck.getDeckOfCards());
        playerCards = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            playerCards.add(deck.getCardAt(i));
            updatedCardList.remove(0);
        }
        deck.setDeckOfCards(updatedCardList);
    }

    public void printPlayerCards() { for (Card card : playerCards) { System.out.print(card + " - ");}}
    public void removeCard(int i){ playerCards.remove(i);}
    public void addCard(Card card){playerCards.add(card);}
    protected Card getCardAt(int i){return playerCards.get(i);}
    public List<Card> getPlayerCards() {
        return playerCards;
    }
    public int getDeadWoodCount() { return deadWoodCount;}
}
