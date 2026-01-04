package main;

import api.DataManager;
import api.gui.LoginFrame;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {


        DataManager dm = new DataManager();
        dm.loadAllData();

        // Εκκίνηση GUI
        SwingUtilities.invokeLater(() -> {
            new LoginFrame(dm);
        });
    }
}
