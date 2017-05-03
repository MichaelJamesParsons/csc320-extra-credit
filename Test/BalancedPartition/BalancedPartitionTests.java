package BalancedPartition;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BalancedPartitionTests {

    private BalancedPartition partition;

    @BeforeEach
    void init() {
        partition = new BalancedPartition();
    }

    @Test
    void testProblemSet1() {
        int[] numbers = {5,1,2,1};
        PartitionResult result = partition.calculate(numbers);
        Assertions.assertEquals(result.getMin(), 7);
        Assertions.assertEquals(result.getMax(), 8);
    }

    @Test
    void testProblemSet2() {
        int[] numbers = {1,2,5,7};
        PartitionResult result = partition.calculate(numbers);
        Assertions.assertEquals(result.getMin(), 7);
        Assertions.assertEquals(result.getMax(), 8);
    }

}
