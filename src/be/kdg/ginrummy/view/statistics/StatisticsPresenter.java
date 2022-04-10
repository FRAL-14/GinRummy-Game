package be.kdg.ginrummy.view.statistics;

import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.model.GameStatistics;
import be.kdg.ginrummy.model.ViewRules;
import be.kdg.ginrummy.view.home.HomePresenter;
import be.kdg.ginrummy.view.home.HomeView;

public class StatisticsPresenter {
    //private attributes

    private GameStatistics model;
    private StatisticsView view;
    private Game modelGame;

    public StatisticsPresenter(GameStatistics model, StatisticsView view) {
        this.model = model;
        this.view=view;
        addEventHandlers();
        updateView();

    }
    private void addEventHandlers(){
        view.getHomeMenuItem().setOnAction(e->{
            returnToHomeScreen();
        });
        view.getRulesMenuItem().setOnAction(e->{
            displayRulesScreen();
        });
    }
    private void updateView(){}
    private void addWindowEventHandlers(){}

    //methods for event handlers
    private void returnToHomeScreen(){
        HomeView homeView = new HomeView();
        HomePresenter homePresenter = new HomePresenter(modelGame, homeView);
        view.getScene().setRoot(homeView);
    }
    private void displayRulesScreen(){
        ViewRules.viewRules(view.getScene());
    }

}
