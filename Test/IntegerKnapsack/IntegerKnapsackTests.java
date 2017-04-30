package IntegerKnapsack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class IntegerKnapsackTests {

    private IntegerKnapsack knapsack;

    @BeforeEach
    void init() {
        knapsack = new IntegerKnapsack();
    }

    @Test
    void testKnapsack() {
        KnapsackItem[] items = new KnapsackItem[]{
            new KnapsackItem(1,1),
            new KnapsackItem(3,4),
            new KnapsackItem(4,5),
            new KnapsackItem(5,7),
        };

        ArrayList<KnapsackItem> result = knapsack.fill(items, 7);
        Assertions.assertEquals(2, result.size());

        Assertions.assertEquals(result.get(0).getWeight(), 4);
        Assertions.assertEquals(result.get(0).getValue(), 5);

        Assertions.assertEquals(result.get(1).getWeight(), 3);
        Assertions.assertEquals(result.get(1).getValue(), 4);
    }
}
