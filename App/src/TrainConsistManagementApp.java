import java.util.ArrayList;
import java.util.List;

/**
 * Use Case 2: Add Passenger Bogies to Train [cite: 19]
 * Description: Demonstrates how passenger bogies can be managed dynamically
 * using ArrayList operations (CRUD). [cite: 21, 25]
 */
public class UseCase2TrainConsistMgmt {

    // Create an ArrayList to hold passenger bogies [cite: 31, 32]
    private List<String> passengerBogies;

    public UseCase2TrainConsistMgmt() {
        this.passengerBogies = new ArrayList<>();
    }

    // CREATE: add() attaches a new bogie to the train [cite: 34, 35]
    public void addBogie(String bogie) {
        passengerBogies.add(bogie);
    }

    // DELETE: remove() deletes elements from the list [cite: 49]
    public void removeBogie(String bogie) {
        passengerBogies.remove(bogie);
    }

    // READ: contains() checks whether a given element exists [cite: 50]
    public boolean checkBogieExists(String bogie) {
        return passengerBogies.contains(bogie);
    }

    public List<String> getPassengerBogies() {
        return passengerBogies;
    }

    public static void main(String[] args) {
        System.out.println("\n UC2 Add Passenger Bogies to Train \n"); // [cite: 30, 65]

        UseCase2TrainConsistMgmt train = new UseCase2TrainConsistMgmt();

        // 1. Add bogies: Sleeper, AC Chair, First Class [cite: 55]
        train.addBogie("Sleeper");
        train.addBogie("AC Chair");
        train.addBogie("First Class");

        // 2. Print the list after insertion [cite: 56]
        System.out.println("After Adding Bogies:"); // [cite: 66]
        System.out.println("Passenger Bogies: " + train.getPassengerBogies()); // [cite: 67]

        // 3. Remove one bogie (AC Chair) [cite: 57]
        train.removeBogie("AC Chair");
        System.out.println("\nAfter Removing 'AC Chair':"); // [cite: 68]
        System.out.println("Passenger Bogies: " + train.getPassengerBogies()); // [cite: 69]

        // 4. Use contains() to check if Sleeper exists [cite: 58]
        System.out.println("\nChecking if 'Sleeper' exists:"); // [cite: 70]
        System.out.println("Contains Sleeper?: " + train.checkBogieExists("Sleeper")); // [cite: 71]

        // 5. Print final list state [cite: 59]
        System.out.println("\nFinal Train Passenger Consist:"); // [cite: 72]
        System.out.println(train.getPassengerBogies()); // [cite: 73]
        System.out.println("\nUC2 operations completed successfully..."); // [cite: 74]
    }
}