// Name: Alejandra de Osma, Minguri Yuan, Christian Santiago, Christian Huber
// Assignment: Final Project Store Shipping System.
// Course: CMS 270  Object Oriented Design and Development
// Due Date: 04/24/20
// Honor Declaration: "On our honor, we have not given, nor received, nor witnessed any unauthorized assistance on this work."
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.ArrayList;

public class OnlinePurchase extends Purchase {
	// DATA MEMBERS
	private String shippingAddr;
	private int daysUntilDelivery;
	private double shippingCost;
	
	//----------------------------------------------------------
	// CONSTRUCTORS
	public OnlinePurchase() {
		super ();
		shippingAddr = "";
		daysUntilDelivery = 0;
		shippingCost = 0;
	}
	
	//----------------------------------------------------------
	public OnlinePurchase(ArrayList<String> items, ArrayList<Integer> quants, int placementDate) {
		super(items, quants, placementDate);
		shippingAddr = "";
		daysUntilDelivery = 0;
		shippingCost = 0;
	}
	
	//----------------------------------------------------------
	public String getShippingAddr() {
		return shippingAddr;
	}
	
	//----------------------------------------------------------
	public void setShippingAddr(String shipAdd) {
		shippingAddr = shipAdd;
	}
	
	//----------------------------------------------------------
	public int getDaysUntilDelivery() {
		return daysUntilDelivery;
	}
	
	//----------------------------------------------------------
	public void setDaysUntilDelivery(int daysTilDeliver) {
		daysUntilDelivery = daysTilDeliver;
	}
	
	//----------------------------------------------------------
	public double getShippingCost() {
		return shippingCost;
	}
	
	//----------------------------------------------------------
	public void setShippingCost(double shipCost) {
		shippingCost = shipCost;
	}

	// ----------------------------------------------------------
	// ----------------------------------------------------------
	// BUSINESS METHODS
	public void addShippingCost () {
		if (this.getTotalPrice() > 60.00) {
			setTotalPrice(getTotalPrice() + 10.00);
		}
	}
	
	// ----------------------------------------------------------
}