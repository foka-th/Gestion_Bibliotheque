package bibliotheque.jdbc;

import java.sql.*;
import java.util.*;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/bibliotheque";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Fox15h16";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
