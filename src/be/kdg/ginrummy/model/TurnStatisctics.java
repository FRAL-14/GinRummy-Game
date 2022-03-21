package be.kdg.ginrummy.model;

import java.sql.Timestamp;

public class TurnStatisctics {

    private int deadWoodScore;
    private Player playerInTurn;
    private Timestamp turnStart;
    private Timestamp turnEnd;
    private Timestamp turnDuration;
    private int lowestDeadWoodScore=Math.min(this.lowestDeadWoodScore, deadWoodScore);

    public int getLowestDeadWoodScore() { return lowestDeadWoodScore;}


}
