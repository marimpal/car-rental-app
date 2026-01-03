package api.gui;

import javax.swing.*;

public class CustomerMenuFrame extends JFrame {

    public CustomerMenuFrame() {
        setTitle("Customer Menu");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Customer Menu", SwingConstants.CENTER));
        setVisible(true);
    }
}
