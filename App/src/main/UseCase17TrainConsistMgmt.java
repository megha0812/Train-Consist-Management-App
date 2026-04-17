import java.util.Arrays;

/**
 * Use Case 17: Sort Bogie Names Using Arrays.sort()
 * This class demonstrates sorting of bogie type names alphabetically
 * using Java's built-in optimized library utilities.
 * * @author Developer
 * @version 17.0
 */
public class UseCase17TrainConsistMgmt {

    /**
     * Sorts an array of bogie names in alphabetical order using Arrays.sort().
     * @param bogieNames The array of bogie names to be sorted.
     * @return The sorted array of bogie names.
     */
    public String[] sortBogieNames(String[] bogieNames) {
        if (bogieNames == null) {
            return null;
        }
        // Using Java's built-in optimized sorting algorithm (O(n log n))
        Arrays.sort(bogieNames);
        return bogieNames;
    }

    public static void main(String[] args) {
        UseCase17TrainConsistMgmt app = new UseCase17TrainConsistMgmt();

        System.out.println("===========================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("===========================================");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("\nOriginal Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        app.sortBogieNames(bogieNames);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");
    }
}
