package GeneticAlgorithm;

import GeneticAlgorithm.Expression.Expression;
import GeneticAlgorithm.Expression.IExpressionTerm;

import java.util.Random;

public class OperandCrossover {

    public static void crossoverByReference(Expression exp1, Expression exp2) {
        int crossOverRange = calculateCrossoverRange(exp1, exp2);
        Random rand = new Random();
        int index = rand.nextInt(crossOverRange);
        swapTerms(exp1, exp2, index);
    }

    private static int calculateCrossoverRange(Expression exp1, Expression exp2) {
        return ((exp1.getSize() < exp2.getSize()) ? exp1.getSize() : exp2.getSize()) - 1;
    }

    private static void swapTerms(Expression exp1, Expression exp2, int index) {
        IExpressionTerm tmpOp = exp1.set(index, exp2.get(index));
        exp2.set(index, tmpOp);

        index++;
        tmpOp = exp1.set(index, exp2.get(index));
        exp2.set(index, tmpOp);
    }
}
