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
    private final DataManager dm;

    public SearchCustomerFrame(DataManager dm) {
        this.dm = dm;
        setTitle("Search Customer");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel top = new JPanel(new FlowLayout());
        JTextField q = new JTextField(20);
        JButton search = new JButton("Search");
        top.add(new JLabel("Query (AFM/name/phone/email):"));
        top.add(q);
        top.add(search);
        add(top, BorderLayout.NORTH);

        JTable table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        search.addActionListener(e -> {
            List<Customer> res = dm.searchCustomer(q.getText().trim());
            String[] cols = {"VAT","FullName","Email","Phone"};
            Object[][] data = new Object[res.size()][cols.length];
            for (int i=0;i<res.size();i++) {
                Customer c = res.get(i);
                data[i] = new Object[] {c.getVatNumber(), c.getFullName(), c.getEmail(), c.getPhoneNumber()};
            }
            table.setModel(new javax.swing.table.DefaultTableModel(data, cols));
        });

        setVisible(true);
    }
}
