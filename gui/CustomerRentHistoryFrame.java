package gui;

import api.DataManager;
import api.Rental;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CustomerRentHistoryFrame extends JFrame {

    public CustomerRentHistoryFrame(DataManager dm) {

        setTitle("Customer Rent History");
        setSize(500,400);
        setLocationRelativeTo(null);

        JTextField vatField = new JTextField();
        JButton searchBtn = new JButton("Search");

        DefaultListModel<Rental> model = new DefaultListModel<>();
        JList<Rental> list = new JList<>(model);

        searchBtn.addActionListener(e -> {
            model.clear();
            List<Rental> rentals = dm.getRentalsByCustomerVat(vatField.getText());
            for (Rental r : rentals) {
                model.addElement(r);
            }
        });

        setLayout(new BorderLayout());
        add(vatField, BorderLayout.NORTH);
        add(new JScrollPane(list), BorderLayout.CENTER);
        add(searchBtn, BorderLayout.SOUTH);

        setVisible(true);
    }
}
