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
public class RegularMember {
/**
 *This class stores variables in relation to membership status and stores these users in a matching ArrayList
 */
    /**
     *Instance variables set member first name, last intial, and amount of money spent as member.
     */
    private String firstName; 
    private String lastName; 
    private double moneySpent; 
    /**
     *@param String firstName, user first name
     *@param String lastName, user last initial
     *@param double moneySpent, users current money spent 
     */
    public RegularMember(String firstName, String lastName, double moneySpent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.moneySpent = moneySpent;
    }
    public RegularMember() {
    }
    /**
     *getter for firstName variable
     *@return firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     *getter for lastName variable
     *@return lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     *getter for moneySpent variable
     *@return moneySpent
     */
    public double getMoneySpent() {
        return moneySpent;
    }
    /**
     *setter for firstName variable
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     *setter for lastName variable
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     *setter for moneySpent variable
     */
    public void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }
    /**
     *Prints amount of money user has spent as of current
     *@param int numBooks
     *@param int numCds
     *@param int numDvds
     */
    public void totalSpending(int numBooks, int numCds, int numDvds) {
        System.out.println("Total spending since becoming a member: $" + moneySpent);
    }
    /**
     *collects money spent after current purchase
     *@param double moneySpent
     */
    public void addMoneySpent(double moneySpent) {
        this.moneySpent += moneySpent;
    }
}
