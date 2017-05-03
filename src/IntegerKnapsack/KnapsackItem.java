package IntegerKnapsack;

public class KnapsackItem {

    private int weight;
    private int value;

    public KnapsackItem(int w, int v) {
        this.weight = w;
        this.value = v;
    }

    int getWeight() {
        return weight;
    }
    public int getValue() {
        return value;
    }
}
