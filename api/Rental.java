
package api;

import java.time.LocalDate;

/**
 * Η κλάση Rental αναπαριστά μια ενοικίαση αυτοκινήτου στο σύστημα ενοικίασης αυτοκινήτων.
 * Περιέχει πληροφορίες όπως το αναγνωριστικό της ενοικίασης, το αναγνωριστικό του αυτοκινήτου,
 * τον πελάτη που έκανε την ενοικίαση, τον χρήστη που κατέγραψε την ενοικίαση, την ημερομηνία
 * ενοικίασης, την ημερομηνία επιστροφής του αυτοκινήτου και την κατάσταση της ενοικίασης (ενεργή ή όχι).
 *
 *
 * * @author Μαριλένα Μπαλαμπανίδου ΑΕΜ 4977
 * @since 2025-12-17
 */
public class Rental {
    /** Ο μοναδικός κωδικός της ενοικίασης */
    private String rentalId;
    /** Το αναγνωριστικό του αυτοκινήτου που ενοικιάστηκε */
    private String carId;
    /** Ο πελάτης που έκανε την ενοικίαση */
    private String customer;
    /** Ο χρήστης που κατέγραψε την ενοικίαση */
    private String user;
    /** Η ημερομηνία ενοικίασης */
    private LocalDate rentalDate;
    /** Η ημερομηνία επιστροφής του αυτοκινήτου */
    private LocalDate returnDate;
    /** Η κατάσταση της ενοικίασης (ενεργή ή όχι) */
    private boolean isActive;

    /**
     * Ο κατασκευαστής της κλάσης Rental, που κατασκευάζει ένα νέο αντικείμενο Rental.
     *
     * @param rentalId τo μοναδικό αναγνωριστικό της ενοικίασης
     * @param carId το αναγνωριστικό του αυτοκινήτου που ενοικιάστηκε
     * @param customer ο πελάτης που έκανε την ενοικίαση
     * @param user ο χρήστης που κατέγραψε την ενοικίαση
     * @param rentalDate η ημερομηνία ενοικίασης
     * @param returnDate η ημερομηνία επιστροφής του αυτοκινήτου
     * @param isActive η κατάσταση της ενοικίασης (ενεργή ή όχι)
     */
    public Rental(String rentalId, String carId, String customer, String user, LocalDate rentalDate, LocalDate returnDate, boolean isActive) {
        this.rentalId = rentalId;
        this.carId = carId;
        this.customer = customer;
        this.user = user;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.isActive = isActive;
    }
    // Getters
    /**
     * @return το μοναδικό αναγνωριστικό της ενοικίασης (String)
     */
    public String getRentalId() {
        return rentalId;
    }
    /**
     * @return το αναγνωριστικό του αυτοκινήτου που ενοικιάστηκε (String)
     */
    public String getCarId() {
        return carId;
    }
    /**
     * @return ο πελάτης που έκανε την ενοικίαση (String)
     */
    public String getCustomer() {return customer;}
    /**
     * @return ο χρήστης που κατέγραψε την ενοικίαση (String)
     */
    public String getUser() {
        return user;
    }
    /**
     * @return η ημερομηνία ενοικίασης (LocalDate)
     */
    public LocalDate getRentalDate() {
        return rentalDate;
    }
    /**
     * @return η ημερομηνία επιστροφής του αυτοκινήτου (LocalDate)
     */
    public LocalDate getReturnDate() {
        return returnDate;
    }
    /**
     * @return η κατάσταση της ενοικίασης (boolean)
     */
    public boolean isActive() {
        return isActive;
    }

    // Setters
    /**
     * Ορίζει την κατάσταση της ενοικίασης.
     *
     * @param active η νέα κατάσταση της ενοικίασης
     */
    public void setActive (boolean active) {
        isActive = active;
    }

    /**
     * Μετατρέπει τα δεδομένα του χρήστη σε μορφή CSV όπως αποθηκεύονται στο αρχείο.
     * Η σειρά των πεδίων είναι: Name, Surname, Username, Email, Password
     *
     * @return Μια συμβολοσειρά (String) με όλες τις τιμές.
     */
    public String toCSV() {
        return rentalId + "," + carId + "," + customer + "," + user + "," + rentalDate + "," + returnDate + "," + isActive;
    }
}