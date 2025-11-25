/**
 *@author Ayden Hocking
 *ITSC 1213- Lab 2
 *This program creates orders in a restraunt setting and manipulates them to allow for user input and order servicing. 
 *
 */
public class BurgerOrder {
    /**
     *
     *instance variables are created to use throughout
     *
     */
    private int numHamburgers;
    private int numCheeseburgers;
    private int numVeggieburgers;
    private int numSodas;
    private boolean orderToGo;
    private int orderNum;
    public int allBurgers;
    /**
     *
     *initializes number of hambers, cheeseburgers, veggieburgers, sodas, and boolean togo 
     *
     */
    public int getnumHamburgers(){
        return this.numHamburgers;
    }
    public int getnumCheeseburgers(){
        return this.numCheeseburgers;
    }
    public int getnumVeggieburgers(){
        return this.numVeggieburgers;
    }
    public int getnumSodas(){
        return this.numSodas;
    }
    public boolean isOrderToGo(){
        return false;
    }
    public boolean setOrderToGo(){
        return false;
    }
        public int getOrderNum(){
        return this.orderNum;
    }
    /**
     *
     *sets the integers of each instance variable to update throughout program process
     *@param numhamburgers number of hamburgers
     *@param numcheeseburgers number of cheeseburgers
     *@param numveggieburgers number of veggieburgers
     *@param numsodas number of sodas
     *@param ordertogo determines if order togo is true or false
     *@param ordernum sets the order number
     */
    public BurgerOrder(int numHamburgers, int numCheeseburgers, int numVeggieburgers, int numSodas, boolean orderToGo, int orderNum) {
        this.numHamburgers = numHamburgers;
        this.numCheeseburgers = numCheeseburgers;
        this.numVeggieburgers = numVeggieburgers;
        this.numSodas = numSodas;
        this.orderToGo = orderToGo;
        this.orderNum = orderNum;
    }
    /**
     * determines if value entered is less than 0 when ordering
     *@param numhamburgers number of hamburgers
     *@param numcheeseburgers number of cheeseburgers
     *@param numveggieburgers number of veggieburgers
     *@param numsodas number of sodas
     *
     */
    public BurgerOrder(int newHamburgers, int numCheeseburgers, int numVeggieburgers, int numSodas){
        if (numHamburgers < 0 || numCheeseburgers < 0 || numVeggieburgers < 0 || numSodas < 0 ) {
            System.out.println("Value is less than 0.");
        } else {
            this.numHamburgers = numHamburgers;
            this.numCheeseburgers = numCheeseburgers;
            this.numVeggieburgers = numVeggieburgers;
            this.numSodas = numSodas;
        }
    }
    /**
    *prints the given order as entered in main
    *@return burger order as inputed 
    */
    public String toString() {
        return "Burger Order: (" + "numHamburgers= " + numHamburgers + ",numCheeseburgers= " + numCheeseburgers + ",numVeggieburgers= " + numVeggieburgers + ",numSodas= " + numSodas + ",orderToGo= " + orderToGo + ",orderNum= " + orderNum + ")";
    }

    public int getTotalBurgers(){
        return getnumCheeseburgers() + getnumHamburgers() + getnumVeggieburgers();
    }
   /* public int orderCompare(BurgerOrder element){
        int check = 0;
        if (this.getAllBurgers() < element.getAllBurgers()){
            check = -1;
        }
        if (this.getAllBurgers() > element.getAllBurgers()){
            check = 1;
        }
        return check;
    }*/

}