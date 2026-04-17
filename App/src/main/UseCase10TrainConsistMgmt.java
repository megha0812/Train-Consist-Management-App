import java.util.ArrayList;
import java.util.List;

/**
 * Use Case 10: Count Total Seats in Train [cite: 6]
 * This class aggregates seating capacity of all bogies into a single total using Stream reduce()[cite: 27].
 */
public class UseCase10TrainConsistMgmt {

    public static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        // Create List of bogies [cite: 42]
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72)); [cite: 44, 51]
        bogies.add(new Bogie("AC Chair", 56)); [cite: 44, 53]
        bogies.add(new Bogie("First Class", 24)); [cite: 44, 54]
        bogies.add(new Bogie("Sleeper", 70)); [cite: 45, 55]

        System.out.println("==========================================");
        System.out.println("UC10 - Count Total Seats in Train");
        System.out.println("==========================================");

        // Display bogies [cite: 46]
        System.out.println("Bogies in Train:");
        bogies.forEach(System.out::println);
        System.out.println();

        // AGGREGATE USING REDUCE [cite: 50]
        // map() extracts capacity field [cite: 56, 62]
        // reduce() sums values into total [cite: 31, 63]
        int totalCapacity = bogies.stream()
                .map(Bogie::getCapacity) [cite: 71]
                .reduce(0, Integer::sum); [cite: 72]

        System.out.println("Total Seating Capacity of Train: " + totalCapacity); [cite: 84]
        System.out.println("\nUC10 aggregation completed..."); [cite: 85]
    }

    // Helper method for unit testing aggregation logic
    public static int calculateTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum); [cite: 72]
    }
}