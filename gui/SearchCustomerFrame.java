/**
 * @author Παναγιώτα Πατεράκη
 *  @since 2025-12-17
 * Παράθυρο αναζήτησης πελάτη
 */
package gui;

import api.Customer;
import api.DataManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SearchCustomerFrame extends JFrame {

    // Αναφορά στο DataManager
    private final DataManager dm;

    public SearchCustomerFrame(DataManager dm) {
        this.dm = dm;

        // Ρυθμίσεις παραθύρου
        setTitle("Search Customer");
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Panel για τα στοιχεία αναζήτησης
        JPanel topPanel = new JPanel();

        JTextField searchField = new JTextField(15);
        JButton searchBtn = new JButton("Search");

        // Λίστα αποτελεσμάτων
        JList<Customer> resultList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(resultList);

        topPanel.add(new JLabel("Search:"));
        topPanel.add(searchField);
        topPanel.add(searchBtn);

        // Ενέργεια κουμπιού Search
        searchBtn.addActionListener(e -> {
            String keyword = searchField.getText();
            List<Customer> results = dm.searchCustomers(keyword);
            resultList.setListData(results.toArray(new Customer[0]));
        });

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
