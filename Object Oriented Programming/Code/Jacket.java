// Name: Alejandra de Osma, Minguri Yuan, Christian Santiago, Christian Huber
// Assignment: Final Project Store Shipping System.
// Course: CMS 270  Object Oriented Design and Development
// Due Date: 04/24/20
// Honor Declaration: "On our honor, we have not given, nor received, nor witnessed any unauthorized assistance on this work."
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
public class Jacket extends Product implements ValueOptions {
	//----------------------------------------------------------
	//----------------------------------------------------------
	// DATA MEMBERS
	private String material;  
	private String designer;               
	
	//----------------------------------------------------------
	//----------------------------------------------------------
	// CONSTRUCTORS
	public Jacket() {
		super();
    	material = "";
    	designer = "";
	}

	//----------------------------------------------------------
	public Jacket(String id, String name, double price, int stck) {
		super(id, name, price, stck);
		material = "";                    
		designer = "";
	}

	//----------------------------------------------------------
	//----------------------------------------------------------
	// ACCESSORS AND MUTATORs	
	public String getMaterial() {
		return material;
	}

	//----------------------------------------------------------
	public void setMaterial(String mat) { 
		material = mat;
	}
	
	//----------------------------------------------------------
	public String getDesigner() {
		return designer;
	}

	//----------------------------------------------------------
	public void setDesigner(String designerName) { 
		designer = designerName;
	}
	
	//----------------------------------------------------------
	//----------------------------------------------------------
	// VALUEOPTIONS INTERFACE IMPLEMENTATION
	public boolean isPremium() {
		if (material.contentEquals("leather") || material.contentEquals("down")
		 || material.contentEquals("suede")   || material.contentEquals("fur")
		 || designer.contentEquals("Gucci")   || designer.contentEquals("LV")
		 || designer.contentEquals("Prada")) 
		{
			return true;
		} else {                                  
			return false;
		}
	}

	//----------------------------------------------------------
	public void addCustomization(boolean premiumStatus) {          
		if (premiumStatus == true) {
			setUnitPrice(getUnitPrice()+30.00);                           
			setProdName (getProdName ()+" CSTM");   
		}
	}
	
	//----------------------------------------------------------
	//-----------------------------------------------------------
}