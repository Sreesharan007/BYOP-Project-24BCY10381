import java.io.*;
import java.util.*;

public class ExpenseManager {

    private final String FILE_NAME = "data/expenses.txt";

    // Add Expense
    public void addExpense() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        Expense expense = new Expense(title, amount, category, date);

        try {
            File file = new File(FILE_NAME);
            file.getParentFile().mkdirs(); // create folder if not exists

            FileWriter fw = new FileWriter(file, true);
            fw.write(expense.toFileString() + "\n");
            fw.close();

            System.out.println("✅ Expense Added Successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error saving expense!");
        }
    }

    // View Expenses
    public void viewExpenses() {
        try {
            File file = new File(FILE_NAME);

            if (!file.exists()) {
                System.out.println("No expenses found!");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            System.out.println("\n--- All Expenses ---");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                Expense expense = new Expense(
                        data[0],
                        Double.parseDouble(data[1]),
                        data[2],
                        data[3]
                );

                System.out.println(expense);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("❌ Error reading file!");
        }
    }
}
