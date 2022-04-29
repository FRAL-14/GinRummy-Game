package view.name;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NameView extends VBox {

	// private Node attributes (controls)
	private Label label;
	private TextField textField;
	private Button startGameButton;
	// TODO: add option where player can choose who begins the first round
	private RadioButton radioButtonHuman;
	private RadioButton radioButtonComputer;

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
		label = new Label("Enter your name and who begins first:");
		startGameButton = new Button("Start Game");

		radioButtonHuman = new RadioButton("You");
		radioButtonComputer = new RadioButton("Computer");

		// menu
		menuBar = new MenuBar();
		menu = new Menu("Menu");

		home = new MenuItem("Home");
		home.setGraphic(new ImageView(new Image("/icons/home.png", 16, 16, false, false)));

		rules = new MenuItem("Rules");
		rules.setGraphic(new ImageView(new Image("/icons/rules.png", 16, 16, false, false)));
	}

	private void layoutNodes() {
		// radiobuttons
		final ToggleGroup radioButtons = new ToggleGroup();
		radioButtonHuman.setToggleGroup(radioButtons);
		radioButtonComputer.setToggleGroup(radioButtons);
		radioButtons.selectToggle(radioButtonHuman);

		final HBox hBox = new HBox(radioButtonHuman, radioButtonComputer);
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(40);

		//menu
		menu.getItems().add(home);
		menu.getItems().add(rules);
		menuBar.getMenus().add(menu);
		getChildren().add(menuBar);

		getChildren().add(label);
		getChildren().add(hBox);
		getChildren().add(textField);
		getChildren().add(startGameButton);
		setSpacing(30);
		setAlignment(Pos.CENTER);
		setStyle("-fx-padding: 16;");
	}

	Label getLabel() {
		return label;
	}

	TextField getTextField() {
		return textField;
	}

	Button getStartGameButton() {
		return startGameButton;
	}

	MenuItem getHomeMenuItem() {
		return home;
	}

	MenuItem getRulesMenuItem() {
		return rules;
	}

	RadioButton getRadioButtonHuman() {
		return radioButtonHuman;
	}

	RadioButton getRadioButtonComputer() {
		return  radioButtonComputer;
	}

}
