package be.kdg.ginrummy.view.name;

import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.model.Player;
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
    }
    private void addEventHandlers() {
        view.getStartGameButton().setOnAction(e->{
            startGame();
        });
    }
    private void startGame(){
        gameView = new GameView();
        GamePresenter gamePresenter = new GamePresenter(gameModel, gameView);
        view.getScene().setRoot(gameView);
    }
    private void updateView() {}
    private void savePlayerName(){ }
}
