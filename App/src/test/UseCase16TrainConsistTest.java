import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for UC16 Bubble Sort implementation [cite: 110]
 */
class UseCase16TrainConsistTest {

    @Test
    void testSort_BasicSorting() {
        // Verifies that the Bubble Sort algorithm correctly sorts a typical unsorted array [cite: 99]
        int[] capacities = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};
        UseCase16TrainConsist.bubbleSort(capacities);
        assertArrayEquals(expected, capacities, "The array should be sorted in ascending order [cite: 100]");
    }

    @Test
    void testSort_AlreadySortedArray() {
        // Verifies that an already sorted array remains unchanged after sorting [cite: 101, 102]
        int[] capacities = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};
        UseCase16TrainConsist.bubbleSort(capacities);
        assertArrayEquals(expected, capacities, "An already sorted array should remain unchanged [cite: 103]");
    }

    @Test
    void testSort_DuplicateValues() {
        // Verifies that duplicate capacities are handled correctly during sorting [cite: 104]
        int[] capacities = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        UseCase16TrainConsist.bubbleSort(capacities);
        assertArrayEquals(expected, capacities, "Duplicates should be retained and ordered correctly [cite: 105]");
    }

    @Test
    void testSort_SingleElementArray() {
        // Verifies that sorting a single element array does not modify the array [cite: 106, 107]
        int[] capacities = {50};
        int[] expected = {50};
        UseCase16TrainConsist.bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_AllEqualValues() {
        // Verifies that arrays containing identical values remain unchanged [cite: 108, 109]
        int[] capacities = {40, 40, 40};
        int[] expected = {40, 40, 40};
        UseCase16TrainConsist.bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }
}
