package api.gui;

import javax.swing.*;

public class ReturnCarFrame extends JFrame {

    public ReturnCarFrame() {
        setTitle("Return Car");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Return Car Screen", SwingConstants.CENTER));
        setVisible(true);
    }
}
