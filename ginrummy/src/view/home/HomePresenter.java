package view.home;

import model.Game;
import model.Player;
import view.help.HelpPresenter;
import view.help.HelpView;
import view.name.NamePresenter;
import view.name.NameView;
import view.allGamesStatistics.StatisticsPresenter;
import view.allGamesStatistics.StatisticsView;
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

    }

    public void addWindowEventHandlers() {
        Window window = VIEW.getScene().getWindow();
        // add event handlers to window
    }


    private void nameInput(){
        NameView nameView = new NameView();
        NamePresenter namePresenter = new NamePresenter(MODEL, nameView);
        VIEW.getScene().setRoot(nameView);
    }
    private void statisticsScreen(){
        StatisticsView statisticsView = new StatisticsView();
        StatisticsPresenter statisticsPresenter = new StatisticsPresenter(MODEL, statisticsView);
        VIEW.getScene().setRoot(statisticsView);
    }

    private void rulesScreen(){
        HelpView helpView = new HelpView();
        HelpPresenter helpPresenter = new HelpPresenter(MODEL, helpView);
        VIEW.getScene().setRoot(helpView);
    }

}
