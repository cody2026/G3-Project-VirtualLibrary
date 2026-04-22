/**
 * Team Name: G3
 * Project Name: Virtual Library Management System
 * Author: Cody Nguyen, Indy Nguyen, Theresa Lewis, Kyle Pickett
 * Date:  04/18/2026
 * Class: TestLibrary
 * Description: test the system.
 */

package team;

public class TestLibrary {
    public static void main(String[] args) {
        Library library = new Library();

        UserAccount user1 = new UserAccount(1, "Alice");
        UserAccount user2 = new UserAccount(2, "Bob");

        Book book1 = new Book(101, "The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book(102, "1984", "George Orwell");
        Book book3 = new Book(103, "To Kill a Mockingbird", "Harper Lee");
        Book book4 = new Book(104, "Moby Dick", "Herman Melville");
        Book book5 = new Book(105, "Pride and Prejudice", "Jane Austen");
        Book book6 = new Book(106, "The Hobbit", "J.R.R. Tolkien");

        library.addUser(user1);
        library.addUser(user2);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);

        System.out.println("=== ALL BOOKS ===");
        System.out.println(library.displayAllBooks());

        System.out.println("=== ALL USERS ===");
        System.out.println(library.displayAllUsers());

        System.out.println("=== CHECKOUT TESTS ===");
        System.out.println(library.checkoutBook(1, 101));
        System.out.println(library.checkoutBook(1, 102));
        System.out.println(library.checkoutBook(1, 103));
        System.out.println(library.checkoutBook(1, 104));
        System.out.println(library.checkoutBook(1, 105));

        // This should fail because max is 5 books
        System.out.println(library.checkoutBook(1, 106));

        System.out.println("=== USER BORROWED BOOKS ===");
        System.out.println(user1.displayBorrowedBooks());

        System.out.println("=== RETURN TEST ===");
        System.out.println(library.returnBook(1, 103));

        System.out.println("=== TRY CHECKOUT AGAIN AFTER RETURN ===");
        System.out.println(library.checkoutBook(1, 106));

        System.out.println("=== AVAILABLE BOOKS ===");
        System.out.println(library.displayAvailableBooks());

        System.out.println("=== SEARCH TEST ===");
        for (Book book : library.searchBooksByTitle("the")) {
            System.out.println(book);
        }
    }
}
