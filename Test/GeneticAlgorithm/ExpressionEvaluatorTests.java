package GeneticAlgorithm;

import GeneticAlgorithm.Expression.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpressionEvaluatorTests {
    private ExpressionEvaluator evaluator;

    @BeforeEach
    void init() {
        evaluator = new ExpressionEvaluator();
    }

    @Test
    void testInvalidOperator() throws InvalidExpressionInsertException {
        try {
            Expression exp = new Expression();
            exp.addTerm(new Operand(.5f));
            exp.addTerm(new Operator('&'));
            exp.addTerm(new Operand(.5f));

            evaluator.evaluate(exp, 0);
            Assertions.assertTrue(false, "Expected InvalidExpressionOperatorException to be thrown.");
        } catch (InvalidExpressionOperationException e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void testSingleOperand() throws InvalidExpressionInsertException, InvalidExpressionOperationException {
        Expression exp = new Expression();
        exp.addTerm(new Operand(.5f));

        Assertions.assertEquals(.5f, evaluator.evaluate(exp, 0));
    }

    @Test
    void testTwoOperands() throws InvalidExpressionInsertException, InvalidExpressionOperationException {
        Expression exp = new Expression();
        exp.addTerm(new Operand(.5f));
        exp.addTerm(new Operator('*'));
        exp.addTerm(new Operand(.2f));

        Assertions.assertEquals(.1f, evaluator.evaluate(exp, 0));
    }

    @Test
    void testThreeOperands() throws InvalidExpressionInsertException, InvalidExpressionOperationException {
        Expression exp = new Expression();
        exp.addTerm(new Operand(.5f));
        exp.addTerm(new Operator('*'));
        exp.addTerm(new Operand(.2f));
        exp.addTerm(new Operator('+'));
        exp.addTerm(new Operand(.4f));

        Assertions.assertEquals(.5f, evaluator.evaluate(exp, 0));
    }
}
