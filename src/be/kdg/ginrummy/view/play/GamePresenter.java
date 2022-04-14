package be.kdg.ginrummy.view.play;

import be.kdg.ginrummy.model.Card;
import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.model.Hand;
import be.kdg.ginrummy.model.ViewRules;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class GamePresenter {

	private final int MAX_NUMBER_OF_CARDS = 11;
	private final Game MODEL;
	private final GameView VIEW;


	public GamePresenter(Game model, GameView view) {
		this.MODEL = model;
		this.VIEW = view;

		MODEL.setStartingTimeToNow();

		addEventHandlers();
		updateView();
	}


	private void addEventHandlers() {
		VIEW.getRulesMenuItem().setOnAction(e -> displayRulesScreen());
		for (Node card : VIEW.getHumanCards().getChildren()) {
			card.setOnMouseEntered(mouseEvent -> moveCard((Node) mouseEvent.getTarget(), true));
			card.setOnMouseExited(mouseEvent -> moveCard((Node) mouseEvent.getTarget(), false));
		}
	}

	private void updateView() {
		// card images
		updateCardImages();

		// scores and deadwood
		VIEW.getComputerPoints().setText(String.valueOf(MODEL.getCOMPUTER_PLAYER().getScore()));
		VIEW.getHumanPoints().setText(String.valueOf(MODEL.getHUMAN_PLAYER().getScore()));
		VIEW.getDeadwoodCount().setText(String.valueOf(MODEL.getHUMAN_PLAYER().getHAND().calculateDeadwood()));

		// elapsed time
		startTimer();
	}

	private void moveCard(Node card, boolean goUp) {
		final TranslateTransition tt = new TranslateTransition(Duration.millis(200), card);
		tt.setToY(goUp ? -20 : 0);
		tt.setCycleCount(1);
		tt.setAutoReverse(false);
		tt.play();
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
			}
		}
		VIEW.setDiscardPileImage(toResourceName(MODEL.getDISCARD_PILE().getNextCard()));
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