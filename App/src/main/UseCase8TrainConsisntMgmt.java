import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Use Case 8: Filter Passenger Bogies Using Streams
 * Description: This class filters passenger bogies based on seating capacity
 * using the Java Stream API.
 * @author Developer
 * @version 8.8
 */
public class UseCase8TrainConsistMgmt {

    // Reusing Bogie model from UC7 as per requirements
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("==============================================\n");

        // 1. Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);

        // 2. Convert list into stream, 3. Apply filter, 4. Collect results
        // Condition: capacity > 60
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // 5. Display filtered bogies
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);

        System.out.println("\nUC8 filtering completed...");
    }
}
