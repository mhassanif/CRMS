
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
        this.isCompleted = false; // Transaction is not completed initially
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
        return "TransactionID: " + transactionID + ", Car: " + car + ", Renter: " + renter + 
               ", Days Rented: " + daysRented + ", Distance Traveled: " + distanceTraveled + 
               ", Insurance Added: " + insuranceAdded + ", Total Cost: " + totalCost +
               ", Damage Cost: " + damageCost + ", Completed: " + isCompleted;
    }
}
