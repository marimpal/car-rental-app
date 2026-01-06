/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 */
package gui;

import api.Customer;
import api.DataManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SearchCustomerFrame extends JFrame {

    // Αναφορά στο DataManager για προσβαση σε ολες τις λειτουργιες
    private final DataManager dm;

    public SearchCustomerFrame(DataManager dm) {
        this.dm = dm;

        // Βασικες ρυθμισεις του παραθυρου της αναζητησης πελατη
        setTitle("Search Customer");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Panel για το επάνω τμήμα με πεδίο και κουμπί αναζήτησης
        JPanel top = new JPanel(new FlowLayout());
        JTextField q = new JTextField(20);
        JButton search = new JButton("Search"); // Κουμπι για εκτέλεση της αναζήτησης
        top.add(new JLabel("Query (AFM/name/phone/email):"));
        top.add(q);
        top.add(search);
        add(top, BorderLayout.NORTH); // Προσθήκη panel στο πάνω μέρος του frame

        // Πίνακας για την εμφάνιση αποτελεσμάτων
        JTable table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER); // Προσθήκη scroll pane για πίνακα

        // Λειτουργία του κουμπιού αναζήτησης
        search.addActionListener(e -> {
            // Κλήση μεθόδου αναζήτησης στο DataManager
            List<Customer> res = dm.searchCustomer(q.getText().trim());

            // Ορισμός τωνστηλών του πίνακα
            String[] cols = {"VAT","FullName","Email","Phone"};

            // Προετοιμασία των δεδομένων για τον πίνακα
            Object[][] data = new Object[res.size()][cols.length];
            for (int i=0;i<res.size();i++) {
                Customer c = res.get(i);
                data[i] = new Object[] {c.getVatNumber(), c.getFullName(), c.getEmail(), c.getPhoneNumber()};
            }

            // Ενημέρωση μοντέλου του πίνακα με τα αποτελέσματα
            table.setModel(new javax.swing.table.DefaultTableModel(data, cols));
        });

        setVisible(true);
    }
}
