package GeneticAlgorithm;

import GeneticAlgorithm.Expression.Expression;
import GeneticAlgorithm.Expression.InvalidExpressionInsertException;
import GeneticAlgorithm.Expression.Operand;
import GeneticAlgorithm.Expression.Operator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperandCrossoverTests {
    private OperandCrossover cross;

    @BeforeEach
    void init() {
        cross = new OperandCrossover();
    }

    @Test
    void swapSingleTermTest() throws InvalidExpressionInsertException {
        Expression exp1 = new Expression();
        exp1.addTerm(new Operand(.3f));
        exp1.addTerm(new Operator('*'));
        exp1.addTerm(new Operand(.5f));

        Expression exp2 = new Expression();
        exp2.addTerm(new Operand(.2f));
        exp2.addTerm(new Operator('+'));
        exp2.addTerm(new Operand(.4f));

        cross.crossoverByReference(exp1, exp2);

        Assertions.assertTrue(exp1.toString().contains("+"));
        Assertions.assertTrue(exp2.toString().contains("*"));
    }

    @Test
    void swapDoubleTermsTest() throws InvalidExpressionInsertException {
        Expression exp1 = new Expression();
        exp1.addTerm(new Operand(.1f));
        exp1.addTerm(new Operator('+'));
        exp1.addTerm(new Operand(.3f));
        exp1.addTerm(new Operator('-'));
        exp1.addTerm(new Operand(.5f));

        Expression exp2 = new Expression();
        exp2.addTerm(new Operand(.2f));
        exp2.addTerm(new Operator('*'));
        exp2.addTerm(new Operand(.4f));
        exp2.addTerm(new Operator('/'));
        exp2.addTerm(new Operand(.4f));

        cross.crossoverByReference(exp1, exp2);

        boolean exp1Test = exp1.toString().contains("*") || exp1.toString().contains("/");
        boolean exp2Test = exp1.toString().contains("+") || exp1.toString().contains("-");
        Assertions.assertTrue(exp1Test);
        Assertions.assertTrue(exp2Test);
    }
}
