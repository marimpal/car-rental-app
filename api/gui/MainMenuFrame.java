package api.gui;

import api.DataManager;
import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {
    private final DataManager dm;

    public MainMenuFrame(DataManager dm) {
        this.dm = dm;
        setTitle("Main Menu");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0,1,8,8));
        JButton addCarBtn = new JButton("Add Car");
        JButton viewCarsBtn = new JButton("View Cars");
        JButton addCustomerBtn = new JButton("Add Customer");
        JButton searchCustomerBtn = new JButton("Search Customer");
        JButton rentCarBtn = new JButton("Rent Car");
        JButton returnCarBtn = new JButton("Return Car");
        JButton userManagementBtn = new JButton("User Management");
        JButton logoutBtn = new JButton("Logout");

        panel.add(addCarBtn); panel.add(viewCarsBtn); panel.add(addCustomerBtn);
        panel.add(searchCustomerBtn); panel.add(rentCarBtn); panel.add(returnCarBtn);
        panel.add(userManagementBtn); panel.add(logoutBtn);

        add(panel);

        addCarBtn.addActionListener(e -> new AddCarFrame(dm));
        viewCarsBtn.addActionListener(e -> new ViewCarsFrame(dm));
        addCustomerBtn.addActionListener(e -> new AddCustomerFrame(dm));
        searchCustomerBtn.addActionListener(e -> new SearchCustomerFrame(dm));
        rentCarBtn.addActionListener(e -> new RentCarFrame(dm));
        returnCarBtn.addActionListener(e -> new ReturnCarFrame(dm));
        userManagementBtn.addActionListener(e -> new UserManagementFrame(dm));

        logoutBtn.addActionListener(e -> {
            dm.logout();
            dispose();
            new LoginFrame(dm);
        });

        setVisible(true);
    }
}
