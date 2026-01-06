package api;

/**
 * Η κλάση Car αναπαριστά ένα αυτοκίνητο στο σύστημα ενοικίασης αυτοκινήτων.
 * Περιέχει πληροφορίες όπως η πινακίδα κυκλοφορίας, η μάρκα, το μοντέλο, το έτος κατασκευής,
 * το χρώμα και η κατάσταση του οχήματος.
 * Μπορεί να χρησιμοποιηθεί για να επιστρέψει όλες τις πληροφορίες για ενα συγκεκριμένο αμάξι,
 * καθώς και να αλλάξει την κατάσταση του οχήματος (διαθέσιμο, ενοικιασμένο κτλ).
 *
 *
 * @author Μαριλένα Μπαλαμπανίδου ΑΕΜ 4977
 * @since 2025-12-17
 */
public class Car {

    /** Το μοναδικό αναγνωριστικό του οχήματος */
    private String id;
    /** Η πινακίδα κυκλοφορίας του οχήματος */
    private String licensePlate;
    /** Η μάρκα του οχήματος (π.χ. Toyota, Ford) */
    private String brand;
    /** Ο τύπος του οχήματος (π.χ. SUV, Sedan) */
    private String type;
    /** Το συγκεκριμένο μοντέλο του οχήματος (π.χ  Corolla, Civic, Focus) */
    private String model;
    /** Το έτος κατασκευής του οχήματος */
    private int year;
    /** Το χρώμα του οχήματος */
    private String color;
    /** Η τρέχουσα κατάσταση του οχήματος (π.χ. διαθέσιμο, ενοικιασμένο) */
    private String status;

    /**
     * Ο κατασκευαστής της κλάσης Car, που κατασκευάζει ένα νέο αντικείμενο Car.
     *
     * @param id Το μοναδικό αναγνωριστικό του οχήματος
     * @param licensePlate Η πινακίδα κυκλοφορίας του οχήματος
     * @param brand Η μάρκα του οχήματος (π.χ. Toyota, Ford)
     * @param type Ο τύπος του οχήματος (π.χ. SUV, Sedan)
     * @param model Το συγκεκριμένο μοντέλο του οχήματος (π.χ  Corolla, Civic, Focus)
     * @param year Το έτος κατασκευής του οχήματος
     * @param color Το χρώμα του οχήματος
     * @param status Η τρέχουσα κατάσταση του οχήματος (π.χ. διαθέσιμο, ενοικιασμένο)
     */

    public Car (String id, String licensePlate, String brand, String model,String type, int year, String color, String status) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.type = type;
        this.model = model;
        this.year = year;
        this.color = color;
        this.status = status;
    }

    // Getters

    /**
     * Επιστρέφει το μοναδικό αναγνωριστικό του οχήματος.
     *
     * @return Το αναγνωριστικό του οχήματος (String)
     */
    public String getId() {
        return id;
    }
    /**
     * Επιστρέφει την πινακίδα κυκλοφορίας του οχήματος.
     *
     * @return Η πινακίδα κυκλοφορίας του οχήματος (String)
     */
    public String getLicensePlate() {
        return licensePlate;
    }
    /**
     * Επιστρέφει τον τύπο του οχήματος.
     *
     * @return Ο τύπος του οχήματος (String)
     */
    public String getType() {
        return type;
    }
    /**
     * Επιστρέφει τη μάρκα του οχήματος.
     *
     * @return Η μάρκα του οχήματος (String)
     */
    public String getBrand() {
        return brand;
    }
    /**
     * Επιστρέφει το μοντέλο του οχήματος.
     *
     * @return Το μοντέλο του οχήματος (String)
     */
    public String getModel() {
        return model;
    }
    /**
     * Επιστρέφει το έτος κατασκευής του οχήματος.
     *
     * @return Το έτος κατασκευής του οχήματος (int)
     */
    public int getYear() {return year;}
    /**
     * Επιστρέφει το χρώμα του οχήματος.
     *
     * @return Το χρώμα του οχήματος (String)
     */
    public String getColor() {return color;}
    /**
     * Επιστρέφει την τρέχουσα κατάσταση του οχήματος.
     *
     * @return Η κατάσταση του οχήματος (String)
     */
    public String getStatus() {return status;}

    // Setters

    /**
     * Ορίζει το χρώμα του οχήματος.
     * @param color Το νέο χρώμα του οχήματος (String)
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * Ορίζει την πινακίδα κυκλοφορίας του οχήματος.
     * @param licensePlate Η νέα πινακίδα κυκλοφορίας του οχήματος (String)
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    /**
     * Ορίζει τον τύπο του οχήματος.
     * @param type Ο νέος τύπος του οχήματος (String)
     */
    public void setType (String type) {
        this.type = type;
    }
    /**
     * Ορίζει τη μάρκα του οχήματος.
     * @param brand Η νέα μάρκα του οχήματος (String)
     */
    public void setBrand (String brand) {
        this.brand = brand;
    }
    /**
     * Ορίζει το μοντέλο του οχήματος.
     * @param model Το νέο μοντέλο του οχήματος (String)
     */
    public void setModel (String model) {
        this.model = model;
    }
    /**
     * Ορίζει την τρέχουσα κατάσταση του οχήματος.
     * @param status Η νέα κατάσταση του οχήματος (String)
     */
    public void setStatus(String status) {
        this.status = status;
    }



    /**
     * Μετατρέπει τα δεδομένα του χρήστη σε μορφή CSV όπως αποθηκεύονται στο αρχείο.
     * Η σειρά των πεδίων είναι: id, licensePlate, brand, type, model, year, color, status.
     *
     * @return Μια συμβολοσειρά (String) με όλες τις τιμές.
     */
    public String toCSV() {
        return id + "," + licensePlate + "," + brand + "," + type + "," + model + "," + year + "," + color + "," + status;
    }

    public String toString() {
        return "Πινακίδα: " + licensePlate +
                " | Μάρκα: " + brand +
                " | Μοντέλο: " + model +
                " | Έτος: " + year +
                " | Κατάσταση: " + status;
    }
}