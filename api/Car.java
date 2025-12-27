package api;

enum CarStatus {
    AVAILABLE,
    RENTED
}
public class Car {
    private String id;
    private String licensePlate;
    private String label;
    private String brand;
    private String model;
    private int year;
    private String color;
    private CarStatus status;

    public Car (String id, String licensePlate, String brand, String model,String label, int year, String color, String status) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.label = label;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.status = CarStatus.AVAILABLE; //Default status

    }

    // Getters
    public String getId() {
        return id;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public String getLabel() {
        return label;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public String getColor() {
        return color;
    }
    public CarStatus getStatus() {
        return status;
    }
    public void setStatus(CarStatus status) {
        this.status = status;
    }
}
