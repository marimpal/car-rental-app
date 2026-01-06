/**
 * Κεντρικό μενού της εφαρμογής.
 * Από εδώ ο χρήστης έχει πρόσβαση σε όλες τις βασικές λειτουργίες.
 *
 * @author Παναγιώτα Πατεράκη
 * @since 2025-12-17
 */

package gui;

import api.DataManager;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {

    // Αντικείμενο DataManager για επικοινωνία GUI με API
    private final DataManager dm;

    public MainMenuFrame(DataManager dm) {
        this.dm = dm;

        // Ρυθμίσεις παραθύρου
        setTitle("Main Menu");
        setSize(400, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel με κάθετη διάταξη κουμπιών
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));

        // Κουμπιά λειτουργιών αυτοκινήτων
        JButton addCarBtn = new JButton("Add Car");
        JButton viewCarsBtn = new JButton("View Cars");
        JButton searchCarBtn = new JButton("Search Car");
        JButton carRentHistoryBtn = new JButton("Car Rent History");

        // Κουμπιά λειτουργιών πελατών
        JButton addCustomerBtn = new JButton("Add Customer");
        JButton searchCustomerBtn = new JButton("Search Customer");
        JButton customerRentHistoryBtn = new JButton("Customer Rent History");

        // Κουμπιά ενοικίασης
        JButton rentCarBtn = new JButton("Rent Car");
        JButton returnCarBtn = new JButton("Return Car");

        // Διαχείριση χρηστών
        JButton userManagementBtn = new JButton("User Management");
        JButton logoutBtn = new JButton("Logout");

        // Προσθήκη κουμπιών στο panel
        panel.add(addCarBtn);
        panel.add(viewCarsBtn);
        panel.add(searchCarBtn);
        panel.add(carRentHistoryBtn);

        panel.add(addCustomerBtn);
        panel.add(searchCustomerBtn);
        panel.add(customerRentHistoryBtn);

        panel.add(rentCarBtn);
        panel.add(returnCarBtn);

        panel.add(userManagementBtn);
        panel.add(logoutBtn);

        add(panel);

        // Συνδέσεις κουμπιών με τα αντίστοιχα Frames
        addCarBtn.addActionListener(e -> new AddCarFrame(dm));
        viewCarsBtn.addActionListener(e -> new ViewCarsFrame(dm));
        searchCarBtn.addActionListener(e -> new SearchCarFrame(dm));
        carRentHistoryBtn.addActionListener(e -> new CarRentHistoryFrame(dm));

        addCustomerBtn.addActionListener(e -> new AddCustomerFrame(dm));
        searchCustomerBtn.addActionListener(e -> new SearchCustomerFrame(dm));
        customerRentHistoryBtn.addActionListener(e -> new CustomerRentHistoryFrame(dm));

        rentCarBtn.addActionListener(e -> new RentCarFrame(dm));
        returnCarBtn.addActionListener(e -> new ReturnCarFrame(dm));

        userManagementBtn.addActionListener(e -> new UserManagementFrame(dm));

        // Logout
        logoutBtn.addActionListener(e -> {
            dm.logout();
            dispose();
            new LoginFrame(dm);
        });

        setVisible(true);
    }
}
