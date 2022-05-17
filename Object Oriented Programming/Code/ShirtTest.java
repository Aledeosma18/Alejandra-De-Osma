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

class ShirtTest {
	//----------------------------------------------------------
	//----------------------------------------------------------
	// CONSTRUCTOR UNIT TESTS
	@Test
	void testShirt() {
		Shirt testShirt = new Shirt();
		
		assertTrue(testShirt instanceof Shirt);
	}
	
	//----------------------------------------------------------
	@Test
	void testShirtArgs() {
		Shirt testShirt = new Shirt("1234","Alejandra",12.2,10);
		
		assertTrue(testShirt instanceof Shirt);
	}
	
	//----------------------------------------------------------
	//----------------------------------------------------------
	// ACCESSOR AND MUTATOR UNIT TESTS
	@Test
	void testGetColor() {
		Shirt  testShirt 	 = new Shirt();
		String expectedColor = "";
		
		String returnColor = testShirt.getColor();
		
		assertEquals(returnColor, expectedColor);
	}

	//----------------------------------------------------------
	@Test
	void testSetColor() {
		Shirt testShirt 	 = new Shirt();
		String expectedColor = "Blue" ;
		
		testShirt.setColor("Blue");
		String returnColor = testShirt.getColor();
		
		assertEquals(returnColor, expectedColor);	
	}
	
	//----------------------------------------------------------
	@Test
	void testGetCloth() {
		Shirt testShirt 	 = new Shirt();
		String expectedCloth = "";

		String returnCloth = testShirt.getCloth();
		
		assertEquals(returnCloth,expectedCloth);
	}

	//----------------------------------------------------------
	@Test
	void testSetCloth() {
		Shirt testShirt 	 = new Shirt();
		String expectedCloth = "Cotton" ;
		
		testShirt.setCloth("Cotton");
		String returnCloth = testShirt.getCloth();
		
		assertEquals(returnCloth,expectedCloth);

	}
	
	//----------------------------------------------------------
	@Test
	void testGetIsFormal() {
		Shirt testShirt = new Shirt();
		boolean expectedFormal = false ;
		
		boolean returnFormal = testShirt.getIsFormal();
		
		assertEquals(returnFormal,expectedFormal);
	}
	
	//----------------------------------------------------------
	@Test
	void testSetIsFormal() {
		Shirt testShirt = new Shirt();
		boolean expectedFormal = true ;

		testShirt.setIsFormal(true);
		boolean returnedFormal = testShirt.getIsFormal();
		
		assertEquals(returnedFormal,expectedFormal);
		
	//----------------------------------------------------------
	}	
}