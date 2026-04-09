import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * UC7: Sort Bogies by Capacity (Comparator)
 * This class sorts passenger bogies based on seating capacity using a custom Comparator. [cite: 27, 30]
 */
public class UseCase7TrainConsistMgmt {

    // Inner Bogie class to model passenger bogies [cite: 41, 45]
    public static class Bogie {
        private String name;
        private int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
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
        System.out.println("========================================");
        System.out.println(" UC7: Sort Bogies by Capacity (Comparator) ");
        System.out.println("========================================\n");

        // Create list of passenger bogies [cite: 55, 56, 75]
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));     // [cite: 76, 85, 86]
        bogies.add(new Bogie("AC Chair", 56));    // [cite: 76, 87]
        bogies.add(new Bogie("First Class", 24)); // [cite: 76, 88]
        bogies.add(new Bogie("General", 90));     // [cite: 89]

        System.out.println("Before Sorting:");
        bogies.forEach(System::println); // [cite: 84]

        // Sort using Comparator logic (comparingInt) [cite: 61, 70, 77]
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nAfter Sorting by Capacity:");
        bogies.forEach(System::println); // [cite: 90]

        System.out.println("\nUC7 sorting completed..."); // [cite: 95]
    }
}