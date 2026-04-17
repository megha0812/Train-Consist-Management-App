import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase11TrainConsistMgmntTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(UseCase11TrainConsistMgmnt.validateTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("TRAIN12"));
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("TRN12A"));
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(UseCase11TrainConsistMgmnt.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("PET-ab"));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("PET123"));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("TRN-123"));
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("PET-aB"));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("PET-12"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId(""));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        // Test for trailing characters
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("TRN-1234 "));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("PET-AB-EXTRA"));
    }
}