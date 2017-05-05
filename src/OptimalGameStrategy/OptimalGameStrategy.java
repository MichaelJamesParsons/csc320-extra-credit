package OptimalGameStrategy;

public class OptimalGameStrategy {

    public ScoreSet calculate(int[] coins) throws Exception {
        if(coins.length % 2 != 0) {
            throw new Exception("Coins must contain an even number of items.");
        }

        ScoreSet[][] matrix = new ScoreSet[coins.length][coins.length];

        for(int x = 0; x < coins.length; x++) {
            matrix[x][x] = new ScoreSet(coins[x], 0);
        }

        for(int d = 1; d < coins.length; d++) {
            for(int i = 0; i < coins.length-d; i++) {
                int j = i+d;

                //int pick3 = Math.min(matrix[i+1][j-1], matrix[i+2][j]);

                int pick1 = matrix[i+1][j].getFirstMove() + matrix[i][j-1].getSecondMove();
                int pick2 = matrix[i][j-1].getFirstMove() + matrix[i+1][j].getSecondMove();
                ScoreSet score;

                if(pick1 > pick2) {
                    score = new ScoreSet(matrix[i+1][j].getFirstMove(), matrix[i][j-1].getFirstMove());
                } else {
                    score = new ScoreSet(matrix[i][j-1].getFirstMove(), matrix[i+1][j].getFirstMove());
                }

                matrix[i][j] = score;
            }
        }

        return matrix[0][coins.length-1];
    }

}
