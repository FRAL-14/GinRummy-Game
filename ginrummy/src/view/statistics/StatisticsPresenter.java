package view.gameover;
import model.Game;


public class GameOverPresenter {

    private Game model;
    private GameOverView view;
    public GameOverPresenter(
            Game model, GameOverView view) {
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
