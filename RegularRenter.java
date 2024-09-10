public class RegularRenter extends Renter {

    private static final double STANDARD_RATE = 1.0; // Standard rate multiplier for regular renters

    // Constructor
    public RegularRenter(String renterID, String name, String email, String phoneNumber, String address) {
        super(renterID, name, email, phoneNumber, address);
    }

    @Override
    public double calculateRentalCost(double baseRent, int daysRented, boolean insuranceAdded) {
        // Regular renters pay standard rate, no discounts or additional charges
        return baseRent * daysRented * STANDARD_RATE;
    }
}
