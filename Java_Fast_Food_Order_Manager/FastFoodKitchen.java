import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.io.*;
import java.util.*;

/**
 *
 * ITSC 1213 
 * University of North Carolina at Charlotte
 */

public class FastFoodKitchen {

    public ArrayList<BurgerOrder> orderList = new ArrayList();

    private static int nextOrderNum = 1;

    FastFoodKitchen() {
        orderList.add(new BurgerOrder(3, 15, 4, 10, false, getNextOrderNum()));
        incrementNextOrderNum();
        orderList.add(new BurgerOrder(10, 10, 3, 3, true, getNextOrderNum()));
        incrementNextOrderNum();
        orderList.add(new BurgerOrder(1, 1, 1, 2, false, getNextOrderNum()));
        incrementNextOrderNum();
    }

    FastFoodKitchen(String csvFilePath) {
    try (Scanner br = new Scanner(new File("burgerOrder.csv"))) {
        
        //br.readLine(); // Skip the header
        while (br.hasNext()) {
            String line = br.nextLine();
            String[] values = line.split(", ");
            int orderID = Integer.parseInt(values[0]);
            int numHamburgers = Integer.parseInt(values[1]);
            int numCheeseburgers = Integer.parseInt(values[2]);
            int numVeggieburgers = Integer.parseInt(values[3]);
            int numSodas = Integer.parseInt(values[4]);
            boolean toGo = Boolean.parseBoolean(values[5]);
            orderList.add(new BurgerOrder(numHamburgers, numCheeseburgers, numVeggieburgers, numSodas, toGo, orderID));
            incrementNextOrderNum();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void endOfDay(String reportPath, String updatedOrdersPath) {
    try (PrintWriter reportWriter = new PrintWriter(new FileWriter(reportPath));
         PrintWriter ordersWriter = new PrintWriter(new FileWriter(updatedOrdersPath))) {
        int totalHamburgers = 0, totalCheeseburgers = 0, totalVeggieburgers = 0, totalSodas = 0;
        reportWriter.println("\nOrders Incomplete:");
        for (BurgerOrder order : orderList) {
            reportWriter.println(order.toString());
            ordersWriter.println(order.getOrderNum() + ", " + order.getNumHamburger() + ", " + order.getNumCheeseburgers() + ", "
                    + order.getNumVeggieburgers() + ", " + order.getNumSodas() + ", " + order.isOrderToGo());
            totalHamburgers += order.getNumHamburger();
            totalCheeseburgers += order.getNumCheeseburgers();
            totalVeggieburgers += order.getNumVeggieburgers();
            totalSodas += order.getNumSodas();
        }
        reportWriter.println("\nIncomplete Orders Totals:");
        reportWriter.println("Hamburgers: " + totalHamburgers);
        reportWriter.println("Cheeseburgers: " + totalCheeseburgers);
        reportWriter.println("Veggieburgers: " + totalVeggieburgers);
        reportWriter.println("Sodas: " + totalSodas);
    } catch (IOException e) {
        e.printStackTrace();
    }

}


    public static int getNextOrderNum() {
        return nextOrderNum;
    }

    private void incrementNextOrderNum() {
        nextOrderNum++;
    }

    public int addOrder(int ham, int cheese, int veggie, int soda, boolean toGo) {
        int orderNum = getNextOrderNum();
        orderList.add(new BurgerOrder(ham, cheese, veggie, soda, toGo, orderNum));
        incrementNextOrderNum();
        orderCallOut(orderList.get(orderList.size() - 1));
        return orderNum;

    }

    public boolean isOrderDone(int orderID) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderNum() == orderID) {
                return false;
            }
        }
        return true;
    }

    public boolean cancelOrder(int orderID) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderNum() == orderID) {
                orderList.get(i).setCompleted(false);
                orderList.remove(i);
                return true;
            }
        }
        return false;
}


    public int getNumOrdersPending() {
        // for(int i = 0; i<orderList.size(); i++){
        //     System.out.println(orderList.get(i));
        // }
        return orderList.size();
    }

    public boolean cancelLastOrder() {

        if (!orderList.isEmpty()) { // same as  if (orderList.size() > 0) 
            orderList.remove(orderList.size() - 1);
            return true;
        }

        return false;
    }

    private void orderCallOut(BurgerOrder order) {
        if (order.getNumCheeseburgers() > 0) {
            System.out.println("You have " + order.getNumHamburger() + " hamburgers");
        }
        if (order.getNumCheeseburgers() > 0) {
            System.out.println("You have " + order.getNumCheeseburgers() + " cheeseburgers");
        }
        if (order.getNumVeggieburgers() > 0) {
            System.out.println("You have " + order.getNumVeggieburgers() + " veggieburgers");
        }
        if (order.getNumSodas() > 0) {
            System.out.println("You have " + order.getNumSodas() + " sodas");
        }
        if(order.isOrderToGo() == true)
            System.out.println("Your order is ToGo");
        else{
            System.out.println("Your order is not ToGo");
        }

    }

    public void completeSpecificOrder(int orderID) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderNum() == orderID) {
                System.out.println("Order number " + orderID + " is done!");
                if (orderList.get(i).isOrderToGo()) {
                    orderCallOut(orderList.get(i));
                }
                orderList.get(i).setCompleted(true);
                orderList.remove(i);
            }
        }

    }

    public void completeNextOrder() {
        int nextOrder = orderList.get(0).getOrderNum();
        completeSpecificOrder(nextOrder);

    }

    // Part 2
    public ArrayList<BurgerOrder> getOrderList() {
        return orderList;
    }

    public int findOrderSeq(int whatWeAreLookingFor) {
        for (int j = 0; j < orderList.size(); j++) {
            if (orderList.get(j).getOrderNum() == whatWeAreLookingFor) {
                return j;
            }
        }
        return -1;
    }

//    public int findOrderBin(int whatWeAreLookingFor) {
//        int left = 0;
//        int right = orderList.size() - 1;
//        while (left <= right) {
//            int middle = (left + right) / 2;
//            if (whatWeAreLookingFor < orderList.get(middle).getOrderNum()) {
//                right = middle - 1;
//            } else if (whatWeAreLookingFor > orderList.get(middle).getOrderNum()) {
//                left = middle + 1;
//            } else {
//                return middle;
//            }
//        }
//        return -1;
//    }

  public int findOrderBin(int orderID){
        int left = 0;
        int right = orderList.size()-1;
        while (left <= right){
            int middle = ((left + right)/2);
            if (orderID < orderList.get(middle).getOrderNum()){
                right = middle-1;
            }
            else if(orderID > orderList.get(middle).getOrderNum()){
                left = middle +1;
            }
            else{
                return middle;
            }
        }
        return -1;
        
    }
    public void selectionSort(){
        for (int i = 0; i< orderList.size()-1; i++){
            int minIndex = i;
            for (int k = i+1; k < orderList.size(); k++){
                if (orderList.get(minIndex).getTotalBurgers() > orderList.get(k).getTotalBurgers()){
                    minIndex = k;
                }
            }
            BurgerOrder temp = orderList.get(i);
            orderList.set(i , orderList.get(minIndex));
            orderList.set(minIndex, temp);
        }
    }

    public void insertionSort() {
        for (int j = 1; j < orderList.size(); j++) {
            BurgerOrder temp = orderList.get(j);
            int possibleIndex = j;
            while (possibleIndex > 0 && temp.getTotalBurgers() < orderList.get(possibleIndex - 1).getTotalBurgers()) {
                orderList.set(possibleIndex, orderList.get(possibleIndex - 1));
                possibleIndex--;
            }
            orderList.set(possibleIndex, temp);
        }
    }
    
//    public void selectionSort() { //weird method!
//
//        for (int j = 0; j < orderList.size() - 1; j++) {
//            int minIndex = j;
//            for (int k = j + 1; k < orderList.size(); k++) {
//
//                 if (orderList.get(minIndex).getTotalBurgers() > orderList.get(j).getTotalBurgers()){
//                    minIndex = k;
//                }
//            }
//            BurgerOrder temp = orderList.get(j);
//            orderList.set(j, orderList.get(minIndex));
//            orderList.set(minIndex, temp);
//
//        }
//    }

}