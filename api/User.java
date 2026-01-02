package api;

/**
 * Η κλάση User αναπαριστά έναν χρήστη στο συστήμα ενοικίασης αυτοκινήτων που δημιουργήσαμε.
 * Περιέχει πληροφορίες όπως το όνομα, το επώνυμο, το email, το όνομα χρήστη και τον κωδικό πρόσβασης.
 *
 *
 * @author Μαριλένα Μπαλαμπανίδου ΑΕΜ 4977
 * @since 2025-12-17
 */
public class User {
    /** Το όνομα του χρήστη */
    private String name;
    /** Το επώνυμο του χρήστη */
    private String surname;
    /** Το email του χρήστη */
    private String email;
    /** Το όνομα χρήστη στην εφαρμογή */
    private String username;
    /** Ο κωδικός πρόσβασης του χρήστη */
    private String password;

    /**
     * Ο κατασκευαστής της κλάσης User, που κατασκευάζει ένα νέο αντικείμενο User
     *
     * @param name Το όνομα του χρήστη
     * @param surname Το επώνυμο του χρήστη
     * @param username Το όνομα του χρήστη στην εφαρμογή
     * @param email Το email του χρήστη
     * @param password Ο κωδικός πρόσβασης του χρήστη
     */
    public User(String name,String surname,String username, String email, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.surname = surname;
    }

    // Getters

    /**
     * @return Το όνομα του χρήστη (String)
     */
    public String getName() {
        return name;
    }

    /**
     * @return Το email του χρήστη (String)
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return Το όνομα χρήστη του χρήστη στην εφαρμογή (String)
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return Ο κωδικός πρόσβασης του χρήστη (String)
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return Το επώνυμο του χρήστη (String)
     */
    public String getSurname() {return surname;}

    /**
     * Μετατρέπει τα δεδομένα του χρήστη σε μορφή CSV όπως αποθηκεύονται στο αρχείο.
     * Η σειρά των πεδίων είναι: Name, Surname, Username, Email, Password
     *
     * @return Μια συμβολοσειρά (String) με όλες τις τιμές.
     */
    public String toCSV() {
        return name + "," + surname + "," + username + "," + email + "," + password;
    }
}