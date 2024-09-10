//public class Main {
//    public static void main(String[] args) {
//        CRMS crms = new CRMS();
//        crms.menu(); 
//    }
//}
// 

public class Main {
    public static void main(String[] args) {
        CRMS crms = new CRMS();

        // Add Cars
        Car compactCar = new CompactCar("Toyota", "Corolla", 2019, 25.0, "XYZ123"); // CompactCar with base rate of $25
        Car suv = new SUV("Ford", "Explorer", 2020, 50.0, "ABC456"); // SUV with base rate of $50
        Car luxuryCar = new LuxuryCar("BMW", "X5", 2021, 100.0, "LMN789"); // LuxuryCar with base rate of $100

        crms.addCar(compactCar);
        crms.addCar(suv);
        crms.addCar(luxuryCar);

        // Add Renters
        Renter regularRenter = new RegularRenter("R1", "John Doe", "johndoe@example.com", "555-1234", "123 Elm St");
        Renter frequentRenter = new FrequentRenter("F1", "Jane Smith", "janesmith@example.com", "555-5678", "456 Maple Ave");
        Renter corporateRenter = new CorporateRenter("C1", "ACME Corp", "contact@acmecorp.com", "555-9876", "789 Oak Blvd");

        crms.addRenter(regularRenter);
        crms.addRenter(frequentRenter);
        crms.addRenter(corporateRenter);
        
        System.out.println("Availible Cars : ");
        crms.displayAvailableCars();
        
        System.out.println("-----------------------------");

        System.out.println("Renters : ");
        crms.displayAvailableCars();

        // Rent Cars
        System.out.println("-----------------------------");
        System.out.println("Renting Cars...");
//        System.out.println("CompactCar for RegularRenter without insurance!");
        crms.rentCar(compactCar.getCarID(), regularRenter.getRenterID(), 5, 100, false); 
//        System.out.println("SUV for FrequentRenter with insurance!");
        crms.rentCar(suv.getCarID(), frequentRenter.getRenterID(), 3, 200, true);  // 
//        System.out.println("LuxuryCar for CorporateRenter with insurance!");
        crms.rentCar(luxuryCar.getCarID(), corporateRenter.getRenterID(), 2, 50, true);   // 

        // View Transactions
        
//        System.out.println("-----------------------------");
//        System.out.println("Viewing Transactions after Renting...");
//        crms.displayTransactions(); // Check if rates, discounts, and tax are applied correctly

        // Return Cars
        System.out.println("-----------------------------");
        System.out.println("Returning Cars...");
        crms.returnCar(compactCar.getCarID(), regularRenter.getRenterID(), 50);  // Return CompactCar with $50 damage cost
        crms.returnCar(suv.getCarID(), frequentRenter.getRenterID(), 0);   // Return SUV with no damage
        crms.returnCar(luxuryCar.getCarID(), corporateRenter.getRenterID(), 200); // Return LuxuryCar with $200 damage cost

        // View Transactions After Return
//        System.out.println("Viewing Transactions after Returning...");
//        crms.displayTransactions(); // Check if damage costs are handled correctly and transactions are updated
    }
}
