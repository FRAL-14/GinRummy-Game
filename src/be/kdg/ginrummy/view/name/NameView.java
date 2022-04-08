package be.kdg.ginrummy.view.name;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NameView extends VBox {
    // private Node attributes (controls)
    private Label label;
    private TextField textField;
    private Button startGameButton;

	// private Node attributes (controls)
	private Label label;
	private TextField textField;

    private void initialiseNodes() {
        textField = new TextField();
        label = new Label("What is your name? ");
        startGameButton = new Button("Start Game");
    }
    private void layoutNodes() {
        getChildren().add(label);
        getChildren().add(textField);
        getChildren().add(startGameButton);
        setSpacing(50);
        setAlignment(Pos.CENTER);
        setStyle("-fx-padding: 16;");
    }
    public Label getLabel() { return label; }
    public TextField getTextField() { return textField;}
    public Button getStartGameButton() { return startGameButton; }
}
