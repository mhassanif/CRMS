//concrete implementations abstract class Car
package myapp;

public class LuxuryCar extends Car {
	// additional members specific to derived class
	// constant/final percentages and attributess 
    private static int luxuryCarCount = 0;
    private static final double BASE_RENTAL_COST = 100.0;
    private static final double LUXURY_TAX = 0.20; // 20 percent 
    private static final double INSURANCE_PERCENTAGE = 0.10; // 10 percent

    // Constructor
    public LuxuryCar(String brand, String model, int year, double rentalFee, String plateNumber) {
        super(brand, model, year, rentalFee, plateNumber);
        luxuryCarCount++;
        //format into a three-digit number
        setCarID("L" + String.format("%03d", luxuryCarCount)); // example L001
    }

    @Override
    public double calculateRent(int daysRented, double distanceTraveled, boolean insuranceAdded) {
        double distanceCost = 0.20 * distanceTraveled;
        double baseFee = BASE_RENTAL_COST * daysRented;
        double luxuryTax = LUXURY_TAX * baseFee;
        return baseFee + distanceCost + luxuryTax;
    }

    @Override
    public double calculateInsuranceCost(double baseFee) {
        double luxuryTax = LUXURY_TAX * baseFee;
        double totalCost = baseFee + luxuryTax;
        return INSURANCE_PERCENTAGE * totalCost;
    }

    @Override
    public boolean isInsurable() {
        return true;
    }
}
