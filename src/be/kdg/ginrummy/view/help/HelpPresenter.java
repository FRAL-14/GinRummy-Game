package be.kdg.ginrummy.view.help;

import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.view.home.HomePresenter;
import be.kdg.ginrummy.view.home.HomeView;
import javafx.stage.Stage;

public class HelpPresenter {

	private final Game MODEL;
	private final HelpView VIEW;


	public HelpPresenter(Game model, HelpView view) {
		this.MODEL = model;
		this.VIEW = view;

		addEventHandlers();
		updateView();
	}


	private void addEventHandlers() {
		// add event handlers to view controls (lambdas)
		// in the event handlers: call model methods and updateView()
		VIEW.getCloseButton().setOnAction(event -> setHomeView());
	}

	private void updateView() {
		// fills the view with model data
	}

	private void setHomeView() {
		final HomeView homeView = new HomeView();
		final HomePresenter homePresenter = new HomePresenter(MODEL, homeView);
		VIEW.getScene().setRoot(homeView);
		Stage stage = (Stage) homeView.getScene().getWindow();
		stage.setMinWidth(HomeView.HOME_WIDTH);
		stage.setMinHeight(HomeView.HOME_HEIGHT);
		homeView.getScene().getWindow().sizeToScene();
	}

}
