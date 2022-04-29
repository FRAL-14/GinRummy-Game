package model;

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

	public void removeCard(int i) {
		discardedCards.remove(i);
	}

	public Card getNextCard() {
		final Card temp = getCardAt(0);
		removeCard(0);
		return temp;
	}

	public Card getCardAt(int i) {
		return discardedCards.get(i);
	}

	public List<Card> getDiscardedCards() {
		return discardedCards;
	}

	public void printDiscardPile() {
		for (Card card : discardedCards) {
			System.out.print(card + " - ");
		}
		System.out.println();
	}

}
