/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 */
package gui;

import api.Car;
import api.DataManager;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

public class AddCarFrame extends JFrame {

    /** Αντικείμενο DataManager για τη διαχείριση των δεδομένων */
    private final DataManager dm;

    /**
     * Κατασκευαστής της κλάσης AddCarFrame.
     * Αρχικοποιεί το παράθυρο και τα γραφικά του στοιχεία.
     *
     * @param dm Το αντικείμενο DataManager της εφαρμογής
     */
    public AddCarFrame(DataManager dm) {
        this.dm = dm;

        // Ρυθμίσεις παραθύρου
        setTitle("Add Car");
        setSize(400,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Πάνελ  για την τοποθέτηση των στοιχείων
        JPanel p = new JPanel(new GridLayout(9,2,4,4));

        // Πεδία εισαγωγής των στοιχείων αυτοκινήτου
        JTextField plate = new JTextField();
        JTextField brand = new JTextField();
        JTextField type = new JTextField();
        JTextField model = new JTextField();
        JTextField year = new JTextField();
        JTextField color = new JTextField();

        // Κουμπί προσθήκης αυτοκινήτου
        JButton addBtn = new JButton("Add");

        // Oνομασια των ετικετών
        p.add(new JLabel("License plate:")); p.add(plate);
        p.add(new JLabel("Brand:")); p.add(brand);
        p.add(new JLabel("Type:")); p.add(type);
        p.add(new JLabel("Model:")); p.add(model);
        p.add(new JLabel("Year:")); p.add(year);
        p.add(new JLabel("Color:")); p.add(color);
        p.add(new JLabel()); p.add(addBtn);

        // Προσθήκη του πάνελ στο παράθυρο
        add(p);

        // Listener για το κουμπί προσθήκης
        addBtn.addActionListener(e -> {
            try {
                // Δημιουργία μοναδικού ID για το αυτοκίνητο
                String id = UUID.randomUUID().toString();

                // Ανάγνωση και καθαρισμός των τιμών από τα πεδία
                String lp = plate.getText().trim();
                String br = brand.getText().trim();
                String tp = type.getText().trim();
                String mo = model.getText().trim();
                int yr = Integer.parseInt(year.getText().trim());
                String col = color.getText().trim();

                // Έλεγχος των υποχρεωτικών πεδίων
                if (lp.isEmpty() || br.isEmpty() || mo.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Συμπληρώστε όλα τα υποχρεωτικά πεδία");
                    return;
                }

                // Δημιουργία αντικειμένου Car,προσθηκη αυτου μεσω του Datamanager και μυνημα επιτυχούς προσθηκης
                Car car = new Car(id, lp, br, mo, tp, yr, col, "Διαθέσιμο");

                dm.addCar(car);

                JOptionPane.showMessageDialog(this, "Το αυτοκίνητο προστέθηκε");

                dispose();

            } catch (NumberFormatException ex) {
                // Σφάλμα  έτους
                JOptionPane.showMessageDialog(this, "Έτος πρέπει να είναι αριθμός");
            } catch (Exception ex) {
                // Για περιπτωση λαθών
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}

