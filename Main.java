
import expense.*;
import mathquiz.MathQuiz;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseHelper.connect()) {
            DatabaseHelper.initializeDatabase(conn);
            ExpenseManager em = new ExpenseManager(conn);
            MathQuiz quiz = new MathQuiz();

            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("\n=== Menu ===");
                System.out.println("1. Start Math Quiz");
                System.out.println("2. Add Expense");
                System.out.println("3. View Expenses");
                System.out.println("4. Delete Expense");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> quiz.startQuiz();
                    case 2 -> em.addExpense();
                    case 3 -> em.viewExpenses();
                    case 4 -> em.deleteExpense();
                    case 5 -> { return; }
                    default -> System.out.println("Invalid option.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}