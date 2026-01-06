/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 */
package gui;

import api.DataManager;
import javax.swing.*;

public class LoginFrame extends JFrame {

    // Αναφορά στο DataManager για τον ελεγχο στοιχειων χρηστη
    private final DataManager dm;

    public LoginFrame(DataManager dm) {
        this.dm = dm;

        // Τιτλος και βασικο μεγεθος παραθυρου login
        setTitle("Login");
        setSize(350,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new java.awt.GridLayout(3,2,5,5));

        // Πεδιο εισαγωγης username
        JTextField usernameField = new JTextField();

        // Πεδιο εισαγωγης κωδικου που να κρυβει τους χαρακτηρες
        JPasswordField passwordField = new JPasswordField();

        // Κουμπι συνδεσης
        JButton loginBtn = new JButton("Login");

        // Προσθηκη στοιχειων στο panel
        panel.add(new JLabel("Username:")); panel.add(usernameField);
        panel.add(new JLabel("Password:")); panel.add(passwordField);
        panel.add(new JLabel()); panel.add(loginBtn);
        add(panel);

        loginBtn.addActionListener(e -> {

            // Διαβασμα στοιχειων απο τα πεδια
            String u = usernameField.getText().trim();
            String p = new String(passwordField.getPassword());

            // Ελεγχος αν καποιο πεδιο ειναι κενο
            if (u.isEmpty() || p.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Συμπληρωστε username & password");
                return;
            }

            // Ελεγχος στοιχειων μεσω DataManager
            if (dm.login(u, p)) {

                // Κλεισιμο παραθυρου login
                dispose();

                // Ανοιγμα του κεντρικου μενου
                new MainMenuFrame(dm);

            } else {
                // Μηνυμα λαθους σε περιπτωση αποτυχιας για συνδεση
                JOptionPane.showMessageDialog(
                        this,
                        "Λαθος credentials",
                        "Login error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        setVisible(true);
    }
}
