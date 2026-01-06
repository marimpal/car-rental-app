package gui;

import api.Car;
import api.DataManager;

import javax.swing.*;
import java.awt.*;

/**
 * Επεξεργασία στοιχείων αυτοκινήτου
 *
 * @author Παναγιώτα Πατεράκη
 * @since 2025-12-18
 */
public class EditCarFrame extends JFrame {

    private final DataManager dm;
    private Car currentCar;

    public EditCarFrame(DataManager dm) {
        this.dm = dm;

        setTitle("Edit Car");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));

        // ===== Αναζήτηση =====
        JTextField searchField = new JTextField();
        JButton searchBtn = new JButton("Search");

        panel.add(new JLabel("Car ID or Plate:"));
        panel.add(searchField);
        panel.add(new JLabel());
        panel.add(searchBtn);

        // ===== Πεδία επεξεργασίας =====
        JTextField brandField = new JTextField();
        JTextField modelField = new JTextField();
        JTextField colorField = new JTextField();
        JTextField statusField = new JTextField();

        brandField.setEnabled(false);
        modelField.setEnabled(false);
        colorField.setEnabled(false);
        statusField.setEnabled(false);

        panel.add(new JLabel("Brand:"));
        panel.add(brandField);
        panel.add(new JLabel("Model:"));
        panel.add(modelField);
        panel.add(new JLabel("Color:"));
        panel.add(colorField);
        panel.add(new JLabel("Status:"));
        panel.add(statusField);

        JButton saveBtn = new JButton("Save Changes");
        saveBtn.setEnabled(false);

        panel.add(new JLabel());
        panel.add(saveBtn);

        add(panel);

        // ===== Αναζήτηση αυτοκινήτου =====
        searchBtn.addActionListener(e -> {
            String criteria = searchField.getText().trim();

            if (criteria.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter car ID or plate",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            currentCar = dm.getAllCars().stream()
                    .filter(c -> c.getId().equals(criteria)
                            || c.getLicensePlate().equals(criteria))
                    .findFirst()
                    .orElse(null);

            if (currentCar == null) {
                JOptionPane.showMessageDialog(this,
                        "Car not found",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            brandField.setText(currentCar.getBrand());
            modelField.setText(currentCar.getModel());
            colorField.setText(currentCar.getColor());
            statusField.setText(currentCar.getStatus());

            brandField.setEnabled(true);
            modelField.setEnabled(true);
            colorField.setEnabled(true);
            statusField.setEnabled(true);
            saveBtn.setEnabled(true);
        });

        // ===== Αποθήκευση αλλαγών =====
        saveBtn.addActionListener(e -> {
            try {
                currentCar.getBrand()(brandField.getText().trim());
                currentCar.getModel(modelField.getText().trim());
                currentCar.getColor(colorField.getText().trim());
                currentCar.setStatus(statusField.getText().trim());

                dm.saveData();

                JOptionPane.showMessageDialog(this,
                        "Car updated successfully");

                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
