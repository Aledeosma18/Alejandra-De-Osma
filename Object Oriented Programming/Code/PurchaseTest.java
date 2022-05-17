// Name: Alejandra de Osma, Minguri Yuan, Christian Santiago, Christian Huber
// Assignment: Final Project Store Shipping System.
// Course: CMS 270  Object Oriented Design and Development
// Due Date: 04/24/20
// Honor Declaration: "On our honor, we have not given, nor received, nor witnessed any unauthorized assistance on this work."
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class PurchaseTest {
	// ----------------------------------------------------------
	// ----------------------------------------------------------
	// CONSTRUCTOR UNIT TESTS
	@Test
	void testPurchase() {
		Purchase purchase = new Purchase();
		
		assertTrue(purchase instanceof Purchase);
		
	}
	
	// ----------------------------------------------------------
	@Test
	void testPurchaseArgs() {
		
		ArrayList<String> itemList = new ArrayList<>();
		ArrayList<Integer>itemListQuantities = new ArrayList<> ();
		
		Purchase purchase = new Purchase(itemList,itemListQuantities,12);
		
		assertTrue(purchase instanceof Purchase);
		
	}

	// ----------------------------------------------------------
	// ----------------------------------------------------------
	// ACCESSORS AND MUTATORS
	@Test
	void testGetIDNoValue() {
		Purchase purchase = new Purchase();
		int ID = purchase.getID();
		int expectedID =1;
		
		assertEquals(ID,expectedID);
	}

	// ----------------------------------------------------------
	@Test
	void testSetID() {
		Purchase purchase = new Purchase();
		purchase.setID(10);
		
		int ID = purchase.getID();
		int expectedID = 10;
		
		assertTrue(ID == expectedID);
		
	}

	// ----------------------------------------------------------
	@Test
	void testGetID() {
		Purchase purchase = new Purchase();
		purchase.setID(20);
		
		int ID = purchase.getID();
		int expectedID = 20;
		
		assertTrue(ID == expectedID);
		
	}
	
	// ----------------------------------------------------------
	void testGetTotalPriceNoValue() {
		Purchase purchase = new Purchase();
		double totPrice = purchase.getTotalPrice();
		double expectedPrice = 0;
		
		assertEquals(totPrice,expectedPrice);
	}

	// ----------------------------------------------------------
	@Test
	void testSetTotalPrice() {
		Purchase purchase = new Purchase();
		purchase.setTotalPrice(10);
		
		double totPrice = purchase.getTotalPrice();
		double expectedPrice = 10;
		
		assertTrue(totPrice == expectedPrice);
		
	}

	// ----------------------------------------------------------
	@Test
	void testGetTotalPrice() {
		Purchase purchase = new Purchase();
		purchase.setTotalPrice(20);
		
		double TotalPrice = purchase.getTotalPrice();
		double expectedPrice = 20;
		
		assertTrue(TotalPrice == expectedPrice);
		
	}
	
	// ----------------------------------------------------------
	@Test
	void testGetOrderItemsIDsEmptyArrayList() {
		Purchase purchase = new Purchase();
		ArrayList<String> list = new ArrayList<>();
		
		ArrayList<String> list2 = purchase.getOrderItemsIDs();
		
		assertEquals(list,list2);
		
	}

	// ----------------------------------------------------------
	@Test
	void testSetOrderItemsIDs() {
		Purchase purchase = new Purchase();
		ArrayList<String> list = new ArrayList<>();
		String s = "";
		list.add(s);
		
		purchase.setOrderItemsIDs(list);
		ArrayList<String> list2 = purchase.getOrderItemsIDs();
		
		assertEquals(list,list2);
	}

	// ----------------------------------------------------------
	@Test
	void testGetOrderItemsIDs() {
		Purchase purchase = new Purchase();
		
		ArrayList<String> list = new ArrayList<>();
		String s1 = "";
		String s2 = "";
		list.add(s1);
		list.add(s2);
		purchase.setOrderItemsIDs(list);
		
		ArrayList<String> list2 = purchase.getOrderItemsIDs();
		
		assertEquals(list,list2);
	
	}
	
	// ----------------------------------------------------------
	@Test
	void testGetOrderItemsQuantitiesEmptyArrayList() {
		Purchase purchase = new Purchase();
		ArrayList<Integer> list = new ArrayList<>();
		
		ArrayList<Integer> list2 = purchase.getOrderItemsQuantities();
		
		assertEquals(list,list2);
		
	}

	// ----------------------------------------------------------
	@Test
	void testSetOrderItemsQuantities() {
		Purchase purchase = new Purchase();
		ArrayList<Integer> list = new ArrayList<>();
		Integer i = 9;
		list.add(i);
		
		purchase.setOrderItemsQuantities(list);
		ArrayList<Integer> list2 = purchase.getOrderItemsQuantities();
		
		assertEquals(list,list2);
	}

	// ----------------------------------------------------------
	@Test
	void testGetOrderItemsQuantities() {
		Purchase purchase = new Purchase();
		
		ArrayList<Integer> list = new ArrayList<>();
		Integer i1 = 0;
		Integer i2 = 0;
		list.add(i1);
		list.add(i2);
		purchase.setOrderItemsQuantities(list);
		
		ArrayList<Integer> list2 = purchase.getOrderItemsQuantities();
		
		assertEquals(list,list2);
	
	}
	
	// ----------------------------------------------------------
	@Test
	void testGetIsHoldNoValue() {
		Purchase purchase = new Purchase();
		
		Boolean hold = purchase.getIsHold();
		boolean expectedHold = false;
	
		assertTrue(hold==expectedHold);
			
	}

	// ----------------------------------------------------------
	@Test
	void testSetIsHold() {
		Purchase purchase = new Purchase();
		purchase.setIsHold(true);
		
		Boolean hold = purchase.getIsHold();
		boolean expectedHold = true;
	
		assertTrue(hold==expectedHold);
	}

	// ----------------------------------------------------------
	@Test
	void testGetIsHold() {
		Purchase purchase = new Purchase();
		purchase.setIsHold(true);
		
		Boolean hold = purchase.getIsHold();
		boolean expectedHold = true;
	
		assertTrue(hold==expectedHold);
	}
	
	// ----------------------------------------------------------
	@Test
	void testGetIsCompleteNoValue() {
		Purchase purchase = new Purchase();
		
		boolean isComplete = purchase.getIsComplete();
		boolean expectedIsComplete= false ;
		
		assertTrue(isComplete == expectedIsComplete);
	}

	// ----------------------------------------------------------
	@Test
	void testSetIsComplete() {
		Purchase purchase = new Purchase();
		purchase.setIsComplete(true);

		boolean isComplete = purchase.getIsComplete();
		boolean expectedIsComplete= true ;
		
		assertTrue(isComplete == expectedIsComplete);
		
	}
	
	// ----------------------------------------------------------
	@Test
	void testGetIsComplete() {
		Purchase purchase = new Purchase();
		purchase.setIsComplete(true);

		boolean isComplete = purchase.getIsComplete();
		boolean expectedIsComplete= true ;
		
		assertTrue(isComplete == expectedIsComplete);
		
	}
	
	// ----------------------------------------------------------
	@Test
	void testGetPlacementDateNoValue() {
		Purchase purchase = new Purchase();
		
		int date = purchase.getPlacementDate();
		int expectedDate = 0 ;
		
		assertTrue(date == expectedDate);
		
	}

	// ----------------------------------------------------------
	@Test
	void testSetPlacementDate() {
		Purchase purchase = new Purchase();
		purchase.setPlacementDate(10);
		
		int date = purchase.getPlacementDate();
		int expectedDate =10 ;
		
		assertTrue(date == expectedDate);
	}

	// ----------------------------------------------------------
	@Test
	void testGetPlacementDate() {
		Purchase purchase = new Purchase();
		purchase.setPlacementDate(10);
		
		int date = purchase.getPlacementDate();
		int expectedDate =10 ;
		
		assertTrue(date == expectedDate);		
	}
	
	//----------------------------------------------------------
	@Test
	void testCalcNumDaysSincePlaced() {
		Purchase purchase = new Purchase();
		purchase.setPlacementDate(3);
		int currentDate = 4;
		int daysWaiting = purchase.calcNumDaysSincePlaced(currentDate);
		int expectedDaysWaiting = 1 ;
		
		assertTrue(daysWaiting == expectedDaysWaiting) ;
		
	}
}