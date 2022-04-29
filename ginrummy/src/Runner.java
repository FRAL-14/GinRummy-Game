import model.Game;
import view.home.HomePresenter;
import view.home.HomeView;
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
		primaryStage.setMinWidth(HomeView.MIN_HOME_WIDTH);
		primaryStage.setMinHeight(HomeView.MIN_HOME_HEIGHT);

		primaryStage.setScene(new Scene(homeView));
		primaryStage.show();
	}

}
