/**
 * Παράθυρο προβολής όλων των αυτοκινήτων
 * Από εδώ ο χρήστης μπορεί να επιλέξει αυτοκίνητο
 * και να το επεξεργαστεί (Edit)
 *
 */
 package gui;

import api.DataManager;
import api.Car;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewCarsFrame extends JFrame {

    // Αναφορά στο DataManager
    private final DataManager dm;

    // Λίστα εμφάνισης αυτοκινήτων
    private final JList<Car> carList;

    /**
     * Constructor του ViewCarsFrame
     */
    public ViewCarsFrame(DataManager dm) {
        this.dm = dm;

        // Ρυθμίσεις παραθύρου
        setTitle("View Cars");
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Λήψη όλων των αυτοκινήτων από τον DataManager
        List<Car> cars = dm.getAllCars();

        // Δημιουργία της λίστας με τα αυτοκίνητα
        carList = new JList<>(cars.toArray(new Car[0]));

        // Scroll για τη λίστα
        JScrollPane scrollPane = new JScrollPane(carList);

        // Κουμπί επεξεργασίας του επιλεγμένου αυτοκινήτου
        JButton editBtn = new JButton("Edit Selected Car");

        // Ενέργεια κουμπιού για Edit
        editBtn.addActionListener(e -> {

            // Παίρνουμε το επιλεγμένο αυτοκίνητο
            Car selectedCar = carList.getSelectedValue();

            // Αν δεν έχει επιλεγεί τίποτα
            if (selectedCar == null) {
                JOptionPane.showMessageDialog(this,
                        "Please select a car first");
                return;
            }

            // Άνοιγμα φόρμας επεξεργασίας
            new EditCarFrame(dm, selectedCar);

            // Κλείσιμο του View
            dispose();
        });

        // Προσθήκη στοιχείων στο παράθυρο
        add(scrollPane, BorderLayout.CENTER);
        add(editBtn, BorderLayout.SOUTH);

        // Εμφάνιση παραθύρου
        setVisible(true);
    }
}



