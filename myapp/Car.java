// abstract class serveing as a superclass for other specific types of cars
package myapp;


public abstract class Car {
	
	// ecapsulation of properties limiting access (private)
    private String carID;
    private String brand;
    private String model;
    private int year;
    private boolean isRented;
    private double rentalFee;
    private String plateNumber;

    // Constructor
    public Car(String brand, String model, int year, double rentalFee, String plateNumber) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.rentalFee = rentalFee;
        this.plateNumber = plateNumber;
        this.isRented = false; 
    }

    // Getters and setters ->  encapslation
    public String getCarID() { return carID; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public boolean isRented() { return isRented; }
    public double getRentalFee() { return rentalFee; }
    public String getPlateNumber() { return plateNumber; }
    public void setRented(boolean isRented) { this.isRented = isRented; }

    protected void setCarID(String carID) {
        this.carID = carID;
    }

    // Abstract Methods to be implemented by subclasses
    public abstract double calculateRent(int daysRented, double distanceTraveled, boolean insuranceAdded);
    public abstract double calculateInsuranceCost(double baseFee);
    public abstract boolean isInsurable();
    
    // overriding default toString() from object class
    @Override
    public String toString() {
        return "CarID: " + carID + ", Brand: " + brand + ", Model: " + model + ", Year: " + year + 
               ", Rental Fee: " + rentalFee + ", Plate Number: " + plateNumber;
//        + ", Rented: " + isRented;
    }
}
