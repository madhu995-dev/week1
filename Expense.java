
package expense;

public class Expense {
    public int id;
    public String category;
    public double amount;
    public String date;

    public Expense(int id, String category, double amount, String date) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String toString() {
        return id + ": " + category + " - " + amount + " on " + date;
    }
}