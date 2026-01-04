import api.DataManager;

public class UserManagementFrame extends JFrame {

    private DataManager dataManager;

    public UserManagementFrame(DataManager dataManager) {
        this.dataManager = dataManager;

        setTitle("User Management");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("User Management Screen", SwingConstants.CENTER));
        setVisible(true);
    }
}
