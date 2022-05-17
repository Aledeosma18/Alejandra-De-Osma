// Name: Alejandra de Osma, Minguri Yuan, Christian Santiago, Christian Huber
// Assignment: Final Project Store Shipping System.
// Course: CMS 270  Object Oriented Design and Development
// Due Date: 04/24/20
// Honor Declaration: "On our honor, we have not given, nor received, nor witnessed any unauthorized assistance on this work."
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------

public class Product {
	//----------------------------------------------------------
	//----------------------------------------------------------
	// DATA MEMBERS
	private String prodID;
	private String prodName;
	private double unitPrice;
	private int stock;
	
	//----------------------------------------------------------
	//----------------------------------------------------------
	// CONSTRUCTORS
	public Product() {
	    prodID    = "";
	    prodName  = "";
	    unitPrice = 0.0;
	    stock     = 0;
	}
	
	//----------------------------------------------------------
	public Product(String id, String name, double price, int stck) {
		prodID    = id;
		prodName  = name;
		unitPrice = price;
		stock     = stck;
	}	

	//----------------------------------------------------------
	//----------------------------------------------------------
	// ACCESSORS AND MUTATORS
	public String getProdID() {
		return prodID;
	}

	//----------------------------------------------------------
	public void setProdID(String id) {      
		prodID = id;
	}

	//----------------------------------------------------------
	public String getProdName() {
		return prodName;
	}

	//----------------------------------------------------------  
	public void setProdName(String pName) {    
		prodName = pName;
	}

	//----------------------------------------------------------
	public double getUnitPrice() {
		return unitPrice;
	}

	//----------------------------------------------------------
	public void setUnitPrice(double price) {    
		unitPrice = price;
	}
	
	//----------------------------------------------------------
	public int getStock() {
		return stock;
	}

	//----------------------------------------------------------
	public void setStock(int stck) {        
		stock = stck;                         
	}

	//----------------------------------------------------------
	//----------------------------------------------------------
	// BUSINESS METHODS
	public void increaseStock(int resupplySize) {
		stock += resupplySize;	
	}

	//----------------------------------------------------------
	public void decreaseStock(int purchaseSize) {
		stock -= purchaseSize;                        
	}                                              
	
	//----------------------------------------------------------
	// TOSTRING METHODS
	public String receiptToString() {
	    return  String.format("%-6s%-23s%2s%9.2f", prodID, prodName, "$", unitPrice);
	}
	
    //----------------------------------------------------------
    public String inventoryToString() {
	    String baseToString 		= receiptToString();
	    String inventoryAttenuation = String.format(" | %5d |", stock);
	    baseToString 			   += inventoryAttenuation;
	    
	    return baseToString;
	  }
}