package model;

import view.UI;

public class Game {

	private static final int POINT_THRESHOLD = 100;

	private final Player HUMAN_PLAYER; // Can be final, as only 1 human player is needed for a game and doesn't change
	private final Player COMPUTER_PLAYER; // Can be final, as only 1 CPU player is needed for a game and doesn't change
	private final DiscardPile DISCARD_PILE = new DiscardPile(); // Can be final, as only 1 is needed and doesn't change, its cards can be changed
	private final Deck DECK = new Deck(); // Can be final, as only 1 deck is needed for a game and doesn't change
	private int turnNumber;
	private long startingTime;


	public Game() {
		this.turnNumber = 0;
		setStartingTimeToNow();

		// Making the players
		this.HUMAN_PLAYER = new Player(0, true);
		this.COMPUTER_PLAYER = new Player("Computer", 0, false);

		dealCards();
	}


	public void dealCards() {
		HUMAN_PLAYER.getHAND().deal(DECK);
		COMPUTER_PLAYER.getHAND().deal(DECK);
		DISCARD_PILE.addCard(DECK.getNextCard());
	}

	public int getTurnNumber() {
		return turnNumber;
	}

	public void incrementTurnNumber() {
		turnNumber++;
	}

	public DiscardPile getDISCARD_PILE() {
		return DISCARD_PILE;
	}

	public Deck getDECK() {
		return DECK;
	}


	public long getStartingTime() {
		return startingTime;
	}

	public void setStartingTimeToNow() {
		this.startingTime = System.currentTimeMillis();
	}

	public Player getHUMAN_PLAYER() {
		return HUMAN_PLAYER;
	}

	public Player getCOMPUTER_PLAYER() {
		return COMPUTER_PLAYER;
	}

	public boolean humanIsPlaying() {
		return HUMAN_PLAYER.getIsPlayerTurn();
	}

	/**
	 * Sorts the player's hand and checks if a user can knock.
	 * Should be run after every move.
	 */
	public void regularGameChecks() {
		getHUMAN_PLAYER().getHAND().sortPlayerCards();

		if (getHUMAN_PLAYER().canKnock()) {
			if (UI.askUserIfKnock()) {
				DISCARD_PILE.addCard(getHUMAN_PLAYER().getHAND().removeLastCard());
				distributePoints();
			}
		}
	}

	public void switchTurn() {
		// TODO: create new Session?

		if (getHUMAN_PLAYER().getIsPlayerTurn()) {
			getHUMAN_PLAYER().setIsPlayerTurn(false);
			getCOMPUTER_PLAYER().setIsPlayerTurn(true);
		} else {
			getHUMAN_PLAYER().setIsPlayerTurn(true);
			getCOMPUTER_PLAYER().setIsPlayerTurn(false);
		}
	}

	public boolean isEndOfGame() {
		return HUMAN_PLAYER.getScore() >= POINT_THRESHOLD || COMPUTER_PLAYER.getScore() >= POINT_THRESHOLD;
	}

	public void distributePoints() {
		final int humanDeadwood = getHUMAN_PLAYER().getHAND().calculateDeadwood();
		final int computerDeadwood = getCOMPUTER_PLAYER().getHAND().calculateDeadwood();
		int newPoints = 0;

		if (computerDeadwood == 0 || humanDeadwood == 0) { // going gin
			newPoints += 25;
		}
		if (getPlayerWhoWon() == getCOMPUTER_PLAYER()) {
			newPoints += humanDeadwood - computerDeadwood;
			getCOMPUTER_PLAYER().addToScore(newPoints);
		} else if (getPlayerWhoWon() == getHUMAN_PLAYER()) {
			newPoints += computerDeadwood - humanDeadwood;
			getHUMAN_PLAYER().addToScore(newPoints);
		}
	}

	public Player getPlayerWhoWon() {
		final int humanDeadwood = getHUMAN_PLAYER().getHAND().calculateDeadwood();
		final int computerDeadwood = getCOMPUTER_PLAYER().getHAND().calculateDeadwood();

		if (humanDeadwood > computerDeadwood) {
			return getCOMPUTER_PLAYER();
		} else if (humanDeadwood < computerDeadwood) {
			return getHUMAN_PLAYER();
		} else {
			return null;
		}
	}

	public void startNewRound() {
		this.turnNumber = 0;
		setStartingTimeToNow();

		DISCARD_PILE.clear();
		DECK.resetDeck();
		dealCards();
	}

}
