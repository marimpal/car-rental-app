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
        JPanel panel = new JPanel(new GridLayout(0,1,12,12));

        // Κουμπια για τις βασικες λειτουργιες της εφαρμογης
        JButton addCarBtn = new JButton("Add Car");
        JButton editCarBtn = new JButton("Edit Car");
        JButton viewCarsBtn = new JButton("View Cars");
        JButton searchCarBtn = new JButton("Search Car");
        JButton rentCarBtn = new JButton("Rent Car");
        JButton returnCarBtn = new JButton("Return Car");
        JButton carRentHistoryBtn = new JButton("Car Rent History");
        JButton addCustomerBtn = new JButton("Add Customer");
        JButton editCustomerBtn = new JButton("Edit Customer");
        JButton searchCustomerBtn = new JButton("Search Customer");
        JButton customerRentHistoryBtn = new JButton("Customer Rent History");
        JButton userManagementBtn = new JButton("User Management");
        JButton logoutBtn = new JButton("Logout");

        // Προσθηκη κουμπιων στο panel
        panel.add(addCarBtn);
        panel.add(editCarBtn);
        panel.add(viewCarsBtn);
        panel.add(searchCarBtn);
        panel.add(rentCarBtn);
        panel.add(returnCarBtn);
        panel.add(carRentHistoryBtn);
        panel.add(addCustomerBtn);
        panel.add(editCustomerBtn);
        panel.add(searchCustomerBtn);
        panel.add(customerRentHistoryBtn);
        panel.add(userManagementBtn);
        panel.add(logoutBtn);

        // Προσθηκη panel στο frame
        add(panel);

        // Ανοιγμα παραθυρου προσθηκης αυτοκινητου
        addCarBtn.addActionListener(e -> new AddCarFrame(dm));

        //Επεξεργασία Αυτοκινήτου
        editCarBtn.addActionListener(e -> new EditCarFrame(dm));

        // Προβολη ολων των αυτοκινητων
        viewCarsBtn.addActionListener(e -> new ViewCarsFrame(dm));

        // αναζήτηση αυτοκινήτου με οποιοδήποτε χαρακτηριστικού
        searchCarBtn.addActionListener(e -> new SearchCarFrame(dm));

        // Διαδικασια ενοικιασης αυτοκινητου
        rentCarBtn.addActionListener(e -> new RentCarFrame(dm));

        // Διαδικασια επιστροφης αυτοκινητου
        returnCarBtn.addActionListener(e -> new ReturnCarFrame(dm));

        //Ιστορικό ενοικιασεων αυτοκινητου
        carRentHistoryBtn.addActionListener(
                e -> new CarRentHistoryFrame(dm)
        );

        // Ανοιγμα φορμας προσθηκης πελατη
        addCustomerBtn.addActionListener(e -> new AddCustomerFrame(dm));

        //Επεξεργασια στοιχειων πελατων
        editCustomerBtn.addActionListener(e -> new EditCustomerFrame(dm));

        // Αναζητηση πελατη
        searchCustomerBtn.addActionListener(e -> new SearchCustomerFrame(dm));

        //Ιστορικο ενοικιασεων πελατων
        customerRentHistoryBtn.addActionListener(
                e -> new CustomerRentHistoryFrame(dm)
        );

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
