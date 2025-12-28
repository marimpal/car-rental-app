package api;

import java.time.LocalDate;

public class Rental {

    private String rentalId;
    private String carId;
    private String customer;
    private String user;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private boolean isActive;


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
    public String getRentalId() {
        return rentalId;
    }
    public String getCarId() {
        return carId;
    }
    public String getCustomer() {
        return customer;
    }
    public String getUser() {
        return user;
    }
    public LocalDate getRentalDate() {
        return rentalDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public boolean isActive() {
        return isActive;
    }


}
