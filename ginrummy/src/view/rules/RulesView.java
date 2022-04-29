package view.rules;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class RulesView extends VBox {
    //private nodes
    private Label label;
    private static final String RULES ="Gin Rummy or Gin is a traditional " +
            "card matching game that\n " +
            "requires 2 players and a standard 52 playing card deck with Kings\n " +
            "high and Aces low. In Gin Rummy, cards are worth their numerical value\n" +
            " with Aces worth 1 and face cards worth 10.";
    public RulesView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        // create and configure controls
        label = new Label(RULES);

    }

    private void layoutNodes() {
        getChildren().add(label);
    }
}
