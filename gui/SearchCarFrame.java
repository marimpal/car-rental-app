package gui;
import api.DataManager;
import api.Car;

import javax.swing.*;
import java.awt.*;
import java.util.List;
public class SearchCarFrame extends JFrame {

    private final DataManager dm;

    public SearchCarFrame(DataManager dm) {
        this.dm = dm;

        setTitle("Search Car");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextField searchField = new JTextField(20);
        JButton searchBtn = new JButton("Search");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        searchBtn.addActionListener(e -> {
            var results = dm.searchCar(searchField.getText());
            resultArea.setText("");
            for (var c : results) {
                resultArea.append(c.toString() + "\n");
            }
        });

        JPanel top = new JPanel();
        top.add(new JLabel("Search:"));
        top.add(searchField);
        top.add(searchBtn);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        setVisible(true);
    }
}
