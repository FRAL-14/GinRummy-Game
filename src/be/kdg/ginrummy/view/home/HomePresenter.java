package be.kdg.ginrummy.view.home;

import be.kdg.ginrummy.model.Game;
import javafx.stage.Window;

public class HomePresenter {

    private final Game MODEL;
    private final HomeView VIEW;


    public HomePresenter(Game model, HomeView view) {
        this.MODEL = model;
        this.VIEW = view;

        addEventHandlers();
        updateView();
    }


    private void addEventHandlers() {
        // add event handlers to view controls (lambdas)
        // in the event handlers: call model methods and updateView()
    }

    private void updateView() {
        // fills the view with model data
    }

    public void addWindowEventHandlers() {
        Window window = VIEW.getScene().getWindow();
        // add event handlers to window
    }

}
