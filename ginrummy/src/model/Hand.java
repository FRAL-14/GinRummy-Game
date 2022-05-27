package model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Hand extends Deck {

	private List<Card> updatedCardList;
	private LinkedList<Card> playerCards;
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
		//Set: 3 or more cards of the same rank

		for (Card playerCard : playerCards) {
			playerCard.setInMeld(false);
		}
		sortPlayerCards();

		//Run
		for (Card card : playerCards) {
            /*if (Collections.frequency(playerCards, card.getValue()) > 3) {
                card.setInMeld(true);
            }*/
			int count = 0;
			for (Card cardToCompare : playerCards) {
				if (card.getRank() == cardToCompare.getRank()) {
					count++;
				}
			}
			if (count >= 3) {
				card.setInMeld(true);
			}
		}

		//Set
		for (Card card : playerCards) {
            /*if (Collections.frequency(playerCards, card.getSuit()) > 3) {
                card.setInMeld(true);
            }*/
			List<Card> cardsToBeInMeld = new ArrayList<>();
			Card previousCard = null;
			for (Card cardToCompare : playerCards) {
				if (card.getSuit() == cardToCompare.getSuit()) {
					if (previousCard == null || previousCard.getRank().ordinal() + 1 == cardToCompare.getRank().ordinal()) {
						cardsToBeInMeld.add(cardToCompare);
						if (cardsToBeInMeld.size() >= 3) {
							for (Card cardToBeInMeld : cardsToBeInMeld) {
								cardToBeInMeld.setInMeld(true);
							}
						}
						previousCard = cardToCompare;
					} else {
						cardsToBeInMeld = new ArrayList<>();
						previousCard = cardToCompare;
						cardsToBeInMeld.add(cardToCompare);
					}
				}
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


	public void removeCard(int i) {
		playerCards.remove(i);
	}

	public Card removeLastCard() {
		return playerCards.removeLast();
	}

	public void addCard(Card card) {
		playerCards.add(card);
	}

	public Card getCardAt(int i) {
		return playerCards.get(i);
	}

	public List<Card> getPlayerCards() {
		return playerCards;
	}

	public void sortPlayerCards() {
		Collections.sort(playerCards);
	}

}
