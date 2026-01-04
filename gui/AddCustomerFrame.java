/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 */
package gui;

import api.Customer;
import api.DataManager;

import javax.swing.*;
import java.awt.*;

public class AddCustomerFrame extends JFrame {

    private final DataManager dm;

    public AddCustomerFrame(DataManager dm) {
        this.dm = dm;

        // Βασικες ρυθμισεις παραθυρου
        setTitle("Add Customer");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel p = new JPanel(new GridLayout(5,2,4,4));

        // Πεδια εισαγωγης στοιχειων πελατη
        JTextField vat = new JTextField();
        JTextField fullname = new JTextField();
        JTextField phone = new JTextField();
        JTextField email = new JTextField();

        // Κουμπι προσθηκης πελατη
        JButton addBtn = new JButton("Add");

        // Προσθηκη labels και πεδιων στο panel
        p.add(new JLabel("VAT (ΑΦΜ):")); p.add(vat);
        p.add(new JLabel("Full name:")); p.add(fullname);
        p.add(new JLabel("Phone:")); p.add(phone);
        p.add(new JLabel("Email:")); p.add(email);
        p.add(new JLabel()); p.add(addBtn);

        // Προσθηκη panel στο frame
        add(p);

        addBtn.addActionListener(e -> {
            try {
                // Διαβασμα τιμων απο τα πεδια
                String v = vat.getText().trim();
                String fn = fullname.getText().trim();
                String ph = phone.getText().trim();
                String em = email.getText().trim();

                // Ελεγχος βασικων υποχρεωτικων πεδιων
                if (v.isEmpty() || fn.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Συμπληρωστε ΑΦΜ και ονομα");
                    return;
                }

                // Δημιουργια αντικειμενου Customer,Προσθηκη πελατη μεσω DataManager και μυνημα επιτυχιας
                Customer c = new Customer(v, fn, em, ph);

                dm.addCustomer(c);

                JOptionPane.showMessageDialog(this, "Ο πελατης προστεθηκε");

                dispose();

            } catch (Exception ex) {
                // Χειρισμος λαθους
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        setVisible(true);
    }
}
