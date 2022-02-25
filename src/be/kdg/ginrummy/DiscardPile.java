package be.kdg.ginrummy;

import java.util.ArrayList;
import java.util.List;

public class DiscardPile {
    private List<Card> discardedCards;
    private int size= 0;

    public DiscardPile(){
        discardedCards = new ArrayList<>();
    }
    protected void discardCard(Card card){
        discardedCards.add(card);
    }
    protected void drawCardFor(Player player){
        size = discardedCards.size();
        player.addCard(discardedCards.get(size-1));
        discardedCards.remove(size-1);
    }
    protected void printDiscardPile(){
        for (Card card: discardedCards){
            System.out.print(card +" - ");
        }
        System.out.println();
    }

}
