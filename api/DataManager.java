package api;

public class DataManager {

    public static Map<String, Car> cars = new HashMap<>();
    public static Map<String, Customer> customers = new HashMap<>();
    public static Map<String, Employee> employees = new HashMap<>();
    public static Map<String, Rental> rentals = new HashMap<>();

    public static void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader("vehicles_with_plates.csv"))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) { firstLine = false; continue; }
                String[] values = line.split(",");
                if(values.length >= 8) {
                    int id = Integer.parseInt(values[0].trim());
                    CarType type = CarType.fromString(values[3].trim());
                    CarStatus status = CarStatus.fromString(values[7].trim());

                    Car c = new Car(
                            id,
                            values[1].trim(),
                            values[2].trim(),
                            type,
                            values[4].trim(),
                            Integer.parseInt(values[5].trim()),
                            values[6].trim(),
                            status
                    );
                    // Αποθήκευση στο Map με κλειδί το ID
                    cars.put(String.valueOf(id), c);
                }
            }
        } catch (IOException e) {
            System.out.println("Σφάλμα vehicles CSV: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader("users.csv"))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) { firstLine = false; continue; }
                String[] values = line.split(",");
                if(values.length >= 5) {
                    String username = values[2].trim();
                    Employee emp = new Employee(
                            values[0].trim(),
                            values[1].trim(),
                            username,
                            values[3].trim(),
                            values[4].trim()
                    );
                    // Αποθήκευση στο Map με κλειδί το Username
                    employees.put(username, emp);
                }
            }
        } catch (IOException e) {
            System.out.println("Σφάλμα users CSV: " + e.getMessage());
        }
    }
}
