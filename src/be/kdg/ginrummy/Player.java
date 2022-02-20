package be.kdg.ginrummy;

public class Player {

    private final String NAME;
    private int score;
    private boolean isPlayerTurn;

    public Player(String NAME, int score, boolean isPlayerTurn) {
        this.NAME = NAME;
        this.score = score;
        this.isPlayerTurn = isPlayerTurn;
    }

    public String getNAME() {
        return NAME;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean getIsPlayerTurn() {
        return isPlayerTurn;
    }

    public void setIsPlayerTurn(boolean playerTurn) {
        isPlayerTurn = playerTurn;
    }

}
