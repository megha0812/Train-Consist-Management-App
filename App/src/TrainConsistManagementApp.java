import java.util.LinkedHashSet;
import java.util.Set;

/**
 * UC5: Preserve Insertion Order of Bogies
 * This class maintains the exact attachment order of bogies while preventing duplicates.
 * @author Developer
 * @version 5.0
 */
public class UseCase5TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" UC5 - Preserve Insertion Order of Bogies ");
        System.out.println("=========================================\n");

        // LinkedHashSet preserves order and ensures uniqueness [cite: 39]
        Set<String> formation = getInitialFormation();

        // Attempting to add a duplicate bogie (Sleeper) [cite: 59]
        formation.add("Sleeper");

        System.out.println("Final Train Formation:");
        System.out.println(formation); [cite: 60, 70]

        System.out.println("\nNote:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically."); [cite: 72]
        System.out.println("UC5 formation setup completed..."); [cite: 73]
    }

    /**
     * Logic to create the LinkedHashSet and add initial bogies.
     * @return Set of unique bogies in insertion order.
     */
    public static Set<String> getInitialFormation() {
        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine"); [cite: 58]
        formation.add("Sleeper"); [cite: 58]
        formation.add("Cargo"); [cite: 58]
        formation.add("Guard"); [cite: 58]
        return formation;
    }
}