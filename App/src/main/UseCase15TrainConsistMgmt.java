/**
 * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 * This class safely assigns cargo to goods bogies while handling unsafe 
 * combinations using structured exception handling blocks. [cite: 28, 30, 31]
 */
public class UseCase15TrainConsistMgmt {

    // CUSTOM RUNTIME EXCEPTION [cite: 40, 48, 49]
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie model [cite: 42, 52]
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape; [cite: 56]
        }

        /**
         * Assigns cargo with safety validation using try-catch-finally [cite: 57, 58]
         */
        void assignCargo(String cargo) {
            try {
                // Rule: Rectangular bogie cannot carry petroleum [cite: 61, 79]
                if (this.shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!"); [cite: 65, 73]
                }
                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo); [cite: 90]
            } catch (CargoSafetyException e) {
                // Catch and handle the exception [cite: 66, 80]
                System.out.println("Error: " + e.getMessage()); [cite: 92]
            } finally {
                // Execute mandatory logging regardless of outcome [cite: 68, 75, 81]
                System.out.println("Cargo validation completed for " + this.shape + " bogie"); [cite: 91, 93]
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("=========================================\n");

        // Scenario 1: Safe Assignment [cite: 109]
        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        cylindrical.assignCargo("Petroleum");

        System.out.println(); // Formatting

        // Scenario 2: Unsafe Assignment [cite: 111]
        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        rectangular.assignCargo("Petroleum");

        System.out.println("\nUC15 runtime handling completed.."); [cite: 94]
    }
}