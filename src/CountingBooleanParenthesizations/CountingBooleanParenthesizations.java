package CountingBooleanParenthesizations;

public class CountingBooleanParenthesizations {

    public int count(char[] symbols, char[] operators) {
        int[][] evalTrue = new int[symbols.length][symbols.length];
        int[][] evalFalse = new int[symbols.length][symbols.length];

        for (int x = 0; x < symbols.length; x++) {
            evalTrue[x][x] = symbols[x] == 'T' ? 1 : 0;
            evalFalse[x][x] = symbols[x] == 'F' ? 1 : 0;
        }

        for (int d = 1; d < symbols.length; d++) {
            for (int i = 0; i < symbols.length - d; i++) {
                int j = i + d;

                for(int x = 0; x < d; x++) {
                    int k = x + i;
                    int totalLeft = evalTrue[i][k] + evalFalse[i][k];
                    int totalRight = evalTrue[k + 1][j] + evalFalse[k + 1][j];

                    if (operators[k] == '&') {
                        evalTrue[i][j] += evalTrue[i][k] * evalTrue[k + 1][j];
                        evalFalse[i][j] += (totalLeft * totalRight - evalTrue[i][k] * evalTrue[k + 1][j]);
                    }
                    if (operators[k] == '|') {
                        evalFalse[i][j] += evalFalse[i][k] * evalFalse[k + 1][j];
                        evalTrue[i][j] += (totalLeft * totalRight - evalFalse[i][k] * evalFalse[k + 1][j]);
                    }
                    if (operators[k] == '^') {
                        evalTrue[i][j] += evalFalse[i][k] * evalTrue[k + 1][j] + evalTrue[i][k] * evalFalse[k + 1][j];
                        evalFalse[i][j] += evalTrue[i][k] * evalTrue[k + 1][j] + evalFalse[i][k] * evalFalse[k + 1][j];
                    }
                }
            }
        }

        return evalTrue[0][symbols.length - 1];
    }
}
