package be.kdg.ginrummy.view.statistics;

import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.model.GameStatistics;
import be.kdg.ginrummy.view.home.HomePresenter;
import be.kdg.ginrummy.view.home.HomeView;

public class StatisticsPresenter {
    //private attributes
    private StatisticsView view;
    private Game model;

    public StatisticsPresenter(Game model, StatisticsView view) {
        this.model = model;
        this.view=view;
        addEventHandlers();
        updateView();

    }
    private void addEventHandlers(){
        view.getHomeMenuItem().setOnAction(e->{
            returnToHomeScreen();
        });

    }
    private void updateView(){}
    private void addWindowEventHandlers(){}

    //methods for event handlers
    private void returnToHomeScreen(){
        HomeView homeView = new HomeView();
        HomePresenter homePresenter = new HomePresenter(model, homeView);
        view.getScene().setRoot(homeView);
    }


}
