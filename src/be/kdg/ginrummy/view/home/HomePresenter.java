package be.kdg.ginrummy.view.home;

import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.view.help.HelpPresenter;
import be.kdg.ginrummy.view.help.HelpView;
import be.kdg.ginrummy.view.name.NamePresenter;
import be.kdg.ginrummy.view.name.NameView;
import javafx.stage.Stage;

public class HomePresenter {

	private final Game MODEL;
	private final HomeView VIEW;


	public HomePresenter(Game model, HomeView view) {
		this.MODEL = model;
		this.VIEW = view;

		addEventHandlers();
		updateView();
	}


	private void addEventHandlers() {
		// add event handlers to view controls (lambdas)
		// in the event handlers: call model methods and updateView()
		VIEW.getPlayButton().setOnAction(event -> nameInput());
		VIEW.getHelpButton().setOnAction(event -> setHelpView());
	}

	private void updateView() {
		// fills the view with model data
	}

	private void nameInput() {
		final NameView nameView = new NameView();
		final NamePresenter namePresenter = new NamePresenter(nameView, MODEL);
		VIEW.getScene().setRoot(nameView);
		nameView.getScene().getWindow().sizeToScene();
	}

	private void setHelpView() {
		final HelpView helpView = new HelpView();
		final HelpPresenter helpPresenter = new HelpPresenter(MODEL, helpView);
		VIEW.getScene().setRoot(helpView);
		Stage stage = (Stage) helpView.getScene().getWindow();
		stage.setMinWidth(500);
		stage.setMinHeight(400);
		stage.setWidth(HelpView.HELP_WIDTH);
		stage.setHeight(HelpView.HELP_HEIGHT);
	}

}
