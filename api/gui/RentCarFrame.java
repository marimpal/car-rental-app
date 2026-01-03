package api.gui;

import javax.swing.*;

public class RentCarFrame extends JFrame {

    public RentCarFrame() {
        setTitle("Rent Car");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Rent Car Screen", SwingConstants.CENTER));
        setVisible(true);
    }
}


