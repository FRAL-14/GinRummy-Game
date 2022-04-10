package be.kdg.ginrummy.model;

import be.kdg.ginrummy.view.rules.RulesView;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewRules {
    public static void viewRules(Scene scene) {
        RulesView rulesView = new RulesView();
        Stage helpStage = new Stage();
        helpStage.initOwner(scene.getWindow());
        helpStage.initModality(Modality.APPLICATION_MODAL);
        helpStage.setScene(new Scene(rulesView));
        helpStage.setX(scene.getWindow().getX());
        helpStage.setY(scene.getWindow().getY());
        helpStage.showAndWait();
    }

}
