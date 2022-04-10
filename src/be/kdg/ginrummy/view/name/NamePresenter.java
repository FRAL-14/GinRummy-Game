package be.kdg.ginrummy.view.name;

import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.model.Player;
import be.kdg.ginrummy.model.RepeatedCode;
import be.kdg.ginrummy.view.home.HomePresenter;
import be.kdg.ginrummy.view.home.HomeView;
import be.kdg.ginrummy.view.play.GamePresenter;
import be.kdg.ginrummy.view.play.GameView;
import be.kdg.ginrummy.view.rules.RulesView;
import be.kdg.ginrummy.view.statistics.StatisticsPresenter;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class NamePresenter {
    private final NameView view;
    private  Game gameModel;
    private Player model;
    private GameView gameView;
    private RepeatedCode code;



    public NamePresenter(Player model, NameView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }
    private void addEventHandlers() {
        view.getStartGameButton().setOnAction(e->{
            startGame();
        });
        view.getHomeMenuItem().setOnAction(e->{
            returnToHomeScreen();
        });
        view.getRulesMenuItem().setOnAction(e->{
            displayRulesScreen();
        });
    }
    //methods for eventHandlers
    private void startGame(){
        gameView = new GameView();
        GamePresenter gamePresenter = new GamePresenter(gameModel, gameView);
        view.getScene().setRoot(gameView);
    }
    private void returnToHomeScreen(){
        HomeView homeView = new HomeView();
        HomePresenter homePresenter = new HomePresenter(gameModel, homeView);
        view.getScene().setRoot(homeView);
    }
    private void displayRulesScreen(){
        RulesView rulesView = new RulesView();
        Stage helpStage = new Stage();
        helpStage.initOwner(view.getScene().getWindow());
        helpStage.initModality(Modality.APPLICATION_MODAL);
        helpStage.setScene(new Scene(rulesView));
        helpStage.setX(view.getScene().getWindow().getX());
        helpStage.setY(view.getScene().getWindow().getY());
        helpStage.showAndWait();
    }
    private void updateView() {}
    private void savePlayerName(){}
}
