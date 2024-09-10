public class CorporateRenter extends Renter {

    private static final double CORPORATE_DISCOUNT_RATE = 0.85; // 15% discount for corporate renters

    // Constructor
    public CorporateRenter(String renterID, String name, String email, String phoneNumber, String address) {
        super(renterID, name, email, phoneNumber, address);
    }

    @Override
    public double calculateRentalCost(double baseRent, int daysRented, boolean insuranceAdded) {
        // Corporate renters get a 15% discount
        double discountedRate = baseRent * CORPORATE_DISCOUNT_RATE;
        return discountedRate * daysRented;
    }
}
