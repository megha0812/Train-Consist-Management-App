import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import UseCase10TrainConsistMgmt.Bogie;

public class UseCase10TrainConsistMgmtTest {

    @Test
    void testReduce_TotalSeatCalculation() { [cite: 104]
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70)
        );
        int expectedTotal = 72 + 56 + 24 + 70; // 222
        assertEquals(expectedTotal, UseCase10TrainConsistMgmt.calculateTotalCapacity(bogies),
                "The computed total should equal the sum of all bogie capacities."); [cite: 106]
    }

    @Test
    void testReduce_EmptyBogieList() { [cite: 112]
        List<Bogie> bogies = new ArrayList<>();
        assertEquals(0, UseCase10TrainConsistMgmt.calculateTotalCapacity(bogies),
                "Aggregation on an empty bogie list should return 0."); [cite: 114]
    }

    @Test
    void testReduce_SingleBogieCapacity() { [cite: 109]
        List<Bogie> bogies = List.of(new Bogie("Sleeper", 72));
        assertEquals(72, UseCase10TrainConsistMgmt.calculateTotalCapacity(bogies),
                "Total should match the capacity of a single bogie."); [cite: 111]
    }

    @Test
    void testReduce_OriginalListUnchanged() { [cite: 121]
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        int originalSize = bogies.size();

        UseCase10TrainConsistMgmt.calculateTotalCapacity(bogies);

        assertEquals(originalSize, bogies.size(),
                "The original bogie list should remain unchanged after stream processing."); [cite: 123]
    }
}