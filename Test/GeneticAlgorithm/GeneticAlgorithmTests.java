package GeneticAlgorithm;

import GeneticAlgorithm.Expression.Expression;
import GeneticAlgorithm.Expression.ExpressionEvaluator;
import GeneticAlgorithm.Expression.InvalidExpressionInsertException;
import GeneticAlgorithm.Expression.InvalidExpressionOperationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

class GeneticAlgorithmTests {

    @Test
    void simpleAddition() {
        float[] operands = {1,2,3,4,5,6,7,8,9};
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(operands);
        LinkedHashMap<Float, Float> dataSet = new LinkedHashMap<>();
        dataSet.put(2f, 7f);
        dataSet.put(3f, 8f);
        dataSet.put(6f, 11f);
        dataSet.put(21f, 26f);

        testEvaluation(dataSet, geneticAlgorithm);
    }

    @Test
    void simpleSubtraction() throws InvalidExpressionOperationException, InvalidExpressionInsertException, AttemptLimitReachedException {
        float[] operands = {1,2,3,4,5,6,7,8,9};
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(operands);
        LinkedHashMap<Float, Float> dataSet = new LinkedHashMap<>();
        dataSet.put(35f, 17f);
        dataSet.put(105f, 87f);
        dataSet.put(289f, 271f);
        dataSet.put(13f, -5f);

        testEvaluation(dataSet, geneticAlgorithm);
    }

    @Test
    void simpleMultiplication() throws InvalidExpressionOperationException, InvalidExpressionInsertException, AttemptLimitReachedException {
        float[] operands = {1,2,3,4,5,6,7,8,9};
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(operands);
        LinkedHashMap<Float, Float> dataSet = new LinkedHashMap<>();
        dataSet.put(0f, 0f);
        dataSet.put(1f, 1f);
        dataSet.put(2f, 4f);
        dataSet.put(3f, 9f);

        testEvaluation(dataSet, geneticAlgorithm);
    }

    @Test
    void simpleDivision() throws InvalidExpressionOperationException, InvalidExpressionInsertException, AttemptLimitReachedException {
        float[] operands = {1,2,3,4,5,6,7,8,9};
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(operands);
        LinkedHashMap<Float, Float> dataSet = new LinkedHashMap<>();
        dataSet.put(15f, 3f);
        dataSet.put(45f, 9f);
        dataSet.put(120f, 24f);
        dataSet.put(300f, 60f);

        testEvaluation(dataSet, geneticAlgorithm);
    }

    private void testEvaluation(LinkedHashMap<Float, Float> dataSet, GeneticAlgorithm geneticAlgorithm) {
        try {
            Expression exp = geneticAlgorithm.getExpression(dataSet);
            ExpressionEvaluator evaluator = new ExpressionEvaluator();

            for (Map.Entry<Float, Float> entry : dataSet.entrySet()) {
                Assertions.assertEquals(entry.getValue(), (Float)evaluator.evaluate(exp, entry.getKey()));
            }
        } catch (InvalidExpressionOperationException | InvalidExpressionInsertException e) {
            Assertions.assertTrue(false, "Invalid operand or operation detected.");
            e.printStackTrace();
        } catch (AttemptLimitReachedException e) {
            Assertions.assertTrue(false, "Unable to calculate expression. Attempted 1000 times.");
            e.printStackTrace();
        }
    }
}
