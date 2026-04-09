import java.util.HashMap;
import java.util.Map;

/**
 * Use Case 6: Map Bogie to Capacity (HashMap)
 * This class associates each bogie with its seating or load capacity
 * using a key-value mapping structure.
 * * @author Developer
 * @version 6.0
 */
public class UseCase6TrainConsistMgmt {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC6 - Map Bogie to Capacity (HashMap) ");
        System.out.println("==============================================");

        // HashMap stores data in key-value format [cite: 37, 38]
        Map<String, Integer> capacityMap = getBogieCapacityMap();

        System.out.println("\nBogie Capacity Details:");

        // Iterate through the map entries using entrySet() [cite: 56, 62]
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed..."); [cite: 76]
    }

    /**
     * Creates and populates the capacity map.
     * @return Map containing bogie names and their integer capacities.
     */
    public static Map<String, Integer> getBogieCapacityMap() {
        Map<String, Integer> capacityMap = new HashMap<>(); [cite: 59]

        // Using put() method to map each bogie to its capacity [cite: 53, 61]
        capacityMap.put("First Class", 24); [cite: 72]
        capacityMap.put("Cargo", 120);       [cite: 73]
        capacityMap.put("Sleeper", 72);     [cite: 74]
        capacityMap.put("AC Chair", 56);    [cite: 75]

        return capacityMap;
    }
}