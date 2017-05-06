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

    @Test
    void testProblemSet1() {
        int[][] matrix = new int[4][4];

        for(int x = 0; x < 4; x++) {
            matrix[x][x] = 0;
        }

        matrix[0][1] = 1;
        matrix[0][2] = 15;
        matrix[0][3] = 6;

        matrix[1][0] = 2;
        matrix[1][2] = 6;
        matrix[1][3] = 3;

        matrix[2][0] = 9;
        matrix[2][1] = 6;
        matrix[2][3] = 12;

        matrix[3][0] = 10;
        matrix[3][1] = 4;
        matrix[3][2] = 8;

        salesman.calculateRoute(matrix);
    }

    @Test
    void testProblemSet2() {
        int[][] matrix = new int[4][4];

        for(int x = 0; x < 4; x++) {
            matrix[x][x] = 0;
        }

        matrix[0][1] = 2;
        matrix[0][2] = 9;
        matrix[0][3] = 99;

        matrix[1][0] = 1;
        matrix[1][2] = 6;
        matrix[1][3] = 4;

        matrix[2][0] = 99;
        matrix[2][1] = 7;
        matrix[2][3] = 8;

        matrix[3][0] = 6;
        matrix[3][1] = 3;
        matrix[3][2] = 99;

        salesman.calculateRoute(matrix);
    }

}
