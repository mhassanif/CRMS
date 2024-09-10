public class LuxuryCar extends Car {
    private static int luxuryCarCount = 0;
    private static final double BASE_RENTAL_COST = 100.0;
    private static final double LUXURY_TAX = 0.20;
    private static final double INSURANCE_PERCENTAGE = 0.10;
    private static final double DAMAGE_COST_PERCENTAGE = 0.15;

    // Constructor
    public LuxuryCar(String brand, String model, int year, double rentalFee, String plateNumber) {
        super(brand, model, year, rentalFee, plateNumber);
        luxuryCarCount++;
        setCarID("L" + String.format("%03d", luxuryCarCount)); // e.g., L001
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
