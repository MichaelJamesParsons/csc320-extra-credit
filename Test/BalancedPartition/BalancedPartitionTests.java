package BalancedPartition;

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
        int result = partition.calculate(numbers);
    }

}
