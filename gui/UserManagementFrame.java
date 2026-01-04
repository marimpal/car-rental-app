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

    // Αναφορα στο DataManager για προσβαση σε ολες τις λειτουργιες
    private final DataManager dm;

    public UserManagementFrame(DataManager dm) {
        this.dm = dm;

        // Βασικες ρυθμισεις του παραθυρου διαχειρισης χρηστων
        setTitle("User Management");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel με grid για κουμπια
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Κουμπια λειτουργιων
        JButton viewUsersBtn = new JButton("View Users");
        JButton deleteUserBtn = new JButton("Delete User");
        JButton backBtn = new JButton("Back");

        // Προσθηκη των κουμπιων στο panel
        panel.add(viewUsersBtn);
        panel.add(deleteUserBtn);
        panel.add(backBtn);

        viewUsersBtn.addActionListener(e -> {
            // Ληψη της λιστας ολων των χρηστων
            List<User> users = dm.getAllUsers();

            if (users.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Δεν υπαρχουν χρηστες");
                return;
            }

            // Δημιουργια μηνυματος για εμφανιση ολων των χρηστων
            StringBuilder sb = new StringBuilder();
            for (User u : users) {
                sb.append("Ονομα: ").append(u.getName()).append("\n")
                        .append("Επωνυμο: ").append(u.getSurname()).append("\n")
                        .append("Username: ").append(u.getUsername()).append("\n")
                        .append("Email: ").append(u.getEmail()).append("\n")
                        .append("----------------------------\n");
            }

            // Δειχνει το παραθυρο με την λιστα χρηστων
            JOptionPane.showMessageDialog(
                    this,
                    sb.toString(),
                    "Λιστα Χρηστων",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        deleteUserBtn.addActionListener(e -> {
            // Εισαγωγη του username για διαγραφη
            String username = JOptionPane.showInputDialog(
                    this,
                    "Δωσε το username του χρηστη προς διαγραφη:"
            );

            if (username == null || username.isEmpty()) return;

            // Διαγραφη του χρηστη αν υπαρχει στη λιστα
            boolean removed = dm.getAllUsers()
                    .removeIf(u -> u.getUsername().equals(username));

            if (removed) {
                dm.saveData(); // Αποθηκευει της αλλαγες
                JOptionPane.showMessageDialog(this, "Ο χρηστης διαγραφηκε επιτυχως");
            } else {
                JOptionPane.showMessageDialog(this, "Ο χρηστης δεν βρεθηκε");
            }
        });

        // Κουμπι επιστροφης για κλεισιμο παραθυρου
        backBtn.addActionListener(e -> dispose());

        // Προσθετει το panel στο frame
        add(panel);

        setVisible(true);
    }
}
