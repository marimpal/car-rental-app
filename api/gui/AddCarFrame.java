package api.gui;

import javax.swing.*;

public class AddCarFrame extends JFrame {

    public AddCarFrame() {
        setTitle("Add Car");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Add Car Form", SwingConstants.CENTER));
        setVisible(true);
    }
}



