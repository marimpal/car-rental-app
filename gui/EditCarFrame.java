/**
 * @author Παναγιώτα Πατεράκη
 *  @since 2025-12-17
 * Παράθυρο επεξεργασίας αυτοκινήτου
 * Δέχεται συγκεκριμένο αντικείμενο Car
 */
package gui;

import api.Car;
import api.DataManager;

import javax.swing.*;
import java.awt.*;

public class EditCarFrame extends JFrame {

    // Αναφορά στον DataManager
    private final DataManager dm;

    // Το αυτοκίνητο που επεξεργαζόμαστε
    private final Car car;

    /**
     * Constructor EditCarFrame
     */
    public EditCarFrame(DataManager dm, Car car) {
        this.dm = dm;
        this.car = car;

        // Ρυθμίσεις παραθύρου
        setTitle("Edit Car");
        setSize(300, 250);
        setLocationRelativeTo(null);

        // Panel με grid layout
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

        // Πεδία με αρχικές τιμές από το αντικείμενο car
        JTextField licencePlateField = new JTextField(car.getLicensePlate());
        JTextField brandField = new JTextField(car.getBrand());
        JTextField typeField = new JTextField(car.getType());
        JTextField modelField = new JTextField(car.getModel());
        JTextField yearField = new JTextField(String.valueOf(car.getYear()));
        JTextField colorField = new JTextField(car.getColor());
        JTextField statusField = new JTextField(car.getStatus());

        // Κουμπί αποθήκευσης
        JButton saveBtn = new JButton("Save");

        // Προσθήκη στοιχείων στο panel
        panel.add(new JLabel("License Plate:"));
        panel.add(licencePlateField);
        panel.add(new JLabel("Brand:"));
        panel.add(brandField);
        panel.add(new JLabel("Type:"));
        panel.add(typeField);
        panel.add(new JLabel("Year:"));
        panel.add(yearField);
        panel.add(new JLabel("Color:"));
        panel.add(colorField);
        panel.add(new JLabel("Status:"));
        panel.add(statusField);
        panel.add(new JLabel("Model:"));
        panel.add(modelField);
        panel.add(new JLabel());
        panel.add(saveBtn);

        // Ενέργεια κουμπιού Save
        saveBtn.addActionListener(e -> {

            // Ενημέρωση αντικειμένου car
            car.setLicensePlate(licencePlateField.getText());
            car.setBrand(brandField.getText());
            car.setType(typeField.getText());
            car.setModel(modelField.getText());
            car.setYear(Integer.parseInt(yearField.getText()));
            car.setColor(colorField.getText());
            car.setStatus(statusField.getText());

            // Αποθήκευση αλλαγών μέσω DataManager
            try {
                dm.updateCar(car);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            // Μήνυμα επιτυχίας
            JOptionPane.showMessageDialog(this,
                    "Car updated successfully");

            // Κλείσιμο παραθύρου
            dispose();

            // Επιστροφή στη λίστα αυτοκινήτων
            new ViewCarsFrame(dm);
        });

        add(panel);
        setVisible(true);
    }
}

