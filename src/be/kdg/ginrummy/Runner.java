package be.kdg.ginrummy;

import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.view.home.HomePresenter;
import be.kdg.ginrummy.view.home.HomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Runner extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Game model = new Game("Leo");
		HomeView homeView = new HomeView();
		HomePresenter homePresenter = new HomePresenter(model, homeView);

		primaryStage.setTitle("Gin Rummy");
		primaryStage.setMinWidth(HomeView.HOME_WIDTH);
		primaryStage.setMinHeight(HomeView.HOME_HEIGHT);

		primaryStage.setScene(new Scene(homeView));
		primaryStage.show();
	}

}
