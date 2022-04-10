package be.kdg.ginrummy.view.name;

import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.model.Player;
import be.kdg.ginrummy.model.ViewRules;
import be.kdg.ginrummy.view.home.HomePresenter;
import be.kdg.ginrummy.view.home.HomeView;
import be.kdg.ginrummy.view.play.GamePresenter;
import be.kdg.ginrummy.view.play.GameView;




public class NamePresenter {
    private final NameView view;
    private  Game gameModel;
    private Player model;
    private GameView gameView;



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
        ViewRules.viewRules(view.getScene());
    }
    private void updateView() {}
    private void savePlayerName(){}
}
