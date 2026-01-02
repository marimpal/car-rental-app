package api;

/**
 * Η κλάση Customer αναπαριστά έναν πελάτη στο σύστημα ενοικίασης αυτοκινήτων.
 * Περιέχει πληροφορίες όπως ο ΑΦΜ, το πλήρες όνομα, το email και ο αριθμός τηλεφώνου του πελάτη.
 * Μπορεί να χρησιμοποιηθεί για να επιστρέψει όλες τις πληροφορίες για έναν συγκεκριμένο πελάτη,
 * καθώς και να αλλάξει κάποια στοιχεία επικοινωνίας του πελάτη.
 *
 * @author Μαριλένα Μπαλαμπανίδου ΑΕΜ 4977
 * @since 2024-12-12
 */
public class Customer {

    /** Το ΑΦΜ του πελάτη */
    private String vatNumber;
    /** Το πλήρες όνομα του πελάτη */
    private String fullName;
    /** Το email του πελάτη */
    private String email;
    /** Ο αριθμός τηλεφώνου του πελάτη */
    private String phoneNumber;

    /**
     * Ο κατασκευαστής της κλάσης Customer, που κατασκευάζει ένα νέο αντικείμενο Customer
     *
     * @param vatNumber τo ΑΦΜ του πελάτη
     * @param fullName το πλήρες όνομα του πελάτη
     * @param email το email του πελάτη
     * @param phoneNumber ο αριθμός τηλεφώνου του πελάτη
     */
    public Customer(String vatNumber, String fullName, String email, String phoneNumber) {
        this.vatNumber = vatNumber;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters

    /**
     * @return το ΑΦΜ του πελάτη (String)
     */
    public String getVatNumber() {
        return vatNumber;
    }
    /**
     * @return το πλήρες όνομα του πελάτη (String)
     */
    public String getFullName() {
        return fullName;
    }
    /**
     * @return το email του πελάτη (String)
     */
    public String getEmail() {
        return email;
    }
    /**
     * @return ο αριθμός τηλεφώνου του πελάτη (String)
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters
    /**
     * Θέτει το πλήρες όνομα του πελάτη.
     *
     * @param fullName το νέο πλήρες όνομα του πελάτη
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    /**
     * Θέτει το email του πελάτη.
     *
     * @param email το νέο email του πελάτη
     */
    public void setEmail(String email) {this.email = email;}
    /**
     * Θέτει τον αριθμό τηλεφώνου του πελάτη.
     *
     * @param phoneNumber ο νέος αριθμός τηλεφώνου του πελάτη
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Μετατρέπει τα δεδομένα του χρήστη σε μορφή CSV όπως αποθηκεύονται στο αρχείο.
     * Η σειρά των πεδίων είναι: Name, Surname, Username, Email, Password
     *
     * @return Μια συμβολοσειρά (String) με όλες τις τιμές.
     */
    public String toCSV() {
        return vatNumber + "," + fullName + "," + phoneNumber + "," + email;
    }



}
