/**
 * @author Παναγιώτα Πατεράκη
 *  @since 2025-12-17
 * Παράθυρο επεξεργασίας αυτοκινήτου
 * Δέχεται συγκεκριμένο αντικείμενο Car
 */
package gui;

import api.Car;
import api.DataManager;

import javax.swing.*;
import java.awt.*;

public class EditCarFrame extends JFrame {

    private final DataManager dm;
    private final Car car;

    public EditCarFrame(DataManager dm, Car car) {
        this.dm = dm;
        this.car = car;

        setTitle("Edit Car");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextField brandField = new JTextField(car.getBrand());
        JTextField modelField = new JTextField(car.getModel());
        JTextField colorField = new JTextField(car.getColor());
        JTextField statusField = new JTextField(car.getStatus());

        JButton saveBtn = new JButton("Save");

        saveBtn.addActionListener(e -> {
            car.setBrand(brandField.getText());
            car.setModel(modelField.getText());
            car.setColor(colorField.getText());
            car.setStatus(statusField.getText());

            dm.toString();
            JOptionPane.showMessageDialog(this, "Car updated successfully");
            dispose();
        });

        setLayout(new GridLayout(0, 2, 8, 8));
        add(new JLabel("Brand:"));
        add(brandField);
        add(new JLabel("Model:"));
        add(modelField);
        add(new JLabel("Color:"));
        add(colorField);
        add(new JLabel("Status:"));
        add(statusField);
        add(new JLabel());
        add(saveBtn);

        setVisible(true);
    }
}
