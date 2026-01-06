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

    private final DataManager dm;
    private final Customer customer;

    public EditCustomerFrame(DataManager dm, Customer customer) {
        this.dm = dm;
        this.customer = customer;

        setTitle("Edit Customer");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextField vatField = new JTextField(customer.getVatNumber());
        vatField.setEditable(false);

        JTextField nameField = new JTextField(customer.getFullName());
        JTextField phoneField = new JTextField(customer.getPhoneNumber());
        JTextField emailField = new JTextField(customer.getEmail());

        JButton saveBtn = new JButton("Save");

        saveBtn.addActionListener(e -> {
            customer.setFullName(nameField.getText());
            customer.setPhoneNumber(phoneField.getText());
            customer.setEmail(emailField.getText());

            dm.updateCustomer(customer);
            JOptionPane.showMessageDialog(this, "Customer updated");
            dispose();
        });

        setLayout(new GridLayout(0, 2, 8, 8));
        add(new JLabel("VAT:"));
        add(vatField);
        add(new JLabel("Full Name:"));
        add(nameField);
        add(new JLabel("Phone:"));
        add(phoneField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel());
        add(saveBtn);

        setVisible(true);
    }
}
