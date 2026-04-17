import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for UC15 using JUnit 5 [cite: 120-129]
 */
class UseCase15TrainConsistMgmtTest {

    @Test
    void testCargo_SafeAssignment() {
        // Verifies that safe cargo assignments are processed successfully [cite: 108]
        UseCase15TrainConsistMgmt.GoodsBogie bogie = new UseCase15TrainConsistMgmt.GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.cargo, "Cargo should be assigned to cylindrical bogie"); [cite: 109]
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        // Verifies that assigning petroleum to a rectangular bogie triggers safety validation [cite: 111]
        UseCase15TrainConsistMgmt.GoodsBogie bogie = new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");

        // No exception should escape the method because it is handled internally via catch [cite: 66, 101]
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        // Verifies that cargo is not assigned when an unsafe combination occurs [cite: 112]
        UseCase15TrainConsistMgmt.GoodsBogie bogie = new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        assertNull(bogie.cargo, "Rectangular bogie should not store Petroleum cargo after failure"); [cite: 113]
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        // Verifies that multiple cargo assignments proceed without terminating the program [cite: 115]
        UseCase15TrainConsistMgmt.GoodsBogie bogie1 = new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");
        UseCase15TrainConsistMgmt.GoodsBogie bogie2 = new UseCase15TrainConsistMgmt.GoodsBogie("Cylindrical");

        bogie1.assignCargo("Petroleum"); // Fails but caught
        bogie2.assignCargo("Coal");      // Should still execute [cite: 103, 114]

        assertEquals("Coal", bogie2.cargo);
    }
}