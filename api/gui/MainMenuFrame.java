package api.gui;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {

    public MainMenuFrame() {
        setTitle("Main Menu");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1, 8, 8));

        JButton addCarBtn = new JButton("Add Car");
        JButton viewCarsBtn = new JButton("View Cars");
        JButton addCustomerBtn = new JButton("Add Customer");
        JButton searchCustomerBtn = new JButton("Search Customer");
        JButton customerMenuBtn = new JButton("Customer Menu");
        JButton rentCarBtn = new JButton("Rent Car");
        JButton returnCarBtn = new JButton("Return Car");
        JButton userManagementBtn = new JButton("User Management");
        JButton logoutBtn = new JButton("Logout");

        panel.add(addCarBtn);
        panel.add(viewCarsBtn);
        panel.add(addCustomerBtn);
        panel.add(searchCustomerBtn);
        panel.add(customerMenuBtn);
        panel.add(rentCarBtn);
        panel.add(returnCarBtn);
        panel.add(userManagementBtn);
        panel.add(logoutBtn);

        add(panel);

        addCarBtn.addActionListener(e -> new AddCarFrame());
        viewCarsBtn.addActionListener(e -> new ViewCarsFrame());
        addCustomerBtn.addActionListener(e -> new AddCustomerFrame());
        searchCustomerBtn.addActionListener(e -> new SearchCustomerFrame());
        customerMenuBtn.addActionListener(e -> new CustomerMenuFrame());
        rentCarBtn.addActionListener(e -> new RentCarFrame());
        returnCarBtn.addActionListener(e -> new ReturnCarFrame());
        userManagementBtn.addActionListener(e -> new UserManagementFrame());

        logoutBtn.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        setVisible(true);
    }
}
