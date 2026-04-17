/**
 * Use Case 16: Sort Passenger Bogies by Capacity
 * Description: Demonstrates manual sorting of passenger bogie capacities 
 * using the Bubble Sort algorithm instead of built-in sorting utilities.
 * * @author Developer
 * @version 26.0
 */
public class UseCase16TrainConsist {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" UC16 - Manual Sorting using Bubble Sort ");
        System.out.println("==================================================");

        // Create array of passenger bogie capacities [cite: 39]
        int[] capacities = {72, 56, 24, 70, 60};

        // Display original order [cite: 41]
        System.out.println("Original Capacities:");
        printArray(capacities);

        // Perform Bubble Sort [cite: 44]
        bubbleSort(capacities);

        // Display sorted result [cite: 48]
        System.out.println("\nSorted Capacities (Ascending):");
        printArray(capacities);

        System.out.println("\nUC16 sorting completed..."); [cite: 85]
    }

    /**
     * Sorts an integer array in ascending order using Bubble Sort algorithm.
     * Time Complexity: O(n^2) [cite: 65]
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        // Outer loop controls the number of passes [cite: 45]
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for adjacent comparisons [cite: 68]
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the left element is greater than the right [cite: 69]
                if (array[j] > array[j + 1]) {
                    // Swapping logic [cite: 63]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}