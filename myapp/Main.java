package myapp;

public class Main {
    public static void main(String[] args) {
    	
        CRMS crms = new CRMS();
        
        
        // dummy cars
        Car compactCar1 = new CompactCar("Toyota", "Corolla", 2019, 25.0, "XYZ123");
        Car compactCar2 = new CompactCar("Honda", "Civic", 2018, 25.0, "XYZ124");
        Car suv1 = new SUV("Ford", "Explorer", 2020, 50.0, "ABC456");
        Car suv2 = new SUV("Chevrolet", "Tahoe", 2021, 50.0, "ABC457");
        Car luxuryCar1 = new LuxuryCar("BMW", "X5", 2021, 100.0, "LMN789");
        Car luxuryCar2 = new LuxuryCar("Mercedes", "GLE", 2022, 100.0, "LMN790");

        //dummt renters
        Renter regularRenter1 = new RegularRenter("R1", "John Doe", "johndoe@example.com", "555-1234", "123 Elm St");
        Renter regularRenter2 = new RegularRenter("R2", "Alice Johnson", "alicejohnson@example.com", "555-5678", "456 Oak St");
        Renter frequentRenter1 = new FrequentRenter("F1", "Jane Smith", "janesmith@example.com", "555-8765", "789 Pine Ave");
        Renter frequentRenter2 = new FrequentRenter("F2", "Bob Brown", "bobbrown@example.com", "555-4321", "101 Maple St");
        Renter corporateRenter1 = new CorporateRenter("C1", "ACME Corp", "contact@acmecorp.com", "555-9876", "789 Oak Blvd");
        
        // add cars
        crms.addCar(compactCar1);
        crms.addCar(compactCar2);
        crms.addCar(suv1);
        crms.addCar(suv2);
        crms.addCar(luxuryCar1);
        crms.addCar(luxuryCar2);

        // add renters
        crms.addRenter(regularRenter1);
        crms.addRenter(regularRenter2);
        crms.addRenter(frequentRenter1);
        crms.addRenter(frequentRenter2);
        crms.addRenter(corporateRenter1);

        // rent cars --> dummy transactions
        crms.rentCar("C001", "R1", 5, 100.0, false); // Compact Car, Regular Renter, 5 days, 100 distance
        crms.rentCar("S001","F1", 3, 200.0, true); // SUV, Frequent Renter, 3 days, 200 distance, insurance
        crms.rentCar("L001", "C1", 2, 50.0, true); // Luxury Car, Corporate Renter, 2 days, 50 distance, insurance

        //return cars
        crms.returnCar("C001", "R1", 50.0); // Return Compact Car with damage cost
        crms.returnCar("S001", "F1", 0.0); // Return SUV with no damage cost

        // menu for further operations and viewing
        crms.menu();
    }
}
