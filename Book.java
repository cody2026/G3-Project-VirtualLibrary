package Team;
/**
* Team G3
* Project Library Management System
* Author Theresa Lewis
* Class Book
* Tracks books checked out
*/

public class Book {
	
    // Attributes
    private int bookId;
    private String title;
    private String author;
    private boolean checkedOut;

    // Constructor to initialize a new book object
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.checkedOut = false; 
    }

    // Getter methods to retrieve book details
    public int getBookId() { 
    	return bookId; 
    }
    public String getTitle() { 
       	return title; 
    }
    public String getAuthor() {
    	return author; 
    }
    public boolean isCheckedOut() {
        return checkedOut;
    }

    // Library Methods
    public void checkout() {
        if (!checkedOut) {
            checkedOut = true;
            System.out.println("The book '" + title + "' has been checked out.");
        } else {
            System.out.println("Sorry, '" + title + "' is already checked out.");
        }
    }

    public void returnBook() {
        if (checkedOut) {
            checkedOut = false;
            System.out.println("The book '" + title + "' has been returned.");
        } else {
            System.out.println("The book '" + title + "' was not checked out.");
        }
    }

    @Override
    public String toString() {
        String status = checkedOut ? "Checked Out" : "Available";
        return "Book ID: " + bookId + " | Title: " + title + 
               " | Author: " + author + " | Status: " + status;
    }
}
