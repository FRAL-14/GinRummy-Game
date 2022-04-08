package be.kdg.ginrummy.view.home;

import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.model.Player;
import be.kdg.ginrummy.view.name.NamePresenter;
import be.kdg.ginrummy.view.name.NameView;
import javafx.stage.Window;

public class HomePresenter {

    private final Game MODEL;
    private Player playerModel;
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
        this.VIEW.getPlayButton().setOnAction(e->
        {
            nameInput();
        });
    }

    private void updateView() {
        // fills the view with model data
    }

    public void addWindowEventHandlers() {
        Window window = VIEW.getScene().getWindow();
        // add event handlers to window
    }
    //method for transfering to name input screen
    private void nameInput(){
        NameView nameView = new NameView();
        NamePresenter namePresenter = new NamePresenter(playerModel, nameView);
        VIEW.getScene().setRoot(nameView);
    }

}
