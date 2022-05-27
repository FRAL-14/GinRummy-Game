package view.statistics;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class StatisticsView extends VBox {
    Label label;
    ImageView gameOverImageView;
    Image gameOverPic;

    public StatisticsView() {
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        this.gameOverPic = new Image("/statistics/gameFinished.png");
        this.gameOverImageView=new ImageView(gameOverPic);
// create and configure controls // button = new Button("...") // label = new Label("...")
    }


    private void layoutNodes() {
        getChildren().add(gameOverImageView);
// add/set ... methods
// Insets, padding, alignment, ...
    }

// package-private Getters
    // for controls used by Presenter
}

