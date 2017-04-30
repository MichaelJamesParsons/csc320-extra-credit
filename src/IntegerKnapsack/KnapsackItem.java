package IntegerKnapsack;

public class KnapsackItem {

    private int value;
    private int weight;

    public KnapsackItem(int v, int w) {
        this.value = v;
        this.weight = w;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
