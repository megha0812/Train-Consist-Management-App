import java.util.ArrayList;
import java.util.List;

/**
 * UC12: Safety Compliance Check for Goods Bogies
 * Enforces domain safety rules: Cylindrical bogies must only carry Petroleum. [cite: 6, 90, 110]
 * @author Developer
 * @version 12.0
 */
public class UseCase12TrainConsistMgmt {

    // Goods Bogie model [cite: 43, 47]
    public static class GoodsBogie {
        String type;
        String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() { return type; }
        public String getCargo() { return cargo; }
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC12 Safety Compliance Check for Goods Bogies ");
        System.out.println("==============================================");

        // 1. User prepares a list of goods bogies [cite: 67]
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // Invalid cargo [cite: 102]

        System.out.println("Goods Bogies in Train:");
        goodsBogies.forEach(b -> System.out.println(b.getType() + " -> " + b.getCargo()));

        // 2. System converts list to stream and applies validation [cite: 68, 69]
        boolean isSafe = checkSafetyCompliance(goodsBogies);

        // 5. & 6. Display safety status [cite: 71, 72]
        System.out.println("Safety Compliance Status: " + isSafe);
        if (!isSafe) {
            System.out.println("Train formation is NOT SAFE."); [cite: 104]
        } else {
            System.out.println("Train formation is SAFE.");
        }

        System.out.println("UC12 safety validation completed..."); [cite: 105]
    }

    /**
     * Validates if all bogies satisfy safety constraints using allMatch(). [cite: 80, 88]
     */
    public static boolean checkSafetyCompliance(List<GoodsBogie> bogies) {
        // Short-circuit evaluation: stops as soon as a rule fails [cite: 83]
        return bogies.stream().allMatch(bogie -> {
            // Rule: Cylindrical only Petroleum allowed. [cite: 90, 110]
            if ("Cylindrical".equalsIgnoreCase(bogie.getType())) {
                return "Petroleum".equalsIgnoreCase(bogie.getCargo());
            }
            // Non-cylindrical bogies allow different cargo types [cite: 115, 116]
            return true;
        });
    }
}
