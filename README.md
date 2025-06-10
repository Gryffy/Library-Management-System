# 📚 Library Management System (Java Console Application)

This is a Java-based Library Management System designed for educational use. It provides basic functionalities such as book management, user registration, book issuing, returning, fine calculation, and file persistence.

## 🧠 OOP Concepts Used

This project applies fundamental Object-Oriented Programming (OOP) principles in Java to ensure clean, modular, and maintainable code:

- **Classes & Objects**: Core entities like `Book`, `User`, and `LibrarySystem` are modeled as classes. Individual books and users are created as objects of these classes.

- **Encapsulation**: All class data members are marked as `private` and accessed via `public` getter and setter methods. This keeps data secure and prevents unauthorized access or modification.

- **Abstraction**: Users of the system interact with high-level methods (e.g., `addBook()`, `issueBook()`), which abstract away the internal logic like validation or file handling.

- **Extensibility (for future use)**: The system can be expanded using **inheritance** and **polymorphism**. For example, `Student` and `Teacher` classes could inherit from `User`, allowing role-specific functionality.



---

## 🚀 Features

- ✅ Add, view, and search books
- ✅ Register and view users
- ✅ Issue and return books
- ✅ Automatic fine calculation (₹5/day after 14 days)
- ✅ File storage for books and users
- ✅ Input validation and duplicate checks
- ✅ Clean and object-oriented code

---

## 🏗️ Technologies Used

- Java SE (Java Standard Edition)
- File I/O using `ObjectInputStream` / `ObjectOutputStream`
- Collections: `ArrayList`
- Console-based interaction

---

## 📂 Project Structure

LibraryManagementSystem/
├── Book.java
├── User.java
├── LibrarySystem.java
├── Main.java
├── books.txt # Auto-generated - stores book records
├── users.txt # Auto-generated - stores user records
├── README.md

`yaml`

---

## 🧪 How to Run

1. **Compile all `.java` files:**

   ```bash
   javac *.java

2. **Run the Program**

Java Main

## **Developed By**

Team - Code Runners


