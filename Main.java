import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList rooms = new ArrayList<Rooms>();
        loadRooms(rooms);        
        ArrayList reservations = new ArrayList<Reservation>();
        loadReservations(reservations);

        Scanner userInput = new Scanner(System.in);
        int choice = 0;
        while (choice != 6) {
            // see what the user wants to do
            System.out.println("Please select from the following menu of options, by typing a number:");
            System.out.println("\t 1. Print Reservations");
            System.out.println("\t 2. Add a new reservation");
            System.out.println("\t 3. Cancel a reservation");
            System.out.println("\t 4. View List of Rooms");
            System.out.println("\t 5. Modify a Room");
            System.out.println("\t 6. Save and Close");
    
            choice = userInput.nextInt();
            userInput.nextLine();
            switch (choice) {
                case 1:     
                    for(int i = 0; i<reservations.size(); i++){
                        System.out.println(reservations.get(i));
                    }
                    break;
                case 2:
                    addReservation(reservations, userInput);
                    break;
                case 3:
                    removeReservation(reservations, userInput);
                    break;
                case 4:
                    for(int i = 0; i<rooms.size(); i++){
                        System.out.println(rooms.get(i));
                    }
                    break;
                case 5:
                    modifyRooms(rooms, userInput);
                    break;
                case 6:
                    saveRoomsList(rooms);
                    saveList(reservations);
                    break;            
                default:
                    System.out.println("Sorry, but you need to enter a 1, 2, 3, 4, 5, 6");
                }
            } // end while loop
        

    }

    public static void saveList(ArrayList<Reservation> reservations){
        try {
            FileOutputStream stream = new FileOutputStream("Reservations.csv");
            PrintWriter printer = new PrintWriter(stream);
            for(int i = 0; i<reservations.size(); i++){
                printer.println(reservations.get(i).printToCSV());
            }
            printer.close();
            stream.close();
            System.exit(0);
        } catch (FileNotFoundException x){
            System.out.println("Please check the locations of the Reservations File and try again.");
        } catch (IOException x){
            System.out.println("Error Please Try Again.");
        }
    }       
    public static void saveRoomsList(ArrayList<Rooms> rooms){
        try {
            FileOutputStream stream = new FileOutputStream("Rooms.csv");
            PrintWriter printer = new PrintWriter(stream);
            for(int i = 0; i<rooms.size(); i++){
                printer.println(rooms.get(i).printToCSV());
            }
            printer.close();
            stream.close();
            System.exit(0);
        } catch (FileNotFoundException x){
            System.out.println("Please check the locations of the Rooms File and try again.");
        } catch (IOException x){
            System.out.println("Error Please Try Again.");
        }
    }

    public static void addReservation(ArrayList reservations, Scanner userInput) {
        System.out.println("Enter the reservation information: ");
        System.out.println("First Name: ");
        String firstName = userInput.nextLine().strip();
        System.out.println("Last Name: ");
        String lastName = userInput.nextLine().strip();
        System.out.println("Starting Month: ");
        int startMonth = Integer.valueOf(userInput.nextLine().strip());
        System.out.println("Starting Day: ");
        int startDay = Integer.valueOf(userInput.nextLine().strip());
        System.out.println("Starting Year: ");
        int startYear = Integer.valueOf(userInput.nextLine().strip());
        System.out.println("Ending Month: ");
        int endMonth = Integer.valueOf(userInput.nextLine().strip());
        System.out.println("Ending Day: ");
        int endDay = Integer.valueOf(userInput.nextLine().strip());
        System.out.println("Ending Year: ");
        int endYear = Integer.valueOf(userInput.nextLine().strip());
        System.out.println("Room Number: ");
        int roomNumber = Integer.valueOf(userInput.nextLine().strip());
        System.out.println("Prepaid?: (enter true or false) ");
        boolean prepaid = Boolean.parseBoolean(userInput.nextLine().strip());
        reservations.add(new Reservation(firstName, lastName, 
            startMonth, startDay, startYear, endMonth, endDay, endYear, 
            roomNumber, prepaid));
    }

    public static void removeReservation(ArrayList<Reservation> reservations, Scanner userInput) {
        System.out.println("Enter the customer's information: ");
        System.out.println("First Name: ");
        String firstName = userInput.nextLine().strip();
        System.out.println("Last Name: ");
        String lastName = userInput.nextLine().strip();
        for(int i = 0; i<reservations.size(); i++){
            Reservation test = reservations.get(i);
            if(test.getFirstName().equals(firstName) && test.getLastName().equals(lastName)){
                reservations.remove(i);
            }
        }
    }
    public static void modifyRooms(ArrayList<Rooms> rooms, Scanner userInput) {
        System.out.println("Enter the Room Number: ");
        System.out.println("Room Number: ");
        String roomN = userInput.nextLine().strip();
        for(int i = 0; i<rooms.size(); i++){
            Rooms test = rooms.get(i);
            if(test.getRoomNum().equals(roomN)){
                rooms.remove(i);
            }
        }
        System.out.println("Enter the room information: ");
        System.out.println("Room Number: ");
        String roomNum = userInput.nextLine().strip();
        System.out.println("Guest Amount: ");
        int guestAmount = Integer.valueOf(userInput.nextLine().strip());
        System.out.println("Cost: ");
        double cost = Double.valueOf(userInput.nextLine().strip());
        System.out.println("Floor: ");
        int floor = Integer.valueOf(userInput.nextLine().strip());
        System.out.println("Bed Amount: ");
        int bedNum = Integer.valueOf(userInput.nextLine().strip());
        System.out.println("Bed Size: ");
        int bedSize = Integer.valueOf(userInput.nextLine().strip());
        System.out.println("View:True/False");
        boolean view = Boolean.parseBoolean(userInput.nextLine().strip());
        System.out.println("Suite:True/False");
        boolean suite = Boolean.parseBoolean(userInput.nextLine().strip());
        rooms.add(new Rooms(roomNum, guestAmount, cost, floor, bedNum, bedSize, view, suite));
    }

    public static void loadReservations(ArrayList<Reservation> reservations) {
        try {
            Scanner fileScanner = new Scanner(new File("Reservations.csv"));
            while(fileScanner.hasNext()){
                String line = fileScanner.nextLine();
                //System.out.println(line);
                String[] parsedLine = line.split(",");
                int startMonth = Integer.valueOf(parsedLine[2]);
                int startDay = Integer.valueOf(parsedLine[3]);
                int startYear = Integer.valueOf(parsedLine[4]);
                int endMonth = Integer.valueOf(parsedLine[5]);
                int endDay = Integer.valueOf(parsedLine[6]);
                int endYear = Integer.valueOf(parsedLine[7]);
                int roomNumber = Integer.valueOf(parsedLine[8]);
                boolean prepaid = Boolean.parseBoolean(parsedLine[9]);
                reservations.add(new Reservation(parsedLine[0], parsedLine[1], 
                    startMonth, startDay, startYear, endMonth, endDay, endYear, 
                    roomNumber, prepaid));
            }
            System.out.println("Finished Loading Reservations");
            fileScanner.close();
        } catch (FileNotFoundException x){
            System.out.println("Please check the Reservations File and try again.");
                System.exit(0);
        }
    }
    public static void loadRooms(ArrayList<Rooms> rooms) {
        try {
            Scanner fileScanner = new Scanner(new File("Rooms.csv"));
            while(fileScanner.hasNext()){
                String line = fileScanner.nextLine();
                //System.out.println(line);
                String[] parsedLine = line.split(",");
                //int roomNum = Integer.valueOf(parsedLine[0]); 
                int guestAmount = Integer.valueOf(parsedLine[1]); 
                double cost = Double.valueOf(parsedLine[2]);
                int floor = Integer.valueOf(parsedLine[3]);
                int bedNum = Integer.valueOf(parsedLine[4]); 
                int bedSize = Integer.valueOf(parsedLine[5]); 
                boolean view = Boolean.parseBoolean(parsedLine[6]); 
                boolean suite = Boolean.parseBoolean(parsedLine[7]);
                rooms.add(new Rooms( 
                    (parsedLine[0]), guestAmount, cost, floor, bedNum, bedSize, view, suite));
            }
            System.out.println("Finished Loading Rooms");
            fileScanner.close();
        } catch (FileNotFoundException x){
            System.out.println("Please check the Rooms File and try again.");
                System.exit(0);
        }
    }

}
