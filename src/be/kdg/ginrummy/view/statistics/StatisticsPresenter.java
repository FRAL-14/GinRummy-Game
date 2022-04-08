package be.kdg.ginrummy.view.statistics;

import be.kdg.ginrummy.model.Game;

public class StatisticsPresenter {

	//private attributes
	private final Game MODEL;
	private final StatisticsView VIEW;


	public StatisticsPresenter(Game model, StatisticsView view) {
		this.MODEL = model;
		this.VIEW = view;
		addEventHandlers();
		updateView();
	}


	private void addEventHandlers() {
	}

	private void updateView() {
	}

}
