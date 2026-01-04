package main;

import api.DataManager;
import api.gui.LoginFrame;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        // Δημιουργία και αρχικοποίηση API
        DataManager dataManager = new DataManager();
        dataManager.loadAllData();

        // Εκκίνηση GUI
        SwingUtilities.invokeLater(() -> {
            new LoginFrame(dataManager);
        });
    }
}
