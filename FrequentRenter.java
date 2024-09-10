public class FrequentRenter extends Renter {

    private static final double DISCOUNT_RATE = 0.9; // 10% discount for frequent renters

    // Constructor
    public FrequentRenter(String renterID, String name, String email, String phoneNumber, String address) {
        super(renterID, name, email, phoneNumber, address);
    }

    @Override
    public double calculateRentalCost(double baseRent, int daysRented, boolean insuranceAdded) {
        // Frequent renters get a 10% discount
        double discountedRate = baseRent * DISCOUNT_RATE;
        return discountedRate * daysRented;
    }
}
