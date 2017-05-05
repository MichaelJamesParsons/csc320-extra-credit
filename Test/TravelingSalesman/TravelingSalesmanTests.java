package TravelingSalesman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TravelingSalesmanTests {
    private TravelingSalesman salesman;

    @BeforeEach
    void init() {
        salesman = new TravelingSalesman();
    }

    @Test
    void testPowerSetGeneration() {
        salesman.getPowerSet(4);
    }

}
