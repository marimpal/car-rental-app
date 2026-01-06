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

    public ViewCarsFrame(DataManager dm) {

        setTitle("View Cars");
        setSize(600, 400);
        setLocationRelativeTo(null);

        DefaultListModel<Car> model = new DefaultListModel<>();
        JList<Car> carList = new JList<>(model);

        // Φόρτωση όλων των αυτοκινήτων
        List<Car> cars = dm.getAllCars();
        for (Car c : cars) {
            model.addElement(c);
        }

        JButton editBtn = new JButton("Edit Selected Car");

        editBtn.addActionListener(e -> {
            Car selected = carList.getSelectedValue();
            if (selected != null) {
                new EditCarFrame(dm, selected);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Select a car first");
            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(carList), BorderLayout.CENTER);
        add(editBtn, BorderLayout.SOUTH);

        setVisible(true);
    }
}
