package myapp;

public class Transaction {
    private String transactionID;
    private Car car;
    private Renter renter;
    private int daysRented;
    private double distanceTraveled;
    private boolean insuranceAdded;
    private double totalCost;
    private double damageCost;
    private boolean isCompleted;

    // Constructor for creating a new transaction
    public Transaction(String transactionID, Car car, Renter renter, int daysRented, double distanceTraveled,
                       boolean insuranceAdded, double totalCost) {
        this.transactionID = transactionID;
        this.car = car;
        this.renter = renter;
        this.daysRented = daysRented;
        this.distanceTraveled = distanceTraveled;
        this.insuranceAdded = insuranceAdded;
        this.totalCost = totalCost;
        this.damageCost = 0.0; // Default damage cost
        
        // Transaction is not completed initially since damage unkown
        this.isCompleted = false;
        // once car returned damage cost adjusted --> Transaction completes
    }

    // Method to finalize the transaction with damage cost
    public void finalizeTransaction(double damageCost) {
        this.damageCost = damageCost;
        this.totalCost += damageCost; // Add damage cost to the total cost
        this.isCompleted = true;
    }

    // Getters and toString() method
    public String getTransactionID() { return transactionID; }
    public Car getCar() { return car; }
    public Renter getRenter() { return renter; }
    public int getDaysRented() { return daysRented; }
    public double getDistanceTraveled() { return distanceTraveled; }
    public boolean isInsuranceAdded() { return insuranceAdded; }
    public double getTotalCost() { return totalCost; }
    public double getDamageCost() { return damageCost; }
    public boolean isCompleted() { return isCompleted; }

    @Override
    public String toString() {
//    	"TransactionID: " + transactionID + 
        return "Car ID: " + car.getCarID() + "\nRenter: " + renter.getRenterID() + 
               "\nDays Rented: " + daysRented + "\nDistance Traveled: " + distanceTraveled + 
               "\nInsurance Added: " + insuranceAdded + "\nTotal Cost: " + totalCost +
               "\nAdditional Damage Cost: " + damageCost + "\nCompleted: " + isCompleted + "\nTotal Bill : " + (totalCost +damageCost) +"\n__________";
    }
}
