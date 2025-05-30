
package expense;

import java.sql.*;
import java.util.Scanner;

public class ExpenseManager {
    private Connection conn;

    public ExpenseManager(Connection conn) {
        this.conn = conn;
    }

    public void addExpense() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        String sql = "INSERT INTO expenses (category, amount, date) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category);
            pstmt.setDouble(2, amount);
            pstmt.setString(3, date);
            pstmt.executeUpdate();
        }
        System.out.println("Expense added.");
    }

    public void viewExpenses() throws SQLException {
        String sql = "SELECT * FROM expenses";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(new Expense(
                    rs.getInt("id"),
                    rs.getString("category"),
                    rs.getDouble("amount"),
                    rs.getString("date")
                ));
            }
        }
    }

    public void deleteExpense() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter expense ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM expenses WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
        System.out.println("Expense deleted.");
    }
}