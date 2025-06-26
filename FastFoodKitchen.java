/**
 *@author Ayden Hocking
 *ITSC 1213- Lab 2
 *This program creates orders in a restraunt setting and manipulates them to allow for user input and order servicing. 
 *
 */
import java.util.ArrayList;
import java.util.Collections;
public class FastFoodKitchen{
    /**
     *instance variables as well as array list are created
     */
    private ArrayList<BurgerOrder> orderList = new ArrayList<BurgerOrder>();
    private static int nextOrderNum=1;
    private static int incrementNextOrderNum;
    
    public ArrayList<BurgerOrder> getOrderList(){
        return orderList;
    }
    
    /**
     *inistializes next order number
     */
    public int getNextOrderNum(){
        return nextOrderNum;
    }
    /**
     *adds 1 to the next order number in system
     */
    private static void incrementNextOrderNum(){
        nextOrderNum ++;
    }
    /**
     *add 3 orders as a default reference into the arraylist
     */
    public FastFoodKitchen(){
        orderList.add(new BurgerOrder(3,5,4,10,false,getNextOrderNum()));
        incrementNextOrderNum();
        orderList.add(new BurgerOrder(1,1,0,2,false,getNextOrderNum()));
        incrementNextOrderNum();
        orderList.add(new BurgerOrder(0,0,3,3,true,getNextOrderNum()));
        incrementNextOrderNum();



        //orderList.add(new BurgerOrder(1,1,1,1,false,getNextOrderNum()));
        //incrementNextOrderNum();
    }
    /**
     *allows user input to be added in the arraylist and updates or numbers
     *@param ham number of hamburgers ordered
     *@param cheese number of cheeseburgers ordered
     *@param veggie number of veggieburgers ordered
     *@param soda number of sodas ordered
     *@param togo determines if order is togo
     */
    public int addOrder(int ham, int cheese, int veggie, int soda, boolean toGo) {
        BurgerOrder newOrder = new BurgerOrder(ham, cheese, veggie, soda, toGo, nextOrderNum);
        orderList.add(newOrder);
        incrementNextOrderNum();
        return nextOrderNum;
        
    }
    /**
     * cancels the last order placed in arraylist
     */
    public boolean cancelLastOrder(){
        for(int i=0; i<orderList.size(); i++) {

            if(i>0){
                orderList.remove(i);
                return true;
            }
        }
        return false;
    }
    /**
     * gets the amount of orders in queue currently
     */
    public int getOrdersPending(){
        return orderList.size();
    }
    /**
     * determines if a given order is done
     */
    public boolean isOrderDone(int orderID){
        for (int i=0; i<orderList.size(); i++){
            if (orderList.size() == nextOrderNum){
                return false;
            }
        }
        return true;
    }
    /**
     * cancels a user inputed order
     */
    public boolean cancelOrder(int orderID){
        for (BurgerOrder order : orderList){
            if (orderList.size() == orderID){
                orderList.remove(true);
            }
            return true;
        }
        return false;
    }
    /**
     * prints full arraylist of items
     */
    public String toString (){
        return "Fast Food Kitchen(" + "orderList= " + orderList + ")"; 
    }
    /**
     * Order Sequence: Finds order with given number of total burgers by moving through array.  Will add 1 to the index order so that order number = index number.
     *
     */
    public int findOrderSeq(int orderID){
        for (int i = 0; i <= orderList.size() -1; i++){
            if (orderID == orderList.get(i).getTotalBurgers()) {

                return i+1;
            }
        }
        return -1;
    }
    /**
     * Insertion Sort: Moves through array and deteremines if value is less then the previous. If that is the case, index value is moved to front of array. 
     *
     */
    public void insertionSort(){
        for (int i = 1; i < orderList.size(); i++){
            int index = i;
            int totalBurg = orderList.get(i).getTotalBurgers();
            while (index > 0 && (totalBurg < orderList.get(index - 1).getTotalBurgers())){
                BurgerOrder test = orderList.remove(index -1);
                orderList.add(index, test);
                index--;

            }
            
        }
    }
    /**
     *Selection Sort: Moves through array and find if value is less than the previous, then replaces it, until every number is sorted.
     *
     */
    public void selectionSort(){
        for (int i = 0; i < orderList.size()-1; i++){
            int minIndex = i;
            for (int j = i + 1; j < orderList.size(); j++){
                if (orderList.get(j).getTotalBurgers() < orderList.get(minIndex).getTotalBurgers()){
                    minIndex = j;
                }

            }
            Collections.swap(orderList, i, minIndex);
        }
    }
    /**
     * Binary Search : Searches through array, moves values according to middle value in order to get the requested order to the middle. Then prints this value. 
     *
     */
    public int findOrderBin(int burgerNum){
        int left = 0;
        int right = orderList.size()-1;
        while (left <= right){
            int middle = (left+right) / 2;
            int temp = orderList.get(middle).getTotalBurgers();
            if (burgerNum == temp){
                return middle+1;
            }
            if (burgerNum < temp){
                left = middle+1;
            }            
            if (burgerNum > temp){
                right = middle -1;
            }
        }
        return -99;

    }
}
