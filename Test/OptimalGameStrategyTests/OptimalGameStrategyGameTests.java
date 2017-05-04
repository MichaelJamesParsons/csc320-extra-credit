package OptimalGameStrategyTests;

import OptimalGameStrategy.OptimalGameStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OptimalGameStrategyGameTests {
    private OptimalGameStrategy strategy;

    @BeforeEach
    void init() {
        strategy = new OptimalGameStrategy();
    }

    @Test
    void testProblemSet1() throws Exception {
        int[] coins = {3,9,1,2};
        strategy.calculate(coins);
    }

}
