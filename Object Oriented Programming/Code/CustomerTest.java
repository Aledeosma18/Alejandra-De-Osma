// Name: Alejandra de Osma, Minguri Yuan, Christian Santiago, Christian Huber
// Assignment: Final Project Store Shipping System.
// Course: CMS 270  Object Oriented Design and Development
// Due Date: 04/24/20
// Honor Declaration: "On our honor, we have not given, nor received, nor witnessed any unauthorized assistance on this work."
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class CustomerTest {
	//---------------------------------------------------------- 
	//---------------------------------------------------------- 
	// CONSTRUCTOR METHODS UNIT TESTS
	@Test
	void testCustomerNoArgs() {
		Customer testCustomer = new Customer() ;
		
		assertTrue(testCustomer instanceof Customer);
	}

    //---------------------------------------------------------- 
	@Test
	void testCustomerArgs() {
		Customer testCustomer = new Customer("kate","Holt AVE 221","954 673 2300",1234) ;
		
		assertTrue(testCustomer instanceof Customer);
	}

	//---------------------------------------------------------- 
	//----------------------------------------------------------
	// ACCESSOR AND MUTATOR UNIT TESTS
	@Test
	void testGetCustName() {
		Customer testCustomer = new Customer("kate","Holt AVE 221","954 673 2300",1234) ;
		String   expectedName = "kate";

		String returnName = testCustomer.getCustName();
		
		assertEquals(returnName, expectedName);			
	}

    //---------------------------------------------------------- 
	@Test
	void testSetCustName() {
		Customer testCustomer = new Customer();
		String   expectedName = "Alejandra";

		testCustomer.setCustName("Alejandra");
		String changedName = testCustomer.getCustName();
		
		assertEquals(changedName, expectedName);	
	}

    //----------------------------------------------------------
	@Test
	void testGetCustAddress() {
		Customer testCustomer    = new Customer("kate","Holt AVE 221","954 673 2300",1234) ;
		String   expectedAddress = "Holt AVE 221";
		
		String returnedAddress = testCustomer.getCustAddress();

		assertEquals(returnedAddress, expectedAddress);
	}

	//----------------------------------------------------------
	@Test
	void testSetCustAddress() {
		Customer testCustomer    = new Customer();
		String   expectedAddress = "Rollins College";

		testCustomer.setCustAddress("Rollins College");
		String returnedAddress = testCustomer.getCustAddress();	
		
		assertEquals(returnedAddress, expectedAddress);
	}

	//----------------------------------------------------------
	@Test
	void testGetPhoneNum() {
		Customer testCustomer  = new Customer("kate","Holt AVE 221","954 673 2300",1234) ;
		String   expectedPhone = "954 673 2300";
		
		String returnPhone = testCustomer.getPhoneNum();

		assertEquals(returnPhone, expectedPhone);
	}

	//----------------------------------------------------------
	@Test
	void testSetPhoneNum() {
		Customer testCustomer = new Customer();
		String expectedPhone  = "954 673 2300";

		testCustomer.setPhoneNum("954 673 2300");
		String returnPhone = testCustomer.getPhoneNum();

		assertEquals(returnPhone, expectedPhone);
	}

	//----------------------------------------------------------
	@Test
	void testGetAccountID() {
		Customer testCustomer = new Customer("kate","Holt AVE 221","9546732300",1234) ;
		int expectedAccountID = 1234;
		
		int returnedAccountID = testCustomer.getAccountID();

		assertEquals(returnedAccountID, expectedAccountID);
	}

	//----------------------------------------------------------
	@Test
	void testSetAccountID() {
		Customer testCustomer = new Customer();
		int expectedAccountID = 1234;
		
		testCustomer.setAccountID(1234);
		int returnedAccountID = testCustomer.getAccountID();

		assertEquals(returnedAccountID,expectedAccountID);
	}

	//----------------------------------------------------------
	@Test
	void testGetPurchasesMade() {
		Customer 			testCustomer         = new Customer   (); 
		ArrayList<Purchase> expectedPurchaseList = new ArrayList<>();
	
		ArrayList<Purchase> returnPurchaseList= testCustomer.getPurchasesMade();
		
		assertEquals(expectedPurchaseList, returnPurchaseList);
	}
	
	//----------------------------------------------------------
	@Test
	void testSetPurchasesMade() {
		ArrayList<Purchase> expectedPurchaseList = new ArrayList<>();
		expectedPurchaseList.add(new Purchase ());
		Customer testCustomer = new Customer();
		testCustomer.setPurchasesMade(expectedPurchaseList);

		ArrayList<Purchase> returnedList = testCustomer.getPurchasesMade();
		
		assertEquals(returnedList, expectedPurchaseList);
	}
	
	//----------------------------------------------------------
	@Test
	void testToString() {
		Customer testCustomer = new Customer("Kate","Holt AVE 221","9546732300",1234);
		String expectedString = "Customer: "+"Kate"+"\nAccount ID: "+1234+"\nPhone Number: "+"9546732300"+"\nAddress: "+"Holt AVE 221";

        String toString = testCustomer.toString();

		assertEquals(toString ,expectedString); 
	}
	
	//----------------------------------------------------------
}