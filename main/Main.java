/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 */
package main;

import api.DataManager;
import gui.LoginFrame;

import javax.swing.SwingUtilities;

public class Main {

    /**
     * Η κύρια μέθοδος εκκίνησης της εφαρμογής.
     *
     * @param args τα ορίσματα γραμμής εντολών (δεν χρησιμοποιούνται)
     */
    public static void main(String[] args) {

        // δημιουργία της αναφοράς στο DataManager για διαχείριση όλων των δεδομένων
        DataManager dm = new DataManager();

        // Φόρτωση όλων των δεδομένων από τα αρχεία ή τη βάση
        dm.loadAllData();

        // Δημιουργία και εμφάνιση του παραθύρου login στο Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new LoginFrame(dm); // Το παράθυρο login χρησιμοποιεί το ίδιο DataManager
        });
    }
}
