package api.gui;

import javax.swing.*;

public class SearchCustomerFrame extends JFrame {

    public SearchCustomerFrame() {
        setTitle("Search Customer");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Search Customer Screen", SwingConstants.CENTER));
        setVisible(true);
    }
}
