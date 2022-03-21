package be.kdg.ginrummy.model;

import java.sql.Timestamp;

public class GameStatistics {

    //private attributes
    private Timestamp startTime;
    private Timestamp endTime;
    private Timestamp gameDuration;
    private Timestamp averageTurnDuration;
    private int playerID;
    private String winner;



    //getters and setters
    public Timestamp getStartTime() { return startTime; }
    public void setStartTime(Timestamp timeStamp) { this.startTime = timeStamp; }

    public Timestamp getEndTime() { return endTime;}
    public void setEndTime(Timestamp endTime) { this.endTime = endTime;}

    public Timestamp getGameDuration() { return gameDuration; }


}
