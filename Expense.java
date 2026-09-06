public class Expense {
    private String title;
    private double amount;
    private String category;
    private String date;

    // Constructor
    public Expense(String title, double amount, String category, String date) {
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Convert object to file format
    public String toFileString() {
        return title + "," + amount + "," + category + "," + date;
    }

    // Optional: Display format
    public String toString() {
        return "Title: " + title +
               " | Amount: " + amount +
               " | Category: " + category +
               " | Date: " + date;
    }
}
