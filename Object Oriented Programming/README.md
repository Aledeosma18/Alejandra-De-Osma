# Store Information System (README)
**Authors:** Alejandra De Osma, Mingrui Yuan, Christian Santiago, Christian Huber
<br/>
**Date:** 04/24/2020
<br/>
**Version:** 1.2.0

<br/>


## Purpose
To manage the **inventory** of a store that is being changed through 		customer's purchases (**online and in-store**) **restock** calls. New customers, their purchases, and restock calls are all fed to the program via an input file (StoreData.txt) that serves as input for all days. The system will then create **receipt files** and **inventory files** for every day. Receipt files only contain **valid purchases**, which means that all products in the purchase must be in stock. Invalid purchases are **placed on hold** and can be picked up/be shipped once all products in the purchase are available in the required quantity.

## How to write input correctly?
***All instructions are separated by a dash ("-") or a new line***
### Order of entries:

 1. Day Indicator
 2. Restock Instructions
 3. **New** Customers
 4. Purchases
 5. In-Store Pick-Ups
 <br/>
 
### How to create/restock a product:
<br/>
Think: `ProductType-ProductID-ProductName-PricePerUnit-StockChange-(misc.)-(misc.)-(misc.)`
<br/>

**Examples:**
Shoe

    shoe-49992-Radford Boots-65.99-15-Shoelaces-Timberlands-metallic silver

Jacket
  

    jacket-99857-Puffy ULTRA-233.99-2-Wool-Gucci

Shirt

    shirt-16376-Caribbean Shirt-10.99-25-yellow-false-polyester
    
Any other Product: *(Note: don't enter miscellaneous data for general Products)*

    other-57339-Toenail Clippers-5.75-12

**Restock:** Only enter ProductID and restock amount (e.g. "49992-12")
    
    
### How to handle Customers and their Purchases:
Think: `CustomerName-CustomerAddress-CustomerPhone-CustomerID`

**Example:**

    Christian Huber-021 Jump St.-122 303 2211-64582

**Create Purchase with Customer:** Enter "OP" or "SP" for OnlinePurchase or StorePurchase and the CustomerID followed by alternating ProductID and AmountBought. *Note: OnlinePurchases additionally include the DaysUntilDelivery as third token*

Example of OnlinePurchase (OP):

    OP-12345-3-57339-2-49992-2
Example of StorePurchase (SP):

    SP-64582-99857-1-57339-1

**Pick-Up an In-Store Purchase:** Enter the CustomerID (e.g. "64582")

## Miscellaneous

 - All changes to the inventory and purchases will be neatly outputted in the Console
 - There is no Receipt file for Day 0 because only the inventory is established on that day
 - Held orders do not appear in Receipt files, their status is shown in the Console

