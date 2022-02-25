package be.kdg.ginrummy;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Game {

    private final Player HUMAN_PLAYER;
    private final Player COMPUTER_PLAYER;
    private int turnNumber;
    private Timestamp timeStamp;

    public Game(String nameHumanPlayer) {
        this.turnNumber = 0;
        setTimeStampToNow();
        this.HUMAN_PLAYER = new Player(nameHumanPlayer, 0, false);
        this.COMPUTER_PLAYER = new Player("Computer", 0, true);
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void incrementTurnNumber() {
        turnNumber++;
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

}
