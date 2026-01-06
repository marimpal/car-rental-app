package gui;

import api.DataManager;
import api.Rental;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CarRentHistoryFrame extends JFrame {

    public CarRentHistoryFrame(DataManager dm) {

        setTitle("Car Rent History");
        setSize(500,400);
        setLocationRelativeTo(null);

        JTextField carIdField = new JTextField();
        JButton searchBtn = new JButton("Search");

        DefaultListModel<Rental> model = new DefaultListModel<>();
        JList<Rental> list = new JList<>(model);

        searchBtn.addActionListener(e -> {
            model.clear();
            List<Rental> rentals = dm.getRentalsHistoryByCar(carIdField.getText());
            for (Rental r : rentals) {
                model.addElement(r);
            }
        });

        setLayout(new BorderLayout());
        add(carIdField, BorderLayout.NORTH);
        add(new JScrollPane(list), BorderLayout.CENTER);
        add(searchBtn, BorderLayout.SOUTH);

        setVisible(true);
    }
}
