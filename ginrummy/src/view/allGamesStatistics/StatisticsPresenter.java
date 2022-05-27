package view.allGamesStatistics;

import model.Game;
import view.home.HomePresenter;
import view.home.HomeView;

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
