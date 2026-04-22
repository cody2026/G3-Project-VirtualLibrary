// Project: Virtual Library
// Author: Kyle Pickett
// Date: April 14, 2026
// This class manages user accounts for a virtual library, tracking borrowed books and eligibility to borrow more books.

package team;

import java.util.ArrayList;

public class UserAccount {
    
    // UserAccount attributes
    private int userId;
    private String name;
    private ArrayList<Book> borrowedBooks;
    private final int MAX_BOOKS = 5;
    
    // Parameterized constructor
    public UserAccount(int userId, String name) {
        this.userId = userId;
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean canBorrowMore() {
        return borrowedBooks.size() < MAX_BOOKS;
    }

    public boolean borrowBook(Book book) {
        if (book == null || !canBorrowMore()) {
            return false;
        }

        borrowedBooks.add(book);
        return true;
    }

    public boolean returnBook(Book book) {
        return borrowedBooks.remove(book);
    }

    public int getBorrowedBookCount() {
        return borrowedBooks.size();
    }

    public String displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            return name + " has not borrowed any books.";
        }

        StringBuilder result = new StringBuilder();
        result.append("Books borrowed by ").append(name).append(":\n");

        for (Book book : borrowedBooks) {
            result.append(book).append("\n");
        }

        return result.toString();
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + ", Borrowed Books: " + borrowedBooks.size();
    }
}
