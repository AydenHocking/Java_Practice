/**
 *@author Ayden Hocking
 *ITSC 1213 Project 1 - Bookstore Database
 *Last Updated:9/29/2023
 *This program fuctions as a store interface in which the user can: 
 *  1. Register as a member based on type, 2. Make a purchase, and 3. Manage(+/-) inventory.
 *Info is stored with the use of ArrayLists as well as inheritance methods.
 *Resources used for inheritance understanding: 
 *  https://www.geeksforgeeks.org/inheritance-in-java/ , https://www.w3schools.com/java/java_inheritance.asp 
 */
import java.util.*;
public class FullInventorySort {
/**
 * FullInventorySort takes integer prices for all three purchase options and sets each to its own variables. Mathmatical equations are done to add or remove inventory and configure buying options. 
 */
 /**
  * Instance varibles address price, inventory amount and total for each purchase item. 
  */
    private int price; 
    private int inventory; 
    private int total; 
    /**
     *@param int price, price of item
     *@param int inventory, amount of item 
     */
    public FullInventorySort(int price, int inventory) {
        this.price = price;
        this.inventory = inventory;
    }
    public FullInventorySort(){
    } 
    /**
     *getter for price variable
     *@ return, price of item
     */
    public int getPrice() {
        return price;
    }
    /**
     *getter for inventory variable
     *@return, inventory amount of item 
     */
    public int getInventory() {
        return inventory;
    }
    /**
     *getter for total variable
     *@param int numBooks, amount of books in purchase
     *@param int numCds, amount of cds in purchase
     *@param int numDvds, amount of dvds in purchase
     *@return, total purchase amount
     */
    public int getTotal(int numBooks, int numCds, int numDvds) {
        this.total = (5 * numBooks) + (10 * numCds) + (15 * numDvds);
        return total;
    }
    /**
     *setter for price variable
     *@param int price
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     *setter for inventory variable
     *@param int inventory
     */
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
    /**
     *removes sold items from inventory after purchase
     *@param int sold, amount of item sold
     */
    public void subtractInventory(int sold) {
        this.inventory = this.inventory - sold;
    }
    /**
     *adds inventory based on user input in TestHarness class
     *@param int add, amount of item to add to inventory
     */
    public void addInventory(int add) {
        this.inventory = this.inventory + add;
    }
    /**
     *removes inventory based on user input in TestHarness class
     *@param int remove, amount of item to remove from inventory
     */
    public void removeInventory(int remove) {
        this.inventory = this.inventory - remove;
    }
    /**
     *setter for total variable 
     *@param int numbooks, number of books to purchase
     *@param int numCds, number of cds to purchase
     *@param int numDvds, number of Dvds to purchase
     */
    public void setTotal(int numBooks, int numCds, int numDvds) {
        this.total = (5 * numBooks) + (10 * numCds) + (15 * numDvds);
    }

}
