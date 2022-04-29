package view.play;


import javafx.scene.control.Alert;
import model.*;
import view.home.HomePresenter;
import view.home.HomeView;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
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

		final ImageView upturnCard = VIEW.getDiscardPileTopCard();
		upturnCard.setOnMouseEntered(mouseEvent -> upturnCardAnimation(upturnCard, true));
		upturnCard.setOnMouseExited(mouseEvent -> upturnCardAnimation(upturnCard, false));
		upturnCard.setOnMouseClicked(mouseEvent -> moveUpturnCardToHand(upturnCard));

		for (Node card : VIEW.getHumanCards().getChildren()) {
			final ImageView imageView = (ImageView) card;
			imageView.setOnMouseEntered(mouseEvent -> humanHandCardAnimation(imageView, true));
			imageView.setOnMouseExited(mouseEvent -> humanHandCardAnimation(imageView, false));
			imageView.setOnMouseClicked(mouseEvent -> moveCardToDiscardPile(imageView));
		}

		final ImageView stackCard = VIEW.getStackPileTopCard();
		stackCard.setOnMouseEntered(mouseEvent -> stackCardAnimation(stackCard, true));
		stackCard.setOnMouseExited(mouseEvent -> stackCardAnimation(stackCard, false));
		stackCard.setOnMouseClicked(mouseEvent -> moveStackCardToHand(stackCard));

		VIEW.getPassFirstCardButton().setOnAction(actionEvent -> setTurnState(TurnState.FIRST_TURN));
		VIEW.getKnockButton().setOnAction(actionEvent -> {
			MODEL.distributePoints();
			if (MODEL.isEndOfGame()) {
				setHomeMenu(); // TODO: needs to be replaced by ending screen
			} else {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Gin Rummy");
				alert.setHeaderText("Round ended!");
				if (MODEL.getPlayerWhoWon() == MODEL.getHUMAN_PLAYER()) {
					alert.setContentText(String.format("""
							Congratulations!
							You won this round.
							%s""", (MODEL.getHUMAN_PLAYER().getHAND().calculateDeadwood() == 0)? "You even called gin!": ""));
				} else if (MODEL.getPlayerWhoWon() == MODEL.getCOMPUTER_PLAYER()) {
					alert.setContentText("""
							Sadly, you lost this round!""");
				} else {
					alert.setContentText("""
							It's a draw!
							No one gets points.""");
				}
				alert.setResizable(true);
				alert.showAndWait();

				MODEL.startNewRound();
			}
			updateView();
		});
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
		VIEW.getKnockButton().setDisable(!MODEL.getHUMAN_PLAYER().canKnock());
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
			VIEW.setPlayerTurnColour(true);
			computerMoves();
		} else {
			VIEW.setPlayerTurnColour(false);
		}

		updateView();
	}

	private void computerMoves() {
		if (turnState == TurnState.FIRST_TURN) {
			boolean passUpturnCard = RANDOM.nextBoolean();
			if (passUpturnCard) {
				setTurnState(TurnState.FIRST_TURN);
			} else {
				cardPlayToHand(false);
			}
		} else if (turnState == TurnState.HAND_TO_DISCARD_PILE_OR_KNOCK) {
			int numberOfCard = RANDOM.nextInt(MAX_NUMBER_OF_CARDS);
			cardPlayToDiscardPile(numberOfCard);
		} else if (turnState == TurnState.TAKE_FROM_PILE) {
			boolean takeFromStack = RANDOM.nextBoolean();
			if (takeFromStack) {
				cardPlayToHand(true);
			} else {
				cardPlayToHand(false);
			}
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

	private void cardPlayToDiscardPile(int numberOfCard) {
		final ImageView card = VIEW.getComputerCard(numberOfCard);

		final Bounds cardBounds = card.localToScene(card.getBoundsInLocal());
		final double cardMinX = cardBounds.getMinX();
		final double cardMinY = cardBounds.getMinY();
		final Bounds discardPileBounds = VIEW.getDiscardPileTopCard().localToScene(VIEW.getDiscardPileTopCard().getBoundsInLocal());
		final double discardPileMinX = discardPileBounds.getMinX();
		final double discardPileMinY = discardPileBounds.getMinY();

		card.setImage(new Image(toResourceName(MODEL.getCOMPUTER_PLAYER().getHAND().getCardAt(numberOfCard))));

		final TranslateTransition tt = new TranslateTransition(Duration.millis(1000), card);
		tt.setToX(discardPileMinX - cardMinX);
		tt.setToY(discardPileMinY - cardMinY);
		tt.setCycleCount(1);
		tt.setAutoReverse(false);
		tt.play();
		tt.setOnFinished(actionEvent -> {
			card.setImage(VIEW.getBACKSIDE_CARD());
			card.setTranslateX(0);
			card.setTranslateY(0);

			MODEL.getDISCARD_PILE().addCard(MODEL.getCOMPUTER_PLAYER().discardCard(numberOfCard));
			setTurnState(TurnState.TAKE_FROM_PILE);
		});
	}

	private void cardPlayToHand(boolean takeFromStackPile) {
		final ImageView card = takeFromStackPile ? VIEW.getStackPileTopCard() : VIEW.getDiscardPileTopCard();

		final Bounds sourceBounds = card.localToScene(card.getBoundsInLocal());
		final double sourceMinX = sourceBounds.getMinX();
		final double sourceMinY = sourceBounds.getMinY();
		final Bounds eleventhCardBounds = VIEW.getComputerCard(MAX_NUMBER_OF_CARDS - 1).localToScene(VIEW.getComputerCard(MAX_NUMBER_OF_CARDS - 1).getBoundsInLocal());
		final double eleventhCardMinX = eleventhCardBounds.getMinX();
		final double eleventhCardMinY = eleventhCardBounds.getMinY();

		if (!takeFromStackPile) {
			card.setImage(VIEW.getBACKSIDE_CARD());
		}

		final TranslateTransition tt = new TranslateTransition(Duration.millis(1000), card);
		tt.setToX(eleventhCardMinX - sourceMinX);
		tt.setToY(eleventhCardMinY - sourceMinY);
		tt.setCycleCount(1);
		tt.setAutoReverse(false);
		tt.play();
		tt.setOnFinished(actionEvent -> {
			card.setTranslateX(0);
			card.setTranslateY(0);

			if (takeFromStackPile) {
				MODEL.getCOMPUTER_PLAYER().getHAND().addCard(MODEL.getDECK().getNextCard());
			} else {
				MODEL.getCOMPUTER_PLAYER().getHAND().addCard(MODEL.getDISCARD_PILE().getNextCard());
			}
			setTurnState(TurnState.HAND_TO_DISCARD_PILE_OR_KNOCK);
		});
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

		final Hand modelComputerHand = MODEL.getCOMPUTER_PLAYER().getHAND();
		for (int i = 0; i < MAX_NUMBER_OF_CARDS; i++) {
			VIEW.getComputerCard(i).setVisible(modelComputerHand.getPlayerCards().size() != MAX_NUMBER_OF_CARDS - 1 || i != MAX_NUMBER_OF_CARDS - 1);
		}

		if (!MODEL.getDISCARD_PILE().getDiscardedCards().isEmpty()) {
			VIEW.setDiscardPileTopCardImage(toResourceName(MODEL.getDISCARD_PILE().getCardAt(0)));
		} else {
			MODEL.getDISCARD_PILE().addCard(MODEL.getDECK().getCardAt(0));
		}

		if (MODEL.getDISCARD_PILE().getDiscardedCards().size() <= 1) {
			VIEW.getDiscardPileBeneath().setVisible(false);
		} else {
			VIEW.setDiscardPileBeneathImage(toResourceName(MODEL.getDISCARD_PILE().getCardAt(1)));
			VIEW.getDiscardPileBeneath().setVisible(true);
		}
	}

	//methods for event handlers
	private void displayRulesScreen() {
		ViewRules.viewRules(VIEW.getScene());
	}

	private void setHomeMenu() {
		HomeView homeView = new HomeView();
		HomePresenter homePresenter = new HomePresenter(MODEL, homeView);
		VIEW.getScene().setRoot(homeView);
		Stage stage = (Stage) homeView.getScene().getWindow();
		stage.setMinWidth(HomeView.MIN_HOME_WIDTH);
		stage.setWidth(HomeView.MIN_HOME_WIDTH);
		stage.setMinHeight(HomeView.MIN_HOME_HEIGHT);
		stage.setHeight(HomeView.MIN_HOME_HEIGHT);
		stage.centerOnScreen();
	}

	private String toResourceName(Card card) {
		final String rankName = card.getRank().toString();
		final String suitName = card.getSuit().toString();
		return String.format("cards/%s%s.png", rankName.substring(0, 1).toUpperCase(Locale.ROOT) + rankName.substring(1), suitName.substring(0, 1).toUpperCase(Locale.ROOT) + suitName.substring(1));
	}

}