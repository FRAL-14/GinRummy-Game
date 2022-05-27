package view.gameover;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.awt.event.WindowEvent;

public class GameOverView extends VBox {
    Label label;
    ImageView gameOverImageView;
    Image gameOverPic;

    public GameOverView() {
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        this.gameOverPic = new Image("");
// create and configure controls // button = new Button("...") // label = new Label("...")
    }
    private void layoutNodes() {
        getChildren().add(label);
// add/set ... methods
// Insets, padding, alignment, ...
    }

// package-private Getters
    // for controls used by Presenter
}

