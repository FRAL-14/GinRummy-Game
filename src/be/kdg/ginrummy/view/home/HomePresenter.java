package be.kdg.ginrummy.view.home;

import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.model.GameStatistics;
import be.kdg.ginrummy.model.Player;
import be.kdg.ginrummy.model.ViewRules;
import be.kdg.ginrummy.view.name.NamePresenter;
import be.kdg.ginrummy.view.name.NameView;
import be.kdg.ginrummy.view.rules.RulesView;
import be.kdg.ginrummy.view.statistics.StatisticsPresenter;
import be.kdg.ginrummy.view.statistics.StatisticsView;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class HomePresenter {

    private final Game MODEL;
    private Player playerModel;
    private GameStatistics gameStatisticsModel;
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

        this.VIEW.getStatisticsButton().setOnAction(e->{
            statisticsScreen();
        });

        this.VIEW.getHelpButton().setOnAction(e->{
            rulesScreen();
        });

    }

    private void updateView() {
        // fills the view with model data
    }

    public void addWindowEventHandlers() {
        Window window = VIEW.getScene().getWindow();
        // add event handlers to window
    }

    //methods for new screens
    private void nameInput(){
        NameView nameView = new NameView();
        NamePresenter namePresenter = new NamePresenter(playerModel, nameView);
        VIEW.getScene().setRoot(nameView);
    }
    private void statisticsScreen(){
        StatisticsView statisticsView = new StatisticsView();
        StatisticsPresenter statisticsPresenter = new StatisticsPresenter(gameStatisticsModel, statisticsView);
        VIEW.getScene().setRoot(statisticsView);
    }

    private void rulesScreen(){
        ViewRules.viewRules(VIEW.getScene());

    }

}
