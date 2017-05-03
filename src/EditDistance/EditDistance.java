package EditDistance;

public class EditDistance {
    /**
     * Calculates the cost of transforming string "a" into string "b".
     *
     * @param a             - A string of characters to be compared.
     * @param b             - A string of characters to be compared.
     * @param insertCost    - The cost of inserting a character.
     * @param deleteCost    - The cost of deleting a character.
     * @param replaceCost   - The cost of replacing a character.
     */
    public int calculate(String a, String b, int insertCost, int deleteCost, int replaceCost) {
        int aSetLen = a.length() + 1;
        int bSetLen = b.length() + 1;
        int[][] matrix = new int[aSetLen][bSetLen];

        for(int x = 1; x < aSetLen; x++) {
            matrix[x][0] = x;
        }

        for(int y = 1; y < bSetLen; y++) {
            matrix[0][y] = y;
        }

        for(int i = 1; i < aSetLen; i++) {
            for(int j = 1; j < bSetLen; j++) {
                //Minimum of delete cost and insert cost
                int min = Math.min(matrix[i-1][j] + deleteCost, matrix[i][j-1] + insertCost);

                //Minimum of delete/insert and replace
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    matrix[i][j] = Math.min(min, matrix[i-1][j-1]);
                } else {
                    matrix[i][j] = Math.min(min, matrix[i-1][j-1] + replaceCost);
                }
            }
        }

        return matrix[a.length()][b.length()];
    }
}
