package model;


import java.sql.Timestamp;
import java.time.Instant;



public class Game {

	private static final int POINT_THRESHOLD = 100;

	private final Player HUMAN_PLAYER;
	private final Player COMPUTER_PLAYER;
	private final DiscardPile DISCARD_PILE = new DiscardPile();
	private final Deck DECK = new Deck();
	private int turnNumber;
	private long startingTime;

	//for a single game
	private Timestamp gameStartTime;
	private Timestamp gameEndTime;
	private int gameDurationInMs; //In milliseconds

	//for human turns only
	private int humanTurn=0;
	private int turnDurationInMs; //In milliseconds
	private Timestamp humanTurnStarts =Timestamp.from(Instant.now());
	private Timestamp humanTurnEnds;




	public Game() {
		this.turnNumber = 0;
		setStartingTimeToNow();

		this.HUMAN_PLAYER = new Player(true);
		this.COMPUTER_PLAYER = new Player("Computer", false);

		DB_Connection.connectToDB();
		GameStatistics.createTables();
		dealCards();
	}




	public void dealCards() {
		HUMAN_PLAYER.getHAND().deal(DECK);
		COMPUTER_PLAYER.getHAND().deal(DECK);
		DISCARD_PILE.addCard(DECK.getNextCard());
	}


	public void switchTurn() {
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
		System.out.println(HUMAN_PLAYER.getNAME()+" has "+HUMAN_PLAYER.getScore()+" points ");
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
		DISCARD_PILE.clear();
		DECK.resetDeck();
		dealCards();
	}

	public int calculateTurnDuration() {
		this.turnDurationInMs = (int) (humanTurnEnds.getTime()-humanTurnStarts.getTime());
		return turnDurationInMs;
	}

	public Timestamp getGameStartTime() { return gameStartTime; }
	public void setGameStartTime() { //checked
		this.gameStartTime = Timestamp.from(Instant.now());
		System.out.println("Game started at: "+ gameStartTime); //for checking
	}

	public Timestamp getGameEndTime() { return gameEndTime;}
	public void setGameEndTime() { this.gameEndTime = Timestamp.from(Instant.now());}

	public int getGameDurationInMs() {
		return (int) (gameEndTime.getTime() - gameStartTime.getTime());
	}

	public Timestamp getHumanTurnStarts() {
		return humanTurnStarts;
	}

	public int getTurnDurationInMs() {
		return turnDurationInMs;
	}

	public Timestamp getHumanTurnEnds() {
		return humanTurnEnds;
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


	//for timer on the game screen.
	public long getStartingTime() {return startingTime;}
	public void setStartingTimeToNow() { this.startingTime = System.currentTimeMillis();}

	public Player getHUMAN_PLAYER() {
		return HUMAN_PLAYER;
	}
	public Player getCOMPUTER_PLAYER() {
		return COMPUTER_PLAYER;
	}

	public boolean humanIsPlaying() {
		return HUMAN_PLAYER.getIsPlayerTurn();
	}


	public void setHumanTurnEnds() {
		this.humanTurnEnds = Timestamp.from(Instant.now());
	}
	public void setHumanTurnStarts() {
		this.humanTurnStarts = Timestamp.from(Instant.now());
	}
	public void incrementHumanTurn(){
		if (humanIsPlaying()){
			humanTurn+=1;
		}

	}



}
