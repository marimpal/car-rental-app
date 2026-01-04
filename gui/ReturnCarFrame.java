/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 */
package gui;

import api.DataManager;
import javax.swing.*;
import java.awt.*;

public class ReturnCarFrame extends JFrame {
    private final DataManager dm;

    public ReturnCarFrame(DataManager dm) {
        this.dm = dm;
        setTitle("Return Car");
        setSize(350,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel p = new JPanel(new GridLayout(2,2,4,4));
        JTextField rentalId = new JTextField();
        JButton retBtn = new JButton("Return");

        p.add(new JLabel("Rental ID:")); p.add(rentalId);
        p.add(new JLabel()); p.add(retBtn);
        add(p);

        retBtn.addActionListener(e -> {
            try {
                dm.returnCar(rentalId.getText().trim());
                JOptionPane.showMessageDialog(this, "Returned");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
