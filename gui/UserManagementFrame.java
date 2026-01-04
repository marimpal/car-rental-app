/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 */
package gui;

import api.DataManager;
import api.User;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UserManagementFrame extends JFrame {

    private final DataManager dm;

    public UserManagementFrame(DataManager dm) {
        this.dm = dm;

        setTitle("User Management");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton viewUsersBtn = new JButton("View Users");
        JButton deleteUserBtn = new JButton("Delete User");
        JButton backBtn = new JButton("Back");

        panel.add(viewUsersBtn);
        panel.add(deleteUserBtn);
        panel.add(backBtn);

        /* ===== View Users ===== */
        viewUsersBtn.addActionListener(e -> {
            List<User> users = dm.getAllUsers();

            if (users.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Δεν υπάρχουν χρήστες");
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (User u : users) {
                sb.append("Όνομα: ").append(u.getName()).append("\n")
                        .append("Επώνυμο: ").append(u.getSurname()).append("\n")
                        .append("Username: ").append(u.getUsername()).append("\n")
                        .append("Email: ").append(u.getEmail()).append("\n")
                        .append("----------------------------\n");
            }

            JOptionPane.showMessageDialog(
                    this,
                    sb.toString(),
                    "Λίστα Χρηστών",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        deleteUserBtn.addActionListener(e -> {
            String username = JOptionPane.showInputDialog(
                    this,
                    "Δώσε το username του χρήστη προς διαγραφή:"
            );

            if (username == null || username.isEmpty()) return;

            boolean removed = dm.getAllUsers()
                    .removeIf(u -> u.getUsername().equals(username));

            if (removed) {
                dm.saveData();
                JOptionPane.showMessageDialog(this, "Ο χρήστης διαγράφηκε επιτυχώς");
            } else {
                JOptionPane.showMessageDialog(this, "Ο χρήστης δεν βρέθηκε");
            }
        });

        backBtn.addActionListener(e -> dispose());

        add(panel);
        setVisible(true);
    }
}
