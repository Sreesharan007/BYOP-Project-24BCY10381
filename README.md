# 💰 Student Expense Tracker (Java)

## 📌 Overview

The **Student Expense Tracker** is a simple Java console application that helps students manage and track their daily expenses. It uses file handling to store data, making it lightweight and easy to run without any database setup.

---

## 🎯 Problem Statement

Many students struggle to keep track of their daily spending, which can lead to poor financial management. This project provides a simple solution to record and view expenses efficiently.

---

## 🚀 Features

* ➕ Add new expenses
* 📄 View all recorded expenses
* 💾 Persistent storage using file handling
* 🧾 Simple and user-friendly console interface

---

## 🛠️ Technologies Used

* Java
* File Handling (BufferedReader, FileWriter)

---

## 📂 Project Structure

```
Student-Expense-Tracker/
│   ├── Main.java
│   ├── Expense.java
│   ├── ExpenseManager.java

```

---

## ▶️ How to Run the Project

### 1️⃣ Clone the Repository

```
git clone https://github.com/LeonPaul007/BYOP-Project-24BAI10045.git
```

### 2️⃣ Navigate to Project Folder

```
cd BYOP-Project-24BAI10045
```

### 3️⃣ Compile the Java Files

```
javac src/*.java
```

### 4️⃣ Run the Application

```
java -cp src Main
```

---

## 📸 Sample Output

```
=== Expense Tracker ===
1. Add Expense
2. View Expenses
3. Exit
Enter choice: 1

Enter Title: Lunch
Enter Amount: 120
Enter Category: Food
Enter Date (YYYY-MM-DD): 2026-03-29
Expense Added Successfully!
```

---

## 💾 Data Storage

All expenses are stored in:

```
data/expenses.txt
```

Example:

```
Lunch,120.0,Food,2026-03-29
Bus Ticket,50.0,Travel,2026-03-29
```

---

## 🧠 Concepts Used

* Object-Oriented Programming (OOP)
* Classes and Objects
* Encapsulation
* File Handling in Java

---

## ⚡ Future Enhancements

* 🔍 Search expenses by category
* ❌ Delete expenses
* 📊 Monthly expense summary
* 🎨 GUI version using Java Swing

---

## 👨‍💻 Author

Sreesharan
