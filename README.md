# G3-Project-VirtualLibrary
The Virtual Library Management System is a Java application that allows users to manage a collection of books and user accounts. The system enables users to check out and return books while enforcing a borrowing limit of up to 5 books per user.
The application includes a simple graphical user interface (GUI) that allows interaction with the system, as well as testing code to validate functionality.

Team members (Contributors): Theresa Lewis, Kyle Pickett, Indy Nguyen, Cody Nguyen

Book.java — Theresa Lewis
UserAccount.java — Kyle Pickett
Library.java — Indy Nguyen
LibraryGUI.java — Cody Nguyen
TestLibrary.java - Team

Book.java - stores bookID, title, author availability status.
UserAccount.java - stores userID, user name, list of checked-out books, max allowed books.
Library.java - main system controller that manages books and users. Stores collection of books, collection of users; add books and users; handle checkout and return logic; search books by title; disply available books and system data.
LibraryGUI.java - provides a graphical interface using Java Swing. Buttons for add user, add book, checkout, return, search; text fields for book title or userID; text area for results.
TestLibrary.java - contains test cases for validating system functionality: create sample users and books; check out books; try to exceed 5-book limit; return books; search books, print results.

How to Run the Program (two options)

Option 1: Run GUI
1. compile all .java files
2. run: LibraryGUI.java
3. the graphical interface will open

Option 2: Run Console Tests
1. compile all .java files
2. run: TestLibrary.java
3. output will be shown in the console

Interface Functionality

The GUI allows users to:
* enter user ID and name to create accounts
* enter book details to add new books
* check out books by entering user ID and book ID
* return books
* search books by title
* view all books and users
* view available (not checked out) books

Data Structures Used
* ArrayList<Book> to store books
* ArrayList<UserAccount> to store users
* ArrayList<Book> inside each user to track borrowed books

Features and Constraints
* each user can borrow up to 5 books
* a book cannot be checked out if it is already borrowed
* users must return books before borrowing more
* system handles invalid input and missing data

Test Cases
* please refer to "C211 - Team Project - GUI Test Cases.pdf" file.

Summary

This project demonstrates the use of object-oriented programming, data structures, and GUI development in Java. It provides a functional and interactive system for managing a virtual library while meeting all project requirements.
