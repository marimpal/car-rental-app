/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 */
package gui;

import api.DataManager;
import javax.swing.*;
import java.awt.*;

public class ReturnCarFrame extends JFrame {

    // Αναφορά στο DataManager για προσβαση σε ολες τις λειτουργιες
    private final DataManager dm;

    public ReturnCarFrame(DataManager dm) {
        this.dm = dm;

        // Βασικες ρυθμισεις του παραθυρου επιστροφης
        setTitle("Return Car");
        setSize(350,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Panel με grid για πεδίο και κουμπι
        JPanel p = new JPanel(new GridLayout(2,2,4,4));

        // Πεδίο εισαγωγής για το ID της ενοικίασης
        JTextField rentalId = new JTextField();

        // Κουμπι για επιστροφη αυτοκινητου
        JButton retBtn = new JButton("Return");

        // Προσθήκη ετικετών και πεδίων στο panel
        p.add(new JLabel("Rental ID:")); p.add(rentalId);
        p.add(new JLabel()); p.add(retBtn); // κενό κελί για σωστή διάταξη

        // Προσθήκη panel στο frame
        add(p);

        // Λειτουργία κουμπιού επιστροφής
        retBtn.addActionListener(e -> {
            try {
                // Κλήση μεθόδου επιστροφής στο DataManager
                dm.returnCar(rentalId.getText().trim());

                // Ενημέρωνει τον χρήστη για επιτυχημένη επιστροφή
                JOptionPane.showMessageDialog(this, "Returned");

                dispose();
            } catch (Exception ex) {
                // Εμφάνιση λαθών με dialog
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
