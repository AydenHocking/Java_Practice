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
public class PremiumMember extends RegularMember {
/**
 *PremiumMemeber class is an extension of RegularMember where an addtional payment method is saved
 *Resource: https://www.w3schools.com/java/java_inheritance.asp
 */
    /**
     *Instance variable for separate payment method 
     */
    private String payMethod;
    /**
     *@param String fName
     *@param String lName
     *@param String payMethod
     *@param double moneySpent
     */
    public PremiumMember(String fName, String lName, double moneySpent, String payMethod) {
        super(fName, lName, moneySpent); //Resource: https://www.geeksforgeeks.org/inheritance-in-java/
        this.payMethod = payMethod;
    }
    public PremiumMember() {
    }
    /**
     *getter for payMethod
     *@return payMethod
     */
    public String getPayMethod() {
        return payMethod;
    }
    /**
     *setter for payMethod
     *@param, String payMethod
     */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }
    /**
     * Takes a payment form from user to save in PremMember ArrayList. 
     *@param, int method
     */
    public void makePayment(int method) {
        Scanner sc = new Scanner(System.in);
        boolean status = false; // while loop for executing payment 
        while (status == false) {
            if (method == 1) {
                System.out.println("Enter a 16 digit card number:");
                String card = sc.nextLine(); // user input
                if (card.length() == 16) {
                    System.out.println("Premium Member Payment Method Saved.(Card)");
                    status = true; //exit while loop
                } else {
                    System.out.println("Enter a 16 digit card number:");
                }
            }
            if (method == 2) {
                System.out.println("Premium Member Payment Method Saved.(Cash)");
                status = true; //exit while loop
                
            }
        }
    }

}
