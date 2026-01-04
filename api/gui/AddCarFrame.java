package api.gui;

import api.Car;
import api.DataManager;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

public class AddCarFrame extends JFrame {
    private final DataManager dm;

    public AddCarFrame(DataManager dm) {
        this.dm = dm;
        setTitle("Add Car");
        setSize(400,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel p = new JPanel(new GridLayout(9,2,4,4));
        JTextField plate = new JTextField();
        JTextField brand = new JTextField();
        JTextField type = new JTextField();
        JTextField model = new JTextField();
        JTextField year = new JTextField();
        JTextField color = new JTextField();
        JButton addBtn = new JButton("Add");

        p.add(new JLabel("License plate:")); p.add(plate);
        p.add(new JLabel("Brand:")); p.add(brand);
        p.add(new JLabel("Type:")); p.add(type);
        p.add(new JLabel("Model:")); p.add(model);
        p.add(new JLabel("Year:")); p.add(year);
        p.add(new JLabel("Color:")); p.add(color);
        p.add(new JLabel()); p.add(addBtn);

        add(p);

        addBtn.addActionListener(e -> {
            try {
                String id = UUID.randomUUID().toString();
                String lp = plate.getText().trim();
                String br = brand.getText().trim();
                String tp = type.getText().trim();
                String mo = model.getText().trim();
                int yr = Integer.parseInt(year.getText().trim());
                String col = color.getText().trim();
                if (lp.isEmpty() || br.isEmpty() || mo.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Συμπληρώστε όλα τα υποχρεωτικά πεδία");
                    return;
                }
                Car car = new Car(id, lp, br, mo, tp, yr, col, "Διαθέσιμο");
                dm.addCar(car);
                JOptionPane.showMessageDialog(this, "Το αυτοκίνητο προστέθηκε");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Έτος πρέπει να είναι αριθμός");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}




