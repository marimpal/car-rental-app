package api;


public class Car {
    private String id;
    private String licensePlate;
    private String type;
    private String brand;
    private String model;
    private int year;
    private String color;
    private String status;

    public Car (String id, String licensePlate, String brand, String model,String type, int year, String color, String status) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.status = status;

    }

    // Getters
    public String getId() {
        return id;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public String getType() {
        return type;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {return year;}
    public String getColor() {return color;}
    public String getStatus() {return status;}

    public void setStatus(String status) {
        this.status = status;
    }

    public String toCSV() {
        return id + "," + licensePlate + "," + brand + "," + type + "," + model + "," + year + "," + color + "," + status;
    }
}
