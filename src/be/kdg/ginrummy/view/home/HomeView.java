package be.kdg.ginrummy.view.home;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HomeView extends VBox {

    private Label titleLabel;
    private Button playButton;
    private Button statisticsButton;
    private Button helpButton;


    public HomeView() {
        initialiseNodes();
        layoutNodes();
    }


    private void initialiseNodes() {
        titleLabel = new Label("GIN RUMMY DELUXE");
        playButton = new Button("PLAY");
        statisticsButton = new Button("Statistics");
        helpButton = new Button("Help & Rules");
    }

    private void layoutNodes() {
        getChildren().addAll(titleLabel, playButton, statisticsButton, helpButton);
    }

    Label getTitleLabel() {
        return titleLabel;
    }

    Button getPlayButton() {
        return playButton;
    }

    Button getStatisticsButton() {
        return statisticsButton;
    }

    Button getHelpButton() {
        return helpButton;
    }

}
