package view.name;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class NameView extends VBox {
    // private Node attributes (controls)
    private Label label;
    private TextField textField;
    private Button startGameButton;
    // TODO: add option where player can choose who begins the first round

    //menu attributes
    private MenuBar menuBar;
    private Menu menu;
    private MenuItem home;
    private MenuItem rules;

    public NameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        textField = new TextField();
        label = new Label("What is your name? ");
        startGameButton = new Button("Start Game");

        menuBar = new MenuBar();
        menu = new Menu("Menu");

        home = new MenuItem("Home");
        home.setGraphic(new ImageView(new Image("/icons/home.png", 16, 16, false, false)));

        rules = new MenuItem("Rules");
        rules.setGraphic(new ImageView(new Image("/icons/rules.png", 16, 16, false, false)));
    }

    private void layoutNodes() {
        //menu
        menu.getItems().add(home);
        menu.getItems().add(rules);
        menuBar.getMenus().add(menu);
        getChildren().add(menuBar);

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
    public MenuItem getHomeMenuItem() {
        return home;
    }
    public MenuItem getRulesMenuItem() {
        return rules;
    }

}
