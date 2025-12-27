package api;

public class Rental {

    private String id;
    private String carId;
    private Customer customer;
    private Employee employee;
    private String rentalDate;
    private String returnDate;

    public Rental(String id, String carId, Customer customer, Employee employee, String rentalDate, String returnDate) {
        this.id = id;
        this.carId = carId;
        this.customer = customer;
        this.employee = employee;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }
    // Getters
    public String getId() {
        return id;
    }
    public String getCarId() {
        return carId;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Employee getEmployee() {
        return employee;
    }
    public String getRentalDate() {
        return rentalDate;
    }
    public String getReturnDate() {
        return returnDate;
    }

}
