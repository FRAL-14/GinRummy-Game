package view.home;

import model.Game;
import model.GameStatistics;
import model.Player;
import view.help.HelpPresenter;
import view.help.HelpView;
import view.name.NamePresenter;
import view.name.NameView;
import view.statistics.StatisticsPresenter;
import view.statistics.StatisticsView;
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
