package be.kdg.ginrummy.view.name;

import be.kdg.ginrummy.model.Game;

public class NamePresenter {
    private final NameView view;
    private final Game model;

    public NamePresenter(NameView view, Game game) {
        this.view = view;
        this.model = game;
    }
    private void addEventHandlers() {
        model.getHUMAN_PLAYER().setNAME(view.textField.getText());
        //model.setPlayerName(view.textField.getText());
    }
    private void updateView() {}
}
