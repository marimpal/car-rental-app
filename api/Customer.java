package api;

public class Customer {

    private String vatNumber;
    private String name;
    private String email;
    private String phoneNumber;

    public Customer(String vatNumber, String name, String email, String phoneNumber) {
        this.vatNumber = vatNumber;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
