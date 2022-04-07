package be.kdg.ginrummy.view.name;

import be.kdg.ginrummy.model.Game;

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
	}

	private void updateView() {
	}

}
