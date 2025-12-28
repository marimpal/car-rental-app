package api;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public static Map<String, Car> cars = new HashMap<>();
    public static Map<String, Customer> customers = new HashMap<>();
    public static Map<String, User> users = new HashMap<>();
    public static Map<String, Rental> rentals = new HashMap<>();

    private User loggedInUser = null;

    public static void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader("vehicles_with_plates.csv"))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                if (values.length >= 8) {
                    String id = values[0].trim();
                    String plate = values[1].trim();
                    String brand = values[2].trim();
                    String type = values[3].trim();
                    String model = values[4].trim();
                    int year = Integer.parseInt(values[5].trim());
                    String color = values[6].trim();
                    String status = values[7].trim();

                    Car car = new Car(id, plate, brand, type, model, year, color, status);
                    cars.put(id, car); // Χρήση του ID ως κλειδί
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("users.csv"))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                if (values.length >= 5) {
                    String username = values[2].trim();
                    User u = new User(values[0].trim(), values[1].trim(), username, values[3].trim(),
                            values[4].trim());
                    // Αποθήκευση στο Map με κλειδί το Username
                    users.put(username, u);
                }
            }
        } catch (IOException e) {
        e.printStackTrace();
        }
    }

    public boolean authentication (String username, String password) {
        if (users.containsKey(username)) {
            User u = users.get(username);
            return u.getPassword().equals(password);
        }
        return false;
    }
    public void logout() {
        loggedInUser = null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
    // Method to get cars as a List (in case it is needed)
    public static List<Car> getCarsAsList() {
        return new ArrayList<>(cars.values());
    }


}

