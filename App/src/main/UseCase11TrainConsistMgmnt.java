import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Use Case 11: Validate Train ID and Cargo Code
 * * This class validates input formats using Regular Expressions.
 * It ensures that Train IDs and Cargo Codes follow strict business rules.
 */
public class UseCase11TrainConsistMgmnt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("==========================================");

        // Accept Input
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // Validate Inputs
        boolean isTrainIdValid = validateTrainId(trainId);
        boolean isCargoCodeValid = validateCargoCode(cargoCode);

        // Display Results
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainIdValid);
        System.out.println("Cargo Code Valid: " + isCargoCodeValid);

        System.out.println("\nUC11 validation completed...");
        scanner.close();
    }

    /**
     * Validates Train ID: Fixed "TRN-" followed by exactly 4 digits.
     */
    public static boolean validateTrainId(String trainId) {
        if (trainId == null) return false;
        String regex = "^TRN-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    /**
     * Validates Cargo Code: Fixed "PET-" followed by exactly 2 uppercase letters.
     */
    public static boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        String regex = "^PET-[A-Z]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }
}