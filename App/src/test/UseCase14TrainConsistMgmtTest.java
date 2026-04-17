import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import UseCase14TrainConsistMgmt.PassengerBogie;
import UseCase14TrainConsistMgmt.InvalidCapacityException;

public class UseCase14TrainConsistMgmtTest {

    @Test
    void testException_ValidCapacityCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 72);
        assertNotNull(bogie);
        assertEquals(72, bogie.getCapacity());
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        InvalidCapacityException exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("First Class", -10);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("AC Chair", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        try {
            new PassengerBogie("Sleeper", -5);
        } catch (InvalidCapacityException e) {
            assertEquals("Capacity must be greater than zero", e.getMessage());
        }
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("First Class", 24);
        assertEquals("First Class", bogie.getType());
        assertEquals(24, bogie.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
        PassengerBogie b2 = new PassengerBogie("AC Chair", 40);
        assertNotNull(b1);
        assertNotNull(b2);
    }
}