package api;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Η κλάση DataManager διαχειρίζεται τα δεδομένα της εφαρμογής ενοικίασης αυτοκινήτων.
 * Περιλαμβάνει μεθόδους για τη φόρτωση και αποθήκευση δεδομένων από/σε αρχεία,
 * καθώς και λειτουργίες για τη διαχείριση χρηστών, οχημάτων, πελατών και ενοικιάσεων.
 * Eπιπλέον, παρέχει λειτουργίες για την είσοδο και έξοδο χρηστών, την προσθήκη νέων οχημάτων και πελατών,
 * την αναζήτηση οχημάτων και πελατών, καθώς και την ενοικίαση και επιστροφή οχημάτων.
 *
 * @author Μαριλένα Μπαλαμπανίδου ΑΕΜ 4977
 * @since 2025-12-18
 */
public class DataManager {

    // Αποθήκευση δεδομένων σε λίστες
    private static List<Car> cars = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static List<Rental> rentals = new ArrayList<>();

    //Ονόματα των αρχείων
    private final String usersFiles = "users.csv";
    private final String vehiclesFiles = "vehicles_with_plates.csv";
    private final String CustomerFiles = "customers.csv";
    private final String RentalsFiles = "rentals.csv";

    private User loggedInUser = null;

    // Φόρτωση δεδομένων

    /**
     * Φορτώνει όλα τα δεδομένα από τα αρχεία CSV στις αντίστοιχες λίστες.
     * Σε περίπτωση που δεν υπάρχουν πελάτες, προσθέτει δύο δοκιμαστικούς πελάτες και
     * αποθηκεύει τα δεδομένα. (6.2)
     */
    public void loadAllData() {
        loadVehicles();
        loadUsers();
        loadCustomers();
        loadRentals();

        // Προσθήκη δοκιμαστικών πελατών αν δεν υπάρχουν
        if (customers.isEmpty()) {
            customers.add(new Customer("123456789", "Test 1", "test1@mail.com", "6912345678"));
            customers.add(new Customer("123456788", "Test 2", "test2@mail.com", "6912345679"));
            saveCustomers();
        }
    }

    /**
     * Φορτώνει τα οχήματα από το αρχείο "vehicles_with_plates.csv" στη λίστα cars.
     * Παραλείπει την πρώτη γραμμή που περιέχει τις κεφαλίδες των στηλών.
     */
    public void loadVehicles() {
        try (BufferedReader br = new BufferedReader(new FileReader("vehicles_with_plates.csv"))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {firstLine = false;
                    continue;}
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

    /**
     * Φορτώνει τους χρήστες από το αρχείο "users.csv" στη λίστα users.
     * Παραλείπει την πρώτη γραμμή που περιέχει τις κεφαλίδες των στηλών.
     */
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

    /**
     * Φορτώνει τους πελάτες από το αρχείο "customers.csv" που δημιουργεί στη λίστα customers.
     */
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

    /**
     * Φορτώνει τις ενοικιάσεις από το αρχείο "rentals.csv" που δημιουργεί στη λίστα rentals.
     */
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

    // Αποθήκευση δεδομένων

    /**
     * Αποθηκεύει όλα τα δεδομένα από τις λίστες στα αντίστοιχα αρχεία CSV.
     * Καλεί βοηθητικές μεθόδους για την αποθήκευση χρηστών, οχημάτων, πελατών και ενοικιάσεων.
     */
    public void saveData() {
        saveListToFile(usersFiles, users, "name, surname, username, email, password");
        saveListToFile(vehiclesFiles, cars, "id, plate, brand, type, model, year, color, status");
        saveCustomers();
        saveRentals();
    }

    /** Βοηθητική μέθοδος για την αποθήκευση λίστας αντικειμένων σε αρχείο CSV με κεφαλίδα.
     *
     * @param filename Το όνομα του αρχείου όπου θα αποθηκευτούν τα δεδομένα.
     * @param list Η λίστα των αντικειμένων προς αποθήκευση. (User ή Car)
     * @param header Η κεφαλίδα του αρχείου CSV. (πχ. "name, surname, username, email, password" για χρήστες)
     * @param <T> Ο τύπος των αντικειμένων στη λίστα (User ή Car).
     */
    private <T> void saveListToFile(String filename, List<T> list, String header) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(header + "\n");
            for (T item : list) {
                if (item instanceof User) bw.write(((User) item).toCSV() + "\n");
                else if (item instanceof Car) bw.write(((Car) item).toCSV() + "\n");
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    /**
     * Αποθηκεύει τους πελάτες στο αρχείο "customers.csv".
     */
    private void saveCustomers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CustomerFiles))) {
            for (Customer c : customers) bw.write(c.toCSV() + "\n");
        } catch (IOException e) { e.printStackTrace(); }
    }

    /**
     * Αποθηκεύει τις ενοικιάσεις στο αρχείο "rentals.csv".
     */
    private void saveRentals() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RentalsFiles))) {
            for (Rental r : rentals) bw.write(r.toCSV() + "\n");
        } catch (IOException e) { e.printStackTrace(); }
    }

    // Είσοδοσ και έξοδος χρήστη

    /**
     * Ελέγχει τα στοιχεία του χρήστη και πραγματοποιεί είσοδο αν είναι σωστά.
     *
     * @param username Το όνομα χρήστη.
     * @param password Ο κωδικός πρόσβασης.
     * @return true αν τα στοιχεία είναι σωστά και η είσοδος ήταν επιτυχής, αλλιώς false.
     */
    public boolean login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                this.loggedInUser = u;
                return true;
            }
        }
        return false;
    }

    /**
     * Αποσυνδέει τον χρήστη.
     */
    public void logout() {
        this.loggedInUser = null;
    }

    /**
     * Επιστρέφει τον τρέχοντα συνδεδεμένο χρήστη.
     *
     * @return Ο τρέχοντα συνδεδεμένος χρήστης (User).
     */
    public User getLoggedInUser() {
        return loggedInUser;
    }

    // Διαχείριση Αυτοκινήτων

    /**
     * Προσθέτει ένα νέο αυτοκίνητο στη λίστα αν δεν υπάρχει ήδη.
     *
     * @param c Το αυτοκίνητο προς προσθήκη.
     * @throws Exception Αν το αυτοκίνητο με το ίδιο ID ή πινακίδα υπάρχει ήδη.
     */

    public void addCar(Car c) throws Exception {
        for (Car car : cars) {
            if ((car.getId().equals(c.getId()) || car.getLicensePlate().equals(c.getLicensePlate()))) {
                throw new Exception("Το αυτοκίνητο υπάρχει ήδη");
            }
        }
        cars.add(c);
        saveData();
    }

    /**
     * Αναζητά αυτοκίνητα που ταιριάζουν με τα κριτήρια αναζήτησης.
     * Αναζητά σε ID, πινακίδα, μάρκα, μοντέλο, χρώμα και κατάσταση.
     *
     * @param criteria Τα κριτήρια αναζήτησης (μπορεί να είναι μέρος του ID, της πινακίδας, της μάρκας, του μοντέλου, του χρώματος ή της κατάστασης).
     * @return Μια λίστα με τα αυτοκίνητα που ταιριάζουν με τα κριτήρια.
     */
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

    //Διαχείριση Πελατών

    /**
     * Προσθέτει έναν νέο πελάτη στη λίστα αν δεν υπάρχει ήδη.
     *
     * @param customer Ο πελάτης προς προσθήκη.
     * @throws Exception Αν ο πελάτης με το ίδιο ΑΦΜ υπάρχει ήδη.(καθώς το ΑΦΜ είναι μοναδικό για κάθε πελάτη)
     */
    public void addCustomer(Customer customer) throws Exception {
        for (Customer c : customers) {
            if (c.getVatNumber().equals(customer.getVatNumber())) {
                throw new Exception("Ο πελάτης υπάρχει ήδη");
            }
        }
        customers.add(customer);
        saveData();
    }

    /**
     * Αναζητά πελάτες που ταιριάζουν με τα κριτήρια αναζήτησης.
     * Αναζητά σε ΑΦΜ, πλήρες όνομα, email και αριθμό τηλεφώνου.
     *
     * @param criteria Τα κριτήρια αναζήτησης (μπορεί να είναι μέρος του ΑΦΜ, του πλήρους ονόματος, του email ή του αριθμού τηλεφώνου).
     * @return Μια λίστα με τους πελάτες που ταιριάζουν με τα κριτήρια.
     */
    public ArrayList<Customer> searchCustomer(String criteria) {
        ArrayList<Customer> results = new ArrayList<>();
        for (Customer c : customers) {
            if (c.getVatNumber().contains(criteria) || c.getFullName().contains(criteria) ||
                    c.getEmail().contains(criteria) || c.getPhoneNumber().contains(criteria)) {
                results.add(c);
            }
        }
        return results;
    }

    // Διαχείριση Ενοικιάσεων

    /**
     * Δημιουργεί μια νέα ενοικίαση για ενα συγκεκριμένο αυτοκίνητο και πελάτη
     * και ενημερώνει την κατάσταση του αυτοκινήτου σε "Ενοικιασμένο".
     *
     * @param carId Το μοναδικό Id του αυτοκινήτου προς ενοικίαση.
     * @param customer Το όνομα του πελάτη που ενοικιάζει το αυτοκίνητο.
     * @param start Η ημερομηνία έναρξης της ενοικίασης.
     * @param end Η ημερομηνία λήξης της ενοικίασης.
     * @throws Exception Αν το αυτοκίνητο δεν βρεθεί ή δεν είναι διαθέσιμο.
     */
    public void rentCar(String carId, String customer, LocalDate start, LocalDate end) throws Exception {
        Car c = cars.stream().filter(veh -> veh.getId().equals(carId)).findFirst().orElse(null);
        if (c == null) throw new Exception("Το όχημα δεν βρέθηκε.");
        if (!c.getStatus().equals("Διαθέσιμο")) throw new Exception("Το όχημα δεν είναι διαθέσιμο.");

        String rentalId = UUID.randomUUID().toString(); // Μοναδικό ID για την ενοικίαση
        Rental rental = new Rental(rentalId, carId, customer, loggedInUser.getUsername(), start, end, true);

        rentals.add(rental);

        // Ενημέρωση κατάστασης του οχήματος σε "Ενοικιασμένο"
        c.setStatus("Ενοικιασμένο");
        saveData();
    }

    /**
     * Επιστρέφει ένα ενοικιασμένο αυτοκίνητο και ενημερώνει την κατάσταση της ενοικίασης και του αυτοκινήτου.
     *
     * @param rentalId Το μοναδικό Id της ενοικίασης που πρόκειται να επιστραφεί.
     * @throws Exception Αν η ενοικίαση δεν βρεθεί ή έχει ήδη ολοκληρωθεί.
     */
    public void returnCar(String rentalId) throws Exception {
        Rental rental = rentals.stream().filter(r -> r.getRentalId().equals(rentalId)).findFirst().orElse(null);
        if (rental == null) throw new Exception("Η ενοικίαση δεν βρέθηκε.");
        if (!rental.isActive()) throw new Exception("Η ενοικίαση έχει ήδη ολοκληρωθεί.");

        rental.setActive(false);

        // Ενημέρωση κατάστασης του αυτοκινήτου σε "Διαθέσιμο"
        Car v = cars.stream().filter(veh -> veh.getId().equals(rental.getCarId())).findFirst().orElse(null);
        if (v != null) {
            v.setStatus("Διαθέσιμο");
        }
        saveData();
    }
}