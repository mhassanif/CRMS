import java.util.ArrayList;
import java.util.Scanner;

public class CRMS {
    
    private ArrayList<Car> cars;
    private ArrayList<Renter> renters;
    private ArrayList<Transaction> transactions;
    private int transactionCounter;


    // Constructor
    public CRMS() {
        this.cars = new ArrayList<>();
        this.renters = new ArrayList<>();
        this.transactions = new ArrayList<>(); 
    }

    // Car Management Methods
    public void addCar(Car car) {
        cars.add(car);
    }

    public void displayAvailableCars() {
        for (Car car : cars) {
            if (!car.isRented()) {
                System.out.println(car);
            }
        }
    }

    public void removeCar(String carID) {
        Car car = findCarByID(carID);
        if (car != null && !car.isRented()) {
            cars.remove(car);
            System.out.println("Car removed: " + car);
        } else if (car != null) {
            System.out.println("Car is currently rented and cannot be removed.");
        } else {
            System.out.println("Car not found.");
        }
    }

    private Car findCarByID(String carID) {
        for (Car car : cars) {
            if (car.getCarID().equals(carID)) {
                return car;
            }
        }
        return null;
    }

    // Renter Management Methods
    public void addRenter(Renter renter) {
        renters.add(renter);
    }

    public void displayRenters() {
        for (Renter renter : renters) {
            System.out.println(renter);
        }
    }

    public void removeRenter(String renterID) {
        Renter renter = findRenterByID(renterID);
        if (renter != null) {
            renters.remove(renter);
            System.out.println("Renter removed: " + renter);
        } else {
            System.out.println("Renter not found.");
        }
    }

    private Renter findRenterByID(String renterID) {
        for (Renter renter : renters) {
            if (renter.getRenterID().equals(renterID)) {
                return renter;
            }
        }
        return null;
    }

 // Rent Car Method
    public void rentCar(String carID, String renterID, int daysRented, double distanceTraveled, boolean insuranceAdded) {
        Car car = findCarByID(carID);
        Renter renter = findRenterByID(renterID);
        
        if (car == null) {
            System.out.println("Car not found.");
            return;
        }
        
        if (renter == null) {
            System.out.println("Renter not found.");
            return;
        }
        
        if (car.isRented()) {
            System.out.println("Car is already rented.");
            return;
        }
        
        double baseRent = car.calculateRent(daysRented, distanceTraveled, insuranceAdded);
        double rentalCost = renter.calculateRentalCost(baseRent, daysRented, insuranceAdded);
        renter.addRentalFee(rentalCost);
        
        car.setRented(true);
        
        // Create a new transaction
        String transactionID = "T" + String.format("%05d", ++transactionCounter);
        Transaction transaction = new Transaction(transactionID, car, renter, daysRented, distanceTraveled, insuranceAdded, rentalCost);
        transactions.add(transaction);

        System.out.println("Car rented: " + car);
        System.out.println("Total rental cost for renter: " + rentalCost);
    }

    // Return Car Method
    public void returnCar(String carID, String renterID, double damageCost) {
        Car car = findCarByID(carID);
        Renter renter = findRenterByID(renterID);
        
        if (car == null) {
            System.out.println("Car not found.");
            return;
        }
        
        if (renter == null) {
            System.out.println("Renter not found.");
            return;
        }
        
        if (!car.isRented()) {
            System.out.println("Car is not currently rented.");
            return;
        }
        
        // Find the corresponding transaction
        for (Transaction transaction : transactions) {
            if (transaction.getCar().equals(car) && !transaction.isCompleted()) {
                transaction.finalizeTransaction(damageCost);
                car.setRented(false);
                System.out.println("Car returned: " + car);
                System.out.println("Total damage cost: " + damageCost);
                System.out.println("Transaction finalized: " + transaction);
                return;
            }
        }

        System.out.println("No active transaction found for this car.");
    }


//    private double calculateDamageCost(double totalCost, double damageCost, boolean isInsurable) {
//        double damageCostPercentage = isInsurable ? 
//            (totalCost - (totalCost * 0.1)) * 0.15 : 
//            totalCost * 0.2;
//        return Math.max(damageCostPercentage, damageCost);
//    }
    
    public void displayTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);  // uses overridden toString() method
            }
        }
    }

    
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nCRMS Menu:");
            System.out.println("1. Add Car");
            System.out.println("2. Display Available Cars");
            System.out.println("3. Remove Car");
            System.out.println("4. Add Renter");
            System.out.println("5. Display Renters");
            System.out.println("6. Remove Renter");
            System.out.println("7. Rent Car");
            System.out.println("8. Return Car");
            System.out.println("9. View Transactions");
            System.out.println("10. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter car type (Compact/SUV/Luxury):");
                    String carType = scanner.nextLine();
                    System.out.println("Enter brand:");
                    String brand = scanner.nextLine();
                    System.out.println("Enter model:");
                    String model = scanner.nextLine();
                    System.out.println("Enter year:");
                    int year = scanner.nextInt();
                    System.out.println("Enter rental fee:");
                    double rentalFee = scanner.nextDouble();
                    System.out.println("Enter plate number:");
                    scanner.nextLine(); // Consume newline
                    String plateNumber = scanner.nextLine();
                    if (carType.equalsIgnoreCase("Compact")) {
                        addCar(new CompactCar(brand, model, year, rentalFee, plateNumber));
                    } else if (carType.equalsIgnoreCase("SUV")) {
                        addCar(new SUV(brand, model, year, rentalFee, plateNumber));
                    } else if (carType.equalsIgnoreCase("Luxury")) {
                        addCar(new LuxuryCar(brand, model, year, rentalFee, plateNumber));
                    }
                    break;

                case 2:
                    System.out.println("Available cars:");
                    displayAvailableCars();
                    break;

                case 3:
                    System.out.println("Enter car ID to remove:");
                    String carID = scanner.nextLine();
                    removeCar(carID);
                    break;

                case 4:
                    System.out.println("Enter renter type (Regular/Frequent/Corporate):");
                    String renterType = scanner.nextLine();
                    System.out.println("Enter renter ID:");
                    String renterID = scanner.nextLine();
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter phone number:");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Enter address:");
                    String address = scanner.nextLine();
                    if (renterType.equalsIgnoreCase("Regular")) {
                        addRenter(new RegularRenter(renterID, name, email, phoneNumber, address));
                    } else if (renterType.equalsIgnoreCase("Frequent")) {
                        addRenter(new FrequentRenter(renterID, name, email, phoneNumber, address));
                    } else if (renterType.equalsIgnoreCase("Corporate")) {
                        addRenter(new CorporateRenter(renterID, name, email, phoneNumber, address));
                    }
                    break;

                case 5:
                    System.out.println("Renters:");
                    displayRenters();
                    break;

                case 6:
                    System.out.println("Enter renter ID to remove:");
                    String renterIDToRemove = scanner.nextLine();
                    removeRenter(renterIDToRemove);
                    break;

                case 7:
                    scanner.nextLine();
                    System.out.println("Enter car ID to rent:");
                    String carIDToRent = scanner.nextLine();
                    System.out.println("Enter renter ID:");
                    String renterIDToRent = scanner.nextLine();
                    System.out.println("Enter number of days rented:");
                    int daysRented = scanner.nextInt();
                    System.out.println("Enter distance traveled:");
                    double distanceTraveled = scanner.nextDouble();
                    scanner.nextLine();// Clear the buffer
                    System.out.println("Add insurance (yes/no):");
                    String insuranceInput = scanner.nextLine().trim().toLowerCase();
                    boolean insuranceAdded;
                    
                    if (insuranceInput.equals("yes")) {
                        insuranceAdded = true;
                    } else if (insuranceInput.equals("no")) {
                        insuranceAdded = false;
                    } else {
                        System.out.println("Invalid input for insurance. Assuming no insurance.");
                        insuranceAdded = false;
                    }
                    
                    rentCar(carIDToRent, renterIDToRent, daysRented, distanceTraveled, insuranceAdded);
                    break;

                case 8:
                    System.out.println("Enter car ID to return:");
                    String carIDToReturn = scanner.nextLine();
                    System.out.println("Enter renter ID:");
                    String renterIDToReturn = scanner.nextLine();
                    System.out.println("Enter damage cost:");
                    double damageCost = scanner.nextDouble();
                    returnCar(carIDToReturn, renterIDToReturn, damageCost);
                    break;
                    
                case 9:
                	displayTransactions();
                	break;
                case 10:
                    exit = true;
                    System.out.println("Exiting the system...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
