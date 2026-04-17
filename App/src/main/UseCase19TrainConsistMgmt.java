import java.util.Arrays;

/**
 * Use Case 19: Binary Search for Bogie ID
 * Demonstrates optimized searching using divide-and-conquer on sorted data.
 */
public class UseCase19TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("=========================================");

        // Create array of bogie IDs
        String[] bogieIds = {"B6101", "B6205", "B6309", "BG412", "B6550"};

        // Ensure data is sorted (Precondition for Binary Search)
        Arrays.sort(bogieIds);

        String key = "B6309";

        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }
        System.out.println();

        boolean found = performBinarySearch(bogieIds, key);

        if (found) {
            System.out.println("Bogie " + key + " found using Binary Search.");
        } else {
            System.out.println("Bogie " + key + " not found.");
        }

        System.out.println("UC19 search completed...");
    }

    /**
     * Performs a binary search on a sorted array of Strings.
     * @param arr The sorted array to search.
     * @param key The Bogie ID to find.
     * @return true if found, false otherwise.
     */
    public static boolean performBinarySearch(String[] arr, String key) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        // Logic requires sorted input; ensure sorting if not already handled
        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = key.compareTo(arr[mid]);

            if (comparison == 0) {
                return true; // Key found
            } else if (comparison > 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return false; // Key not found
    }
}