package GeneticAlgorithm;

import GeneticAlgorithm.Expression.Expression;
import GeneticAlgorithm.Expression.IExpressionTerm;
import GeneticAlgorithm.Expression.InvalidExpressionInsertException;

import java.util.Random;

public class OperandCrossover {

    Expression lastExp1;
    Expression lastExp2;

    void crossoverByReference(Expression exp1, Expression exp2) throws InvalidExpressionInsertException {
        int crossOverRange = calculateCrossoverRange(exp1, exp2);
        Random rand = new Random();
        int index = rand.nextInt(crossOverRange);

        Expression exp1Clone = exp1.deepClone();
        Expression exp2Clone = exp2.deepClone();
        swapTerms(exp1Clone, exp2Clone, index);

        this.lastExp1 = exp1Clone;
        this.lastExp2 = exp2Clone;
    }

    private int calculateCrossoverRange(Expression exp1, Expression exp2) {
        return ((exp1.getSize() < exp2.getSize()) ? exp1.getSize() : exp2.getSize()) - 1;
    }

    private void swapTerms(Expression exp1, Expression exp2, int index) {
        IExpressionTerm tmpOp = exp1.set(index, exp2.get(index));
        exp2.set(index, tmpOp);

        index++;
        tmpOp = exp1.set(index, exp2.get(index));
        exp2.set(index, tmpOp);
    }
}
