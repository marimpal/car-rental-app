package gui;

import api.Car;
import api.DataManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SearchCarFrame extends JFrame {

    public SearchCarFrame(DataManager dm) {

        setTitle("Search Car");
        setSize(500,400);
        setLocationRelativeTo(null);

        JTextField searchField = new JTextField();
        JButton searchBtn = new JButton("Search");
        JButton editBtn = new JButton("Edit Selected");

        DefaultListModel<Car> model = new DefaultListModel<>();
        JList<Car> list = new JList<>(model);

        searchBtn.addActionListener(e -> {
            model.clear();
            List<Car> results = dm.searchCar(searchField.getText());
            for (Car c : results) {
                model.addElement(c);
            }
        });

        editBtn.addActionListener(e -> {
            Car selected = list.getSelectedValue();
            if (selected != null) {
                new EditCarFrame(dm, selected);
            }
        });

        JPanel top = new JPanel(new BorderLayout());
        top.add(searchField, BorderLayout.CENTER);
        top.add(searchBtn, BorderLayout.EAST);

        JPanel bottom = new JPanel();
        bottom.add(editBtn);

        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(list), BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }
}
