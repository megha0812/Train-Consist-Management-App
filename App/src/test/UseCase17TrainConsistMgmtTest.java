import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Unit tests for UC17 using JUnit 5.
 */
public class UseCase17TrainConsistMgmtTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        UseCase17TrainConsistMgmt app = new UseCase17TrainConsistMgmt();
        String[] input = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        assertArrayEquals(expected, app.sortBogieNames(input));
    }

    @Test
    void testSort_UnsortedInput() {
        UseCase17TrainConsistMgmt app = new UseCase17TrainConsistMgmt();
        String[] input = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};
        assertArrayEquals(expected, app.sortBogieNames(input));
    }

    @Test
    void testSort_AlreadySortedArray() {
        UseCase17TrainConsistMgmt app = new UseCase17TrainConsistMgmt();
        String[] input = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};
        assertArrayEquals(expected, app.sortBogieNames(input));
    }

    @Test
    void testSort_DuplicateBogieNames() {
        UseCase17TrainConsistMgmt app = new UseCase17TrainConsistMgmt();
        String[] input = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};
        assertArrayEquals(expected, app.sortBogieNames(input));
    }

    @Test
    void testSort_SingleElementArray() {
        UseCase17TrainConsistMgmt app = new UseCase17TrainConsistMgmt();
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};
        assertArrayEquals(expected, app.sortBogieNames(input));
    }
}