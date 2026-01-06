package gui;

import api.DataManager;
import api.Rental;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Προβολή ιστορικού ενοικιάσεων πελάτη
 *
 * @author Παναγιώτα Πατεράκη
 * @since 2025-12-18
 */
public class CustomerRentHistoryFrame extends JFrame {

    private final DataManager dm;

    public CustomerRentHistoryFrame(DataManager dm) {
        this.dm = dm;

        setTitle("Customer Rental History");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // ===== Πάνελ αναζήτησης =====
        JPanel topPanel = new JPanel(new FlowLayout());

        JLabel vatLabel = new JLabel("Customer VAT:");
        JTextField vatField = new JTextField(15);
        JButton searchBtn = new JButton("Search");

        topPanel.add(vatLabel);
        topPanel.add(vatField);
        topPanel.add(searchBtn);

        // ===== Περιοχή αποτελεσμάτων =====
        JTextArea resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsArea);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // ===== Λογική κουμπιού =====
        searchBtn.addActionListener(e -> {
            resultsArea.setText("");

            String vat = vatField.getText().trim();
            if (vat.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter customer VAT",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<Rental> rentals = dm.getAllRentals();
            boolean found = false;

            for (Rental r : rentals) {
                if (r.getCustomer().equals(vat)) {
                    resultsArea.append(
                            "Rental ID: " + r.getRentalId() + "\n" +
                                    "Car ID: " + r.getCarId() + "\n" +
                                    "From: " + r.getRentalDate() + "\n" +
                                    "To: " + r.getReturnDate() + "\n" +
                                    "Active: " + r.isActive() + "\n" +
                                    "-----------------------------\n"
                    );
                    found = true;
                }
            }

            if (!found) {
                resultsArea.setText("No rental history found for this customer.");
            }
        });

        setVisible(true);
    }
}
