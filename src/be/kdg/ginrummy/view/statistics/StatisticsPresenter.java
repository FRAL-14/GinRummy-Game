package be.kdg.ginrummy.view.statistics;

import be.kdg.ginrummy.model.Game;

public class StatisticsPresenter {
    //private attributes

    private Game model;
    private StatisticsView view;

    public StatisticsPresenter(Game model, StatisticsView view) {
        this.model = model;
        this.view=view;
        addEventHandlers();
        updateView();

    }
    private void addEventHandlers(){}
    private void updateView(){}
    private void addWindowEventHandlers(){}
}
