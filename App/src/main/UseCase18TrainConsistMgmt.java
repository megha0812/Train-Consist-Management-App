/**
 * Use Case 18: Linear Search for Bogie ID
 * This class demonstrates searching for a specific bogie ID 
 * using a simple Linear Search algorithm. [cite: 23, 25, 26]
 */
public class UseCase18TrainConsistMgmt {

    /**
     * Performs a linear search on an array of bogie IDs.
     * @param bogieIds The array of bogie IDs to search through.
     * @param searchId The ID to find.
     * @return true if the ID is found, false otherwise.
     */
    public boolean searchBogie(String[] bogieIds, String searchId) {
        // Traverse each element sequentially [cite: 49]
        for (String id : bogieIds) {
            // Compare each ID using equals() [cite: 73]
            if (id.equals(searchId)) {
                // Early Termination - Stops searching immediately once a match is found [cite: 67]
                return true;
            }
        }
        return false; // Return false if the entire list was traversed without a match [cite: 98]
    }

    public static void main(String[] args) {
        UseCase18TrainConsistMgmt app = new UseCase18TrainConsistMgmt();

        // Create array of bogie IDs [cite: 41, 70]
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Bogie ID to search [cite: 43, 71]
        String searchId = "BG309";

        System.out.println("UC18 Linear Search for Bogie ID"); [cite: 83]
        System.out.println("Available Bogie IDs:"); [cite: 84]
        for (String id : bogieIds) {
            System.out.println(id); [cite: 85, 89]
        }

        boolean found = app.searchBogie(bogieIds, searchId);

        // Display result [cite: 52]
        if (found) {
            System.out.println("Bogie " + searchId + " found in train consist."); [cite: 90]
        } else {
            System.out.println("Bogie " + searchId + " not found.");
        }

        System.out.println("UC18 search completed..."); [cite: 91]
    }
}