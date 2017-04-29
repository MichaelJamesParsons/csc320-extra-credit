package BuildingBridges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for building bridges algorithm.
 */
class BuildingBridgesTests {

    private BuildingBridges builder;

    @BeforeEach
    void init() {
        builder = new BuildingBridges();
    }

    @Test
    void testMismatchedListSize() {
        try {
            int[] topBridges = {};
            int[] bottomBridges = {0};

            builder.build(topBridges, bottomBridges);
            Assertions.assertTrue(false);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void testSingleBridgeList() throws Exception {
        int[] topBridges = {0};
        int[] bottomBridges = {0};

        int[] expected = {0};
        int[] result = builder.build(topBridges, bottomBridges);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testOrderedBridges() throws Exception {
        int[] topBridges = {0,1,2,3,4,5,6,7,8,9};
        int[] bottomBridges = {0,1,2,3,4,5,6,7,8,9};

        int[] expected = {0,1,2,3,4,5,6,7,8,9};
        int[] result = builder.build(topBridges, bottomBridges);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testReversedBridges() throws Exception {
        int[] topBridges = {9,8,7,6,5,4,3,2,1,0};
        int[] bottomBridges = {0,1,2,3,4,5,6,7,8,9};

        int[] expected = {0};
        int[] result = builder.build(topBridges, bottomBridges);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testDoubleResults() throws Exception {
        int[] topBridges = {1,4,0,3,2};
        int[] bottomBridges = {0,1,2,3,4};

        int[] expected = {0,2};
        int[] result = builder.build(topBridges, bottomBridges);
        Assertions.assertArrayEquals(expected, result);
    }

}
