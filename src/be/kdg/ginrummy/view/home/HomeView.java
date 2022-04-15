package be.kdg.ginrummy.view.home;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class HomeView extends BorderPane {

    public static final int MIN_HOME_WIDTH = 200;
    public static final int MIN_HOME_HEIGHT = 220;
    public static final int PREF_HOME_WIDTH = 350;
    public static final int PREF_HOME_HEIGHT = 250;

    private VBox vBox;
    private Label titleLabel;
    private Button playButton;
    private Button statisticsButton;
    private Button helpButton;


    public HomeView() {
        initialiseNodes();
        layoutNodes();
    }


    private void initialiseNodes() {
        vBox = new VBox(20);
        titleLabel = new Label("GIN RUMMY DELUXE");
        playButton = new Button("PLAY");
        statisticsButton = new Button("Statistics");
        helpButton = new Button("Help & Rules");
    }

    private void layoutNodes() {
        setTop(titleLabel);
        setAlignment(titleLabel, Pos.CENTER);

        setCenter(vBox);
        vBox.getChildren().addAll(playButton, statisticsButton, helpButton);
        vBox.setAlignment(Pos.CENTER);

        setPadding(new Insets(20, 35, 20, 35));
        setPrefSize(PREF_HOME_WIDTH, PREF_HOME_HEIGHT);
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
