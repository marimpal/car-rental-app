/**
 * @author Παναγιώτα Πατεράκη  ΑΕΜ 4839
 * @since 2025-12-17
 */
package main;

import api.DataManager;
import gui.LoginFrame;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {


        DataManager dm = new DataManager();
        dm.loadAllData();

        SwingUtilities.invokeLater(() -> {
            new LoginFrame(dm);
        });
    }
}
