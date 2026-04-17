import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import UseCase12TrainConsistMgmt.GoodsBogie;

public class UseCase12TrainConsistMgmtTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );
        assertTrue(UseCase12TrainConsistMgmt.checkSafetyCompliance(bogies),
                "Should be safe when Cylindrical bogies carry Petroleum."); [cite: 120, 121]
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(UseCase12TrainConsistMgmt.checkSafetyCompliance(bogies),
                "Should be unsafe when Cylindrical bogies carry Coal."); [cite: 122, 123]
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );
        assertTrue(UseCase12TrainConsistMgmt.checkSafetyCompliance(bogies),
                "Non-cylindrical bogies should allow different cargo."); [cite: 124, 125]
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal"),
                new GoodsBogie("Open", "Grain")
        );
        assertFalse(UseCase12TrainConsistMgmt.checkSafetyCompliance(bogies),
                "One violation should make the entire train unsafe."); [cite: 127, 128]
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> bogies = new ArrayList<>();
        assertTrue(UseCase12TrainConsistMgmt.checkSafetyCompliance(bogies),
                "Empty list should return true as no rules are violated."); [cite: 130, 132]
    }
}
