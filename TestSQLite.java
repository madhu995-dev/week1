Project: Expense Manager + Math Quiz
Intern: Gaddam Madhu
Batch: Virtunexa Internship [MAY-2025]

How to Run:
1. Make sure Java is installed.
2. Open CMD and navigate to src folder.
3. Compile: 
   javac -cp ".;../lib/sqlite-jdbc-3.46.1.jar" Main.java expense/*.java mathquiz/*.java
4. Run:
   java -cp ".;../lib/sqlite-jdbc-3.46.1.jar" Main

Features:
- Start Math Quiz (5 random questions)
- Add/View/Delete Expenses with SQLite storage

Dependencies:
- SQLite JDBC driver (in /lib folder)
