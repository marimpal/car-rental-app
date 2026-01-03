package api.gui;

import javax.swing.*;

public class ViewCarsFrame extends JFrame {

    public ViewCarsFrame() {
        setTitle("View Cars");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("View Cars Screen", SwingConstants.CENTER));
        setVisible(true);
    }
}
