/*
 * Name: Julio Pochet
 * Date: 07/18/2025
 * Module 10 Programming Assignment
 * Purpose: This program displays and updates fan records from the 'fans' table in the 'databasedb' database.
 */

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Pochet_FanApp extends JFrame {

    // GUI components
    private JTextField txtID, txtFirstName, txtLastName, txtFavoriteTeam;
    private JButton btnDisplay, btnUpdate;
    private Connection conn;

    public Pochet_FanApp() {
        setTitle("Fans Database App");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        // Add labels and text fields
        add(new JLabel("ID:"));
        txtID = new JTextField();
        add(txtID);

        add(new JLabel("First Name:"));
        txtFirstName = new JTextField();
        add(txtFirstName);

        add(new JLabel("Last Name:"));
        txtLastName = new JTextField();
        add(txtLastName);

        add(new JLabel("Favorite Team:"));
        txtFavoriteTeam = new JTextField();
        add(txtFavoriteTeam);

        // Add buttons
        btnDisplay = new JButton("Display");
        btnUpdate = new JButton("Update");
        add(btnDisplay);
        add(btnUpdate);

        // Connect to database and show a test popup
        connectToDatabase();

        // Actions for buttons
        btnDisplay.addActionListener(e -> displayRecord());
        btnUpdate.addActionListener(e -> updateRecord());
    }

    // Connect to the database
    private void connectToDatabase() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/databasedb", "student1", "pass");
            JOptionPane.showMessageDialog(this, "Connected to database successfully!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Connection failed: " + ex.getMessage());
        }
    }

    // Display record based on ID
    private void displayRecord() {
        try {
            String id = txtID.getText();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM fans WHERE ID = ?");
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                txtFirstName.setText(rs.getString("firstname"));
                txtLastName.setText(rs.getString("lastname"));
                txtFavoriteTeam.setText(rs.getString("favoriteteam"));
            } else {
                JOptionPane.showMessageDialog(this, "No record found for ID: " + id);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error displaying record: " + ex.getMessage());
        }
    }

    // Update record based on ID and new values
    private void updateRecord() {
        try {
            String id = txtID.getText();
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?");
            ps.setString(1, txtFirstName.getText());
            ps.setString(2, txtLastName.getText());
            ps.setString(3, txtFavoriteTeam.getText());
            ps.setInt(4, Integer.parseInt(id));

            int rows = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, rows + " record(s) updated.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error updating record: " + ex.getMessage());
        }
    }

    // Main method to start the app
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Pochet_FanApp().setVisible(true));
    }
}

/*
 * Testing Notes:
 * - Verified database connection (popup shows success).
 * - Tested Display button with valid and invalid IDs.
 * - Tested Update button by editing a record and confirming changes in
 * database.
 */