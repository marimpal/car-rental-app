package api.gui;

import api.DataManager;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class RentCarFrame extends JFrame {
    private final DataManager dm;

    public RentCarFrame(DataManager dm) {
        this.dm = dm;
        setTitle("Rent Car");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel p = new JPanel(new GridLayout(5,2,4,4));
        JTextField carId = new JTextField();
        JTextField customerVat = new JTextField();
        JTextField start = new JTextField("YYYY-MM-DD");
        JTextField end = new JTextField("YYYY-MM-DD");
        JButton rentBtn = new JButton("Rent");

        p.add(new JLabel("Car ID:")); p.add(carId);
        p.add(new JLabel("Customer VAT:")); p.add(customerVat);
        p.add(new JLabel("Start date:")); p.add(start);
        p.add(new JLabel("End date:")); p.add(end);
        p.add(new JLabel()); p.add(rentBtn);

        add(p);

        rentBtn.addActionListener(e -> {
            try {
                LocalDate s = LocalDate.parse(start.getText().trim());
                LocalDate en = LocalDate.parse(end.getText().trim());
                dm.rentCar(carId.getText().trim(), customerVat.getText().trim(), s, en);
                JOptionPane.showMessageDialog(this,"Rent created");
                dispose();
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this,"Invalid date format. Use YYYY-MM-DD");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}

