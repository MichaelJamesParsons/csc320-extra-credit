package BalancedPartition;

import IntegerKnapsack.*;

import java.util.ArrayList;

public class BalancedPartition {

    /**
     * O(kn^2)
     *
     * P(i,j) = (1 if some subset of {A1...Aj} has a sum of j.
     *          or
     *          (0 default)
     *
     * @param numbers - An unordered list of integers.
     */
    public PartitionResult calculate(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        KnapsackItem[] items = new KnapsackItem[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            items[i] = new KnapsackItem(numbers[i], numbers[i]);
        }

        IntegerKnapsack knapsack = new IntegerKnapsack();
        ArrayList<KnapsackItem> result = knapsack.fill(items, sum/2);

        int total = getTotalFromKnapsackResult(result);
        return new PartitionResult(total, sum - total);
    }

    private int getTotalFromKnapsackResult(ArrayList<KnapsackItem> items) {
        int total = 0;
        for (KnapsackItem i : items) {
            total += i.getValue();
        }

        return total;
    }

}
