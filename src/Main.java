import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Example: Flipping a biased coin
        Map<Object, Integer> outcomes = new HashMap<>();
        outcomes.put(1, 3);
        outcomes.put(2, 30);
        outcomes.put(3, 15);
        outcomes.put(4, 15);
        outcomes.put(5, 30);
        outcomes.put(6, 0);

        EventSimulator eventSimulator = new EventSimulator(outcomes);
        int numOccurrences = 1000;

        // Count occurrences of each outcome
        Map<Object, Integer> occurrenceCounts = new HashMap<>();
        for (int i = 0; i < numOccurrences; i++) {
            Object outcome = eventSimulator.generateOutcome();
            occurrenceCounts.put(outcome, occurrenceCounts.getOrDefault(outcome, 0) + 1);
        }

        // Print occurrence counts
        for (Map.Entry<Object, Integer> entry : occurrenceCounts.entrySet()) {
            Object outcome = entry.getKey();
            int count = entry.getValue();
            System.out.println(outcome + " appeared " + count + " times.");
        }
    }
}
