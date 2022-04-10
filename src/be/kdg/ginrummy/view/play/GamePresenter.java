package be.kdg.ginrummy.view.play;

import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.model.ViewRules;


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
        view.getRulesMenuItem().setOnAction(e->{
            displayRulesScreen();
        });
    }
    private void updateView(){
        // fills the view with model data
    }
    //methods for event handlers
    public void displayRulesScreen() {
        ViewRules.viewRules(view.getScene());
    }

}