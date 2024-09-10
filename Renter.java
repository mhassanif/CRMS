public abstract class Renter {
    private String renterID;
    private String name;
    private String email;
    private double totalRentalFee;
    private String phoneNumber;
    private String address;

    // Constructor
    public Renter(String renterID, String name, String email, String phoneNumber, String address) {
        this.renterID = renterID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.totalRentalFee = 0.0;
    }

    // Getters and setters
    public String getRenterID() { return renterID; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public double getTotalRentalFee() { return totalRentalFee; }
    public void addRentalFee(double fee) { this.totalRentalFee += fee; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }

    // Abstract method for calculating rental cost based on renter type
    public abstract double calculateRentalCost(double baseRent, int daysRented, boolean insuranceAdded);

    @Override
    public String toString() {
        return "RenterID: " + renterID + ", Name: " + name + ", Email: " + email + 
               ", Total Rental Fee: " + totalRentalFee + ", Phone Number: " + phoneNumber +
               ", Address: " + address;
    }
}
