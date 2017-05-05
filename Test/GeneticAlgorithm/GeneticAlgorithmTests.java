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

    @Test
    void simplePower() throws InvalidExpressionOperationException, InvalidExpressionInsertException, AttemptLimitReachedException {
        float[] operands = {1,2,3,4,5,6,7,8,9};
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(operands);
        LinkedHashMap<Float, Float> dataSet = new LinkedHashMap<>();
        dataSet.put(1f,1f);
        dataSet.put(2f, 16f);
        dataSet.put(3f, 81f);
        dataSet.put(4f, 256f);

        testEvaluation(dataSet, geneticAlgorithm);
    }

    /**
     * Example from book (page 461)
     *
     * @throws InvalidExpressionOperationException
     * @throws InvalidExpressionInsertException
     * @throws AttemptLimitReachedException
     */
    @Test
    void quadratic() throws InvalidExpressionOperationException, InvalidExpressionInsertException, AttemptLimitReachedException {
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        LinkedHashMap<Float, Float> dataSet = new LinkedHashMap<>();
        dataSet.put(0f,0f);
        dataSet.put(.1f, .005f);
        dataSet.put(.2f, .020f);
        dataSet.put(.3f, .045f);
        dataSet.put(.4f, .080f);
        dataSet.put(.5f, .125f);
        dataSet.put(.6f, .180f);
        dataSet.put(.7f, .245f);
        dataSet.put(.8f, .320f);
        dataSet.put(.9f, .405f);

        testEvaluation(dataSet, geneticAlgorithm);
    }

    /**
     * Tests for y= f(x) = x^2
     *
     * @throws InvalidExpressionOperationException
     * @throws InvalidExpressionInsertException
     * @throws AttemptLimitReachedException
     */
    @Test
    void homeworkSet1() throws InvalidExpressionOperationException, InvalidExpressionInsertException, AttemptLimitReachedException {
        float[] operands = new float[]{0, 1,2,3,4,5,6,7,8,9};

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(operands);
        LinkedHashMap<Float, Float> dataSet = new LinkedHashMap<>();
        dataSet.put(1f, 1f);
        dataSet.put(2f, 4f);
        dataSet.put(3f, 9f);
        dataSet.put(4f, 16f);
        dataSet.put(5f, 25f);
        dataSet.put(6f, 36f);
        dataSet.put(7f, 49f);
        dataSet.put(8f, 64f);
        dataSet.put(9f, 81f);

        testEvaluation(dataSet, geneticAlgorithm);
    }

    /**
     * Tests for y= f(x) = (x^2/12)+1
     *
     * @throws InvalidExpressionOperationException
     * @throws InvalidExpressionInsertException
     * @throws AttemptLimitReachedException
     */
    @Test
    void homeworkSet2() throws InvalidExpressionOperationException, InvalidExpressionInsertException, AttemptLimitReachedException {
        float[] operands = new float[]{0, 1,2,3,4,5,6,7,8,9};

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(operands);
        LinkedHashMap<Float, Float> dataSet = new LinkedHashMap<>();
        dataSet.put(1f, 13/12f);
        dataSet.put(2f, 5/3f);
        dataSet.put(3f, 13/4f);
        dataSet.put(4f, 19/3f);
        dataSet.put(5f, 137/12f);
        dataSet.put(6f, 19f);
        dataSet.put(7f, 355/12f);
        dataSet.put(8f, 131/3f);
        dataSet.put(9f, 247/4f);

        testEvaluation(dataSet, geneticAlgorithm);
    }

    /**
     * Test the generated expression against the given data set.
     *
     * Warning: Rarely, a
     *
     * @param dataSet           - Inputs and outputs of unknown function.
     * @param geneticAlgorithm  - A genetic algorithm containing operator and operand sets which are optimized to solve
     *                            for the given inputs and outputs.
     */
    private void testEvaluation(LinkedHashMap<Float, Float> dataSet, GeneticAlgorithm geneticAlgorithm) {
        try {
            Expression exp = geneticAlgorithm.getExpression(dataSet);
            ExpressionEvaluator evaluator = new ExpressionEvaluator();

            for (Map.Entry<Float, Float> entry : dataSet.entrySet()) {
                float evaluation = evaluator.evaluate(exp, entry.getKey());

                try {
                    Assertions.assertEquals(entry.getValue(), evaluation, geneticAlgorithm.getEpsilon());
                } catch (org.opentest4j.AssertionFailedError e) {
                    //Prevent float rounding errors from failing tests. Compare diff of expression and expected result
                    //with the algorithm's epsilon value to determine if the value is acceptable.
                    float diff = Math.max(entry.getValue() - evaluation, evaluation - entry.getValue());
                    if(diff >= geneticAlgorithm.getEpsilon()) {
                        throw e;
                    }
                }
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
