package be.kdg.ginrummy.view.statistics;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class StatisticsView extends VBox {
    //private menu Bar attributes
    private MenuBar menuBar;
    private Menu menu;
    private MenuItem home;
    private Label label;

    public StatisticsView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        //menu Bar attributes
        menuBar = new MenuBar();
        menu = new Menu("Menu");

        home = new MenuItem("Home");
        home.setGraphic(new ImageView(new Image("/icons/home.png", 16, 16, false, false)));

        label = new Label("this screen is for all games statistics");
    }
    private void layoutNodes(){
        //menu Bar
        menu.getItems().add(home);
        menuBar.getMenus().add(menu);
        getChildren().add(menuBar);
        getChildren().add(label);
        setSpacing(50);
    }

    public MenuItem getHomeMenuItem() {
        return home;
    }

}
