package bibliotheque.jdbc;

import java.sql.*

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/bibliotheque";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Fox15h16";
    static Connetion connection;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
