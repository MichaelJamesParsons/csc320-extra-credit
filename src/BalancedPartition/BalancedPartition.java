package BalancedPartition;

public class BalancedPartition {

    /**
     * O(kn^2)
     *
     * P(i,j) = (1 if some subset of {A1...Aj} has a sum of j.
     *          or
     *          (0 default)
     *
     * @param numbers - An unordered list of integers.
     */
    public int calculate(int[] numbers) {
        int[][] matrix = new int[numbers.length][numbers.length];
        int sum = 0;
        int s;

        for(int x = 0; x < numbers.length; x++) {
            sum += numbers[x];
        }

        s = sum / 2;

        for(int i = 1; i < matrix.length; i++) {
            matrix[i][0] = 1;
            for(int j = 1; j < matrix.length; j++) {
                matrix[i][j] = (matrix[i-1][j] == 1 || matrix[i-1][j - numbers[i]] == 1) ? 1 : 0;
            }
        }

        return matrix[numbers.length - 1][numbers.length - 1];
    }

}
