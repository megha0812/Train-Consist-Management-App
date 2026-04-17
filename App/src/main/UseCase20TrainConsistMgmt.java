/**
 * UC20: Exception Handling During Search Operations
 * This class demonstrates defensive programming and the fail-fast principle.
 * It prevents searching when no bogies exist by throwing an IllegalStateException. [cite: 6, 25, 64]
 */
public class UseCase20TrainConsistMgmt {

    public static void main(String[] args) {
        // Create bogie array (empty train scenario for UC20) [cite: 39]
        String[] bogieIds = {};
        String searchId = "86101"; [cite: 41]

        try {
            boolean found = performSearch(bogieIds, searchId);
            if (found) {
                System.out.println("Bogie " + searchId + " found in train."); [cite: 51]
            } else {
                System.out.println("Bogie " + searchId + " not found in train."); [cite: 51]
            }
        } catch (IllegalStateException e) {
            System.err.println("Exception in thread \"main\" java.lang.IllegalStateException: " + e.getMessage()); [cite: 82]
        }

        System.out.println("\nUC20 execution completed..."); [cite: 52]
    }

    /**
     * Searches for a bogie ID after validating the train state. [cite: 65]
     * @param bogieIds Array of bogie IDs
     * @param searchId ID to search for
     * @return true if found, false otherwise
     * @throws IllegalStateException if the bogie array is empty [cite: 70]
     */
    public static boolean performSearch(String[] bogieIds, String searchId) {
        // FAIL-FAST VALIDATION: Check if train has bogies before performing search [cite: 43, 44]
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search."); [cite: 45, 70, 82]
        }

        // SEARCH LOGIC (executes only if data exists) [cite: 47]
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true; [cite: 49]
            }
        }
        return false;
    }
}