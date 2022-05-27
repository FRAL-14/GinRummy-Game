package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class GameStatistics extends DB_Connection {

    public GameStatistics() {
    }


    public static Statement statement;

    public static void createTables() {
        try {
            assert connection != null;
            statement = connection.createStatement();
            String PlayerTable = "create table IF NOT EXISTS players (\n"
                    + "	player_id serial constraint players_pk primary key,\n"
                    + "	name      varchar(30)\n"
                    + ");";

            String GameTable = "create table IF NOT EXISTS game\n" +
                    "(\n" +
                    "    game_id serial constraint game_pk  primary key,\n" +
                    "    player_id    int not null constraint player_id_fk references players (player_id),\n" +
                    "    start_time timestamp,\n" +
                    "    end_time timestamp,\n" +
                    "    duration numeric\n" +
                    ");";

            String MoveTable = "create table IF NOT EXISTS moves\n" +
                    "(\n" +
                    "    game_id    int constraint game_id_fk references game (game_id),\n" +
                    "    move_number int," +
                    "    player_id  int constraint player_id_fk references players (player_id),\n" +
                    "    deadwood   int CHECK(deadwood>=0),\n" +
                    "    start_time timestamp,\n" +
                    "    end_time   timestamp,\n" +
                    "    duration numeric\n" +
                    ");";

            statement.execute(PlayerTable);
            statement.execute(GameTable);
            statement.execute(MoveTable);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void savePlayerData(Game game) {
        try {
            assert connection != null;
            PreparedStatement newData = connection.prepareStatement("INSERT INTO players (player_id, name) VALUES (Default,?)");
            newData.setString(1, game.getHUMAN_PLAYER().getNAME());
            newData.executeUpdate();
            newData.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveStartingGameData() {
        try {
            assert connection != null;
            PreparedStatement newData = connection.prepareStatement("INSERT INTO game (game_id, player_id, start_time)" +
                    "VALUES(DEFAULT, currval(pg_get_serial_sequence('players', 'player_id')),current_timestamp)");

            newData.executeUpdate();
            newData.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void saveMoveData(Game game) {
        try {
            assert connection != null;
            PreparedStatement newData = connection.prepareStatement("INSERT INTO moves (game_id, player_id,move_number,deadwood, start_time, end_time, duration)" +
                    "VALUES (currval(pg_get_serial_sequence('game', 'game_id'))," +
                    "currval(pg_get_serial_sequence('players', 'player_id'))," +
                    "?,?,?,?,?)");
            newData.setInt(1, game.getTurnNumber());
            newData.setInt(2, game.getHUMAN_PLAYER().getHAND().calculateDeadwood());
            newData.setTimestamp(3, game.getHumanTurnStarts());
            newData.setTimestamp(4, game.getHumanTurnEnds());
            newData.setInt(5, game.getTurnDurationInMs());

            newData.executeUpdate();
            newData.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Used AFTER the a game is finished
    public static void saveEndingGameData(Game game) {
        try {
            assert connection != null;
            PreparedStatement newData = connection.prepareStatement("UPDATE game SET end_time = current_timestamp, duration = ?\n" +
                    "WHERE game_id=(SELECT max(game_id) FROM game);");
            newData.setInt(1, game.getGameDurationInMs());
            newData.executeUpdate();
            newData.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //to be used for the graph: returns an array of the human player turns durations.
    public static List<Double> getArrayofHumanMovesDuration() {
        double movesInSeconds;
        PreparedStatement ps;
        ResultSet rs;
        List <Double> allMoves= new ArrayList<>();

        try {
            assert connection != null;
            //dividing by 1000, because durations are stored as milliseconds.
            ps = connection.prepareStatement("select duration/1000 from moves\n" +
                    "where game_id = (select max(game_id) from game);");
            rs= ps.executeQuery();
            while (rs.next()){
                //the size of the array is the number of moves.
                allMoves.add(movesInSeconds=rs.getInt(1));
            }

    } catch (SQLException e){
            e.printStackTrace();
        }
    return allMoves;

    }
}

