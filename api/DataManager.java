package api;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public static List<Car> cars = new ArrayList<>();
    public static List<Customer> customers = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Rental> rentals = new ArrayList<>();

    private final String usersFiles = "users.csv";
    private final String vehiclesFiles = "vehicles_with_plates.csv";
    private final String CustomerFiles = "customers.csv";
    private final String RentalsFiles = "rentals.csv";

    private User loggedInUser = null;

    public void loadAllData() {
        loadVehicles();
        loadUsers();
        loadCustomers();
        loadRentals();
        if (customers.isEmpty()) {
            customers.add(new Customer("123456789", "Test 1", "test1@mail.com", "6912345678"));
            customers.add(new Customer("123456788", "Test 2", "test2@mail.com", "6912345679"));
            saveCustomers();
        }
    }

    public void loadVehicles() {
        try (BufferedReader br = new BufferedReader(new FileReader("vehicles_with_plates.csv"))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {firstLine = false;
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length >= 8) {
                    cars.add(new Car(
                            parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim(), parts[4].trim(),
                            Integer.parseInt(parts[5].trim()), parts[6].trim(), parts[7].trim()));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void loadUsers () {
        try (BufferedReader br = new BufferedReader(new FileReader("users.csv"))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {firstLine = false;
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    // Trim για να φύγουν κενά
                    users.add(new User(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim(), parts[4].trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCustomers() {
        File f = new File(CustomerFiles);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    customers.add(new Customer(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    private void loadRentals() {
        File f = new File(RentalsFiles);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 7) {
                    rentals.add(new Rental(
                            parts[0], parts[1], parts[2], parts[3],
                            LocalDate.parse(parts[4]), LocalDate.parse(parts[5]), Boolean.parseBoolean(parts[6])
                    ));
                }
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void saveData() {
        saveListToFile(usersFiles, users, "name, surname, username, email, password"); // Αν θέλουμε να αποθηκεύουμε νέους users
        saveListToFile(vehiclesFiles, cars, "id, plate, brand, type, model, year, color, status");
        saveCustomers();
        saveRentals();
    }

    private void saveCustomers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CustomerFiles))) {
            for (Customer c : customers) bw.write(c.toCSV() + "\n");
        } catch (IOException e) { e.printStackTrace(); }
    }

    private void saveRentals() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RentalsFiles))) {
            for (Rental r : rentals) bw.write(r.toCSV() + "\n");
        } catch (IOException e) { e.printStackTrace(); }
    }

    // Generic helper for Users/Vehicles to keep headers
    private <T> void saveListToFile(String filename, ArrayList<T> list, String header) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(header + "\n");
            for (T item : list) {
                if (item instanceof User) bw.write(((User) item).toCSV() + "\n");
                else if (item instanceof Car) bw.write(((Car) item).toCSV() + "\n");
            }
        } catch (IOException e) { e.printStackTrace(); }
    }


    // User Authentication

    public boolean login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                this.loggedInUser = u;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        this.loggedInUser = null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    // Add Car

    public void addCar(Car c) throws Exception {
        for (Car car : cars) {
            if (c.getId().equals(c.getId()) || c.getLicensePlate().equals(c.getLicensePlate())) {
                throw new Exception("Το αυτοκίνητο υπάρχει ήδη");
            }
        }
        cars.add(c);
        saveCars();
    }

    public ArrayList<Car> searchCar(String criteria) {
        ArrayList<Car> results = new ArrayList<>();
        for (Car car : cars) {
            if (car.getId().contains(criteria) || car.getLicensePlate().contains(criteria) ||
                    car.getBrand().contains(criteria) || car.getModel().contains(criteria) ||
                    car.getColor().contains(criteria) || car.getStatus().contains(criteria)) {
                results.add(car);
            }
        }
        return results;
    }

    public void addCustomer(Customer customer) throws Exception {
        for (Customer c : customers) {
            if (c.getVatNumber().equals(customer.getVatNumber())) {
                throw new Exception("Ο πελάτης υπάρχει ήδη");
            }
        }
        customers.add(customer);
        saveCustomers();
    }
}

