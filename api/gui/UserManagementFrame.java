package api.gui;

import javax.swing.*;

public class UserManagementFrame extends JFrame {

    public UserManagementFrame() {
        setTitle("User Management");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("User Management Screen", SwingConstants.CENTER));
        setVisible(true);
    }
}
