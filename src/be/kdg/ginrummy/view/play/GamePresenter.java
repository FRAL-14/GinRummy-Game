package be.kdg.ginrummy.view.play;

import be.kdg.ginrummy.model.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

public class GamePresenter {

	private final int MAX_NUMBER_OF_CARDS = 11;
	private final Game MODEL;
	private final GameView VIEW;
	private TurnState turnState;
	private final Random RANDOM = new Random();


	public GamePresenter(Game model, GameView view) {
		this.MODEL = model;
		this.VIEW = view;

		setTurnState(TurnState.FIRST_TURN);

		MODEL.setStartingTimeToNow();

		addEventHandlers();
		updateView();
	}


	private void addEventHandlers() {
		VIEW.getRulesMenuItem().setOnAction(e -> displayRulesScreen());

		final ImageView upturnCard = VIEW.getDiscardPile();
		upturnCard.setOnMouseEntered(mouseEvent -> upturnCardAnimation(upturnCard, true));
		upturnCard.setOnMouseExited(mouseEvent -> upturnCardAnimation(upturnCard, false));
		upturnCard.setOnMouseClicked(mouseEvent -> moveUpturnCardToHand(upturnCard));

		for (Node card : VIEW.getHumanCards().getChildren()) {
			final ImageView imageView = (ImageView) card;
			imageView.setOnMouseEntered(mouseEvent -> humanHandCardAnimation(imageView, true));
			imageView.setOnMouseExited(mouseEvent -> humanHandCardAnimation(imageView, false));
			imageView.setOnMouseClicked(mouseEvent -> moveCardToDiscardPile(imageView));
		}

		final ImageView stackCard = VIEW.getStackPile();
		stackCard.setOnMouseEntered(mouseEvent -> stackCardAnimation(stackCard, true));
		stackCard.setOnMouseExited(mouseEvent -> stackCardAnimation(stackCard, false));
		stackCard.setOnMouseClicked(mouseEvent -> moveStackCardToHand(stackCard));

		VIEW.getPassFirstCardButton().setOnAction(actionEvent -> setTurnState(TurnState.FIRST_TURN));
	}

	private void updateView() {
		// card images
		MODEL.getHUMAN_PLAYER().getHAND().sortPlayerCards();
		updateCardImages();

		// scores and deadwood
		VIEW.getComputerPoints().setText(String.valueOf(MODEL.getCOMPUTER_PLAYER().getScore()));
		VIEW.getHumanPoints().setText(String.valueOf(MODEL.getHUMAN_PLAYER().getScore()));
		VIEW.getDeadwoodCount().setText(String.valueOf(MODEL.getHUMAN_PLAYER().getHAND().calculateDeadwood()));

		// elapsed time
		startTimer();

		// buttons
		VIEW.getPassFirstCardButton().setVisible(turnState == TurnState.FIRST_TURN && MODEL.humanIsPlaying());
	}

	private void setTurnState(TurnState turnState) {
		this.turnState = turnState;

		if (this.turnState == TurnState.FIRST_TURN || this.turnState == TurnState.TAKE_FROM_PILE) {
			MODEL.incrementTurnNumber();
			if (MODEL.getTurnNumber() > 1) {
				MODEL.switchTurn();
			}
			if (MODEL.getTurnNumber() > 2 && this.turnState == TurnState.FIRST_TURN) {
				this.turnState = TurnState.TAKE_FROM_PILE;
			}
		}

		if (!MODEL.humanIsPlaying()) {
			VIEW.setBoxBorders(true);
			computerMoves();
		} else {
			VIEW.setBoxBorders(false);
		}

		updateView();
	}

	private void computerMoves() {
		if (turnState == TurnState.FIRST_TURN) {
			boolean passUpturnCard = RANDOM.nextBoolean();
			if (passUpturnCard) {
				System.out.println("passed upturn card");
				setTurnState(TurnState.FIRST_TURN);
			} else {
				MODEL.getCOMPUTER_PLAYER().getHAND().addCard(MODEL.getDISCARD_PILE().getNextCard());
				System.out.println("took upturn card");
				setTurnState(TurnState.HAND_TO_DISCARD_PILE_OR_KNOCK);
			}
		} else if (turnState == TurnState.HAND_TO_DISCARD_PILE_OR_KNOCK) {
			int numberOfCard = RANDOM.nextInt(MAX_NUMBER_OF_CARDS);
			MODEL.getDISCARD_PILE().addCard(MODEL.getCOMPUTER_PLAYER().discardCard(numberOfCard));
			System.out.println("discarded " + numberOfCard + " from hand to discard pile");
			setTurnState(TurnState.TAKE_FROM_PILE);
		} else if (turnState == TurnState.TAKE_FROM_PILE) {
			boolean takeFromStack = RANDOM.nextBoolean();
			if (takeFromStack) {
				MODEL.getCOMPUTER_PLAYER().getHAND().addCard(MODEL.getDECK().getNextCard());
				System.out.println("took from deck");
			} else {
				MODEL.getCOMPUTER_PLAYER().getHAND().addCard(MODEL.getDISCARD_PILE().getNextCard());
				System.out.println("took from discard pile");
			}
			setTurnState(TurnState.HAND_TO_DISCARD_PILE_OR_KNOCK);
		}
	}

	private void moveUpturnCardToHand(ImageView cardView) {
		if ((turnState == TurnState.FIRST_TURN || turnState == TurnState.TAKE_FROM_PILE) && MODEL.humanIsPlaying()) {
			MODEL.getHUMAN_PLAYER().getHAND().addCard(MODEL.getDISCARD_PILE().getNextCard());
			upturnCardAnimation(cardView, false);
			setTurnState(TurnState.HAND_TO_DISCARD_PILE_OR_KNOCK);
		}
	}

	private void moveCardToDiscardPile(ImageView cardView) {
		if (turnState == TurnState.HAND_TO_DISCARD_PILE_OR_KNOCK && MODEL.humanIsPlaying()) {
			int cardIndex = Integer.parseInt(cardView.getId());
			MODEL.getDISCARD_PILE().addCard(MODEL.getHUMAN_PLAYER().discardCard(cardIndex));
			humanHandCardAnimation(cardView, false);
			setTurnState(TurnState.TAKE_FROM_PILE);
		}
	}

	private void moveStackCardToHand(ImageView cardView) {
		if (turnState == TurnState.TAKE_FROM_PILE && MODEL.humanIsPlaying()) {
			MODEL.getHUMAN_PLAYER().getHAND().addCard(MODEL.getDECK().getNextCard());
			stackCardAnimation(cardView, false);
			setTurnState(TurnState.HAND_TO_DISCARD_PILE_OR_KNOCK);
		}
	}

	private void upturnCardAnimation(ImageView card, boolean goUp) {
		if ((turnState == TurnState.FIRST_TURN || turnState == TurnState.TAKE_FROM_PILE) && MODEL.humanIsPlaying()) {
			cardHoverAnimation(card, goUp);
		}
	}

	private void humanHandCardAnimation(ImageView card, boolean goUp) {
		if (turnState == TurnState.HAND_TO_DISCARD_PILE_OR_KNOCK && MODEL.humanIsPlaying()) {
			cardHoverAnimation(card, goUp);
		}
	}

	private void stackCardAnimation(ImageView card, boolean goUp) {
		if (turnState == TurnState.TAKE_FROM_PILE && MODEL.humanIsPlaying()) {
			cardHoverAnimation(card, goUp);
		}
	}

	private void cardHoverAnimation(ImageView card, boolean goUp) {
		final TranslateTransition tt = new TranslateTransition(Duration.millis(200), card);
		tt.setToY(goUp ? -20 : 0);
		tt.setCycleCount(1);
		tt.setAutoReverse(false);
		tt.play();
		updateView();
	}

	private void startTimer() {
		final DateFormat timeFormat = new SimpleDateFormat("mm:ss");
		final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
			final long elapsedTime = System.currentTimeMillis() - MODEL.getStartingTime();
			VIEW.getTimeElapsed().setText(timeFormat.format(elapsedTime));
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

	private void updateCardImages() {
		final Hand modelHumanHand = MODEL.getHUMAN_PLAYER().getHAND();
		for (int i = 0; i < MAX_NUMBER_OF_CARDS; i++) {
			if (modelHumanHand.getPlayerCards().size() == MAX_NUMBER_OF_CARDS - 1 && i == MAX_NUMBER_OF_CARDS - 1) {
				VIEW.getHumanCard(i).setVisible(false);
			} else {
				VIEW.setHandImage(i, toResourceName(modelHumanHand.getCardAt(i)));
				VIEW.getHumanCard(i).setVisible(true);
			}
		}
		if (!MODEL.getDISCARD_PILE().getDiscardedCards().isEmpty()) {
			VIEW.setDiscardPileImage(toResourceName(MODEL.getDISCARD_PILE().getCardAt(0)));
		} else {
			MODEL.getDISCARD_PILE().addCard(MODEL.getDECK().getCardAt(0));
		}
	}

	//methods for event handlers
	private void displayRulesScreen() {
		ViewRules.viewRules(VIEW.getScene());
	}

	private String toResourceName(Card card) {
		final String rankName = card.getRank().toString();
		final String suitName = card.getSuit().toString();
		return String.format("cards/%s%s.png", rankName.substring(0, 1).toUpperCase(Locale.ROOT) + rankName.substring(1), suitName.substring(0, 1).toUpperCase(Locale.ROOT) + suitName.substring(1));
	}

}