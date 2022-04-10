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
        primaryStage.setMinWidth(200);
        primaryStage.setMinHeight(220);

        primaryStage.setScene(new Scene(homeView));
        homePresenter.addWindowEventHandlers();
        primaryStage.show();
    }

}
