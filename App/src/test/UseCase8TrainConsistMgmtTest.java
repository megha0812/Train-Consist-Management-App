import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase8TrainConsistMgmtTest {

    private List<UseCase8TrainConsistMgmt.Bogie> getMockBogies() {
        List<UseCase8TrainConsistMgmt.Bogie> list = new ArrayList<>();
        list.add(new UseCase8TrainConsistMgmt.Bogie("Sleeper", 72));
        list.add(new UseCase8TrainConsistMgmt.Bogie("AC Chair", 56));
        list.add(new UseCase8TrainConsistMgmt.Bogie("First Class", 24));
        list.add(new UseCase8TrainConsistMgmt.Bogie("General", 90));
        return list;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = getMockBogies();
        List<UseCase8TrainConsistMgmt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        // Should contain Sleeper (72) and General (90)
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(b -> b.name.equals("Sleeper")));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = getMockBogies();
        int threshold = 72;
        List<UseCase8TrainConsistMgmt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());

        // 72 should be excluded as condition is > 72
        assertFalse(result.stream().anyMatch(b -> b.capacity == threshold));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = getMockBogies();
        List<UseCase8TrainConsistMgmt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 100)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = getMockBogies();
        List<UseCase8TrainConsistMgmt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 20)
                .collect(Collectors.toList());

        assertEquals(4, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = getMockBogies();
        List<UseCase8TrainConsistMgmt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 1000)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = getMockBogies();
        List<UseCase8TrainConsistMgmt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 0)
                .collect(Collectors.toList());

        assertEquals(bogies.size(), result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        List<UseCase8TrainConsistMgmt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = getMockBogies();
        int originalSize = bogies.size();

        bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(originalSize, bogies.size());
    }
}
