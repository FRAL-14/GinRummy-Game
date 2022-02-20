package be.kdg.ginrummy;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Game {

    private final Player HUMAN_PLAYER;
    private final Player COMPUTER_PLAYER;
    private int turnNumber;
    private Timestamp timeStamp;

    public Game(int turnNumber, Player HUMAN_PLAYER, Player COMPUTER_PLAYER) {
        this.turnNumber = turnNumber;
        setTimeStampToNow();
        this.HUMAN_PLAYER = HUMAN_PLAYER;
        this.COMPUTER_PLAYER = COMPUTER_PLAYER;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
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
