package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection{

    protected static final Connection connection = connectToDB();

    public DB_Connection() {
    }

    private static Connection connectToDB() {
        try {
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javafx_game", "javafx_game", "Student_1234");
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
