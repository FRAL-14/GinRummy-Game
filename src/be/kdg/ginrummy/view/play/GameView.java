package be.kdg.ginrummy.view.play;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

public class GameView extends BorderPane {

	private static final double IMAGE_WIDTH = 100;
	private static final double OVERLAP = IMAGE_WIDTH * (-.5);
	private final Image BACKSIDE_CARD = new Image("cards/Backside.png");
	//private menu Bar attributes
	private MenuBar menuBar;
	private Menu menu;
	private MenuItem rules;
	private VBox leftSide;
	private Label computerLabel;
	private TextField computerPoints;
	private Label humanLabel;
	private TextField humanPoints;
	private Label timeLabel;
	private TextField timeElapsed;
	private BorderPane center;
	private Label deadwoodLabel;
	private TextField deadwoodCount;
	private HBox humanCards;
	private HBox computerCards;
	private HBox piles;
	private ImageView stackPile;
	private ImageView discardPile;
	private Button knockButton;
	private Button passFirstCardButton;


	public GameView() {
		this.initialiseNodes();
		this.layoutNodes();
	}


	private void initialiseNodes() {
		//menu
		menuBar = new MenuBar();
		menu = new Menu("View Rules");

		rules = new MenuItem("Rules");
		rules.setGraphic(new ImageView(new Image("/icons/rules.png", 16, 16, false, false)));

		leftSide = new VBox();
		computerLabel = new Label("Computer");
		computerPoints = new TextField("0");
		humanLabel = new Label("You");
		humanPoints = new TextField("0");
		timeLabel = new Label("Elapsed time");
		timeElapsed = new TextField("00:00");

		center = new BorderPane();
		deadwoodLabel = new Label("DEADWOOD");
		deadwoodCount = new TextField("0");

		humanCards = new HBox(OVERLAP);
		this.addCards(humanCards);

		computerCards = new HBox(OVERLAP);
		this.addCards(computerCards);

		stackPile = new ImageView(BACKSIDE_CARD);
		stackPile.setFitWidth(IMAGE_WIDTH);
		stackPile.setPreserveRatio(true);
		discardPile = new ImageView(BACKSIDE_CARD);
		discardPile.setFitWidth(IMAGE_WIDTH);
		discardPile.setPreserveRatio(true);

		knockButton = new Button("Knock");

		passFirstCardButton = new Button("Pass");
	}

	private void layoutNodes() {
		// menu Bar
		menu.getItems().add(rules);
		menuBar.getMenus().add(menu);
		setTop(menuBar);

		// left side
		layoutLeftSide();

		// center piles
		piles = new HBox(stackPile, discardPile);
		piles.setAlignment(Pos.CENTER);
		piles.setSpacing(25);
		center.setCenter(piles);
		setMargin(piles, new Insets(10));

		// top and bottom
		layoutHandsAndDeadwood();

		center.setPadding(new Insets(20, 10, 20, 10));
		setCenter(center);

		// right side
		layoutButtons();
	}

	private void layoutHandsAndDeadwood() {
		deadwoodCount.setEditable(false);
		deadwoodCount.setFocusTraversable(false);
		final HBox deadwoodBox = new HBox(deadwoodLabel, deadwoodCount);
		this.layoutBox(deadwoodBox);

		final VBox humanHandAndDeadwood = new VBox(10, deadwoodBox, humanCards);
		humanHandAndDeadwood.setAlignment(Pos.CENTER_RIGHT);
		center.setBottom(humanHandAndDeadwood);
		humanCards.setAlignment(Pos.CENTER);

		final HBox invisibleDeadwoodBox = new HBox(new Label(), new TextField()); // to have same spacing above the stack and discard piles
		this.layoutBox(invisibleDeadwoodBox);
		invisibleDeadwoodBox.setVisible(false);
		final VBox computerHandAndDeadwood = new VBox(10, computerCards, invisibleDeadwoodBox);
		center.setTop(computerHandAndDeadwood);
		computerCards.setAlignment(Pos.CENTER);
	}

	private void layoutLeftSide() {
		computerPoints.setEditable(false);
		computerPoints.setFocusTraversable(false);
		timeElapsed.setEditable(false);
		timeElapsed.setFocusTraversable(false);
		humanPoints.setEditable(false);
		humanPoints.setFocusTraversable(false);

		final HBox computerBox = new HBox(computerLabel, computerPoints);
		final HBox timeBox = new HBox(timeLabel, timeElapsed);
		final HBox humanBox = new HBox(humanLabel, humanPoints);
		leftSide.getChildren().addAll(computerBox, timeBox, humanBox);
		// set a border on the boxes
		for (int i = 0; i < leftSide.getChildren().size(); i++) {
			final HBox box = (HBox) leftSide.getChildren().get(i);
			this.layoutBox(box);
		}

		final Region space1 = new Region();
		VBox.setVgrow(space1, Priority.ALWAYS);
		final Region space2 = new Region();
		VBox.setVgrow(space2, Priority.ALWAYS);
		leftSide.getChildren().add(1, space1);
		leftSide.getChildren().add(3, space2);

		setLeft(leftSide);
		setMargin(leftSide, new Insets(20, 0, 20, 35));
	}

	private void layoutButtons() {
		knockButton.setPrefSize(160, 40);
		knockButton.setDisable(true);

		final SplitPane sp = new SplitPane(knockButton);
		sp.setTooltip(new Tooltip("You can only knock when deadwood is 10 or below"));
		sp.setStyle("-fx-box-border: transparent;");
		sp.setMaxSize(160, 40);

		passFirstCardButton.setPrefSize(160, 40);
		passFirstCardButton.setVisible(false);

		final VBox buttonBox = new VBox(passFirstCardButton, sp);
		buttonBox.setAlignment(Pos.BOTTOM_CENTER);
		VBox.setMargin(passFirstCardButton, new Insets(0, 0, 50, 0));

		setRight(buttonBox);
		setMargin(buttonBox, new Insets(20, 35, 20, 0));
	}

	private void addCards(HBox box) {
		for (int i = 0; i < 11; i++) {
			final ImageView card = new ImageView(BACKSIDE_CARD);
			card.setFitWidth(IMAGE_WIDTH);
			card.setPreserveRatio(true);
			card.setId("" + i);
			box.getChildren().add(card);
		}
		final ImageView eleventhCard = (ImageView) box.getChildren().get(10);
		eleventhCard.setVisible(false);
	}

	private void layoutBox(HBox box) {
		box.setBorder(new Border(new BorderStroke(Paint.valueOf("Black"), BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
		box.setSpacing(10);
		box.setAlignment(Pos.CENTER);
		box.setPadding(new Insets(5, 7, 5, 7));
		box.setMaxWidth(185);
		final TextField field = (TextField) box.getChildren().get(1);
		field.setPrefColumnCount(4);
		field.setAlignment(Pos.CENTER);
	}

	void setHandImage(int numberOfCard, String imageResource) {
		getHumanCard(numberOfCard).setImage(new Image(imageResource));
	}

	void setDiscardPileImage(String imageResource) {
		getDiscardPile().setImage(new Image(imageResource));
	}

	MenuItem getRulesMenuItem() {
		return rules;
	}

	ImageView getHumanCard(int numberOfCard) {
		return (ImageView) humanCards.getChildren().get(numberOfCard);
	}

	ImageView getComputerCard(int numberOfCard) {
		return (ImageView) computerCards.getChildren().get(numberOfCard);
	}

	TextField getComputerPoints() {
		return computerPoints;
	}

	TextField getHumanPoints() {
		return humanPoints;
	}

	TextField getTimeElapsed() {
		return timeElapsed;
	}

	TextField getDeadwoodCount() {
		return deadwoodCount;
	}

	ImageView getStackPile() {
		return stackPile;
	}

	ImageView getDiscardPile() {
		return discardPile;
	}

	HBox getHumanCards() {
		return humanCards;
	}

	HBox getPiles() {
		return piles;
	}

	Button getKnockButton() {
		return knockButton;
	}

	Button getPassFirstCardButton() {
		return passFirstCardButton;
	}

}
