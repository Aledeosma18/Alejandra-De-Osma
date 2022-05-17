// Name: Alejandra de Osma, Minguri Yuan, Christian Santiago, Christian Huber
// Assignment: Final Project Store Shipping System.
// Course: CMS 270  Object Oriented Design and Development
// Due Date: 04/24/20
// Honor Declaration: "On our honor, we have not given, nor received, nor witnessed any unauthorized assistance on this work."
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
public class Shirt extends Product {
	//----------------------------------------------------------
	//----------------------------------------------------------
	// DATA MEMBERS
	private String color;        
	private String cloth;        
	private boolean isFormal;
	
	//----------------------------------------------------------
	//----------------------------------------------------------
	// CONSTRUCTORS
	public Shirt() {
		super ();
		color 	 = "";
		cloth	 = "";
		isFormal = false;
	}
	
	//----------------------------------------------------------
	public Shirt(String id, String name, double price, int stck) {
		super(id, name, price, stck);
	    color  	 = "";
	    cloth	 = "";
	    isFormal = false;
	}
  
	//----------------------------------------------------------
	//----------------------------------------------------------
	// ACCESSORS AND MUTATORS
	public String getColor() {          
		return color;                   
	}

	//----------------------------------------------------------
	public void setColor(String col) {
		color = col;
	}
	
	//----------------------------------------------------------
    public String getCloth () {
    	return cloth;
    }

	//----------------------------------------------------------
    public void setCloth (String clothType) {
	    cloth = clothType;
    }

    //----------------------------------------------------------
    public boolean getIsFormal () {
    	return isFormal;
	}

    //----------------------------------------------------------
    public void setIsFormal (boolean formal) {
    	isFormal = formal; 
	}
	
    //----------------------------------------------------------
}