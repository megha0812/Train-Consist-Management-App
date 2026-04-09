import java.util.HashSet;
import java.util.Set;

/**
 * UC3: Track Unique Bogie IDs
 * This class ensures that duplicate bogie IDs are not added
 * into the train formation using HashSet. [cite: 17, 20]
 */
public class UseCase3TrackUniqueBogieIDs {

    private Set<String> bogies;

    public UseCase3TrackUniqueBogieIDs() {
        // HashSet is used to store only unique values [cite: 34, 53]
        this.bogies = new HashSet<>();
    }

    /**
     * Adds a bogie ID to the set. Duplicates are automatically
     * ignored by the HashSet implementation. [cite: 43, 57]
     * @param bogieId The ID to add
     * @return true if the ID was added, false if it was a duplicate
     */
    public boolean addBogie(String bogieId) {
        return bogies.add(bogieId);
    }

    public Set<String> getBogies() {
        return new HashSet<>(bogies);
    }

    public void displayBogies() {
        System.out.println("UC3 Track Unique Bogie IDs"); [cite: 32, 70]
        System.out.println("Bogie IDs After Insertion:"); [cite: 71]
        System.out.println(bogies); [cite: 71]
        System.out.println("UC3 uniqueness validation completed..."); [cite: 74]
    }

    public static void main(String[] args) {
        UseCase3TrackUniqueBogieIDs app = new UseCase3TrackUniqueBogieIDs();

        // Adding IDs including duplicates [cite: 37]
        app.addBogie("B6101"); [cite: 39]
        app.addBogie("B6102"); [cite: 40]
        app.addBogie("B6103"); [cite: 41]
        app.addBogie("B6104"); [cite: 42]

        // Duplicate entries will be ignored internally [cite: 43]
        app.addBogie("B6101"); // Duplicate entry [cite: 44]
        app.addBogie("B6102"); // Duplicate entry [cite: 45]

        app.displayBogies();
    }
}