package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    public static Connection getConnection() throws Exception {
        String DRIVER = "org.postgresql.Driver";
        String URL = "jdbc:postgresql://127.0.0.1:5432/Event";
        String USERNAME = "postgres";
        String PASSWORD = "197624";

        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }
}
