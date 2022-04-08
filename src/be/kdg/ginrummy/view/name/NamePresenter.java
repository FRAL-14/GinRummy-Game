package be.kdg.ginrummy.view.name;

import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.model.Player;
import be.kdg.ginrummy.view.play.GamePresenter;
import be.kdg.ginrummy.view.play.GameView;

public class NamePresenter {
    private final NameView view;
    private final Game model;

	public NamePresenter(NameView view, Game game) {
		this.view = view;
		this.model = game;

		addEventHandlers();
		updateView();
	}


	private void addEventHandlers() {
		view.getTextField().setOnAction(event -> {
			model.getHUMAN_PLAYER().setNAME(view.getTextField().getText());
		});
        view.getStartGameButton().setOnAction(e->{
            startGame();
        });
	}

	private void updateView() {
	}

    private void startGame(){
        final GameView gameView = new GameView();
        GamePresenter gamePresenter = new GamePresenter(model, gameView);
        view.getScene().setRoot(gameView);
}
