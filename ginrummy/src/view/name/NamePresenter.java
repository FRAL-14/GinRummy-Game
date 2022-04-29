package view.name;

import javafx.scene.control.Alert;
import model.Game;
import model.ViewRules;
import view.home.HomePresenter;
import view.home.HomeView;
import view.play.GamePresenter;
import view.play.GameView;
import javafx.stage.Stage;


public class NamePresenter {

	private final NameView view;
	private Game model;
	private GameView gameView;


	public NamePresenter(Game model, NameView view) {
		this.model = model;
		this.view = view;
		addEventHandlers();
		updateView();
	}


	private void addEventHandlers() {
		view.getStartGameButton().setOnAction(e -> {
			if (!"".equalsIgnoreCase(view.getTextField().getText())) {
				savePlayerName();
				startGame();
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Gin Rummy");
				alert.setHeaderText("Empty name");
				alert.setContentText("You need to input a name!");
				alert.showAndWait();
			}
		});
		view.getHomeMenuItem().setOnAction(e -> {
			returnToHomeScreen();
		});
		view.getRulesMenuItem().setOnAction(e -> {
			displayRulesScreen();
		});
	}

	//methods for eventHandlers
	private void startGame() {
		gameView = new GameView();
		GamePresenter gamePresenter = new GamePresenter(model, gameView);
		view.getScene().setRoot(gameView);
		Stage stage = (Stage) gameView.getScene().getWindow();
		stage.setMinWidth(1010);
		stage.setMinHeight(620);
		stage.centerOnScreen();
	}

	private void returnToHomeScreen() {
		HomeView homeView = new HomeView();
		HomePresenter homePresenter = new HomePresenter(model, homeView);
		view.getScene().setRoot(homeView);
	}

	private void displayRulesScreen() {
		ViewRules.viewRules(view.getScene());
	}

	private void updateView() {
	}

	private void savePlayerName() {
		final String playerName = view.getTextField().getText();
		model.getHUMAN_PLAYER().setNAME(playerName);
	}

}
