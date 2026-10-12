package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// OR
// import java.sql.*

public class App {

    private static final String URL = "jdbc:mysql://localhost:3306/college";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "8839178090@Az#";

    public static void main(String[] args) {

        try (
                Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM student")) {
            System.out.println("Connection established");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }

        } catch (SQLException e) {
            System.err.println("Database error : " + e.getMessage());
            System.err.println("SQLState       : " + e.getSQLState());
            System.err.println("ErrorCode      : " + e.getErrorCode());
            e.printStackTrace();
        }
    }
}
