package BalancedPartition;

public class PartitionResult {
    private int min;
    private int max;

    public PartitionResult(int val1, int val2) {
        this.min = Math.min(val1, val2);
        this.max = Math.max(val1, val2);
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
