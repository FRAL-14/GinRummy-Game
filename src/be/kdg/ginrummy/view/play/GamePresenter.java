package be.kdg.ginrummy.view.play;

import be.kdg.ginrummy.model.Card;
import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.model.Hand;
import be.kdg.ginrummy.model.ViewRules;

import java.util.Locale;

public class GamePresenter {

	private final int MAX_NUMBER_OF_CARDS = 11;
	private final Game MODEL;
	private final GameView VIEW;


	public GamePresenter(Game model, GameView view) {
		this.MODEL = model;
		this.VIEW = view;
		addEventHandlers();
		updateView();
	}


	private void addEventHandlers() {
		VIEW.getRulesMenuItem().setOnAction(e -> displayRulesScreen());
	}

	private void updateView() {
		Hand modelHumanHand = MODEL.getHUMAN_PLAYER().getHAND();
		for (int i = 0; i < MAX_NUMBER_OF_CARDS; i++) {
			if (modelHumanHand.getPlayerCards().size() == MAX_NUMBER_OF_CARDS - 1 && i == MAX_NUMBER_OF_CARDS - 1) {
				VIEW.getHumanCard(i).setVisible(false);
			} else {
				VIEW.setHandImage(i, toResourceName(modelHumanHand.getCardAt(i)));
			}
		}
//		VIEW.setDiscardPileImage(toResourceName(MODEL.getDISCARD_PILE().getNextCard()));
	}

	//methods for event handlers
	private void displayRulesScreen() {
		ViewRules.viewRules(VIEW.getScene());
	}

	private String toResourceName(Card card) {
		String rankName = card.getRank().toString();
		String suitName = card.getSuit().toString();
		return String.format("cards/%s%s.png", rankName.substring(0, 1).toUpperCase(Locale.ROOT) + rankName.substring(1), suitName.substring(0, 1).toUpperCase(Locale.ROOT) + suitName.substring(1));
	}

}