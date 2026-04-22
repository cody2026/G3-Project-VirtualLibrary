/**
 * Team Name: G3
 * Project Name: Virtual Library Management System
 * Author: Cody Nguyen
 * Date: 04/11/2026
 * Class: LibraryGUI
 * Description:
 * Provides a graphical interface for interacting with the library system.
 * Allows users to add books/users, check out/return books, search by title,
 * and display library data.
 */

package team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LibraryGUI extends JFrame implements ActionListener {
    private Library library;

    // Input fields
    private JTextField userIdField;
    private JTextField userNameField;
    private JTextField bookIdField;
    private JTextField bookTitleField;
    private JTextField bookAuthorField;

    // Output area
    private JTextArea outputArea;

    // Buttons
    private JButton addUserButton;
    private JButton addBookButton;
    private JButton checkoutButton;
    private JButton returnButton;
    private JButton showBooksButton;
    private JButton showUsersButton;
    private JButton searchButton;
    private JButton showAvailableButton;
    private JButton clearButton;

    /**
     * Constructor builds the GUI layout
     */
    public LibraryGUI() {
        library = new Library();

        setTitle("Virtual Library Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Main panel with padding
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(mainPanel);

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 8, 8));

        inputPanel.add(new JLabel("User ID:"));
        userIdField = new JTextField();
        inputPanel.add(userIdField);

        inputPanel.add(new JLabel("User Name:"));
        userNameField = new JTextField();
        inputPanel.add(userNameField);

        inputPanel.add(new JLabel("Book ID:"));
        bookIdField = new JTextField();
        inputPanel.add(bookIdField);

        inputPanel.add(new JLabel("Book Title:"));
        bookTitleField = new JTextField();
        inputPanel.add(bookTitleField);

        inputPanel.add(new JLabel("Book Author:"));
        bookAuthorField = new JTextField();
        inputPanel.add(bookAuthorField);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(3, 3, 8, 8));

        addUserButton = new JButton("Add User");
        addBookButton = new JButton("Add Book");
        checkoutButton = new JButton("Check Out Book");
        returnButton = new JButton("Return Book");
        showBooksButton = new JButton("Show All Books");
        showUsersButton = new JButton("Show All Users");
        searchButton = new JButton("Search by Title");
        showAvailableButton = new JButton("Show Available Books");
        clearButton = new JButton("Clear Fields");

        buttonPanel.add(addUserButton);
        buttonPanel.add(addBookButton);
        buttonPanel.add(checkoutButton);
        buttonPanel.add(returnButton);
        buttonPanel.add(showBooksButton);
        buttonPanel.add(showUsersButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(showAvailableButton);
        buttonPanel.add(clearButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Output area
        outputArea = new JTextArea(12, 50);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setMargin(new Insets(8, 8, 8, 8));

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Output"));
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        // Register listeners
        addUserButton.addActionListener(this);
        addBookButton.addActionListener(this);
        checkoutButton.addActionListener(this);
        returnButton.addActionListener(this);
        showBooksButton.addActionListener(this);
        showUsersButton.addActionListener(this);
        searchButton.addActionListener(this);
        showAvailableButton.addActionListener(this);
        clearButton.addActionListener(this);

        addSampleData();

        // Show startup message
        outputArea.setText("Welcome to the Virtual Library Management System.\n"
                + "Sample data has been loaded.\n\n"
                + "Try clicking 'Show All Books' or 'Show All Users'.");
    }

    /**
     * Adds some sample data for testing
     */
    private void addSampleData() {
        library.addUser(new UserAccount(1, "Alice"));
        library.addUser(new UserAccount(2, "Bob"));

        library.addBook(new Book(101, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(102, "1984", "George Orwell"));
        library.addBook(new Book(103, "To Kill a Mockingbird", "Harper Lee"));
    }

    /**
     * Clears all input fields
     */
    private void clearFields() {
        userIdField.setText("");
        userNameField.setText("");
        bookIdField.setText("");
        bookTitleField.setText("");
        bookAuthorField.setText("");
    }

    /**
     * Checks whether a text field is empty
     */
    private boolean isBlank(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    /**
     * Handles button clicks
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == addUserButton) {
                if (isBlank(userIdField) || isBlank(userNameField)) {
                    outputArea.setText("Please enter both User ID and User Name.");
                    return;
                }

                int userId = Integer.parseInt(userIdField.getText().trim());
                String userName = userNameField.getText().trim();

                library.addUser(new UserAccount(userId, userName));
                outputArea.setText("User added successfully:\nID: " + userId + "\nName: " + userName);

            } else if (e.getSource() == addBookButton) {
                if (isBlank(bookIdField) || isBlank(bookTitleField) || isBlank(bookAuthorField)) {
                    outputArea.setText("Please enter Book ID, Book Title, and Book Author.");
                    return;
                }

                int bookId = Integer.parseInt(bookIdField.getText().trim());
                String title = bookTitleField.getText().trim();
                String author = bookAuthorField.getText().trim();

                library.addBook(new Book(bookId, title, author));
                outputArea.setText("Book added successfully:\nID: " + bookId
                        + "\nTitle: " + title + "\nAuthor: " + author);

            } else if (e.getSource() == checkoutButton) {
                if (isBlank(userIdField) || isBlank(bookIdField)) {
                    outputArea.setText("Please enter both User ID and Book ID.");
                    return;
                }

                int userId = Integer.parseInt(userIdField.getText().trim());
                int bookId = Integer.parseInt(bookIdField.getText().trim());

                outputArea.setText(library.checkoutBook(userId, bookId));

            } else if (e.getSource() == returnButton) {
                if (isBlank(userIdField) || isBlank(bookIdField)) {
                    outputArea.setText("Please enter both User ID and Book ID.");
                    return;
                }

                int userId = Integer.parseInt(userIdField.getText().trim());
                int bookId = Integer.parseInt(bookIdField.getText().trim());

                outputArea.setText(library.returnBook(userId, bookId));

            } else if (e.getSource() == showBooksButton) {
                outputArea.setText(library.displayAllBooks());

            } else if (e.getSource() == showUsersButton) {
                outputArea.setText(library.displayAllUsers());

            } else if (e.getSource() == searchButton) {
                if (isBlank(bookTitleField)) {
                    outputArea.setText("Please enter a book title to search.");
                    return;
                }

                String title = bookTitleField.getText().trim();
                ArrayList<Book> results = library.searchBooksByTitle(title);

                if (results.isEmpty()) {
                    outputArea.setText("No books found with that title.");
                } else {
                    StringBuilder resultText = new StringBuilder("Search Results:\n\n");
                    for (Book book : results) {
                        resultText.append(book).append("\n");
                    }
                    outputArea.setText(resultText.toString());
                }

            } else if (e.getSource() == showAvailableButton) {
                outputArea.setText(library.displayAvailableBooks());

            } else if (e.getSource() == clearButton) {
                clearFields();
                outputArea.setText("Input fields cleared.");
            }

        } catch (NumberFormatException ex) {
            outputArea.setText("Please enter valid numeric values for User ID and Book ID.");
        } catch (Exception ex) {
            outputArea.setText("An error occurred: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LibraryGUI gui = new LibraryGUI();
            gui.setVisible(true);
        });
    }
}

/**
 * I used several tutorials from YouTube, 
 * mainly to learn how to create a GUI in Java, 
 * and this is just a portion of them.
 * https://www.youtube.com/watch?v=5o3fMLPY7qY
 * https://www.youtube.com/watch?v=00-6riPEUN8
 * https://www.youtube.com/watch?v=r5oasVxC8Ko
 * https://www.youtube.com/watch?v=iE8tZ0hn2Ws
 * https://www.youtube.com/watch?v=rWCnZKF-U3Q
 * https://www.youtube.com/watch?v=Kmgo00avvEw
 * https://www.youtube.com/watch?v=r8Qiz9Bn1Ag
 * 
 */