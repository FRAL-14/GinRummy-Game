package view.statistics;
import model.Game;


public class StatisticsPresenter {

    private Game model;
    private StatisticsView view;
    public StatisticsPresenter(
            Game model, StatisticsView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }
    private void addEventHandlers() {
// Add event handlers (inner classes or
// lambdas) to view controls.
// In the event handlers: call model methods // and updateView().
    }
    private void updateView() {
// fills the view with model data
    }
    public void addWindowEventHandlers () {
        // Add event handlers to window
    }
}
