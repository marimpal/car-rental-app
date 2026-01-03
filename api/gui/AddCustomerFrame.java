package api.gui;

import javax.swing.*;

public class AddCustomerFrame extends JFrame {

    public AddCustomerFrame() {
        setTitle("Add Customer");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Add Customer Form", SwingConstants.CENTER));
        setVisible(true);
    }
}
