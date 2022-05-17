// Name: Alejandra de Osma, Minguri Yuan, Christian Santiago, Christian Huber
// Assignment: Final Project Store Shipping System.
// Course: CMS 270  Object Oriented Design and Development
// Due Date: 04/24/20
// Honor Declaration: "On our honor, we have not given, nor received, nor witnessed any unauthorized assistance on this work."
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.ArrayList;

public class Customer {
	// ----------------------------------------------------------
	// ----------------------------------------------------------
	// DATA MEMBERS
	private String custName;
	private String custAddress;
	private String phoneNum;
	private int accountID;
	private ArrayList<Purchase> purchasesMade;

	// ----------------------------------------------------------
	// ----------------------------------------------------------
	// CONSTRUCTORS
	public Customer() {
		custName      = "";
	    custAddress   = "";
	    phoneNum      = "";
	    accountID     = 0 ;
	    purchasesMade = new ArrayList <Purchase> ();
	}

	// ----------------------------------------------------------
	public Customer(String name, String addr, String pNum, int acctID) {
		custName      = name;
		custAddress   = addr;
		phoneNum      = pNum;	
		accountID     = acctID;
		purchasesMade = new ArrayList <Purchase> ();
	}

	//----------------------------------------------------------	
	// ----------------------------------------------------------
	// ACCESSORS AND MUTATORS
	public String getCustName() {
		return custName;
	}

	// ----------------------------------------------------------
	public void setCustName(String name) {
		custName = name;
	}
	
	//----------------------------------------------------------
	public String getCustAddress() {
		return custAddress;
	}

	// ----------------------------------------------------------
	public void setCustAddress(String address) {
		custAddress = address;
	}
	
	//----------------------------------------------------------
	public String getPhoneNum() {
		return phoneNum;
	}

	//----------------------------------------------------------
	public void setPhoneNum(String pnum) {
		phoneNum = pnum;
	}

	//----------------------------------------------------------
	public int getAccountID() {
		return accountID;
	}

	//----------------------------------------------------------
	public void setAccountID(int id) {
		accountID = id;
	}
	
	//----------------------------------------------------------
	public ArrayList<Purchase> getPurchasesMade() {
		return purchasesMade;
	}

	//----------------------------------------------------------            
	public void setPurchasesMade(ArrayList<Purchase> listOfPurchs) {        
		purchasesMade = listOfPurchs;                                       
	}

	//---------------------------------------------------------- 
	//---------------------------------------------------------- 
	// TOSTRING 
	public String toString(){
		return "Customer: "+ custName+"\nAccount ID: "+accountID+"\nPhone Number: "+phoneNum+"\nAddress: "+custAddress ;
	}

	//---------------------------------------------------------- 
}