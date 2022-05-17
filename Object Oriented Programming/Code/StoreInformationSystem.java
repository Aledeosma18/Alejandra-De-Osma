// Name: Alejandra de Osma, Minguri Yuan, Christian Santiago, Christian Huber
// Assignment: Final Project Store Shipping System.
// Course: CMS 270  Object Oriented Design and Development
// Due Date: 04/24/20
// Honor Declaration: "On our honor, we have not given, nor received, nor witnessed any unauthorized assistance on this work."
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.*;
import java.io.*;
	
public class StoreInformationSystem {
	// ----------------------------------------------------------
	// ----------------------------------------------------------
	// MAIN
	public static void main (String[] args) {
		processStoreData();
		System.out.println("\n-------Done-------");
	}
	
	// ----------------------------------------------------------
	// ----------------------------------------------------------
	// BUSINESS METHODS
	public static void processStoreData() {
		try {
			File instructions = new File("src\\StoreData.txt");
	    	Scanner dataScan = new Scanner (instructions);
	    	int     dayCount = 0;
	    	ArrayList <Customer> customerList = new ArrayList <Customer> ();
	    	ArrayList <Product>  productInventoryList = new ArrayList <Product> ();
	    	
	    	// -----
	    	String [] actionIndicator = dataScan.nextLine().split("-");  // action = new day, restock, new customer, purchases, pickup
	    	
	    	while (dataScan.hasNextLine()) {
	    		
	    		System.out.println("------------------------------------------------------------");
	    		dayCount = Integer.parseInt(actionIndicator [1]);
	    		
	    		actionIndicator = dataScan.nextLine().split("-");
	    		while (!actionIndicator[0].contentEquals("Day") && dataScan.hasNextLine()) {
	    			
	    			// -----
		    		if (actionIndicator[0].contentEquals("Day")) {
		    			dayCount = Integer.parseInt(actionIndicator[1]);		  			
		    			cancelOverdueStorePickups(dayCount, customerList);
		    		}
		    		
		    		// -----
		    		if (actionIndicator[0].contentEquals("R")) {	
		    			int numProducts = Integer.parseInt(actionIndicator[1]);  // Gets number of restock/stock orders
		    			for (int i = 0; i < numProducts; i ++) {
		    				String[] tokens = dataScan.nextLine().split("-");
		    				restock(productInventoryList, tokens);
		    			}
		    			processHoldOrders(customerList, productInventoryList); // Checks if held orders can be completed after restock
		    		}
	
		    		// -----
		    		if (actionIndicator[0].contentEquals("NC")) {
		    			int numCustomers = Integer.parseInt(actionIndicator[1]);  // Gets number of new customers in file
		    			for (int i = 0; i < numCustomers; i++) {
		    				String[] tokens = dataScan.nextLine().split("-");
		    				createNewCustomer(tokens, customerList);
		    			}
		    		}
		
		    		// -----
		    		if (actionIndicator[0].contentEquals("P")) {
		    			int numPurchases = Integer.parseInt(actionIndicator[1]);  // Gets number of new purchases in file
		    			for (int i = 0; i < numPurchases; i++) {
		    				String[] tokens = dataScan.nextLine().split("-");
		    				Purchase p = createNewPurchase(tokens, dayCount, productInventoryList, customerList);
		    				System.out.println(attemptToCompletePurchase(p, productInventoryList, dayCount));
		    			}
		    		}
		          
		    		// -----
		    		if (actionIndicator[0].contentEquals("PU")) {
		    			int numPickups = Integer.parseInt(actionIndicator[1]);  // Gets number of new pickups in file
		    			for (int i = 0; i < numPickups; i++) {
		    				String[] tokens = dataScan.nextLine().split("-");
		    				pickUp(customerList, Integer.parseInt(tokens[0]), dayCount, productInventoryList); // Processes orders that are in stock
		    			}
		    		}
		    		
		    		if (dataScan.hasNextLine()) {
		    			actionIndicator = dataScan.nextLine().split("-");
		    		}
	    		}
	    	
	    		if(dayCount > 0) {
	    			printDailyReceipt(customerList, productInventoryList, dayCount);
	    		}
	    			printDailyInventory(productInventoryList, dayCount);
	    	}
	    
		
	    	dataScan.close();	
	    } catch (FileNotFoundException f) {
	    	System.out.println("File Not Found: processStoreData()");
	    	f.printStackTrace();
	    } catch (NullPointerException e) {
	        System.out.println("Nullpointer Exception: processRawStoreData()");
	        e.printStackTrace();
	    }
	}
	
	// ----------------------------------------------------------
	// ----------------------------------------------------------
	// HELPER METHODS
	public static void printDailyReceipt(ArrayList<Customer> customers, ArrayList<Product> products, int dayCount) {
		try{		  
	      if(dayCount != 0) {
	    	  File receipts = new File("src\\CustomerReceipts_Day" + dayCount + ".txt");
		      FileWriter writer = new FileWriter(receipts);
	    	  writer.write("CUSTOMER RECEIPTS FOR DAY " + dayCount + ":\n\n");
	    	  
	    	  for(int i = 0; i < customers.size(); i++) {
	    		  ArrayList<Purchase> purchasesMade = customers.get(i).getPurchasesMade();
	    		  
	    		  	if (purchasesMade.size() != 0) {
	    		  		Purchase tempPurchase = purchasesMade.get(purchasesMade.size()-1);
	    		  		
	    		  		if (tempPurchase.getPlacementDate() == dayCount && !tempPurchase.getIsHold()) {
		    		  		writer.write("Receipt for " + customers.get(i).getCustName() + ":\n\n");
		    		  		writer.write(generateReceiptData(tempPurchase, products)
		    		  				+ "\n-----------------------------------------------------------------\n\n");
	    		  		}
	    		  	}
	    	  }
	    	  
	    	  System.out.println("Receipt file for day " + dayCount + " has been created");
	    	  writer.close();
	      }
	      
	    } catch (FileNotFoundException e) {
	    	System.out.println("File Not Found: createReceipts(), day " + dayCount);
	    	e.printStackTrace();
	    } catch (IOException f) {
	    	System.out.println("IOException: createReceipts(), day " + dayCount);
	    	f.printStackTrace();    
		}
	}
	
	// ----------------------------------------------------------
	public static void printDailyInventory(ArrayList<Product> products, int dayCount) {
		try{
			File inventory = new File("src\\StoreInventory_Day" + dayCount + ".txt");
			FileWriter writer = new FileWriter(inventory);
			String s = String.format("%29s%-12s|%5s |%17s|",
					"_____________________________", " Unit Price ",  " Stock", "   Stock Level   ");
			writer.write("INVENTORY AT THE END OF DAY " + dayCount + ":\n\n" + s);
			for(int i = 0; i < products.size(); i++) {
				writer.write("\n" + products.get(i).inventoryToString() + "  " + getStatusBar(products.get(i)) + "  |");
			}
			System.out.println("\nInventory file for day " + dayCount + " has been created");
			writer.close();
		} catch(FileNotFoundException e) {
			System.out.println("File Not Found: printDailyInventory(), day " + dayCount);
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("IOException: printDailyInventory(), day " + dayCount);
			e.printStackTrace();
		}
	}
		
	// ----------------------------------------------------------
	public static void cancelOverdueStorePickups (int dayCount, ArrayList<Customer> customers) {
		for (int i = 0; i < customers.size(); i++ ) {
			ArrayList <Purchase> purchases = new ArrayList<Purchase>();
			
			for (int g = 0; g < purchases.size(); g++) {
				if (purchases.get(g) instanceof StorePurchase && (dayCount - purchases.get(g).getPlacementDate()) >= 2) {
					purchases.remove(purchases.get(g));	// removes overdue purchase
					System.out.println("Purchase was not picked up in time by " + customers.get(i).getCustName() + " on day " + dayCount);
				}
			}
		}
	}
	
	// ----------------------------------------------------------
	public static void restock(ArrayList<Product> productInventoryList, String [] tokens) {
		String prodIdentifier = tokens[0]; // tells program if the product is new (and what type) or existing product

		// -----
		if(prodIdentifier.contentEquals("shoe") ||prodIdentifier.contentEquals("shirt") ||	// checks if new product
		   prodIdentifier.contentEquals("other")||prodIdentifier.contentEquals("jacket"))
		{
			productInventoryList.add(createProduct(tokens));
			System.out.printf("New Product added to Inventory: %-20s (" + tokens[4] + ")\n",tokens[2]);
		} 
		
		// -----
		else // existing product
		{
			try {
				int index = searchForProductIndex (productInventoryList, tokens[0]);
				productInventoryList.get(index).increaseStock(Integer.parseInt(tokens[1]));   // updates found product stock
				System.out.printf("Restocked %-20s (+" + tokens[1] + ")\n", productInventoryList.get(index).getProdName());
			}
			
			catch (NullPointerException e) {
				System.out.println("Product ID: " + tokens[0] + " not found");			// should not occur but just in case
			}		
		}
	}
	
	// ----------------------------------------------------------
	public static void createNewCustomer (String[] customerData, ArrayList<Customer> customerList) {
		String tempName 	= customerData[0];
		String tempAddress 	= customerData[1];
		String tempPhoneNum = customerData[2];
     	int    tempAcctID   = Integer.parseInt(customerData[3]);
     
     	Customer tempCustomer = new Customer(tempName, tempAddress, tempPhoneNum, tempAcctID);

     	customerList.add(tempCustomer);
     	System.out.println("New Customer created: " + tempCustomer.getCustName());
	}
		
	// ----------------------------------------------------------
	public static Purchase createNewPurchase(String[] tokens, int dayCount, ArrayList <Product> productList, ArrayList <Customer> customerList) {
		Customer purchasingCustomer = searchCustomerListByID(customerList, tokens[1]);
		ArrayList <Purchase> customerPurchaseList = purchasingCustomer.getPurchasesMade();
		
		ArrayList <String> 	tempOrderItemsIDs = new ArrayList <String> ();
		ArrayList <Integer> tempOrderItemsQuantities = new ArrayList <Integer> ();
			
		// -----
		if (tokens[0].contentEquals("OP") == true) {				
			for (int i = 4; i < tokens.length; i += 2) {
				tempOrderItemsIDs.add(tokens[i-1]);
				tempOrderItemsQuantities.add(Integer.parseInt(tokens[i]));	
			}
			
			OnlinePurchase tempPurchase = new OnlinePurchase(tempOrderItemsIDs, tempOrderItemsQuantities, dayCount);
			tempPurchase.setShippingAddr(purchasingCustomer.getCustAddress());
			tempPurchase.setDaysUntilDelivery(Integer.parseInt(tokens[2]));
			
			customerPurchaseList.add(tempPurchase);
			purchasingCustomer.setPurchasesMade(customerPurchaseList);
			System.out.println("\n" + purchasingCustomer.getCustName() + " submitted an Online Purchase");
			return tempPurchase;
		} 
		
		// -----
		else {		
			for (int i = 3; i < tokens.length; i += 2) {
				tempOrderItemsIDs.add(tokens[i-1]);	
				tempOrderItemsQuantities.add(Integer.parseInt(tokens[i]));
			}
			
			StorePurchase tempPurchase = new StorePurchase(tempOrderItemsIDs, tempOrderItemsQuantities, dayCount);
			tempPurchase.setCustomerPickupDaysLeft(tempPurchase.determineNumPickupDaysLeft(dayCount));
						
			customerPurchaseList.add(tempPurchase);
			purchasingCustomer.setPurchasesMade(customerPurchaseList);
			System.out.println("\n" + purchasingCustomer.getCustName() + " submitted an In-Store Purchase");
			return tempPurchase;
		}
	}
  
	// ----------------------------------------------------------
	public static String attemptToCompletePurchase(Purchase tempPurchase, ArrayList <Product> prodList, int dayCount) {
	 // in store purchases are complete once they are picked up, online purchases are complete once sent
		try {
			if (tempPurchase.getOrderItemsIDs().size() == 0) {
				tempPurchase.setIsComplete(true);
				return "Empty Order - Processed and Disregarded";
			}
			
			// -----
			String holdWarning = "";
			
			for(int i = 0; i < tempPurchase.getOrderItemsIDs().size(); i++) {
				int soughtProductIndex = searchForProductIndex(prodList, tempPurchase.getOrderItemsIDs().get(i));
				int quantitySought = tempPurchase.getOrderItemsQuantities().get(i);
								
				if(prodList.get(soughtProductIndex).getStock() < quantitySought) {
					tempPurchase.setIsHold(true);
					holdWarning += ("Not enough " + prodList.get(soughtProductIndex).getProdName() 
							+ " available to complete purchase");
				}
			}
			
			// -----
			if(tempPurchase.getIsHold() == true) {
				holdWarning += (", Order placed on Hold");
				tempPurchase.setPlacementDate(dayCount);
				return holdWarning;
				
			} else if (tempPurchase instanceof OnlinePurchase) {
				for (int i = 0; i < tempPurchase.getOrderItemsIDs().size(); i++) {
					int soughtProductIndex = searchForProductIndex(prodList, tempPurchase.getOrderItemsIDs().get(i));
					int quantitySought = tempPurchase.getOrderItemsQuantities().get(i);
					prodList.get(soughtProductIndex).decreaseStock(quantitySought);
					System.out.println("OP: Decreased " + prodList.get(soughtProductIndex).getProdName() + " stock by " + quantitySought);
				}
				tempPurchase.setIsComplete(true);
				return "Online Order successful\n";
			} else {
				return "In-Store Order Ready For Pickup";
			}
		}
		catch (IndexOutOfBoundsException e) {
			return "A requested product does not exist according to the provided ID";
		}
	}
	
	// ----------------------------------------------------------
	public static void processHoldOrders(ArrayList<Customer> customers, ArrayList<Product> products) {
		for(int i = 0; i < customers.size(); i++) {
			ArrayList<Purchase> purchases = customers.get(i).getPurchasesMade();
			
			for(int f = 0; f < purchases.size(); f++) {
				
				if (purchases.get(f).getIsHold()) {
					ArrayList<String> IDs = purchases.get(f).getOrderItemsIDs();
					ArrayList<Integer> quantities = purchases.get(f).getOrderItemsQuantities();
					boolean purchaseNoLongerHold = false;
					
					for(int g = 0; g < IDs.size(); g++) {
						purchaseNoLongerHold = true;
						int index = searchForProductIndex(products, IDs.get(g));
						
						if (products.get(index).getStock() < quantities.get(g)) {
							purchaseNoLongerHold = false;
							System.out.println("Customer " + customers.get(i).getAccountID() + "'s purchase still on hold.\n" 
									+ " -> Needs " + (quantities.get(g) - products.get(index).getStock())
									+ " more " + products.get(index).getProdName());
						}
					}
					
					if (purchaseNoLongerHold) {
						purchases.get(f).setIsHold(false);
						purchases.get(f).setIsComplete(true);
						System.out.println(customers.get(i).getCustName() + "'s Purchase is no longer on Hold");
						
						for (int g = 0; g < IDs.size(); g++) {
							int index = searchForProductIndex(products, IDs.get(g));
							products.get(index).decreaseStock(quantities.get(g));
							System.out.println("Held orders: Decreased " + products.get(index).getProdName() + " stock by " + quantities.get(g));
						}
					}
				}
			}
		}
	}
	
	// ----------------------------------------------------------
	public static void pickUp(ArrayList<Customer> customerList, int custID, int dayCount, ArrayList <Product> products) {
		for(int i = 0; i < customerList.size(); i++) {
			if(customerList.get(i).getAccountID() == custID) {
				ArrayList<Purchase> purchases = customerList.get(i).getPurchasesMade();
				
				for(int f = 0; f < purchases.size(); f++) {
					if(purchases.get(f).getIsComplete() == false && purchases.get(f) instanceof StorePurchase) {
					   purchases.get(f).setIsComplete(true);
					   ArrayList<String> items = purchases.get(f).getOrderItemsIDs();
					   ArrayList<Integer> quants = purchases.get(f).getOrderItemsQuantities();
					   
					   for (int w = 0; w < items.size(); w++) {
						   int index = searchForProductIndex(products, items.get(w));
						   Product tempProduct = products.get(index);
						   
						   if(tempProduct.getStock() >= quants.get(w)) {
						   	tempProduct.decreaseStock(purchases.get(f).getOrderItemsQuantities().get(w));
						   	System.out.println("SP: Decreased " + products.get(index).getProdName()
						   			+ " stock by " + purchases.get(f).getOrderItemsQuantities().get(w));
						   } else {
							   System.out.println(customerList.get(i).getCustName() + "'s order " + "is still on hold."
							   		+ "\n  --> Still not enough of " + tempProduct.getProdName() + ".\n");
							   return;
						   }
					   }
					   System.out.println(customerList.get(i).getCustName() + " picked their order up");
					   System.out.println("In-Store Order successful\n");
					}
				}
			}
		}
	}
	
	// ----------------------------------------------------------
	public static Product createProduct(String[] tokens) {
		try{
			if(tokens[0].contentEquals("shoe")) {
				Shoe shoe = new Shoe(tokens[1], tokens[2], Double.parseDouble(tokens[3]), Integer.parseInt(tokens[4]));
				shoe.setSecuringMechanism(tokens[5]);
				shoe.setBrand(tokens[6]);
				shoe.setColor(tokens[7]);
				shoe.addCustomization(shoe.isPremium());
				return shoe;
			} else if(tokens[0].contentEquals("jacket")) {
				Jacket jacket = new Jacket(tokens[1], tokens[2], Double.parseDouble(tokens[3]), Integer.parseInt(tokens[4]));
		        jacket.setMaterial(tokens[5]);
		        jacket.setDesigner(tokens[6]);
		        jacket.addCustomization(jacket.isPremium());
		        return jacket;
			} else if(tokens[0].contentEquals("shirt")){
		        Shirt shirt = new Shirt(tokens[1], tokens[2], Double.parseDouble(tokens[3]), Integer.parseInt(tokens[4]));
		        shirt.setColor(tokens[5]);
		        shirt.setIsFormal(Boolean.parseBoolean(tokens[6]));
		        shirt.setCloth(tokens[7]);
		        return shirt;
		    } else {
		        Product p = new Product(tokens[1], tokens[2], Double.parseDouble(tokens[3]), Integer.parseInt(tokens[4]));
		        return p;
		    }
		} 
		
		catch(IllegalArgumentException e) {
		      System.out.println("Wrong data passed to restock method");
		      e.printStackTrace();
		}
		
		return null;
	}
	
	// ----------------------------------------------------------	
	public static int searchForProductIndex (ArrayList <Product> productList, String targetProdID) {
		for(int i = 0; i < productList.size(); i++) {
			if(productList.get(i).getProdID().contentEquals(targetProdID)) {
				return i;
	        }
	    }
			
		return -1; 		// short circuited if product found ( always be found, data assumed to be valid)
	}
	
	//-----------------------------------------------------------
	public static Customer searchCustomerListByID (ArrayList <Customer> customerList, String targetCustID) {
		boolean customerFound = false;
		int count = 0;
		
		while (customerFound == false && count < customerList.size()) 		
		{		
			Customer customerUnderStudy = customerList.get(count);
			if (customerUnderStudy.getAccountID() == Integer.parseInt(targetCustID)) {
				customerFound = true;
				return customerUnderStudy;
			}
			else {
				count ++;
			}
		}
		
		return null; 		// short circuits if Customer found
	}
	
	// ----------------------------------------------------------
	public static String getStatusBar(Product p) {
	    String s = new String();
	    s = "[";
	    int count = (int) p.getStock() / 5;
	    if(p.getStock() > 0 && p.getStock() < 5) {
	    	return("[#__________]");
	    }
	    for(int i = 0; i < count; i++) {
	      s += "#";
	    }
	    while(count <= 10) {
	      s += "_";
	      count++;
	    }
	    s += "]";
	    return s;
  }
	
	// ----------------------------------------------------------
	public static String generateReceiptData(Purchase p, ArrayList<Product> products) {
		p = (Purchase) p;
		String data = new String();
		
		for(int i = 0; i < p.getOrderItemsIDs().size(); i++) {
			int index = searchForProductIndex(products, p.getOrderItemsIDs().get(i));
			
			double subtotal = products.get(index).getUnitPrice() * p.getOrderItemsQuantities().get(i);
			String s = String.format(" (%3d)  Subtotal: $%7.2f\n", p.getOrderItemsQuantities().get(i), subtotal);
			data += "   " + products.get(index).receiptToString() + s;
			
			p.setTotalPrice(p.getTotalPrice()+subtotal);;
		}
		
		if (p instanceof OnlinePurchase) {
			OnlinePurchase o = (OnlinePurchase) p;
			o.addShippingCost();
			p = o;
		}
		
		String x = String.format("\nTotal: $%-9.2f\n\nThank you for shopping with us!\n", p.getTotalPrice());
		data += x;
		return data;
	}
	
	// ----------------------------------------------------------
}