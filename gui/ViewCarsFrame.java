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

    // Η αναφορά στο DataManager για πρόσβαση σε όλες τις λειτουργίες
    private final DataManager dm;

    // Ο πίνακας που εμφανίζει τα αυτοκίνητα
    private JTable table;

    public ViewCarsFrame(DataManager dm) {
        this.dm = dm;

        // Οι βασικές ρυθμίσεις για το παράθυρο προβολής αυτοκινήτων
        setTitle("View Cars");
        setSize(700,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Λήψη της λίστας με όλα τα αυτοκίνητα
        List<Car> cars = dm.getAllCars();

        // Οι στήλες του πίνακα
        String[] cols = {"ID","Plate","Brand","Model","Type","Year","Color","Status"};

        // Δημιουργία των δεδομένων για τον πίνακα
        Object[][] data = new Object[cars.size()][cols.length];
        for (int i=0;i<cars.size();i++) {
            Car c = cars.get(i);
            data[i] = new Object[] {
                    c.getId(), c.getLicensePlate(), c.getBrand(), c.getModel(),
                    c.getType(), c.getYear(), c.getColor(), c.getStatus()
            };
        }

        // Δημιουργία του πίνακα με τα δεδομένα και τις στήλες
        table = new JTable(data, cols);
        add(new JScrollPane(table), BorderLayout.CENTER); // Προσθήκη scroll pane για εύκολη προβολή

        // Το κουμπί για ανανέωση του πίνακα
        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(e -> refreshTable()); // Κλήση της μεθόδου ανανέωσης
        add(refresh, BorderLayout.SOUTH);

        // Εμφάνιση του παραθύρου
        setVisible(true);
    }

    // Η μέθοδος για ανανέωση των δεδομένων του πίνακα
    private void refreshTable() {
        // Λήψη ξανά της λίστας με όλα τα αυτοκίνητα
        java.util.List<Car> cars = dm.getAllCars();

        // Οι στήλες του πίνακα παραμένουν ίδιες
        String[] cols = {"ID","Plate","Brand","Model","Type","Year","Color","Status"};

        // Ενημέρωση των δεδομένων για τον πίνακα
        Object[][] data = new Object[cars.size()][cols.length];
        for (int i=0;i<cars.size();i++) {
            Car c = cars.get(i);
            data[i] = new Object[] {
                    c.getId(), c.getLicensePlate(), c.getBrand(), c.getModel(),
                    c.getType(), c.getYear(), c.getColor(), c.getStatus()
            };
        }

        // Ενημέρωση του μοντέλου του πίνακα με τα νέα δεδομένα
        table.setModel(new javax.swing.table.DefaultTableModel(data, cols));
    }
}

