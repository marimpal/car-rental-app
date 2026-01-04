package api.gui;

import api.DataManager;
import api.User;
import javax.swing.*;
import java.awt.*;

public class UserManagementFrame extends JFrame {

    private final DataManager dm;

    public UserManagementFrame(DataManager dm) {
        this.dm = dm;
        setTitle("User Management");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton addUserBtn = new JButton("Add User");
        JButton viewUsersBtn = new JButton("View Users");
        JButton deleteUserBtn = new JButton("Delete User");
        JButton backBtn = new JButton("Back");

        panel.add(addUserBtn);
        panel.add(viewUsersBtn);
        panel.add(deleteUserBtn);
        panel.add(backBtn);

        addUserBtn.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Add User – not implemented yet"));

        viewUsersBtn.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "View Users – not implemented yet"));

        deleteUserBtn.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Delete User – not implemented yet"));

        backBtn.addActionListener(e -> dispose());

        add(panel);
        setVisible(true);
    }
}
