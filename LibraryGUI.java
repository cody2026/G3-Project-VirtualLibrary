/**
 * Team Name: G3
 * Project Name: Virtual Library Management System
 * Author: Cody Nguyen
 * Date:  04/07/2026
 * Class: LibraryGUI
 * Description: Provide a graphical interface for interacting with the library system.
 * Allows users to add books/users, checkout/return books, and view data.
 * Create: window, input fields, buttons, output area.
 * Connect GUI actions to Library methods: add user, add book, checkout/return, search, display data.
 */

package team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibraryGUI extends JFrame implements ActionListener {
    
    // attributes
    private JTextField userIdField;
    private JTextField userNameField;
    private JTextField bookIdField;
    private JTextField bookTitleField;
    private JTextField bookAuthorField;
    private JTextArea outputArea;

    private JButton addUserButton;
    private JButton addBookButton;
    private JButton checkoutButton;
    private JButton returnButton;
    private JButton showBooksButton;
    private JButton showUsersButton;
    private JButton searchButton;
    private JButton showAvailableButton;

    
    // constructor builds the GUI layout
    public LibraryGUI() {
        library = new Library();
        
    }
    
    // add sample data
    private void addSampleData() {
        
    }
    
    // handles button clicks
    public void actionPerformed() {
        
    }
    
    public static void main(String[] args) {
        
    }
}
