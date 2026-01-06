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
        setSize(400,400);
        setLocationRelativeTo(null);

        JTextField brandField = new JTextField(car.getBrand());
        JTextField modelField = new JTextField(car.getModel());
        JTextField typeField = new JTextField(car.getType());
        JTextField yearField = new JTextField(String.valueOf(car.getYear()));
        JTextField colorField = new JTextField(car.getColor());
        JTextField statusField = new JTextField(car.getStatus());

        JButton saveBtn = new JButton("Save");

        saveBtn.addActionListener(e -> {
            try {
                Car updated = new Car(
                        car.getId(),
                        car.getLicensePlate(),
                        brandField.getText(),
                        modelField.getText(),
                        typeField.getText(),
                        Integer.parseInt(yearField.getText()),
                        colorField.getText(),
                        statusField.getText()
                );

                dm.updateCar(updated);
                JOptionPane.showMessageDialog(this, "Car updated successfully");
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        setLayout(new GridLayout(0,2,10,10));
        add(new JLabel("Brand")); add(brandField);
        add(new JLabel("Model")); add(modelField);
        add(new JLabel("Type")); add(typeField);
        add(new JLabel("Year")); add(yearField);
        add(new JLabel("Color")); add(colorField);
        add(new JLabel("Status")); add(statusField);
        add(new JLabel()); add(saveBtn);

        setVisible(true);
    }
}
