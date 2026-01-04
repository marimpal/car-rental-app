package api.gui;

import api.DataManager;
import javax.swing.*;

public class LoginFrame extends JFrame {
    private final DataManager dm;

    public LoginFrame(DataManager dm) {
        this.dm = dm;
        setTitle("Login");
        setSize(350,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new java.awt.GridLayout(3,2,5,5));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginBtn = new JButton("Login");

        panel.add(new JLabel("Username:")); panel.add(usernameField);
        panel.add(new JLabel("Password:")); panel.add(passwordField);
        panel.add(new JLabel()); panel.add(loginBtn);
        add(panel);

        loginBtn.addActionListener(e -> {
            String u = usernameField.getText().trim();
            String p = new String(passwordField.getPassword());
            if (u.isEmpty() || p.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Συμπληρώστε username & password");
                return;
            }
            if (dm.login(u, p)) {
                dispose();
                new MainMenuFrame(dm);
            } else {
                JOptionPane.showMessageDialog(this, "Λάθος credentials", "Login error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
