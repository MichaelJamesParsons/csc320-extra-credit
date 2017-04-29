package GeneticAlgorithm;

import GeneticAlgorithm.Expression.Expression;
import GeneticAlgorithm.Expression.InvalidExpressionInsertException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ExpressionBuilderTests {

    private ExpressionBuilder builder;

    @BeforeEach
    void init() {
        GeneticAlgorithm genAlg = new GeneticAlgorithm();
        builder = new ExpressionBuilder(genAlg.getOperators(), genAlg.getOperands());
    }

    @Test
    void expressionContainsVariable() throws InvalidExpressionInsertException {
        Expression exp = builder.generateExpression();
        Assertions.assertTrue(exp.toString().contains("x"), "GeneticAlgorithm.Expression generated without variable.");
    }

    @Test
    void populationSizeCorrectSize() throws InvalidExpressionInsertException {
        ArrayList<Expression> expressions = builder.generatePopulations(500);
        Assertions.assertEquals(500, expressions.size());

        for(Expression exp : expressions) {
            Assertions.assertTrue(exp.toString().contains("x"), "GeneticAlgorithm.Expression generated without variable.");
        }
    }

}