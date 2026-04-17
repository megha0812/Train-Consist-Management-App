import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for UC20 using JUnit 5. [cite: 110]
 */
class UseCase20TrainConsistMgmtTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        // Verifies that the system throws an exception when attempting to search an empty bogie array. [cite: 95, 96]
        String[] bogieIds = {};
        assertThrows(IllegalStateException.class, () -> {
            UseCase20TrainConsistMgmt.performSearch(bogieIds, "BG101"); [cite: 97]
        }, "No bogies available in train. Cannot perform search.");
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        // Verifies that the system allows search execution when bogie data is present. [cite: 98, 99]
        String[] bogieIds = {"BG101", "BG205"};
        assertDoesNotThrow(() -> UseCase20TrainConsistMgmt.performSearch(bogieIds, "BG101")); [cite: 100]
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        // Verifies that a bogie is correctly found after passing validation. [cite: 101, 102]
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        assertTrue(UseCase20TrainConsistMgmt.performSearch(bogieIds, "BG205")); [cite: 103]
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        // Verifies that the system correctly returns false when bogie is not found. [cite: 104, 105]
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        assertFalse(UseCase20TrainConsistMgmt.performSearch(bogieIds, "BG999")); [cite: 106]
    }

    @Test
    void testSearch_SingleElementValidCase() {
        // Verifies correct behavior when only one bogie exists. [cite: 107, 108]
        String[] bogieIds = {"BG101"};
        assertTrue(UseCase20TrainConsistMgmt.performSearch(bogieIds, "BG101")); [cite: 108]
    }
}
