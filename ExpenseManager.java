import java.io.*;
import java.util.Scanner;

public class ExpenseManager {

    private final String FILE_NAME = "data/expenses.txt";
    private final Scanner sc;

    public ExpenseManager(Scanner sc) {
        this.sc = sc;
    }

    // Add Expense
    public void addExpense() {
        System.out.print("Enter Title: ");
        String title = sc.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Title cannot be empty!");
            return;
        }

        System.out.print("Enter Amount: ");
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid amount! Please enter a number.");
            sc.nextLine();
            return;
        }
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount < 0) {
            System.out.println("Amount cannot be negative!");
            return;
        }

        System.out.print("Enter Category: ");
        String category = sc.nextLine().trim();

        if (category.isEmpty()) {
            System.out.println("Category cannot be empty!");
            return;
        }

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = sc.nextLine().trim();

        Expense expense = new Expense(title, amount, category, date);

        try {
            File file = new File(FILE_NAME);
            File parent = file.getParentFile();

            if (parent != null) {
                parent.mkdirs();
            }

            try (FileWriter fw = new FileWriter(file, true)) {
                fw.write(expense.toFileString() + System.lineSeparator());
            }

            System.out.println("Expense Added Successfully!");
        } catch (IOException e) {
            System.out.println("Error saving expense: " + e.getMessage());
        }
    }

    // View Expenses
    public void viewExpenses() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No expenses found!");
            return;
        }

        System.out.println("\n--- All Expenses ---");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length != 4) {
                    System.out.println("Skipping invalid expense record: " + line);
                    continue;
                }

                try {
                    Expense expense = new Expense(
                            data[0],
                            Double.parseDouble(data[1]),
                            data[2],
                            data[3]
                    );

                    System.out.println(expense);
                    found = true;
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid amount in record: " + line);
                }
            }

            if (!found) {
                System.out.println("No valid expenses found!");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
