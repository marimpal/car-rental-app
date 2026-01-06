/**
 * @author Παναγιώτα Πατεράκη
 * @since 2025-12-17
 * Επεξεργασία στοιχείων πελάτη.
 * Ο πελάτης περνιέται έτοιμος από το SearchCustomerFrame.
 */
package gui;

import api.Customer;
import api.DataManager;

import javax.swing.*;
import java.awt.*;

public class EditCustomerFrame extends JFrame {

    // Αναφορά στον DataManager για αποθήκευση αλλαγών
    private final DataManager dm;

    // Ο πελάτης που επεξεργαζόμαστε
    private final Customer customer;

    // Constructor που δέχεται τον DataManager και τον πελάτη
    public EditCustomerFrame(DataManager dm, Customer customer) {
        this.dm = dm;
        this.customer = customer;

        // Τίτλος παραθύρου
        setTitle("Edit Customer");

        // Μέγεθος παραθύρου
        setSize(400, 300);

        // Κεντράρισμα παραθύρου στην οθόνη
        setLocationRelativeTo(null);

        // Πεδίο ΦΠΑ (VAT) – δεν επιτρέπεται αλλαγή
        JTextField vatField = new JTextField(customer.getVatNumber());
        vatField.setEditable(false);

        // Πεδίο ονοματεπώνυμου
        JTextField nameField = new JTextField(customer.getFullName());

        // Πεδίο τηλεφώνου
        JTextField phoneField = new JTextField(customer.getPhoneNumber());

        // Πεδίο email
        JTextField emailField = new JTextField(customer.getEmail());

        // Κουμπί αποθήκευσης αλλαγών
        JButton saveBtn = new JButton("Save");

        // Listener για το κουμπί Save
        saveBtn.addActionListener(e -> {
            try {
                // Ενημέρωση στοιχείων πελάτη από τα πεδία εισαγωγής
                customer.setFullName(nameField.getText());
                customer.setPhoneNumber(phoneField.getText());
                customer.setEmail(emailField.getText());

                // Αποθήκευση αλλαγών μέσω του DataManager
                dm.updateCustomer(customer);

                // Εμφάνιση μηνύματος επιτυχίας
                JOptionPane.showMessageDialog(
                        this,
                        "Customer updated successfully"
                );

                // Κλείσιμο του παραθύρου επεξεργασίας
                dispose();

            } catch (Exception ex) {
                // Εμφάνιση μηνύματος σφάλματος αν κάτι πάει στραβά
                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // Ορισμός GridLayout (2 στήλες, κενά 8px)
        setLayout(new GridLayout(0, 2, 8, 8));

        // Ετικέτες και πεδία εισαγωγής
        add(new JLabel("VAT:"));
        add(vatField);

        add(new JLabel("Full Name:"));
        add(nameField);

        add(new JLabel("Phone:"));
        add(phoneField);

        add(new JLabel("Email:"));
        add(emailField);

        // Κενό κελί για σωστή στοίχιση
        add(new JLabel());

        // Προσθήκη κουμπιού Save
        add(saveBtn);

        // Εμφάνιση παραθύρου
        setVisible(true);
    }
}
