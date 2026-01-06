/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 */
package gui;

import api.DataManager;
import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {

    // Αναφορά στο DataManager για προσβαση σε ολες τις λειτουργιες
    private final DataManager dm;

    public MainMenuFrame(DataManager dm) {
        this.dm = dm;

        // Βασικες ρυθμισεις του κεντρικου μενου
        setTitle("Main Menu");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel με καθετη διαταξη για τα κουμπια
        JPanel panel = new JPanel(new GridLayout(0,1,8,8));

        // Κουμπια για τις βασικες λειτουργιες της εφαρμογης
        JButton addCarBtn = new JButton("Add Car");
        JButton viewCarsBtn = new JButton("View Cars");
        JButton addCustomerBtn = new JButton("Add Customer");
        JButton searchCustomerBtn = new JButton("Search Customer");
        JButton rentCarBtn = new JButton("Rent Car");
        JButton returnCarBtn = new JButton("Return Car");
        JButton userManagementBtn = new JButton("User Management");
        JButton logoutBtn = new JButton("Logout");

        // Προσθηκη κουμπιων στο panel
        panel.add(addCarBtn);
        panel.add(viewCarsBtn);
        panel.add(addCustomerBtn);
        panel.add(searchCustomerBtn);
        panel.add(rentCarBtn);
        panel.add(returnCarBtn);
        panel.add(userManagementBtn);
        panel.add(logoutBtn);

        // Προσθηκη panel στο frame
        add(panel);

        // Ανοιγμα παραθυρου προσθηκης αυτοκινητου
        addCarBtn.addActionListener(e -> new AddCarFrame(dm));

        // Προβολη ολων των αυτοκινητων
        viewCarsBtn.addActionListener(e -> new ViewCarsFrame(dm));

        // Ανοιγμα φορμας προσθηκης πελατη
        addCustomerBtn.addActionListener(e -> new AddCustomerFrame(dm));

        // Αναζητηση πελατη
        searchCustomerBtn.addActionListener(e -> new SearchCustomerFrame(dm));

        // Διαδικασια ενοικιασης αυτοκινητου
        rentCarBtn.addActionListener(e -> new RentCarFrame(dm));

        // Διαδικασια επιστροφης αυτοκινητου
        returnCarBtn.addActionListener(e -> new ReturnCarFrame(dm));

        // Διαχειριση χρηστων του συστηματος
        userManagementBtn.addActionListener(e -> new UserManagementFrame(dm));

        // Απoσυνδεση χρηστη και επιστροφη στο login
        logoutBtn.addActionListener(e -> {
            dm.logout();
            dispose();
            new LoginFrame(dm);
        });

        // Εμφανιση του κεντρικου μενου
        setVisible(true);
    }
}
