# 📦 Part Billing System (Java + SQLite)

## 📌 Project Overview

The **Part Billing System** is a Java Swing-based desktop application that allows users to:

- Search part numbers
- Automatically fetch part rates
- Store search history in SQLite database
- Maintain a clean and simple billing interface

This project demonstrates Java GUI development and database integration using JDBC.

---

## 🛠 Technologies Used

- Java (Core Java)
- Java Swing (GUI)
- SQLite Database
- JDBC
- Git & GitHub (Version Control)

---

## ⚙️ How It Works

1. User enters a **Part Number** in the text field.
2. When the user presses **Enter**, the system:
   - Checks if the part exists in the system.
   - Fetches the corresponding rate.
3. The rate is displayed automatically.
4. Every successful search is saved into the **SQLite database** (`search_history` table).
5. The database stores:
   - Part Number
   - Rate
   - Search Timestamp

---

## 🖥 Application Workflow


---

## 📊 Database Structure

### Table Name: `search_history`

| Column Name   | Type      | Description |
|---------------|----------|-------------|
| id            | INTEGER  | Primary Key (Auto Increment) |
| partno        | TEXT     | Part Number |
| rate          | REAL     | Part Rate |
| searched_at   | DATETIME | Search Time (Auto stored) |

---


Search history is automatically stored in SQLite database.

---

## 🚀 How to Run the Project

1. Clone the repository:

git clone https://github.com/yourusername/part-billing-system-java.git


2. Open the project in VS Code or any Java IDE.
3. Ensure SQLite JDBC driver is added.
4. Run:


---

## 🎯 Key Features

✔ Auto rate fetching  
✔ Database integration  
✔ Search history storage  
✔ Simple & user-friendly UI  
✔ Lightweight desktop application  

---

## 🔮 Future Improvements

- Login authentication system  
- Generate bill with multiple items  
- Export bill as PDF  
- Admin panel to add/edit parts  
- Search history viewer  
- Input validation & error handling  

---

## 👨‍💻 Author

Harikumar E  
Cybersecurity Student | Java Developer  

---

## 📌 License

This project is for educational purposes.


