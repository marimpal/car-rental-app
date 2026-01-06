/**
 * @author Παναγιώτα Πατεράκη
 *  @since 2025-12-17
 * Αναζήτηση πελάτη με βάση ΑΦΜ.
 * Από εδώ ανοίγει το EditCustomerFrame.
 */
package gui;

import api.Customer;
import api.DataManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SearchCustomerFrame extends JFrame {

    /**
     * Frame αναζήτησης πελατών με οποιοδήποτε κριτήριο
     * (ΑΦΜ, όνομα ή τηλέφωνο).
     */
    public SearchCustomerFrame(DataManager dm) {

        // Ρυθμίσεις παραθύρου
        setTitle("Search Customer");
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Πεδίο όπου ο χρήστης γράφει το κριτήριο αναζήτησης
        JTextField searchField = new JTextField();

        // Κουμπί αναζήτησης
        JButton searchBtn = new JButton("Search");

        // Μοντέλο και λίστα για εμφάνιση αποτελεσμάτων
        DefaultListModel<Customer> model = new DefaultListModel<>();
        JList<Customer> customerList = new JList<>(model);

        /**
         * Όταν πατηθεί το κουμπί Search:
         * - καθαρίζω τα παλιά αποτελέσματα
         * - καλω τη searchCustomers του DataManager
         * - εμφανίζω τους πελάτες που βρέθηκαν
         */
        searchBtn.addActionListener(e -> {
            model.clear();

            List<Customer> results =
                    dm.searchCustomer(searchField.getText());

            for (Customer c : results) {
                model.addElement(c);
            }
        });

        // Layout του παραθύρου
        setLayout(new BorderLayout());
        add(searchField, BorderLayout.NORTH);
        add(new JScrollPane(customerList), BorderLayout.CENTER);
        add(searchBtn, BorderLayout.SOUTH);

        // Εμφάνιση παραθύρου
        setVisible(true);
    }
}
