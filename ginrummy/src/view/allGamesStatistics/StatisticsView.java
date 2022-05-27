package view.allGamesStatistics;


import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


public class StatisticsView extends BorderPane {
    //private menu Bar attributes
    private MenuBar menuBar;
    private Menu menu;
    private MenuItem home;
    private Label label;
    //will be deleted later


    private LineChart<Number, Double> lineChart;
    private Double[] DURATIONS;


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


    }
    private void layoutNodes(){
        //menu Bar
        menu.getItems().add(home);
        menuBar.getMenus().add(menu);
        setTop(menuBar);

      //delete later
        lineChart.setTitle(
                "Line graph of the duration of each turn for the human player"
        );
        setCenter(this.lineChart);




    }

    public MenuItem getHomeMenuItem() {
        return home;
    }

}
