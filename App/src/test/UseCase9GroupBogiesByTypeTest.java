import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class UseCase9GroupBogiesByTypeTest {

    @Test
    void testGrouping_BogiesGroupedByType() {
        // [cite: 136, 137] Verifies bogies are correctly grouped by name
        UseCase9GroupBogiesByType app = new UseCase9GroupBogiesByType();
        List<UseCase9GroupBogiesByType.Bogie> bogies = List.of(
                new UseCase9GroupBogiesByType.Bogie("Sleeper", 72),
                new UseCase9GroupBogiesByType.Bogie("AC Chair", 56)
        );

        Map<String, List<UseCase9GroupBogiesByType.Bogie>> result = app.groupBogiesByType(bogies);
        assertTrue(result.containsKey("Sleeper")); [cite: 151]
        assertTrue(result.containsKey("AC Chair")); [cite: 151]
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        // [cite: 138, 139, 140] Verifies multiple bogies of same type are in one list
        UseCase9GroupBogiesByType app = new UseCase9GroupBogiesByType();
        List<UseCase9GroupBogiesByType.Bogie> bogies = List.of(
                new UseCase9GroupBogiesByType.Bogie("Sleeper", 72),
                new UseCase9GroupBogiesByType.Bogie("Sleeper", 70)
        );

        Map<String, List<UseCase9GroupBogiesByType.Bogie>> result = app.groupBogiesByType(bogies);
        assertEquals(2, result.get("Sleeper").size()); [cite: 154]
    }

    @Test
    void testGrouping_EmptyBogieList() {
        // [cite: 144, 145] Verifies empty list returns empty map
        UseCase9GroupBogiesByType app = new UseCase9GroupBogiesByType();
        List<UseCase9GroupBogiesByType.Bogie> bogies = new ArrayList<>();

        Map<String, List<UseCase9GroupBogiesByType.Bogie>> result = app.groupBogiesByType(bogies);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        // [cite: 155, 156, 157] Verifies the original list is not modified
        UseCase9GroupBogiesByType app = new UseCase9GroupBogiesByType();
        List<UseCase9GroupBogiesByType.Bogie> bogies = new ArrayList<>(List.of(
                new UseCase9GroupBogiesByType.Bogie("Sleeper", 72)
        ));

        app.groupBogiesByType(bogies);
        assertEquals(1, bogies.size());
    }
}