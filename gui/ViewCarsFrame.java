/**
 * Προβολή όλων των αυτοκινήτων.
 * Από εδώ γίνεται και η επιλογή για ΕΠΕΞΕΡΓΑΣΙΑ αυτοκινήτου.
 */

/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 */
package gui;

import api.Car;
import api.DataManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewCarsFrame extends JFrame {

    // Constructor που δέχεται τον DataManager
    public ViewCarsFrame(DataManager dm) {

        // Τίτλος παραθύρου
        setTitle("View Cars");

        // Μέγεθος παραθύρου
        setSize(600, 400);

        // Κεντράρισμα παραθύρου στην οθόνη
        setLocationRelativeTo(null);

        // Model για τη λίστα αυτοκινήτων
        DefaultListModel<Car> model = new DefaultListModel<>();

        // JList που εμφανίζει τα αυτοκίνητα
        JList<Car> carList = new JList<>(model);

        // Φόρτωση όλων των αυτοκινήτων από τον DataManager
        List<Car> cars = dm.getAllCars();
        for (Car c : cars) {
            // Προσθήκη κάθε αυτοκινήτου στο model της λίστας
            model.addElement(c);
        }

        // Κουμπί επεξεργασίας επιλεγμένου αυτοκινήτου
        JButton editBtn = new JButton("Edit Selected Car");

        // Listener για το κουμπί Edit
        editBtn.addActionListener(e -> {

            // Παίρνουμε το επιλεγμένο αυτοκίνητο από τη λίστα
            Car selected = carList.getSelectedValue();

            if (selected != null) {
                // Άνοιγμα παραθύρου επεξεργασίας αυτοκινήτου
                new EditCarFrame(dm, selected);

                // Κλείσιμο του τρέχοντος παραθύρου
                dispose();
            } else {
                // Μήνυμα αν δεν έχει επιλεγεί αυτοκίνητο
                JOptionPane.showMessageDialog(this, "Select a car first");
            }
        });

        // Ορισμός layout του παραθύρου
        setLayout(new BorderLayout());

        // Προσθήκη της λίστας στο κέντρο με scroll
        add(new JScrollPane(carList), BorderLayout.CENTER);

        // Προσθήκη κουμπιού στο κάτω μέρος
        add(editBtn, BorderLayout.SOUTH);

        // Εμφάνιση παραθύρου
        setVisible(true);
    }
}
