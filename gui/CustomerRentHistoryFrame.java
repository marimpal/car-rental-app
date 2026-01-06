/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 * Παράθυρο προβολής ιστορικού ενοικιάσεων πελάτη
 * Ο χρήστης εισάγει το ΑΦΜ του πελάτη
 * και εμφανίζονται όλες οι ενοικιάσεις που έχουν γίνει για αυτόν
 */
package gui;

import api.DataManager;
import api.Rental;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CustomerRentHistoryFrame extends JFrame {

    /**
     * Constructor του CustomerRentHistoryFrame
     * Δημιουργεί το παράθυρο και συνδέεται με τον DataManager
     */
    public CustomerRentHistoryFrame(DataManager dm) {

        // Τίτλος παραθύρου
        setTitle("Customer Rent History");

        // Διαστάσεις παραθύρου
        setSize(500, 400);

        // Κεντράρισμα παραθύρου στην οθόνη
        setLocationRelativeTo(null);

        // Πεδίο εισαγωγής ΑΦΜ πελάτη
        JTextField vatField = new JTextField();

        // Κουμπί αναζήτησης ιστορικού ενοικιάσεων
        JButton searchBtn = new JButton("Search");

        // Model που θα κρατά τα αποτελέσματα των ενοικιάσεων
        DefaultListModel<Rental> model = new DefaultListModel<>();

        // Λίστα για την εμφάνιση των ενοικιάσεων του πελάτη
        JList<Rental> list = new JList<>(model);

        // Ενέργεια κουμπιού Search
        searchBtn.addActionListener(e -> {

            // Καθαρισμός προηγούμενων αποτελεσμάτων
            model.clear();

            // Λήψη όλων των ενοικιάσεων του πελάτη με βάση το ΑΦΜ
            List<Rental> rentals =
                    dm.getRentalsByCustomerVat(vatField.getText());

            // Προσθήκη κάθε ενοικίασης στη λίστα
            for (Rental r : rentals) {
                model.addElement(r);
            }
        });

        // Χρήση BorderLayout για απλή διάταξη
        setLayout(new BorderLayout());

        // Το πεδίο εισαγωγής ΑΦΜ τοποθετείται επάνω
        add(vatField, BorderLayout.NORTH);

        // Η λίστα με scroll τοποθετείται στο κέντρο
        add(new JScrollPane(list), BorderLayout.CENTER);

        // Το κουμπί Search τοποθετείται στο κάτω μέρος
        add(searchBtn, BorderLayout.SOUTH);

        // Εμφάνιση παραθύρου
        setVisible(true);
    }
}
