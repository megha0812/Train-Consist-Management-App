import java.util.ArrayList;
import java.util.List;

/**
 * UC14: Handle Invalid Bogie Capacity (Custom Exception)
 * This class prevents creation of passenger bogies with invalid seating capacity.
 * Maps fail-fast validation using checked exceptions.
 */
public class UseCase14TrainConsistMgmt {

    // Custom Exception for Railway Domain
    public static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie model with validation
    public static class PassengerBogie {
        private String type;
        private int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            // Fail-fast validation
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() { return type; }
        public int getCapacity() { return capacity; }

        @Override
        public String toString() {
            return "Created Bogie: " + type + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("UC14 Handle Invalid Bogie Capacity");

        try {
            // Valid Case
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            System.out.println(sleeper);

            // Invalid Case (will throw exception)
            PassengerBogie invalidBogie = new PassengerBogie("AC Chair", 0);
            System.out.println(invalidBogie);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("UC14 exception handling completed....");
    }
}
