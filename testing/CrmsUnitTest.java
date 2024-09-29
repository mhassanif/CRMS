	package testing;
	
	import myapp.CRMS;
	import myapp.Car;
	import myapp.CompactCar;
	import myapp.SUV;
	import myapp.Transaction;
	import myapp.LuxuryCar;
	import myapp.Renter;
	import myapp.RegularRenter;
	import myapp.FrequentRenter;
	import myapp.CorporateRenter;
	import static org.junit.Assert.*;
	import org.junit.Before;
	import org.junit.Test;
	
	public class CrmsUnitTest {
	
	    private CRMS crms;
	
	    @Before
	    public void setUp() {
	        crms = new CRMS();
	    }
	    
	    
	    @Test
	    public void testCarCreation() {
	        Car compactCar = new CompactCar("Nissan", "Sentra", 2022, 30.0, "XYZ125");
	        
	        // Check ID not null and the car not rented
	        assertNotNull(compactCar.getCarID());
	        assertFalse(compactCar.isRented());
	    }

	    @Test
	    public void testRenterCreation() {
	        Renter regularRenter = new RegularRenter("R3", "Emily Davis", "emilydavis@example.com", "555-6789", "321 Maple St");
	        
	        // Check ID not null
	        assertNotNull(regularRenter.getRenterID());
	    }

	    @Test
	    public void testAddCarToCRMS() {
	        Car suv = new SUV("Honda", "Pilot", 2023, 60.0, "XYZ126");
	        crms.addCar(suv);
	        
	        // Verify car added 
	        assertTrue(crms.getCars().contains(suv));
	    }

	    @Test
	    public void testAddRenterToCRMS() {
	        Renter frequentRenter = new FrequentRenter("F3", "Charlie Brown", "charliebrown@example.com", "555-3456", "654 Elm St");
	        crms.addRenter(frequentRenter);
	        
	        // Verify renter added
	        assertTrue(crms.getRenters().contains(frequentRenter));
	    }

	
	    @Test
	    public void RegularCompact() {
	        Car compactCar = new CompactCar("Toyota", "Corolla", 2019, 25.0, "XYZ123");
	        Renter regularRenter = new RegularRenter("R1", "John Doe", "johndoe@example.com", "555-1234", "123 Elm St");
	
	        crms.addCar(compactCar);
	        crms.addRenter(regularRenter);
	
	        // Regular Renter rents Compact Car for 5 days, 100 distance, without insurance
	        crms.rentCar(compactCar.getCarID(), regularRenter.getRenterID(), 5, 100.0, false);
	        
	        Transaction lastTransaction = crms.getTransactions().get(crms.getTransactions().size() - 1);
	        double totalCost = lastTransaction.getTotalCost();
	
	        assertTrue(compactCar.isRented());
	        assertEquals(300, totalCost, 0.01);
	    }
	
	    @Test
	    public void FrequentSUV() {
	        Car suv = new SUV("Ford", "Explorer", 2020, 50.0, "ABC456");
	        Renter frequentRenter = new FrequentRenter("F1", "Jane Smith", "janesmith@example.com", "555-8765", "789 Pine Ave");
	
	        crms.addCar(suv);
	        crms.addRenter(frequentRenter);
	
	        // Frequent Renter rents SUV for 2 days, 100 distance, without insurance
	        crms.rentCar(suv.getCarID(), frequentRenter.getRenterID(), 2, 100.0, false);
	        
	        Transaction lastTransaction = crms.getTransactions().get(crms.getTransactions().size() - 1);
	        double totalCost = lastTransaction.getTotalCost();
	
	        assertEquals(279.0, totalCost, 0.01);
	        assertTrue(suv.isRented());
	    }
	
	    @Test
	    public void CorporateLuxury() {
	        Car luxuryCar = new LuxuryCar("BMW", "X5", 2021, 100.0, "LMN789");
	        Renter corporateRenter = new CorporateRenter("C1", "ACME Corp", "contact@acmecorp.com", "555-9876", "789 Oak Blvd");
	
	        crms.addCar(luxuryCar);
	        crms.addRenter(corporateRenter);
	
	        // Corporate Renter rents Luxury Car for 2 days, 50 distance, without insurance
	        crms.rentCar(luxuryCar.getCarID(), corporateRenter.getRenterID(), 2, 50.0, false);
	
	        Transaction lastTransaction = crms.getTransactions().get(crms.getTransactions().size() - 1);
	        double totalCost = lastTransaction.getTotalCost();
	
	        // Expected cost = 2 days * $100/day = $200
	        assertEquals(425.0, totalCost, 0.01);
	        assertTrue(luxuryCar.isRented());
	    }
	
	    @Test
	    public void RegularSUV() {
	        Car suv = new SUV("Chevrolet", "Tahoe", 2021, 50.0, "ABC457");
	        Renter regularRenter = new RegularRenter("R2", "Alice Johnson", "alicejohnson@example.com", "555-5678", "456 Oak St");
	
	        crms.addCar(suv);
	        crms.addRenter(regularRenter);
	
	        // Regular Renter rents SUV for 4 days, 150 distance, with insurance
	        crms.rentCar(suv.getCarID(), regularRenter.getRenterID(), 4, 150.0, true);
	
	        Transaction lastTransaction = crms.getTransactions().get(crms.getTransactions().size() - 1);
	        double totalCost = lastTransaction.getTotalCost();
	
	        assertEquals(1210.0, totalCost, 0.01);
	        assertTrue(suv.isRented());
	    }
	
	    @Test
	    public void FrequentLuxury() {
	        Car luxuryCar = new LuxuryCar("Mercedes", "GLE", 2022, 100.0, "LMN790");
	        Renter frequentRenter = new FrequentRenter("F2", "Bob Brown", "bobbrown@example.com", "555-4321", "101 Maple St");
	
	        crms.addCar(luxuryCar);
	        crms.addRenter(frequentRenter);
	
	        // Frequent Renter rents Luxury Car for 1 day, 80 distance, without insurance
	        crms.rentCar(luxuryCar.getCarID(), frequentRenter.getRenterID(), 1, 80.0, false);
	
	        Transaction lastTransaction = crms.getTransactions().get(crms.getTransactions().size() - 1);
	        double totalCost = lastTransaction.getTotalCost();
	
	        assertEquals(122.4, totalCost, 0.01);
	        assertTrue(luxuryCar.isRented());
	    }
	
	    @Test
	    public void CorporateCompact() {
	        Car compactCar = new CompactCar("Honda", "Civic", 2018, 25.0, "XYZ124");
	        Renter corporateRenter = new CorporateRenter("C1", "ACME Corp", "contact@acmecorp.com", "555-9876", "789 Oak Blvd");
	
	        crms.addCar(compactCar);
	        crms.addRenter(corporateRenter);
	
	        // Corporate Renter rents Compact Car for 3 days, 90 distance, with insurance
	        crms.rentCar(compactCar.getCarID(), corporateRenter.getRenterID(), 3, 90.0, true);
	
	        Transaction lastTransaction = crms.getTransactions().get(crms.getTransactions().size() - 1);
	        double totalCost = lastTransaction.getTotalCost();
	
	       
	        assertEquals(150.45, totalCost, 0.01);
	        assertTrue(compactCar.isRented());
	    }
	}
