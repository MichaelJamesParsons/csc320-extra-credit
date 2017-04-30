package IntegerKnapsack;

import java.util.ArrayList;

class IntegerKnapsack {

    ArrayList<KnapsackItem> fill(KnapsackItem[] items, int capacity) {
        int[][] matrix = new int[items.length][capacity + 1];

        for(int i = 0; i < items.length; i++) {
            for(int j = 1; j < capacity + 1; j++) {
                if(i == 0) {
                    matrix[i][j] = (items[i].getWeight() <= j) ? items[i].getValue() : 0;
                } else if(items[i].getWeight() > j) {
                    matrix[i][j] = ((i-1) >= 0) ? matrix[i-1][j] : 0;
                } else {
                    matrix[i][j] = Math.max(
                        matrix[i-1][j],
                        items[i].getValue() + matrix[i-1][j - items[i].getWeight()]
                    );
                }
            }
        }

        return getItemsFromResult(matrix, items);
    }

    private ArrayList<KnapsackItem> getItemsFromResult(int[][] matrix, KnapsackItem[] items) {
        int capacity = matrix[0].length - 1;
        ArrayList<KnapsackItem> knapsack = new ArrayList<KnapsackItem>();

        int i = items.length - 1;
        int j = capacity;
        while(i > 0) {
            if(matrix[i][j] != matrix[i-1][j]) {
                knapsack.add(items[i]);
            } else {
                knapsack.add(items[i-1]);
                i--;
            }

            j = capacity - items[i].getWeight();
            i--;
        }

        return knapsack;
    }

}
