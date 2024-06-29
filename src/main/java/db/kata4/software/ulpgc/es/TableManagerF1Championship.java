package db.kata4.software.ulpgc.es;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableManagerF1Championship {

    public static void createTable (Connection conn){
        String sql = "CREATE TABLE IF NOT EXISTS f1championship (" +
                "id TEXT NOT NULL PRIMARY KEY," +
                "position INTEGER," +
                "name TEXT NOT NULL," +
                "team TEXT NOT NULL," +
                "country TEXT NOT NULL," +
                "points FLOAT NOT NULL," +
                "year INTEGER NOT NULL," +
                "acronym TEXT," +
                ");";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.execute();
            System.out.println("Table 'f1championship1' has been created.");
        }catch (SQLException e){
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    public static void dropTable(Connection conn){
        String sql = "DROP TABLE IF EXISTS f1championship;";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.execute();
            System.out.println("Table 'f1championship1' has been dropped.");
        }catch (SQLException e){
            System.out.println("Error dropping table: " + e.getMessage());
            e.printStackTrace();
        }
    }
}