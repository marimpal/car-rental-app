/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 */
package gui;

import javax.swing.*;
import api.DataManager;

public class CustomerMenuFrame extends JFrame {
    // Αναφορά στο DataManager για τον ελεγχο στοιχειων χρηστη
    private DataManager dataManager;

    public CustomerMenuFrame(DataManager dataManager) {
        this.dataManager = dataManager;

        // Ρυθμίσεις βασικών στοιχείων του παραθύρου
        setTitle("Customer Menu");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Εμφάνιση τής ετικέτας στο κέντρο του παραθύρου
        add(new JLabel("Customer Menu", SwingConstants.CENTER));

        setVisible(true);
    }
}

