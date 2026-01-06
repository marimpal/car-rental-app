package gui;

import api.DataManager;
import api.Rental;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Προβολή ιστορικού ενοικιάσεων συγκεκριμένου αυτοκινήτου
 *
 * @author Παναγιώτα Πατεράκη
 * @since 2025-12-18
 */
public class CarRentHistoryFrame extends JFrame {

    private final DataManager dm;

    public CarRentHistoryFrame(DataManager dm) {
        this.dm = dm;

        setTitle("Car Rental History");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel topPanel = new JPanel(new FlowLayout());

        JLabel carIdLabel = new JLabel("Car ID:");
        JTextField carIdField = new JTextField(15);
        JButton searchBtn = new JButton("Search");

        topPanel.add(carIdLabel);
        topPanel.add(carIdField);
        topPanel.add(searchBtn);

        JTextArea resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsArea);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // ===== Λογική κουμπιού =====
        searchBtn.addActionListener(e -> {
            resultsArea.setText("");

            String carId = carIdField.getText().trim();
            if (carId.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a Car ID",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<Rental> rentals = dm.getAllRentals();
            boolean found = false;

            for (Rental r : rentals) {
                if (r.getCarId().equals(carId)) {
                    resultsArea.append(
                            "Rental ID: " + r.getRentalId() + "\n" +
                                    "Customer: " + r.getCustomer() + "\n" +
                                    "From: " + r.getRentalDate() + "\n" +
                                    "To: " + r.getReturnDate() + "\n" +
                                    "Active: " + r.isActive() + "\n" +
                                    "-----------------------------\n"
                    );
                    found = true;
                }
            }

            if (!found) {
                resultsArea.setText("No rental history found for this car.");
            }
        });

        setVisible(true);
    }
}
