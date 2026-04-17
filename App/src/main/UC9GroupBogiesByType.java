import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UseCase9GroupBogiesByType {

    public static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Capacity -> " + capacity;
        }
    }

    public Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        // [cite: 67, 82, 92] Using Collectors.groupingBy to classify bogies by name
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC9 - Group Bogies by Type ");
        System.out.println("==========================================\n");

        // [cite: 47-60] Initializing the bogie list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        System.out.println("All Bogies:");
        bogies.forEach(b -> System.out.println(b.getName() + " -> " + b.capacity));

        UseCase9GroupBogiesByType app = new UseCase9GroupBogiesByType();
        // [cite: 65, 93] Grouping and storing in a Map
        Map<String, List<Bogie>> groupedBogies = app.groupBogiesByType(bogies);

        System.out.println("\nGrouped Bogies:");
        // [cite: 70-73, 107-116] Displaying the structured output
        groupedBogies.forEach((type, list) -> {
            System.out.println("\nBogie Type: " + type);
            list.forEach(System.out::println);
        });

        System.out.println("\nUC9 grouping completed...");
    }
}