package be.kdg.ginrummy.view.statistics;

import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.model.GameStatistics;

public class StatisticsPresenter {
    //private attributes

    private GameStatistics model;
    private StatisticsView view;

    public StatisticsPresenter(GameStatistics model, StatisticsView view) {
        this.model = model;
        this.view=view;
        addEventHandlers();
        updateView();

    }
    private void addEventHandlers(){}
    private void updateView(){}
    private void addWindowEventHandlers(){}
}
