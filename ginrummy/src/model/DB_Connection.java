package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection{

    protected static final Connection connection = connectToDB();

    public DB_Connection() {}

    public static Connection connectToDB(){
        try {
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javafx_game",
                    "postgres", "Student_1234");
            System.out.println("Connected to the PostgreSQL server successfully.");
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database");
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
