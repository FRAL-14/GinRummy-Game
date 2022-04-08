package be.kdg.ginrummy.view.play;

import be.kdg.ginrummy.model.Game;


public class GamePresenter {
    private Game model;
    private GameView view;

    public GamePresenter(Game model, GameView view) {
        this.model = model;
        this.view=view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers(){

    }
    private void updateView(){
        // fills the view with model data

    }
}