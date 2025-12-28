package api;

public class Rental {

    private String id;
    private String car;
    private Customer customer;
    private User user;
    private String rentalDate;
    private String returnDate;

    public Rental(String id, String car, Customer customer, User user, String rentalDate, String returnDate) {
        this.id = id;
        this.car = car;
        this.customer = customer;
        this.user = user;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }
    // Getters
    public String getId() {
        return id;
    }
    public String getCar() {
        return car;
    }
    public Customer getCustomer() {
        return customer;
    }
    public User getUser() {
        return user;
    }
    public String getRentalDate() {
        return rentalDate;
    }
    public String getReturnDate() {
        return returnDate;
    }

}
