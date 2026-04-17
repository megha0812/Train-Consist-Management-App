import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase18TrainConsistMgmtTest {

    private final UseCase18TrainConsistMgmt app = new UseCase18TrainConsistMgmt();
    private final String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

    @Test
    void testSearch_BogieFound() {
        // Verifies that the system successfully identifies an existing bogie ID. [cite: 105]
        assertTrue(app.searchBogie(bogieIds, "BG309")); [cite: 106]
    }

    @Test
    void testSearch_BogieNotFound() {
        // Verifies that the system returns a negative result when the bogie ID does not exist. [cite: 108]
        assertFalse(app.searchBogie(bogieIds, "BG999")); [cite: 109]
    }

    @Test
    void testSearch_FirstElementMatch() {
        // Verifies that the search correctly detects a match at the first position. [cite: 111]
        assertTrue(app.searchBogie(bogieIds, "BG101")); [cite: 112]
    }

    @Test
    void testSearch_LastElementMatch() {
        // Verifies that the search correctly detects a match at the last position. [cite: 114]
        assertTrue(app.searchBogie(bogieIds, "BG550")); [cite: 115]
    }

    @Test
    void testSearch_SingleElementArray() {
        // Verifies that the search works correctly when only one bogie ID exists. [cite: 117]
        String[] singleBogie = {"BG101"};
        assertTrue(app.searchBogie(singleBogie, "BG101")); [cite: 118]
    }
}