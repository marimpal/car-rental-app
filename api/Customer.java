package api;

public class Customer {

    private String vatNumber;
    private String fullName;
    private String email;
    private String phoneNumber;

    public Customer(String vatNumber, String fullName, String email, String phoneNumber) {
        this.vatNumber = vatNumber;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getVatNumber() {
        return vatNumber;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setEmail(String email) {this.email = email;}
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toCSV() {
        return vatNumber + "," + fullName + "," + phoneNumber + "," + email;
    }



}
