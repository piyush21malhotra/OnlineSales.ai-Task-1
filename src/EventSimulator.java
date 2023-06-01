import java.util.Map;
import java.util.Random;

public class EventSimulator {
    private Map<Object, Integer> outcomes;
    private int totalWeight;
    private Random random;

    public EventSimulator(Map<Object, Integer> outcomes) {
        this.outcomes = outcomes;
        this.random = new Random();
        calculateTotalWeight();
    }

    private void calculateTotalWeight() {
        totalWeight = 0;
        for (int weight : outcomes.values()) {
            totalWeight += weight;
        }
    }

    public Object generateOutcome() {
        int randomNumber = random.nextInt(totalWeight);
        int sum = 0;

        for (Map.Entry<Object, Integer> entry : outcomes.entrySet()) {
            sum += entry.getValue();
            if (randomNumber < sum) {
                return entry.getKey();
            }
        }

        // This should never happen if the probabilities are correctly provided
        throw new IllegalStateException("Unable to generate an outcome");
    }
}