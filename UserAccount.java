// Project: Virtual Library
// Author: Kyle Pickett
// Date: April 14, 2026
// This class manages user accounts for a virtual library, tracking borrowed books and eligibility to borrow more books.

package team;

import java.util.ArrayList;

public class UserAccount {

    // UserAccount attributes
    private String userId;
    private String name;
    private ArrayList<Book> borrowedBooks;

    // Parameterized constructor
    public UserAccount(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }
     // Default constructor
    public UserAccount() {
        this.userId = "";
        this.name = "";
        this.borrowedBooks = new ArrayList<>();
    }

    // Method stub for adding a book to borrowedBooks
    public void borrowBook(Book book) {
        
    }
    
    // Method stub for removing a book from borrowedBooks
    public void returnBook(Book book) {
        
    }
    
    // Method stub to verify user is eligible to borrow based on a 5 book limit
    public boolean canBorrowMore() {
        
        return true;
    }
    
    // Method stub to print the list of borrowed books
    public void displayBorrowedBooks() {
        
    }

    // Getter methods to return values of userId, name, and borrowedBooks
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}