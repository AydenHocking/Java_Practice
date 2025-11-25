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
public class Cds extends FullInventorySort {
    /**
     * Cds class inherits the attributes and methods from the the class FullInventorySort, this way it does not need an ArrayList
     * Resource: https://www.w3schools.com/java/java_inheritance.asp
     *@param int price, books price
     *@param int inventory, amount of cds in inventory
     */
    public Cds(int price, int inventory) {
        super(price, inventory);    //sets the Cds price and inventory size to the parent class in FullInventorySort
                                    //Resource: https://www.geeksforgeeks.org/inheritance-in-java/
    }
}
