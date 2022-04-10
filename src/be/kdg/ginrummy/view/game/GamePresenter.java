package be.kdg.ginrummy.view.game;

import be.kdg.ginrummy.model.Game;
import javafx.stage.Window;

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
		// add event handlers to view controls (lambdas)
		// in the event handlers: call model methods and updateView()
	}

	private void updateView() {
		// fills the view with model data
	}

	public void addWindowEventHandlers() {
		Window window = VIEW.getScene().getWindow();
		// add event handlers to window
	}


}
