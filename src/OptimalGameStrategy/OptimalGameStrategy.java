package OptimalGameStrategy;

public class OptimalGameStrategy {

    public int calculate(int[] coins) throws Exception {
        if(coins.length % 2 != 0) {
            throw new Exception("Coins must contain an even number of items.");
        }

        int[][] matrix = new int[coins.length][coins.length];

        for(int d = 1; d < coins.length; d++) {
            for(int i = 0; i < coins.length-d; i++) {
                int j = i+d;

                //pick Vi first
                int pick1 = (i+1 < j-1) ? matrix[i+2][j] : 0;
                int pick2 = (i <= j-2) ? matrix[i+1][j-1] : 0;

                //pick Vj first
                int pick3 = (i+1 < j-1) ? matrix[i][j-2] : 0;

                matrix[i][j] = Math.max(Math.min(pick1, pick2) + coins[i], Math.min(pick1, pick3) + coins[j]);
            }
        }

        return matrix[0][coins.length-1];
    }

}
