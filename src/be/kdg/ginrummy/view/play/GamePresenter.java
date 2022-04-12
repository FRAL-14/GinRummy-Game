package be.kdg.ginrummy.view.play;

import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.model.ViewRules;

public class GamePresenter {

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

	}

	//methods for event handlers
	public void displayRulesScreen() {
		ViewRules.viewRules(VIEW.getScene());
	}

}