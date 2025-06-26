
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args) {
        FastFoodKitchen kitchen = new FastFoodKitchen();

        int orderPosition = kitchen.findOrderSeq(2);
        System.out.println("Using Sequential Search >> order position with this many burgers is order: " + orderPosition);

        int orderPosition2 = kitchen.findOrderBin(2);
        System.out.println("Using Binary Search >> order position with this many burgers is order: " + orderPosition2);


        //kitchen.insertionSort();
        ArrayList<BurgerOrder> sortedOrders = kitchen.getOrderList();
        int orderSize = 0;
        System.out.println("Insertion Sort: ");
        for (BurgerOrder order : sortedOrders){
            orderSize = order.getTotalBurgers();
            System.out.println("Order " + order.getOrderNum() + " has " + orderSize + " burgers.");
        }
        kitchen.selectionSort();
        ArrayList<BurgerOrder> sortedOrders2 = kitchen.getOrderList();
        int orderSize2 = 0;
        System.out.println("Selection Sort:");
        for (BurgerOrder order2 : sortedOrders2){
            orderSize2 = order2.getTotalBurgers();
            System.out.println("Order " + order2.getOrderNum() + " has " + orderSize2 + " burgers.");
        }
    }
}

