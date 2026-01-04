/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 */
package gui;

import api.DataManager;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class RentCarFrame extends JFrame {

    // Αναφορά στο DataManager για προσβαση σε ολες τις λειτουργιες
    private final DataManager dm;

    public RentCarFrame(DataManager dm) {
        this.dm = dm;

        // Βασικες ρυθμισεις του παραθυρου ενοικιασης
        setTitle("Rent Car");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Panel με grid για τα πεδια και κουμπια
        JPanel p = new JPanel(new GridLayout(5,2,4,4));

        // Πεδία εισαγωγής για ID αυτοκινήτου, ΑΦΜ πελάτη και ημερομηνίες
        JTextField carId = new JTextField();
        JTextField customerVat = new JTextField();
        JTextField start = new JTextField("YYYY-MM-DD");
        JTextField end = new JTextField("YYYY-MM-DD");

        // Κουμπι για εκτέλεση της ενοικίασης
        JButton rentBtn = new JButton("Rent");

        // Προσθήκη ετικετών και πεδίων στο panel
        p.add(new JLabel("Car ID:")); p.add(carId);
        p.add(new JLabel("Customer VAT:")); p.add(customerVat);
        p.add(new JLabel("Start date:")); p.add(start);
        p.add(new JLabel("End date:")); p.add(end);
        p.add(new JLabel()); p.add(rentBtn); // κενό κελί για σωστή διάταξη

        // Προσθήκη panel στο frame
        add(p);

        // Λειτουργία κουμπιού ενοικίασης
        rentBtn.addActionListener(e -> {
            try {
                // Ανάγνωση και μετατροπή ημερομηνιών από τα πεδία
                LocalDate s = LocalDate.parse(start.getText().trim());
                LocalDate en = LocalDate.parse(end.getText().trim());

                // Κλήση μεθόδου ενοικίασης στο DataManager
                dm.rentCar(carId.getText().trim(), customerVat.getText().trim(), s, en);

                // Ενημερωνει τον χρήστη για επιτυχημένη ενοικίαση
                JOptionPane.showMessageDialog(this,"Rent created");

                dispose();
            } catch (DateTimeParseException ex) {
                // Εμφάνιζει μυνημα σε περίπτωση λάθους μορφής ημερομηνίας
                JOptionPane.showMessageDialog(this,"Invalid date format. Use YYYY-MM-DD");
            } catch (Exception ex) {
                // Εμφάνιση άλλων λαθών με dialog
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}


