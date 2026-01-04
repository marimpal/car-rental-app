package api.gui;

import api.Customer;
import api.DataManager;

import javax.swing.*;
import java.awt.*;

public class AddCustomerFrame extends JFrame {
    private final DataManager dm;

    public AddCustomerFrame(DataManager dm) {
        this.dm = dm;
        setTitle("Add Customer");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel p = new JPanel(new GridLayout(5,2,4,4));
        JTextField vat = new JTextField();
        JTextField fullname = new JTextField();
        JTextField phone = new JTextField();
        JTextField email = new JTextField();
        JButton addBtn = new JButton("Add");

        p.add(new JLabel("VAT (ΑΦΜ):")); p.add(vat);
        p.add(new JLabel("Full name:")); p.add(fullname);
        p.add(new JLabel("Phone:")); p.add(phone);
        p.add(new JLabel("Email:")); p.add(email);
        p.add(new JLabel()); p.add(addBtn);

        add(p);

        addBtn.addActionListener(e -> {
            try {
                String v = vat.getText().trim();
                String fn = fullname.getText().trim();
                String ph = phone.getText().trim();
                String em = email.getText().trim();
                if (v.isEmpty() || fn.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Συμπληρώστε ΑΦΜ και όνομα");
                    return;
                }
                Customer c = new Customer(v, fn, em, ph);
                dm.addCustomer(c);
                JOptionPane.showMessageDialog(this, "Ο πελάτης προστέθηκε");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
