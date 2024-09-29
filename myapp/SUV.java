//concrete implementations abstract class Car
package myapp;

public class SUV extends Car {
    private static int suvCount = 0;
    private static final double BASE_RENTAL_COST = 70.0;
    private static final double INSURANCE_PERCENTAGE = 0.05;

    // Constructor
    public SUV(String brand, String model, int year, double rentalFee, String plateNumber) {
        super(brand, model, year, rentalFee, plateNumber);
        suvCount++;
        setCarID("S" + String.format("%03d", suvCount)); // e.g., S001
    }

    @Override
    public double calculateRent(int daysRented, double distanceTraveled, boolean insuranceAdded) {
        double distanceCost = 0.15 * distanceTraveled;
        double baseFee = BASE_RENTAL_COST * daysRented;
        return baseFee + distanceCost;
    }

    @Override
    public double calculateInsuranceCost(double baseFee) {
        return INSURANCE_PERCENTAGE * baseFee;
    }

    @Override
    public boolean isInsurable() {
        return true;
    }
}
