/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 * Παράθυρο προβολής ιστορικού ενοικιάσεων αυτοκινήτου
 * Ο χρήστης εισάγει το ID του αυτοκινήτου
 * και εμφανίζονται όλες οι ενοικιάσεις που έχουν γίνει για αυτό
 */
package gui;

import api.DataManager;
import api.Rental;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CarRentHistoryFrame extends JFrame {

    /**
     * Constructor του CarRentHistoryFrame
     * Δημιουργεί το παράθυρο και συνδέεται με τον DataManager
     */
    public CarRentHistoryFrame(DataManager dm) {

        // Τίτλος παραθύρου
        setTitle("Car Rent History");

        // Διαστάσεις παραθύρου
        setSize(500, 400);

        // Κεντράρισμα στην οθόνη
        setLocationRelativeTo(null);

        // Πεδίο εισαγωγής ID των αυτοκινήτου
        JTextField carIdField = new JTextField();

        // Κουμπί αναζήτησης ιστορικού
        JButton searchBtn = new JButton("Search");

        // Model για την αποθήκευση των ενοικιάσεων
        DefaultListModel<Rental> model = new DefaultListModel<>();

        // Λίστα για την εμφάνιση του ιστορικού ενοικιάσεων
        JList<Rental> list = new JList<>(model);

        // Ενέργεια κουμπιού Search
        searchBtn.addActionListener(e -> {

            // Καθαρισμός προηγούμενων αποτελεσμάτων
            model.clear();

            // Λήψη ιστορικού ενοικιάσεων για το συγκεκριμένο αυτοκίνητο
            List<Rental> rentals =
                    dm.getRentalsHistoryByCar(carIdField.getText());

            // Προσθήκη κάθε ενοικίασης στη λίστα
            for (Rental r : rentals) {
                model.addElement(r);
            }
        });

        // Χρήση BorderLayout για τη διάταξη
        setLayout(new BorderLayout());

        // Το πεδίο ID τοποθετείται επάνω
        add(carIdField, BorderLayout.NORTH);

        // Η λίστα με scroll τοποθετείται στο κέντρο
        add(new JScrollPane(list), BorderLayout.CENTER);

        // Το κουμπί αναζήτησης τοποθετείται κάτω
        add(searchBtn, BorderLayout.SOUTH);

        // Εμφάνιση παραθύρου
        setVisible(true);
    }
}
