package be.kdg.ginrummy;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private final int totalCardsNumber = 52;
    private List<Card> deck;

    public Deck(){
        deck = new ArrayList<>(totalCardsNumber);
        int index=0;
        for (int suit = 0; suit <Card.Suit.values().length; suit++){
            for(int rank = 0; rank <Card.Rank.values().length; rank++){
                deck.add(new Card(Card.Rank.values()[rank], Card.Suit.values()[suit]));
                index++;
            }
        }
        // Collections.shuffle(deckOfCards);
    }

    protected void print(){
        for (Card card: deck){ System.out.println(card);}
    }

    protected void setDeckOfCards(List<Card> updatedDeckOfCards) { this.deck = new ArrayList<>(updatedDeckOfCards);}
    public  List<Card> getDeckOfCards() {
        return deck;
    }
    protected Card getCardAt(int i){return deck.get(i);}
    protected void removeCard(int i){deck.remove(i);}
}
