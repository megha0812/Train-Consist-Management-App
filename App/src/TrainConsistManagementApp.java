import java.util.LinkedList;
import java.util.List;

/**
 * UC4: Maintain Ordered Bogie Consist
 * Models the physical chaining of train bogies using LinkedList for ordered operations.
 * [cite: 24, 27]
 */
public class UseCase4TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println(" UC4: Maintain Ordered Bogie Consist ");
        System.out.println("============================================");

        // Create a LinkedList to maintain insertion order [cite: 49, 57]
        LinkedList<String> trainConsist = new LinkedList<>();

        // Add bogies: Engine, Sleeper, AC, Cargo, Guard [cite: 66]
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist); [cite: 77, 78]

        // Insert a Pantry Car at position 2 [cite: 61, 67]
        trainConsist.add(2, "Pantry Car");
        System.out.println("\nAfter Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist); [cite: 79, 80]

        // Remove the first and last bogie [cite: 62, 68]
        trainConsist.removeFirst();
        trainConsist.removeLast();

        System.out.println("\nAfter Removing First and Last Bogie:");
        System.out.println(trainConsist); [cite: 81, 82]

        System.out.println("\nUC4 ordered consist operations completed..."); [cite: 83]
    }

    // Helper method for Unit Testing to return the current consist state
    public LinkedList<String> getConsist() {
        return new LinkedList<>(); // Placeholder for testing logic
    }
}