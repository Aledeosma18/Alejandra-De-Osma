// Name: Alejandra de Osma, Minguri Yuan, Christian Santiago, Christian Huber
// Assignment: Final Project Store Shipping System.
// Course: CMS 270  Object Oriented Design and Development
// Due Date: 04/24/20
// Honor Declaration: "On our honor, we have not given, nor received, nor witnessed any unauthorized assistance on this work."
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
public class Shoe extends Product implements ValueOptions{
	//----------------------------------------------------------
	//----------------------------------------------------------
	// DATA MEMBERS 
	private String securingMechanism; 
	private String brand;
	private String color;
	
	//----------------------------------------------------------
	//----------------------------------------------------------
	// CONSTRUCTORS
	public Shoe() {
		super();
		securingMechanism = ""; 
		brand = "";
		color = "";
	}
	
	//----------------------------------------------------------
	public Shoe(String id, String name, double price, int stck) {
		super(id, name, price, stck);
		securingMechanism = "";
		brand             = ""; 
		color             = "";
	}
	
	//----------------------------------------------------------
	//----------------------------------------------------------
	// ACCESSORS AND MUTATORS
	public String getSecuringMechanism() {
		return securingMechanism;
	}

	//----------------------------------------------------------
	public void setSecuringMechanism(String secMech) {
		securingMechanism = secMech;
	}
	
	//----------------------------------------------------------
	public String getBrand() {
		return brand;
	}

	//----------------------------------------------------------
	public void setBrand(String brnd) {
		brand = brnd;
	}
	
	//----------------------------------------------------------
	public String getColor() {
		return color;
	}

	//----------------------------------------------------------
	public void setColor(String col) {
		color = col;
	}
	
	//----------------------------------------------------------
	//----------------------------------------------------------
	// VALUEOPTIONS INTERFACE IMPLEMENTATION
	public boolean isPremium() {
		if (securingMechanism.contentEquals("buckle") || color.contentEquals("metallic gold")  
		    || color.contentEquals("metallic silver") || brand.contentEquals("Crocs") 
		    || brand.contentEquals("Air Jordan")      || brand.contentEquals("Lebron James")   
			|| brand.contentEquals("Yeezy")           || brand.contentEquals("LV")
			|| brand.contentEquals("Manolo")) 
		{ 
			return true;
		} else {                                  // added other premium options
			return false;
		}
	}

	//----------------------------------------------------------
	public void addCustomization(boolean premiumStatus) {    
		if (premiumStatus == true) {
			setUnitPrice(getUnitPrice() + 70);  // changed customization price
			setProdName(getProdName()+" CSTM");     // add custom to name of jacket
		}
	}
	
	//----------------------------------------------------------
}