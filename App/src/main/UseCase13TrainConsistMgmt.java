import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UC13: Performance Comparison (Loops vs Streams)
 * This class compares execution time of loop-based filtering versus stream-based filtering 
 * using System.nanoTime()[cite: 25, 27].
 * * @author Developer
 * @version 13.0
 */
public class UseCase13TrainConsistMgmt {

    // Bogie model [cite: 34, 38]
    public static class Bogie {
        String type;
        int capacity;

        public Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("-------------------------------------------");
        System.out.println("UC13: Performance Comparison (Loops vs Streams)");
        System.out.println("-------------------------------------------");

        // 1. Create large test dataset [cite: 28, 52]
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", (i % 100)));
        }

        // 2. Measure Loop execution time [cite: 28, 57]
        long loopStart = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopFiltered.add(b);
            }
        }
        long loopEnd = System.nanoTime();
        long loopDuration = loopEnd - loopStart; // [cite: 76]

        // 3. Measure Stream execution time [cite: 28, 58]
        long streamStart = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long streamEnd = System.nanoTime();
        long streamDuration = streamEnd - streamStart; // [cite: 76]

        // 4. Display performance results [cite: 28, 61, 84, 85]
        System.out.println("Loop Execution Time (ns): " + loopDuration);
        System.out.println("Stream Execution Time (ns): " + streamDuration);
        System.out.println("UC13 performance benchmarking completed...");
    }
}