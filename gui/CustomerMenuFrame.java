/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 */
package gui;
import javax.swing.*;

import api.DataManager;

public class CustomerMenuFrame extends JFrame {

    private DataManager dataManager;

    public CustomerMenuFrame(DataManager dataManager) {
        this.dataManager = dataManager;

        setTitle("Customer Menu");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Customer Menu", SwingConstants.CENTER));
        setVisible(true);
    }
}
