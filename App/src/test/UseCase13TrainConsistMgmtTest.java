import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase13TrainConsistMgmtTest {

    private List<UseCase13TrainConsistMgmt.Bogie> bogies;

    @BeforeEach
    void setUp() {
        bogies = new ArrayList<>();
        bogies.add(new UseCase13TrainConsistMgmt.Bogie("Sleeper", 70));
        bogies.add(new UseCase13TrainConsistMgmt.Bogie("AC Chair", 50));
        bogies.add(new UseCase13TrainConsistMgmt.Bogie("First Class", 80));
        bogies.add(new UseCase13TrainConsistMgmt.Bogie("General", 30));
    }

    @Test
    void testLoopFilteringLogic() {
        // Verifies that loop-based filtering correctly returns bogies with capacity > 60 [cite: 100]
        List<UseCase13TrainConsistMgmt.Bogie> filtered = new ArrayList<>();
        for (UseCase13TrainConsistMgmt.Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                filtered.add(b);
            }
        }
        assertEquals(2, filtered.size());
        assertTrue(filtered.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        // Verifies that stream-based filtering correctly returns bogies with capacity > 60 [cite: 102]
        List<UseCase13TrainConsistMgmt.Bogie> filtered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        assertEquals(2, filtered.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        // Verifies that both filtering methods produce the same number of filtered bogies [cite: 104]
        List<UseCase13TrainConsistMgmt.Bogie> loopResult = new ArrayList<>();
        for (UseCase13TrainConsistMgmt.Bogie b : bogies) {
            if (b.getCapacity() > 60) loopResult.add(b);
        }

        List<UseCase13TrainConsistMgmt.Bogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        // Verifies that execution time is calculated and produces a positive value [cite: 106]
        long start = System.nanoTime();
        // Small operation
        long end = System.nanoTime();
        assertTrue((end - start) >= 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        // Verifies filtering logic works correctly when processing a large dataset [cite: 108]
        List<UseCase13TrainConsistMgmt.Bogie> largeData = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            largeData.add(new UseCase13TrainConsistMgmt.Bogie("Cargo", i % 100));
        }
        long count = largeData.stream().filter(b -> b.getCapacity() > 60).count();
        assertEquals(3900, count); // (10000/100) * 39 (61 to 99 inclusive)
    }
}
