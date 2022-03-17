package be.kdg.ginrummy;

import be.kdg.ginrummy.model.Game;
import be.kdg.ginrummy.view.home.HomePresenter;
import be.kdg.ginrummy.view.home.HomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Runner extends Application {

    public static void main(String[] args) {

        Application.launch(args);

//        game = new Game("Leo");

//        //testing
//        Deck deck = new Deck();
//        //deck.print(); full 52 cards set
//
//        Player playerOne = new Player("Bear",0,false);
//        playerOne.dealCards(deck);
//        //playerOne.printCards();
//
//        Player playerTwo = new Player("Bear2",0,false);
//        playerTwo.dealCards(deck);
//        playerTwo.printCards();
//        System.out.println(playerTwo.getDeadWoodCount());//works
//        deck.print(); //the first 20 cards are gone

//        game.printDeck();

        // game.getCOMPUTER_PLAYER().dealCards(game.getDECK());
        //game.getHUMAN_PLAYER().dealCards(game.getDECK());
        //game.getHUMAN_PLAYER().printCards();
        //System.out.println(game.getHUMAN_PLAYER().getDeadWoodCount());

        //System.out.println(game.getDECK().getDeckOfCards());

        // game.regularGameChecks();
        // game.getHUMAN_PLAYER().printCards();
        // System.out.println(game.getHUMAN_PLAYER().getDeadWoodCount());
        // game.getDISCARD_PILE().printDiscardPile();
    }

    @Override
    public void start(Stage primaryStage) {
        Game model = new Game("Leo");
        HomeView homeView = new HomeView();
        HomePresenter homePresenter = new HomePresenter(model, homeView);

        primaryStage.setTitle("Gin Rummy");

        primaryStage.setScene(new Scene(homeView));
        homePresenter.addWindowEventHandlers();
        primaryStage.show();
    }

}
