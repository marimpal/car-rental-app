/**
 * @author Παναγιώτα Πατεράκη
 *   @since 2025-12-17
 * Παράθυρο αναζήτησης αυτοκινήτου
 */
package gui;

import api.DataManager;
import api.Car;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SearchCarFrame extends JFrame {

    // Αναφορά στο DataManager
    private final DataManager dm;

    public SearchCarFrame(DataManager dm) {
        this.dm = dm;

        // Ρυθμίσεις παραθύρου
        setTitle("Search Car");
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Panel επάνω για το πεδίο αναζήτησης
        JPanel topPanel = new JPanel();

        JTextField searchField = new JTextField(15);
        JButton searchBtn = new JButton("Search");

        // Λίστα αποτελεσμάτων
        JList<Car> resultList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(resultList);

        // Προσθήκη στοιχείων στο πάνω panel
        topPanel.add(new JLabel("Search:"));
        topPanel.add(searchField);
        topPanel.add(searchBtn);

        // Ενέργεια αναζήτησης
        searchBtn.addActionListener(e -> {
            String keyword = searchField.getText();
            List<Car> results = dm.searchCar(keyword);
            resultList.setListData(results.toArray(new Car[0]));
        });

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
