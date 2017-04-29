package GeneticAlgorithm;

import GeneticAlgorithm.Expression.Expression;
import GeneticAlgorithm.Expression.InvalidExpressionInsertException;
import GeneticAlgorithm.Expression.Operand;
import GeneticAlgorithm.Expression.Operator;

import java.util.Random;

class ExpressionMutator {
    private ExpressionBuilder builder;
    private Random rand;

    ExpressionMutator(ExpressionBuilder builder) {
        this.builder = builder;
        this.rand = new Random();
    }

    void mutate(Expression exp) throws InvalidExpressionInsertException {
        //Expressions with two operands and a single operator cannot have
        //terms removed.
        if(exp.getSize() == 3) {
            addOperand(exp);
        } else {
            //Randomly add or remove an operand.
            if(rand.nextInt(2) % 2 == 0) {
                addOperand(exp);
            } else {
                removeOperand(exp);
            }
        }
    }

    private void addOperand(Expression exp) throws InvalidExpressionInsertException {
        exp.addTerm(new Operator(builder.getRandomOperator()));
        exp.addTerm(new Operand(builder.getRandomOperand()));
    }

    private void removeOperand(Expression exp) {
        int index = rand.nextInt(exp.getSize() - 1);

        exp.remove(index+1);
        exp.remove(index);
    }
}
