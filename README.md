# 🎓 Student Management System (JDBC)
A simple Java console-based project to perform CRUD (Create, Read, Update, Delete) operations on a student database using JDBC (Java Database Connectivity) with MySQL.  

---

## 🚀 Features
- ➕ Add Student  
- ✏️ Update Student  
- ❌ Delete Student  
- 📋 Display All Students  
- 🧩 Insert Multiple Students  
- 💾 Persistent MySQL Database  

---

## 🗂️ Folder Structure
StudentManagementJDBC/  
│  
├── src/  
│   ├── Main.java  
│   ├── Student.java  
│   └── StudentDAO.java  
│  
├── lib/  
│   └── mysql-connector-j-9.5.0.jar  
│  
├── bin/                # Compiled Java classes  
├── README.md  
└── .vscode/settings.json  

---

## ⚙️ Prerequisites
Before running the project, ensure you have the following installed:  
- ☕ Java JDK 8 or higher  
- 🗄️ MySQL Server  
- 🧩 VS Code or Eclipse IDE  
- 🔗 MySQL Connector JAR (placed in `/lib` folder)  

---

## 🧱 Database Setup
1. Open MySQL Command Line or Workbench.  
2. Create a database and table:  
CREATE DATABASE studentdb;  
USE studentdb;  
CREATE TABLE students (  
    id INT PRIMARY KEY AUTO_INCREMENT,  
    name VARCHAR(100),  
    age INT,  
    marks FLOAT  
);  

---

## 🖥️ Running the Project
**Step 1:** Compile the Code  
javac -cp ".;lib/mysql-connector-j-9.5.0.jar" -d bin src/*.java  

**Step 2:** Run the Application  
java -cp ".;lib/mysql-connector-j-9.5.0.jar;bin" Main  

💡 Use `:` instead of `;` in the classpath on macOS/Linux.  

---

## 🔑 JDBC Connection URL
private static final String URL = "jdbc:mysql://localhost:3306/studentdb";  
private static final String USER = "root";  
private static final String PASSWORD = "yourpassword";  

✅ Update username and password as per your MySQL setup.  

---

## 🧰 Example Output
###########################################  
1 : Add Student  
2 : Delete Student  
3 : Update Student  
4 : Enter Multiple Students  
5 : Show all Students  
6 : Exit Program  
Enter Your Choice: 5  
###########################################  
ID      Name        Age     Marks  
1       Tarun Teja   23      96.0  
2       Karimi       25      99.0  
3       Sri          45      87.0  
###########################################  

---

## 🐞 Common Issues
Error: java.sql.SQLException: No suitable driver found  
Cause: MySQL connector missing  
Solution: Add `.jar` file in `/lib` and include it in classpath  

Error: java.lang.IllegalStateException: Scanner closed  
Cause: Scanner closed prematurely  
Solution: Ensure the Scanner object is not closed before reuse  

Error: Access denied for user  
Cause: Invalid DB credentials  
Solution: Check username/password in `Main.java`  

---

## 💾 Creating a GitHub Repository
git init  
git add .  
git commit -m "Initial commit - Student Management JDBC project"  
git branch -M main  
git remote add origin https://github.com/<yourusername>/StudentManagementJDBC.git  
git push -u origin main  

---

## 🌟 Visuals & Animations
<p align="center">  
  <img src="https://raw.githubusercontent.com/Anmol-Baranwal/Cool-GIFs-For-GitHub/main/Anime%20Code%20Typing.gif" width="500" alt="Typing Animation"/>  
</p>  

---

## 🧑‍💻 Author
**Tarun Teja Karimi**  
📍 Polaki, Andhra Pradesh  
🎓 Graduated in May 2024  
💬 Passionate about Java, Databases, and Machine Learning  
🎵 Listens to *“Fear” by Mandatorily* every day  

---

## 📜 License
This project is licensed under the **MIT License** — feel free to use and modify.  

---

<p align="center">  
  ⭐ If you like this project, give it a star on GitHub! ⭐  
</p>
