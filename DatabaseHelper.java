
package expense;

import java.sql.*;

public class DatabaseHelper {
    public static Connection connect() throws SQLException {
        String url = "jdbc:sqlite:data/expenses.db";
        return DriverManager.getConnection(url);
    }

    public static void initializeDatabase(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS expenses ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                   + "category TEXT NOT NULL,"
                   + "amount REAL NOT NULL,"
                   + "date TEXT NOT NULL)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }
}