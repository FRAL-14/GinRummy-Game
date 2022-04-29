package view.help;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HelpView extends BorderPane {

	// private Node attributes (controls)
	public static final int HELP_WIDTH = 650;
	public static final int HELP_HEIGHT = 450;

	private StackPane innerPane;
	private Label helpLabel;
	private Text helpText;
	private Button closeButton;


	public HelpView() {
		initialiseNodes();
		layoutNodes();
	}


	private void initialiseNodes() {
		// create and configure controls
		// button, label
		innerPane = new StackPane();
		helpLabel = new Label("Help & Rules");
		helpText = new Text("""
				Gin Rummy is a card game that is played with 2 players. It is played with 52 cards (the jokers are not used). In the beginning, each player receives 10 cards. The remaining cards are placed upside down on the table (this is the "stock pile").

				Players take turns in which they take a card and discard a card. The discarded cards are placed, face up, on a pile: the "discard pile". A player can choose whether he/she takes the top card from the discard pile or from the stockpile.

				The goal of the game is to have all 10 cards in his hand as part of a "meld". A meld can be a "run" or a "set". A run is a row of at least 3 consecutive cards of the same suit (eg: clubs 3, 4, 5 and 6). A set is a collection of 3 or 4 cards with the same value.

				If a player only has melds in his hand, he/she calls "Gin" and wins the game. Both players put their cards open on the table. The cards in their hand that are not in a meld are called "dead wood". The sum of the face values of the dead wood cards determines the score of the
				winner. Kings, queens, and jacks are worth 10, aces are worth 1.""");
		closeButton = new Button("Back");
	}

	private void layoutNodes() {
		// add/set ... methods
		// insets, padding, alignment
		setCenter(helpText);
		setTop(innerPane);
		setPadding(new Insets(20, 35, 20, 35));
		setPrefSize(HELP_WIDTH, HELP_HEIGHT);

		StackPane.setAlignment(helpLabel, Pos.CENTER);
		StackPane.setAlignment(closeButton, Pos.TOP_RIGHT);
		innerPane.getChildren().addAll(helpLabel, closeButton);
		innerPane.setPadding(new Insets(10));

		helpLabel.setFont(new Font(20));
		helpText.wrappingWidthProperty().bind(widthProperty().subtract(70));
	}

	//package-private getters for controls used by Presenter
	Button getCloseButton() {
		return closeButton;
	}

}
