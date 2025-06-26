import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * The TextManagementGame class represents a text-based management game where the player manages resources and resource generators.
 */
public class TextManagementGame {
    // Define game variables
    private int round;
    private ArrayList<Resource> resources = new ArrayList<Resource>();
    private ArrayList<Resource> constructionCost = new ArrayList<Resource>();
    private ArrayList<Generator> generators = new ArrayList<Generator>();
    Resource r1 = new Wood("Wood", 15, true);
    Resource r2 = new Steel("Steel", 10, true);
    Resource r3 = new ConstructionTeam("Construction Team", 1, false);
    Generator g1 = new Pickaxe("Pickaxe",constructionCost,  2, 2, r2);
    Generator g2 = new Axe("Axe",constructionCost, 2, 1, r1);
    Generator g3 = new House("House",constructionCost, 1, 1, r3);
    Event flood = new Event("Flood");

    // Define a Scanner for user input
    private Scanner scanner;

    /**
     * Creates a new TextManagementGame instance with initial resource and time values.
     * TODO : Add starting resources
     */
    public TextManagementGame() {
        round = 1;       // Start at time 1
        scanner = new Scanner(System.in);
    }

    /**
     * Check if a method should run with a 1 in number chance.
     *
     * @return true if the method should run, false otherwise
     */
    public boolean haveEventThisTurn(int number) {
        Random random = new Random();
        int chance = random.nextInt(number); // Generates a random number between 0 (inclusive) and number (exclusive)
        return chance == 0; // Returns true with a 1 in number chance
    }

    /**
    * Prints the list of resources
    */
    public void viewResources(){
        for(Resource r : resources){
            System.out.println(r);
        }
    }

    /**
    * Prints the list of Generators
    */
    public void viewGenerators(){
        for(Generator b : generators){
            System.out.println(b);
        }
    }

    /**
     * Checks if a Generator can be constructed and then adds it to the list of Generators
     * TODO : ADD LOGIC
     */
    public void constructGenerator(){
        System.out.println("---------------------------------------");
        System.out.println("---------Generator Constuction:--------");
        System.out.println("---------------------------------------");
        System.out.println("1. Add Pickaxe?(-2 Wood):"); 
        System.out.println("2. Add Axe?(-2 Steel):"); 
        System.out.println("3. Build House?(-2 Wood, -2 Steel, -1 Construction Worker):"); 
        System.out.println("4. Build Nothing(Back):");
        System.out.println("---------------------------------------");
        System.out.print("Choose an option: ");

        int genchoice = scanner.nextInt();
        //switch case checks for which generator to create 
            switch(genchoice) {
                case 1:
                    r1.quantity -= 2;                    
                    g1.numberConstructed = g1.getNumberConstructed() + 1;
                    System.out.println("---------------------------------------");
                    if (r1.quantity == 0){
                        System.out.println("Game Over! You ran out of Wood.");
                        System.out.println("You played for " + round + " rounds and built " + g3.getNumberConstructed() + " houses");
                        scoreImpact();
                        System.exit(0);
                    }
                    System.out.println("You now have " + (g1.getNumberConstructed()+1) + " Pickaxes");
                    break;
                case 2:
                    
                    r2.quantity -= 2;   
                    g2.numberConstructed = g2.getNumberConstructed() + 1;
                    System.out.println("---------------------------------------");
                    if (r2.quantity == 0){
                        System.out.println("Game Over! You ran out of Steel.");
                        System.out.println("You played for " + round + " rounds and built " + g3.getNumberConstructed() + " houses");
                        scoreImpact();
                        System.exit(0);
                    }  
                    System.out.println("You now have " + (g2.getNumberConstructed()+1) + " Axes");                  
                    break;
                case 3:
                    r2.quantity -= 2;                    
                    r1.quantity -= 2;
                    r3.quantity -= 1;                    
                    g3.numberConstructed = g3.getNumberConstructed() + 1;
                    System.out.println("---------------------------------------");
                    if (r1.quantity == 0){
                        System.out.println("Game Over! You ran out of Wood.");
                        System.out.println("You played for " + round + " rounds and built " + g3.getNumberConstructed() + " houses");
                        scoreImpact();
                        System.exit(0);
                    }
                    if (r2.quantity == 0){
                        System.out.println("Game Over! You ran out of Steel.");
                        System.out.println("You played for " + round + " rounds and built " + g3.getNumberConstructed() + " houses");
                        scoreImpact();
                        System.exit(0);
                    } 
                    if (r3.quantity < 0){
                        r3.quantity += 1;                    
                        g3.numberConstructed = g3.getNumberConstructed() - 1;
                        System.out.println("Not Enough Construction Workers");  
                    }
                    System.out.println("You still have " + (g3.getNumberConstructed()) + " Houses");
                    break; 
                case 4:

                    break;
            }
    }

    /** 
     * Increments the time counter and then adds more resources based on what generators are present
     * TODO : Add calculations to generate resources for the next turn
     */
    public void endRound(){
        round++;
    }
    public void scoreImpact(){
        int score = 0;
        int reComparison = r1.compareTo(r2);
        if (reComparison > 0) {
            System.out.println("Your highest quantity resource is Wood(Worth 2 pts each)");
            System.out.println("Wood Score: " + (r1.getQuantity()*2));
        } else if (reComparison < 0) {
            System.out.println("Your highest quantity resource is Steel(Worth 2 pts each)");
            System.out.println("Steel Score: " + (r2.getQuantity()*2));
        } else {System.out.println("Your highest quantity resource is Houses(Worth 4 pts each)");
            System.out.println("Houses Score: " + (r3.getQuantity()*4));
        }

    }
    /**
     * Adds a Generator object to the ArrayList of Generators.
     *
     * @param Generator the Generator object to add
     */
    public void addGenerator(Generator generator) {
        generators.add(generator);
        generators.add(g1);
        generators.add(g2);
        generators.add(g3);
    }

    /**
     * Adds a Resource object to the ArrayList of resources.
     *
     * @param resource the Resource object to add
     */
    public void addResource(Resource resource) {
        resources.add(resource);
        resources.add(r1);
        resources.add(r2);
        resources.add(r3);

    }

    /**
     * Checks if we are out of any critical resources
     *
     * @return returns true if we are out of any critical resources returns false otherwise
    */
    public boolean isCriticalResourceEmpty(){
        for(Resource r : resources){
            if(r.quantity == 0){
                return true;
            }
        }
        return false;
    }

    /**
     * Starts the game and manages the game loop.
     */
    public void start() {
        System.out.println("---------------------------------------");
        System.out.println("--------CONSTRUCTION SIMULATOR:--------");
        System.out.println("---------------------------------------"); //TODO: Change Text
        int oddsOfRandomEvent = 5; //a 25% chance of a random event occuring

        // Main game loop
        while (!isCriticalResourceEmpty()) {
            System.out.println("\nDay: " + round);
            System.out.println("Options:");
            System.out.println("1. View resources");
            System.out.println("2. Collect resources(Will End Day)");
            System.out.println("3. View Generators");
            System.out.println("4. Add a new Generator");
            System.out.println("5. End day");
            System.out.println("6. Quit game");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                //displays resources
                    System.out.println("---------------------------------------");
                    System.out.println("---------------Resources:--------------");
                    System.out.println("---------------------------------------");            
                    System.out.println("Resource: " + r1.getName());
                    System.out.println("Amount: " + r1.getQuantity());
                    System.out.println("Resource: " + r2.getName());
                    System.out.println("Amount: " + r2.getQuantity());
                    System.out.println("Resource: " + r3.getName());
                    System.out.println("Amount: " + r3.getQuantity());
                    viewResources();
                    System.out.println("---------------------------------------");            
                    
                    break;
                case 2:
                //Runs generators to produce resources
                    System.out.println("---------------------------------------");
                    System.out.println("--------Generators in process...-------");
                    System.out.println("---------------------------------------"); 
                    System.out.println(g1.getNumberConstructed() + " Pickaxe(s): Generated " + (g1.getResourceProductionRate()*g1.getNumberConstructed()) + " Steel");
                    r2.quantity += (g1.getResourceProductionRate()*g1.getNumberConstructed());
                    System.out.println(g2.getNumberConstructed() + " Axe(s): Generated " + (g2.getResourceProductionRate()*g2.getNumberConstructed()) + " Wood");
                    r1.quantity += (g2.getResourceProductionRate()*g2.getNumberConstructed());
                    System.out.println(g3.getNumberConstructed() + " House(s): Generated " + (g3.getResourceProductionRate()*g3.getNumberConstructed()) + " Construction Team");                                        
                    r3.quantity += (g3.getResourceProductionRate()*g3.getNumberConstructed());
                    System.out.println("---------------------------------------");            
                    endRound();
                    if(haveEventThisTurn(oddsOfRandomEvent)){
                        //Random flood causes resource loss
                        System.out.println(" ");
                        System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
                        System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
                        System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
                        System.out.println("~^~^~^~^A random flood occured!~^~^~^~^");
                        System.out.println("~^~^~^~^~^~^ -2   Wood ^~^~^~^~^~^~^~^~");
                        System.out.println("~^~^~^~^~^~^ -2   Steel ~^~^~^~^~^~^~^~");
                        System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
                        r1.quantity -= 2; 
                        r2.quantity -= 2;
                        isCriticalResourceEmpty();
                        if (r2.quantity == 0){
                            System.out.println("Game Over! You ran out of Steel.");
                            System.out.println("You played for " + round + " rounds and built " + g3.getNumberConstructed() + " houses");
                            scoreImpact();
                            System.exit(0);
                        }
                        if (r1.quantity == 0){
                            System.out.println("Game Over! You ran out of Wood.");
                            System.out.println("You played for " + round + " rounds and built " + g3.getNumberConstructed() + " houses");
                            scoreImpact();
                            System.exit(0);
                        }
                    }
                    break;
                case 3:
                //display generators
                    System.out.println("---------------------------------------");
                    System.out.println("---------------Generators:-------------");
                    System.out.println("---------------------------------------");
                    System.out.println("Generator: " + g1.getName());
                    System.out.println("Amount: " + g1.getNumberConstructed());
                    System.out.println("Generator: " + g2.getName());
                    System.out.println("Amount: " + g2.getNumberConstructed());
                    System.out.println("Generator: " + g3.getName());
                    System.out.println("Amount: " + g3.getNumberConstructed());
                    viewGenerators();
                    System.out.println("---------------------------------------");
                    break;
                case 4: 
                //runs construct generator switch
                    constructGenerator();
                    break;
                case 5: 
                //ends round checks for event                      
                    endRound();
                    if(haveEventThisTurn(oddsOfRandomEvent)){
                        System.out.println(" ");
                        System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
                        System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
                        System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
                        System.out.println("~^~^~^~^A random flood occured!~^~^~^~^");
                        System.out.println("~^~^~^~^~^~^ -2   Wood ^~^~^~^~^~^~^~^~");
                        System.out.println("~^~^~^~^~^~^ -2   Steel ~^~^~^~^~^~^~^~");
                        System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
                        r1.quantity -= 2; 
                        r2.quantity -= 2;
                        isCriticalResourceEmpty();
                        if (r2.quantity == 0){
                            System.out.println("Game Over! You ran out of Steel.");
                            System.out.println("You played for " + round + " rounds and built " + g3.getNumberConstructed() + " houses");
                            scoreImpact();
                            System.exit(0);
                        }
                        if (r1.quantity == 0){
                            System.out.println("Game Over! You ran out of Wood.");
                            System.out.println("You played for " + round + " rounds and built " + g3.getNumberConstructed() + " houses");
                            scoreImpact();
                            System.exit(0);
                        }
                    }                    
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Game Over! You ran out of resources.");
        System.out.println("You played for " + round + " rounds and built " + g3.getNumberConstructed() + " houses");
        scoreImpact();
    }

    /**
     * Main method to run the game
     *
     * @param args the command-line arguments (not used in this game)
     */
    public static void main(String[] args) {
        TextManagementGame game = new TextManagementGame();
        game.start();
    }
}