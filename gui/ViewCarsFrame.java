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
    private final DataManager dm;
    private JTable table;

    public ViewCarsFrame(DataManager dm) {
        this.dm = dm;
        setTitle("View Cars");
        setSize(700,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        List<Car> cars = dm.getAllCars();
        String[] cols = {"ID","Plate","Brand","Model","Type","Year","Color","Status"};
        Object[][] data = new Object[cars.size()][cols.length];
        for (int i=0;i<cars.size();i++) {
            Car c = cars.get(i);
            data[i] = new Object[] {c.getId(), c.getLicensePlate(), c.getBrand(), c.getModel(), c.getType(), c.getYear(), c.getColor(), c.getStatus()};
        }

        table = new JTable(data, cols);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(e -> refreshTable());
        add(refresh, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void refreshTable() {
        java.util.List<Car> cars = dm.getAllCars();
        String[] cols = {"ID","Plate","Brand","Model","Type","Year","Color","Status"};
        Object[][] data = new Object[cars.size()][cols.length];
        for (int i=0;i<cars.size();i++) {
            Car c = cars.get(i);
            data[i] = new Object[] {c.getId(), c.getLicensePlate(), c.getBrand(), c.getModel(), c.getType(), c.getYear(), c.getColor(), c.getStatus()};
        }
        table.setModel(new javax.swing.table.DefaultTableModel(data, cols));
    }
}
