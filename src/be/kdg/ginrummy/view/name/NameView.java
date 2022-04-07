package be.kdg.ginrummy.view.name;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NameView extends VBox {
    // private Node attributes (controls)
    Label label;
    TextField textField;

    public NameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        textField = new TextField();
        label = new Label("What is your name? ");
    }
    private void layoutNodes() {
        getChildren().add(label);
        getChildren().add(textField);
        setSpacing(50);
        setAlignment(Pos.CENTER);
        setStyle("-fx-padding: 16;");
    }
    public Label getLabel() { return label; }
    public TextField getTextField() { return textField;}
}
