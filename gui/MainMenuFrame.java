/**
 * Κεντρικό μενού της εφαρμογής
 * Από εδώ ο χρήστης έχει πρόσβαση σε όλες τις βασικές λειτουργίες
 *
 * @author Παναγιώτα Πατεράκη
 * @since 2025-12-17
 */
package gui;

import api.DataManager;
import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {

    // Αντικείμενο DataManager για επικοινωνία με τα δεδομένα της εφαρμογής
    private final DataManager dm;

    /**
     * Constructor του Main Menu
     * Δημιουργεί το βασικό παράθυρο με όλα τα κουμπιά
     */
    public MainMenuFrame(DataManager dm) {
        this.dm = dm;

        // Τίτλος παραθύρου
        setTitle("Main Menu");

        // Διαστάσεις παραθύρου
        setSize(400, 450);

        // Κεντράρισμα στην οθόνη
        setLocationRelativeTo(null);

        // Κλείσιμο εφαρμογής όταν κλείσει το παράθυρο
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel με κάθετη διάταξη κουμπιών
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));

        // Δημιουργία κουμπιών για τις βασικές λειτουργίες
        JButton addCarBtn = new JButton("Add Car");
        JButton viewCarsBtn = new JButton("View Cars");
        JButton searchCarBtn = new JButton("Search Car");

        JButton addCustomerBtn = new JButton("Add Customer");
        JButton searchCustomerBtn = new JButton("Search Customer");

        JButton logoutBtn = new JButton("Logout");

        // Προσθήκη των κουμπιών στο panel
        panel.add(addCarBtn);
        panel.add(viewCarsBtn);
        panel.add(searchCarBtn);
        panel.add(addCustomerBtn);
        panel.add(searchCustomerBtn);
        panel.add(logoutBtn);

        // Προσθήκη panel στο παράθυρο
        add(panel);

        // Άνοιγμα της νφόρμας προσθήκης αυτοκινήτου
        addCarBtn.addActionListener(e -> new AddCarFrame(dm));

        // Προβολή όλων των αυτοκινήτων
        // Από αυτό το παράθυρο γίνεται και η επεξεργασία (Edit)
        viewCarsBtn.addActionListener(e -> new ViewCarsFrame(dm));

        // Αναζήτηση αυτοκινήτου
        searchCarBtn.addActionListener(e -> new SearchCarFrame(dm));

        // Προσθήκη νέου πελάτη
        addCustomerBtn.addActionListener(e -> new AddCustomerFrame(dm));

        // Αναζήτηση πελάτη
        searchCustomerBtn.addActionListener(e -> new SearchCustomerFrame(dm));

        // Αποσύνδεση του χρήστη και επιστροφή στο Login
        logoutBtn.addActionListener(e -> {
            dm.logout();
            dispose();
            new LoginFrame(dm);
        });

        // Εμφάνιση παραθύρου
        setVisible(true);
    }
}

