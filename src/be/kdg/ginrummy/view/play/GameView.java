package be.kdg.ginrummy.view.play;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameView extends VBox {
    //private menu Bar attributes
    private MenuBar menuBar;
    private Menu menu;
    private MenuItem rules;
    private HBox hBox;


    public GameView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        hBox = new HBox();
        //menu
        menuBar = new MenuBar();
        menu = new Menu("View Rules");

        rules = new MenuItem("Rules");
        rules.setGraphic(new ImageView(new Image("/icons/rules.png", 16, 16, false, false)));
    }

    private void layoutNodes() {
        //menu Bar
        menu.getItems().add(rules);
        menuBar.getMenus().add(menu);
        getChildren().add(menuBar);
        setSpacing(50);

    }

    public MenuItem getRulesMenuItem() {
        return rules;
    }
}
