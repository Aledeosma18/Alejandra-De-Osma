// Name: Alejandra de Osma, Minguri Yuan, Christian Santiago, Christian Huber
// Assignment: Final Project Store Shipping System.
// Course: CMS 270  Object Oriented Design and Development
// Due Date: 04/24/20
// Honor Declaration: "On our honor, we have not given, nor received, nor witnessed any unauthorized assistance on this work."
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.ArrayList;

public class Purchase {
	//----------------------------------------------------------
	//----------------------------------------------------------
	// DATAMEMBERS
	private static int numPurchases = 0;
	private int ID;
	private double totalPrice;
	private ArrayList<String> IDs;
	private ArrayList<Integer> orderItemsQuantities;
	private boolean isHold;
	private boolean isComplete;
	private int placementDate;

	//----------------------------------------------------------	
	//----------------------------------------------------------	
	// CONSTRUCTORS
	public Purchase() {
		numPurchases++;
		ID = numPurchases;
		totalPrice = 0;
		IDs = new ArrayList<String> ();
		orderItemsQuantities = new ArrayList<Integer> ();
		isHold = false;
		isComplete = false;
		placementDate = 0;
	}

	//----------------------------------------------------------	
	public Purchase(ArrayList<String> items, ArrayList<Integer> quants, int pd) {
		numPurchases++;
		ID = numPurchases;
		totalPrice = 0;
		IDs = items;
		orderItemsQuantities = quants;
		isHold = false;
		isComplete = false;
		placementDate = pd;
	}

	//----------------------------------------------------------
	//----------------------------------------------------------	
	// ACCESSORS AND MUTATORS
	public int getID() {
		return ID;
	}
	
	//----------------------------------------------------------	
	public void setID(int id) {
		ID = id;
	}
	
	//----------------------------------------------------------	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	//----------------------------------------------------------	
	public void setTotalPrice(double tp) {
		totalPrice = tp;
	}
	
	//----------------------------------------------------------		
	public ArrayList<String> getOrderItemsIDs() {
		return IDs;
	}
	
	//----------------------------------------------------------	
	public void setOrderItemsIDs(ArrayList<String> ordItems) {
		IDs = ordItems;
	}
	
	//----------------------------------------------------------	
	public ArrayList<Integer> getOrderItemsQuantities() {
		return orderItemsQuantities;
	}
	
	//----------------------------------------------------------	
	public void setOrderItemsQuantities(ArrayList<Integer> ordItemsQuants) {
		orderItemsQuantities = ordItemsQuants;
	}
	
	//----------------------------------------------------------	
	public boolean getIsHold() {
		return isHold;
	}

	//----------------------------------------------------------	
	public void setIsHold(boolean isHld) {
		isHold = isHld;
	}

	//----------------------------------------------------------	
	public boolean getIsComplete() {
		return isComplete;
	}
	
	//----------------------------------------------------------	
	public void setIsComplete(boolean isCmplt) {
		isComplete = isCmplt;
	}

	//----------------------------------------------------------
	public int getPlacementDate() {
		return placementDate;
	}
	
	//----------------------------------------------------------	
	public void setPlacementDate(int placeDate) {
		placementDate = placeDate;
	}
	
	//----------------------------------------------------------
	//----------------------------------------------------------
	// BUSINESS METHOD
	public int calcNumDaysSincePlaced(int currentDate) {
		return currentDate - placementDate;
	}
}