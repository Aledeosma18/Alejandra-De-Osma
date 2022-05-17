// Name: Alejandra de Osma, Minguri Yuan, Christian Santiago, Christian Huber
// Assignment: Final Project Store Shipping System.
// Course: CMS 270  Object Oriented Design and Development
// Due Date: 04/24/20
// Honor Declaration: "On our honor, we have not given, nor received, nor witnessed any unauthorized assistance on this work."
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.ArrayList;

public class StorePurchase extends Purchase {
	
	//----------------------------------------------------------
	// DATA MEMBERS
	private boolean pickupReady;
	private int customerPickupDaysLeft;
	
	//----------------------------------------------------------
	// CONSTRUCTORS
	public StorePurchase(){
		super();
		pickupReady = false;
		customerPickupDaysLeft = 0;
	}
	
	//----------------------------------------------------------	
	public StorePurchase(ArrayList<String> items, ArrayList<Integer> quants, int placementDate) {
		super(items, quants, placementDate);
		pickupReady = false;
		customerPickupDaysLeft = 0;
	}
	
	//----------------------------------------------------------
	//----------------------------------------------------------
	// ACCESSORS AND MUTATORS
	public boolean getIsPickupReady() {
		return pickupReady;
	}

	//----------------------------------------------------------
	public void setIsPickupReady(boolean pickupReady) {
		this.pickupReady = pickupReady;
	}
	
	//----------------------------------------------------------
	public int getCustomerPickupDaysLeft() {
		return customerPickupDaysLeft;
	}

	//----------------------------------------------------------
	public void setCustomerPickupDaysLeft(int customerPickupDaysLeft) {
		this.customerPickupDaysLeft = customerPickupDaysLeft;
	}
	
	//----------------------------------------------------------
	//----------------------------------------------------------
	// BUSINESS METHODS
	public int determineNumPickupDaysLeft(int currentDay) {
		return 2 - (calcNumDaysSincePlaced(currentDay));
	}
	
	//----------------------------------------------------------
}