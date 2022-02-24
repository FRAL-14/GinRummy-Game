package be.kdg.ginrummy;

import java.util.List;

public class Hand extends Deck{
    protected List<Card> updatedCardList;
    protected List<Card> playerCards;
    private int deadWoodCount=0;
    private List<Card> meld;
}
