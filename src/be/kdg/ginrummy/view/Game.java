// Game class in view because it kind of acts like a presenter
package be.kdg.ginrummy.view;

import be.kdg.ginrummy.model.Deck;
import be.kdg.ginrummy.model.DiscardPile;
import be.kdg.ginrummy.model.Player;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Game {

    private final Player HUMAN_PLAYER; // Can be final, as only 1 human player is needed for a game and doesn't change
    private final Player COMPUTER_PLAYER; // Can be final, as only 1 CPU player is needed for a game and doesn't change
    private final DiscardPile DISCARD_PILE = new DiscardPile(); // Can be final, as only 1 is needed and doesn't change, its cards can be changed
    private final Deck DECK = new Deck(); // Can be final, as only 1 deck is needed for a game and doesn't change
    private int turnNumber;
    private Timestamp timeStamp;

    public Game(String nameHumanPlayer) {
        this.turnNumber = 0;
        setTimeStampToNow();

        // Making the players
        this.HUMAN_PLAYER = new Player(nameHumanPlayer, 0, false);
        this.COMPUTER_PLAYER = new Player("Computer", 0, true);
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void incrementTurnNumber() {
        turnNumber++;
    }

    public DiscardPile getDISCARD_PILE() {
        return DISCARD_PILE;
    }

    public Deck getDECK() {
        return DECK;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStampToNow() {
        this.timeStamp = Timestamp.valueOf(LocalDateTime.now());
    }

    public Player getHUMAN_PLAYER() {
        return HUMAN_PLAYER;
    }

    public Player getCOMPUTER_PLAYER() {
        return COMPUTER_PLAYER;
    }

    /**
     * Sorts the player's hand and checks if a user can knock.
     * Should be run after every move.
     */
    public void regularGameChecks() {
        getHUMAN_PLAYER().getHAND().sortPlayerCards();

        if (getHUMAN_PLAYER().canKnock()) {
            if (UI.askUserIfKnock()) {
                DISCARD_PILE.discardCard(getHUMAN_PLAYER().getHAND().removeLastCard());
            }
        }
    }

}
