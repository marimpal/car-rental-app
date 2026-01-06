/**
 * @author Παναγιώτα Πατεράκη
 * @since 2025-12-17
 * Παράθυρο επεξεργασίας πελάτη
 */
package gui;

import api.Customer;
import api.DataManager;

import javax.swing.*;
import java.awt.*;

public class EditCustomerFrame extends JFrame {

    // Αναφορά στο DataManager
    private final DataManager dm;

    // Ο πελάτης που επεξεργαζόμαστε
    private final Customer customer;

    public EditCustomerFrame(DataManager dm, Customer customer) {
        this.dm = dm;
        this.customer = customer;

        setTitle("Edit Customer");
        setSize(300, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

        // Πεδία με αρχικά στοιχεία πελάτη
        JTextField nameField = new JTextField(customer.getFullName());
        JTextField phoneField = new JTextField(customer.getPhoneNumber());

        JButton saveBtn = new JButton("Save");

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Phone:"));
        panel.add(phoneField);
        panel.add(new JLabel());
        panel.add(saveBtn);

        // Αποθήκευση αλλαγών
        saveBtn.addActionListener(e -> {

            customer.setFullName(nameField.getText());
            customer.setPhoneNumber(phoneField.getText());

            try {
                dm.updateCustomer(customer);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            JOptionPane.showMessageDialog(this,
                    "Customer updated successfully");

            dispose();
        });

        add(panel);
        setVisible(true);
    }
}
