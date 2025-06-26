import java.util.Scanner;
import java.io.*;
import java.util.*;
/**
 *
 * ITSC 1213 
 * University of North Carolina at Charlotte
 */

public class FastFoodKitchenDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    FastFoodKitchen kitchen = new FastFoodKitchen("burgerOrder.csv");

        Scanner sc = new Scanner(System.in);

        while (kitchen.getNumOrdersPending() != 0) {
            // see what the user wants to do
            System.out.println("Please select from the following menu of options, by typing a number:");
            System.out.println("\t 1. Order food");
            System.out.println("\t 2. Cancel last order");
            System.out.println("\t 3. Show number of orders currently pending");
            System.out.println("\t 4. Complete order");
            System.out.println("\t 5. Check on order");
            System.out.println("\t 6. Cancel order");
            System.out.println("\t 7. End of day report");
            System.out.println("\t 8. Exit");
            try{
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        try{
                            System.out.println("How many hamburgers do you want?");
                            int ham = sc.nextInt();
                            if(ham<0){
                                throw new Exception("Negative number entered");
                            }
                            System.out.println("How many cheeseburgers do you want?");
                            int cheese = sc.nextInt();
                            System.out.println("How many veggieburgers do you want?");
                            int veggie = sc.nextInt();
                            System.out.println("How many sodas do you want?");
                            int sodas = sc.nextInt();
                            System.out.println("Is your order to go? (Y/N)");
                            char letter = sc.next().charAt(0);
                            boolean check = false;
                            boolean TOGO = false;
                            if (letter == 'Y' || letter == 'y') {
                                TOGO = true;
                                check = true;
                            }
                            if (letter == 'N' || letter == 'n') {
                                TOGO = false;
                                check = true;
                            }
                            if (check == false){
                                System.out.println("You did not answer Y/y or N/n");
                                break;
                            }
                            int orderNum = kitchen.addOrder(ham, cheese, veggie, sodas, TOGO);
                            System.out.println("Thank you. Your order number is " + orderNum);
                            System.out.println();
                        }catch(InputMismatchException excpt){
                            System.out.println("You did not enter a number");
                            System.exit(0);
                        }catch(Exception ex){
                            System.out.println("Negative number entered");
                        }
                        break;
                    case 2:
                        boolean ready = kitchen.cancelLastOrder();
                        if (ready) {
                            System.out.println("Thank you. The last order has been canceled");
                        } else {
                            System.out.println("Sorry. There are no orders to cancel.");
                        }
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("There are " + kitchen.getNumOrdersPending() + " pending orders");
                        break;
                    case 4:
                        try{
                            System.out.println("Enter order number to complete?");
                            int order = sc.nextInt();
                            if (order<kitchen.orderList.size() && order>0){
                                kitchen.completeSpecificOrder(order);
                                System.out.println("Your order is ready. Thank you!");
                            }else{
                                System.out.println("Sorry, no order with this number was found.");
                            }
                        }catch(InputMismatchException excpt){
                            System.out.println("You did not enter a number");
                            System.exit(0);
                        }
                        break;
                    case 5:
                        try{
                            System.out.println("What is your order number?");
                            int order = sc.nextInt();
                            ready = kitchen.isOrderDone(order);
                            if (ready) {
                                System.out.println("Sorry, no order with this number was found.");
                            } else {
                                System.out.println("No, it's not ready, but it should be up soon. Sorry for the wait.");
                            }
                            System.out.println();
                        }catch(InputMismatchException excpt){
                            System.out.println("You did not enter a number");
                            System.exit(0);
                        }
                        break;
                    case 6:
                        try{
                            System.out.println("What is your order number?");
                            int order = sc.nextInt();
                            boolean cancel = kitchen.cancelOrder(order);
                            if (cancel) {
                                System.out.println("Your order has been successfully cancelled ");
                            } else {
                                System.out.println("Sorry, we can’t find your order number in the system");
                            }
                            System.out.println();
                        }catch(InputMismatchException excpt){
                            System.out.println("You did not enter a number");
                            System.exit(0);
                        }
                        break;
                    case 7:
                        kitchen.endOfDay("endOfDayReport.txt", "burgerOrders2.csv");
                        System.out.println("End of day report generated and orders updated.");
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Sorry, but you need to enter a 1, 2, 3, 4, 5, 6, or a 7");

                } //end switch
            }catch(InputMismatchException excpt){
                System.out.println("You did not enter a number");
                System.exit(0);
            }

        } //end while loop 
    } // end main
}// end class