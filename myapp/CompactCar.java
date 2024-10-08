//concrete implementations abstract class Car
//inherit from car
package myapp;

public class CompactCar extends Car {
	
    private static int compactCarCount = 0; //for autoassignning ids
    private static final double BASE_RENTAL_COST = 50.0;

    // Constructor
    public CompactCar(String brand, String model, int year, double rentalFee, String plateNumber) {
    	//calls baseclass constructor to inialize (super)
        super(brand, model, year, rentalFee, plateNumber);
        compactCarCount++;
        setCarID("C" + String.format("%03d", compactCarCount)); // C001 
    }
    
    // polymorphism 
    //    ie baseclass implenting abstract method accordingly 
    
    @Override
    public double calculateRent(int daysRented, double distanceTraveled, boolean insuranceAdded) {
        double distanceCost = 0.10 * distanceTraveled;
        return BASE_RENTAL_COST + distanceCost;
    }

    @Override
    public double calculateInsuranceCost(double baseFee) {
        return 0.0; // CompactCar is not insurable
    }

    @Override
    public boolean isInsurable() {
        return false;
    }
}
