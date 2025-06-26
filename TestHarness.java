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
public class TestHarness {
/*
 * TestHarness class is used as the interface for the Bookstore. This takes multiple user inputs and arrages them in an assortment of switch-case,and if/if-else statements.
 */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);       //User Input Allowance
        FullInventorySort purchase = new FullInventorySort();   //Generates new FullInventorySort class
        ArrayList<RegularMember> regular = new ArrayList();     //Generates new RegMember ArrayList
        ArrayList<PremiumMember> premium = new ArrayList();     //Generates new PremMember ArrayList
        RegularMember current = null;   //Sets current selected Regmember to null
        PremiumMember pCurrent = null;  //Sets current selected PremMember to null

        PremiumMember payment = new PremiumMember();
        RegularMember receipt = new RegularMember();
        /*
         *Creates sample of customers both regular and premium to be added to the ArrayLists.
         *First Name, Last Initial, Money Spent to Date, Saved Payment Method for PremMembers 
         */
        regular.add(new RegularMember("Adam", "A", 5));
        regular.add(new RegularMember("Betty", "B", 10));
        regular.add(new RegularMember("Cate", "C", 35));
        premium.add(new PremiumMember("Dusty", "D", 50, "card"));
        premium.add(new PremiumMember("Ethel", "E", 40, "cash"));
        premium.add(new PremiumMember("Frank", "F", 80, "card"));
        /*
         *Creates price,inventory values for each item sold. Calls FullInventorySort as each item class is an extension of this class. 
         *Price, Inventory Amount
         */
        FullInventorySort books = new Books(5, 999);
        FullInventorySort cds = new Cds(10, 999);
        FullInventorySort dvds = new Dvds(15, 999);

        boolean TestHarness = true; //TestHarness program start/stop loop
        while (TestHarness == true) {
            /*
             * Main Interface Menu with 5 case options.
             */
            System.out.println("------------------Bookstore:-----------------");
            System.out.println(" ");
            System.out.println("\t 1. Make a purchase:");
            System.out.println("\t 2. Regular Member Sign up:");
            System.out.println("\t 3. Premium member Sign up:");
            System.out.println("\t 4. Add/Remove Inventory:");
            System.out.println("\t 5. Current Members:");

            int num = sc.nextInt();     //detects user inputed number

            boolean validMember = false;    //declares user with no member status at all
            boolean pMember = false;        //declares user with no PremMember status specifically
            String firstName = null;        //declares user with null string first name value(RegMember)
            String lastName = null;         //declares user with null string last name value(RegMember)
            String fName = null;            //declares user with null string first name value(PremMember)
            String lName = null;            //declares user with null string last name value(PremMember)
            
            switch (num) {
                case 1:
                /*
                 *case 1: determines users member status and makes a payment(- on inventory), then stores spent value if validMember status is true
                 */
                    while (validMember == false) {
                    /*
                     *Runs through member sign up options, or completes nonmember payment.
                     */                       
                        System.out.println("Returning member: (Y/N)");
                        char letter = sc.next().charAt(0);  //user input
                        if (letter == 'N' || letter == 'n') { 
                            System.out.println("Sign up as Member: (Y/N)");
                            letter = sc.next().charAt(0);   //user input
                            if (letter == 'Y' || letter == 'y') { 
                                System.out.println("Sign up as Regular Member or Premium Member:");
                                System.out.println(" ");
                                System.out.println("\t 1. Regular Member");
                                System.out.println("\t 2. Premium Member");
                                num = sc.nextInt();     //user input
                                switch (num) {
                                    case 1: 
                                    /*
                                     *Enters user information in RegMember ArrayList
                                     */
                                        sc.nextLine();      //user input
                                        System.out.println("First Name:");     
                                        firstName = sc.nextLine();      //user input
                                        System.out.println("Last Initial:");
                                        lastName = sc.nextLine();       //user input
                                        RegularMember newMem = new RegularMember(firstName, lastName, 0);   //defines RegMember Parameters
                                        regular.add(newMem);    //adds user to RegMember ArrayList
                                        current = newMem;   //sets this index in ArrayList to current, for adding total spent later.
                                        System.out.println("You are now a Regular Member.");
                                        break;
                                    case 2:
                                    /*
                                     *Enters user information in PremMember ArrayList
                                     */
                                        sc.nextLine();  //user input
                                        System.out.println("First Name:");
                                        fName = sc.nextLine();  //user input
                                        System.out.println("Last Initial:");
                                        lName = sc.nextLine();  //user input
                                        PremiumMember newPMem = new PremiumMember(fName, lName, 0, null);   //defines PremMember Parameters
                                        premium.add(newPMem); //adds user to PremMember ArrayList
                                        current = newPMem;    //sets user as member
                                        pCurrent = newPMem;   //sets user as PremMember
                                        pMember = true;       //sets user as PremMember
                                        System.out.println("Premium Member Saved Payment Type:");
                                        System.out.println("\t 1. Credit/Debit Card");
                                        System.out.println("\t 2. Cash");
                                        int method = sc.nextInt();  //user input
                                        payment.makePayment(method); // runs makePayment method in PremiumMember class.   
                                        if (method == 1) {
                                            String pay = "card";
                                            pCurrent.setPayMethod(pay);     //sets user payment method in PremMember ArrayList
                                        }
                                        if (method == 2) {
                                            String pay = "cash";
                                            pCurrent.setPayMethod(pay);     //sets user payment method in PremMember ArrayList
                                        }
                                        System.out.println("You are now a Premium Member.");
                                        break;
                                }
                                System.out.println(" ");
                                validMember = true; // sets user as member to proceed into making purchase
                            }
                            /*
                             * Runs if user doe snot sign up for member status.
                             */
                            if (letter == 'N' || letter == 'n') {
                                System.out.println(" ");
                                break;

                            }
                        /*
                         * Runs if user selects they are a current member.
                         */
                        } else if (letter == 'Y' || letter == 'y') { 
                            System.out.println(" ");
                            System.out.println("\t 1. Regular Member:");
                            System.out.println("\t 2. Premium Member:");
                            num = sc.nextInt();  //user input
                            sc.nextLine();      //userinput  
                            /*
                             * Takes first and last as strings to determine if they match RegMember or PremMember Arraylists.
                             */
                            System.out.println("First Name:");
                            firstName = sc.nextLine();      //userinput 
                            System.out.println("Last Inital:");
                            lastName = sc.nextLine();       //userinput 

                            if (num == 1) { 
                                /*
                                 * Searches RegMember Arraylist for user input, then proceeds to purchase.
                                 */
                                for (int i = 0; i < regular.size(); i++) {
                                    if (firstName.equals(regular.get(i).getFirstName()) && lastName.equals(regular.get(i).getLastName())) {
                                        current = regular.get(i); //sets index to user
                                        validMember = true; //proceeds to purchase
                                        break;
                                    } else if (i == regular.size() - 1) {
                                        System.out.println("Error, you are not a member.");
                                    }
                                }
                            }
                            /*
                             * Searches PremMember Arraylist for user input, then proceeds to purchase.
                             */
                            if (num == 2) { 
                                for (int i = 0; i < premium.size(); i++) {
                                    if (firstName.equals(premium.get(i).getFirstName()) && lastName.equals(premium.get(i).getLastName())) {
                                        current = premium.get(i); //set index to user 
                                        validMember = true; //proceeds to payment
                                        pMember = true; //sets user to PremMember
                                        break;
                                    } else if (i == premium.size() - 1) {
                                        System.out.println("Error, you are not a member.");
                                    }
                                }
                            }
                        }
                    }
                    
                    System.out.println("Enter Book Amount:");
                    int numBooks = sc.nextInt();    //user input
                        if (numBooks > books.getInventory()){
                        System.out.println("Not enough in stock, Books amount set to 0");
                        numBooks = 0;
                    }
                    System.out.println("Enter CD Amount:");
                    int numCds = sc.nextInt();      //user input
                    if (numCds > cds.getInventory()){
                        System.out.println("Not enough in stock, CD amount set to 0");
                        numCds = 0;
                    }
                    System.out.println("Enter DVD Amount:");
                    int numDvds = sc.nextInt();     //user input
                        if (numDvds > dvds.getInventory()){
                        System.out.println("Not enough in stock, DVD amount set to 0");
                        numDvds = 0;
                    }
                    sc.nextLine();
                    double spent = purchase.getTotal(numBooks, numCds, numDvds); //spent is summation of all three items prices
                    System.out.println(" ");
                    System.out.println("------------------Bookstore:-----------------"); 
                    if (validMember == true) { 
                        System.out.println(" ");
                        current.addMoneySpent(spent); //adds this purchase to current amount spent as user
                    }
                    System.out.println("Total: $" + spent);
                    if (validMember == true) {
                        current.totalSpending(numBooks, numCds, numDvds); //sets amount spent to this purchase amount
                    }
                    System.out.println(" ");
                    System.out.println("Payment Complete.");
                    System.out.println(" ");
                    books.subtractInventory(numBooks); //subtracts inventory by sold amount
                    cds.subtractInventory(numCds); //subtracts inventory by sold amount
                    dvds.subtractInventory(numDvds); //subtracts inventory by sold amount
                    break;

                case 2: 
                /*
                 * case 2: Separate RegMemeber sign up without purchase requirement
                 */
                    sc.nextLine(); //user input
                    System.out.println("First Name:");
                    firstName = sc.nextLine(); //user input
                    System.out.println("Last Initial:");
                    lastName = sc.nextLine(); //user input
                    RegularMember newMem = new RegularMember(firstName, lastName, 0); //defines RegMember Parameters
                    regular.add(newMem); //adds user to RegMember ArrayList
                    current = newMem; // sets current user as RegMember
                    System.out.println("You are now a Regular Member.");
                    break;
                case 3: 
                    sc.nextLine(); //user input
                    System.out.println("First Name:");
                    fName = sc.nextLine(); //user input
                    System.out.println("Last Initial:");
                    lName = sc.nextLine(); //user input
                    PremiumMember newPMem = new PremiumMember(fName, lName, 0, null); //defines PremMember Parameters
                    premium.add(newPMem); //adds user to PremMember
                    current = newPMem; //sets current user as member
                    pCurrent = newPMem; //sets current user as PremMember
                    System.out.println("Premium Member Saved Payment Type:");
                    System.out.println("\t 1. Credit/Debit Card");
                    System.out.println("\t 2. Cash");
                    int premPayM = sc.nextInt(); //user input
                    payment.makePayment(premPayM); //runs makePayment method of PremiumMember class
                    if (premPayM == 1) {
                        String pay = "card";
                        pCurrent.setPayMethod(pay); //sets PremMember pay method
                    }
                    if (premPayM == 2) {
                        String pay = "cash";
                        pCurrent.setPayMethod(pay); //sets PremMember pay method
                    }
                    break;
                case 4: 
                /*
                 * case 4: Shows current Inventory and allows user to add or remove items from it
                 */
                    System.out.println("------------------Inventory:-----------------");
                    System.out.println(" ");
                    System.out.println(books.getInventory() + " Books");
                    System.out.println(cds.getInventory() + " CDs");
                    System.out.println(dvds.getInventory() + " DVDs");
                    System.out.println(" ");
                    System.out.println("Add Inventory?(Y/N)");
                    char letter = sc.next().charAt(0); //user input
                    if (letter == 'Y' || letter == 'y') {
                        System.out.println("Add Books:");
                        numBooks = sc.nextInt();
                        System.out.println("Add CDs:");
                        numCds = sc.nextInt();
                        System.out.println("Add DVDs:");
                        numDvds = sc.nextInt();
                        books.addInventory(numBooks);       //adds to inventory
                        cds.addInventory(numCds);           //adds to inventory 
                        dvds.addInventory(numDvds);         //adds to inventory
                        System.out.println(" ");
                        System.out.println("------------------Inventory:-----------------");
                        System.out.println(" ");
                        System.out.println(books.getInventory() + " books left in stock");
                        System.out.println(cds.getInventory() + " cds left in stock");
                        System.out.println(dvds.getInventory() + " dvds left in stock");
                    }
                    if (letter == 'N' || letter == 'n') {
                        System.out.println(" ");
                        System.out.println(books.getInventory() + " Books");
                        System.out.println(cds.getInventory() + " CDs");
                        System.out.println(dvds.getInventory() + " DVDs");
                        System.out.println(" ");
                        System.out.println("Remove Inventory?(Y/N)");
                        char letter2 = sc.next().charAt(0); //user input
                        if (letter2 == 'Y' || letter2 == 'y') {
                            System.out.println("Remove Books:");
                            numBooks = sc.nextInt();
                            System.out.println("Remove CDs:");
                            numCds = sc.nextInt();
                            System.out.println("Remove DVDs:");
                            numDvds = sc.nextInt();
                            books.removeInventory(numBooks);        //removes from inventory
                            cds.removeInventory(numCds);            //removes from inventory
                            dvds.removeInventory(numDvds);          //removes from inventory
                            System.out.println(" ");
                            System.out.println("------------------Inventory:-----------------");
                            System.out.println(" ");
                            System.out.println(books.getInventory() + " books left in stock");
                            System.out.println(cds.getInventory() + " cds left in stock");
                            System.out.println(dvds.getInventory() + " dvds left in stock");
                        }
                    }
                    break;
                case 5: 
                /*
                 *case 5: runs through both ArrayLists and displays each users information
                 */
                    System.out.println("---------------Regular Members---------------");
                    System.out.println(" ");
                    /*
                     *runs through RegMemberArray and prints info
                     */
                    for (int i = 0; i < regular.size(); i++) {
                        System.out.println(i + 1 + ". " + regular.get(i).getFirstName() + " " + regular.get(i).getLastName());
                        System.out.println("\t Past Purchase Amount: $" + regular.get(i).getMoneySpent());
                    }
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("--------------Premium Members--------------");
                    System.out.println(" ");
                    /*
                     *runs through PremMemberArray and prints info
                     */
                    for (int i = 0; i < premium.size(); i++) {
                        System.out.println(i + 1 + ". " + premium.get(i).getFirstName() + " " + premium.get(i).getLastName());
                        System.out.println("\t Past Purchase Amount: $" + premium.get(i).getMoneySpent() + ", via " + premium.get(i).getPayMethod());

                    }
                    break;
                default:
                    System.out.println("Error: Enter An Integer Provided:");        //error integer input check
                    break;
            }
            System.out.println(" ");
            System.out.println("-------------------------------------------");
            System.out.println("\t 1. Return to Bookstore:"); 
            System.out.println("\t 2. Exit Program:"); 
            int input = sc.nextInt();   //user input
            if (input == 1) {
                TestHarness = true; // reruns testharness as true
            }
            if (input == 2) {
                TestHarness = false; //stops program
                System.out.println("Program Terminated");
            }
        }

    }
}
