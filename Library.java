/**
 * Team Name: G3
 * Project Name: Virtual Library Management System
 * Author: Indy Nguyen
 * Date:  04/10/2026
 * Class: Library
 * Description: Main controller class that manages books and users.
 * Handles all operations such as adding, searching, checkout, and return.
 */

package team;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<UserAccount> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(UserAccount user) {
        users.add(user);
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public UserAccount findUserById(int userId) {
        for (UserAccount user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<Book> searchBooksByTitle(String title) {
        ArrayList<Book> results = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }

        return results;
    }

    public String checkoutBook(int userId, int bookId) {
        UserAccount user = findUserById(userId);
        Book book = findBookById(bookId);

        if (user == null) {
            return "User not found.";
        }

        if (book == null) {
            return "Book not found.";
        }

        if (book.isCheckedOut()) {
            return "That book is already checked out.";
        }

        if (!user.canBorrowMore()) {
            return "User has reached the maximum limit of 5 books.";
        }
        
        if (book.isCheckedOut()) {
            return "That book is already checked out.";
        }

        boolean borrowed = user.borrowBook(book);
        
        if (borrowed) {
            book.checkout();
                     
            return user.getName() + " successfully checked out \"" + book.getTitle() + "\".";
        }

        return "Checkout failed.";
    }

    public String returnBook(int userId, int bookId) {
        UserAccount user = findUserById(userId);
        Book book = findBookById(bookId);

        if (user == null) {
            return "User not found.";
        }

        if (book == null) {
            return "Book not found.";
        }

        if (!book.isCheckedOut()) {
            return "That book is not currently checked out.";
        }

        boolean returned = user.returnBook(book);
        if (returned) {
            book.returnBook();
            return user.getName() + " successfully returned \"" + book.getTitle() + "\".";
        }

        return "This user did not borrow that book.";
    }

    public String displayAllBooks() {
        if (books.isEmpty()) {
            return "No books in the library.";
        }

        StringBuilder result = new StringBuilder("All Books:\n");
        for (Book book : books) {
            result.append(book).append("\n");
        }
        return result.toString();
    }

    public String displayAvailableBooks() {
        StringBuilder result = new StringBuilder("Available Books:\n");
        boolean found = false;

        for (Book book : books) {
            if (!book.isCheckedOut()) {
                result.append(book).append("\n");
                found = true;
            }
        }

        if (!found) {
            return "No available books.";
        }

        return result.toString();
    }

    public String displayAllUsers() {
        if (users.isEmpty()) {
            return "No users in the system.";
        }

        StringBuilder result = new StringBuilder("All Users:\n");
        for (UserAccount user : users) {
            result.append(user).append("\n");
        }
        return result.toString();
    }
}
