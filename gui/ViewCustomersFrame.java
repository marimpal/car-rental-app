/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 */
package gui;

import api.Customer;
import api.DataManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ViewCustomersFrame extends JFrame {

    // Ο DataManager που παρέχει δεδομένα και λειτουργίες αποθήκευσης
    private final DataManager dm;

    // Το μοντέλο της λίστας ώστε να ειναι ευκολη η ανανεώση
    private final DefaultListModel<Customer> model;

    public ViewCustomersFrame(DataManager dm) {
        this.dm = dm;

        // Βασικές ρυθμίσεις παραθύρου
        setTitle("View Customers");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Το μοντέλο και η JList που θα εμφανίσει τους πελάτες
        model = new DefaultListModel<>();
        JList<Customer> customerList = new JList<>(model);

        // Custom renderer για να δείχνουμε "VAT - FullName" αντί για toString()
        customerList.setCellRenderer((list, value, index, isSelected, cellHasFocus) -> {
            JLabel lbl = (JLabel) new DefaultListCellRenderer()
                    .getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value != null) {
                // Εμφάνιση σε ευανάγνωστη μορφή: "VAT - FullName"
                lbl.setText(value.getVatNumber() + " - " + value.getFullName());
            }
            return lbl;
        });

        // Φόρτωση αρχικών δεδομένων στη λίστα
        refreshList();

        // Κουμπί για επεξεργασία του επιλεγμένου πελάτη
        JButton editBtn = new JButton("Edit Selected Customer");
        editBtn.addActionListener(e -> {
            Customer selected = customerList.getSelectedValue();
            if (selected != null) {
                // Δημιουργούμε το EditCustomerFrame και προσθέτουμε WindowListener
                // ώστε όταν κλείσει να ανανεώσουμε τη λίστα (refresh).
                EditCustomerFrame edit = new EditCustomerFrame(dm, selected);
                // Προσθήκη listener για να ξαναφορτώσουμε μετά την επεξεργασία
                edit.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent we) {
                        // Όταν το παράθυρο επεξεργασίας κλείσει, ανανεώνουμε τη λίστα
                        refreshList();
                    }
                });
            } else {
                JOptionPane.showMessageDialog(this, "Select a customer first");
            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(customerList), BorderLayout.CENTER);
        add(editBtn, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * Φορτώνει τους πελάτες από τον DataManager και γεμίζει το DefaultListModel.
     * Χρησιμοποιείται στην αρχική φόρτωση και όταν θέλουμε refresh μετά από edit.
     */
    private void refreshList() {
        model.clear();
        List<Customer> customers = dm.getAllCustomers();
        if (customers != null) {
            for (Customer c : customers) {
                model.addElement(c);
            }
        }
    }
}
