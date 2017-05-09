package OptimalGameStrategyTests;

import OptimalGameStrategy.OptimalGameStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OptimalGameStrategyGameTests {
    private OptimalGameStrategy strategy;

    @BeforeEach
    void init() {
        strategy = new OptimalGameStrategy();
    }

    /**
     * Example from instructional video.
     * @link https://www.youtube.com/watch?v=WxpIHvsu1RI
     * @throws Exception
     */
    @Test
    void testProblemSet1() throws Exception {
        int[] coins = {3,9,1,2};
        Assertions.assertEquals(strategy.calculate(coins), 5);
    }

}
