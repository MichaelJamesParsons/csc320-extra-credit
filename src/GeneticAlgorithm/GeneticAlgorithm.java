package GeneticAlgorithm;

import GeneticAlgorithm.Expression.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * GeneticAlgorithm
 *
 * Implementation of a genetic algorithm which determines the function which generated a given set
 * of outputs. The design of the program is strictly object oriented, which allows for optimizations
 * that reduce iteration, memory usage, and excess processing behind the scenes in the JVM.
 *
 * Use the provided unit tests to verify the algorithm, or include this source code as a module
 * in your project.
 *
 * @author Michael-James Parsons
 */
public class GeneticAlgorithm {

    //Operands allowed to be used in the generation of expressions.
    private float[] operands = new float[]{1f, .9f, .8f, .7f, .6f, .5f, .4f, .3f, .2f, .1f, 0f,
                                            -0.1f, -0.2f, -0.3f, -0.4f, -0.5f, -0.6f, -0.7f, -0.8f, -0.9f};

    //Operations allowed to be used in the generation of expressions.
    private char[] operators = new char[]{'+','-','*','/','^'};

    //Threshold of accuracy that must be met for an expression to be deemed acceptable.
    private float epsilon = .000001f;

    //Generates populations of expressions.
    private ExpressionBuilder expBuilder;

    /**
     * GeneticAlgorithm constructor
     */
    public GeneticAlgorithm() {
        this.expBuilder = new ExpressionBuilder(operators, operands);
    }

    /**
     * GeneticAlgorithm constructor
     *
     * @param operands - List of operands used in calculations.
     */
    public GeneticAlgorithm(float[] operands) {
        this.operands = operands;
        this.expBuilder = new ExpressionBuilder(operators, operands);
    }

    /**
     * Determines the expression used to generated the outputs of a data set.
     *
     * @param dataSet                               - A set of inputs and their corresponding outputs. Used to calculate
     *                                                the expression that created them.
     * @return                                      - The expression used to create the outputs found in the given
     *                                                data set.
     * @throws InvalidExpressionInsertException     - Thrown when a malformed expression is detected.
     * @throws InvalidExpressionOperationException  - Thrown when an unknown operator is detected.
     * @throws AttemptLimitReachedException         - Thrown when too many generations have been processed without a
     *                                                solution presenting itself.
     */
    Expression getExpression(LinkedHashMap<Float, Float> dataSet)
            throws InvalidExpressionInsertException, InvalidExpressionOperationException, AttemptLimitReachedException {
        try {
            int attempts = 0;

            while(true) {
                int generations = 0;
                ArrayList<Expression> population = expBuilder.generatePopulations(100);
                System.out.println("Attempt " + attempts);

                while(generations < 30) {
                    population = mutate(crossOver(compete(population, dataSet)));
                    generations++;
                }

                if(attempts > 5000) {
                    break;
                }

                attempts++;
            }
        } catch (ExpressionFoundException e) {
            return e.getExpression();
        }

        throw new AttemptLimitReachedException();
    }

    /**
     * Competes a list of expressions against each other in groups of two.
     *
     * @param expressions                           - A population of expressions.
     * @param dataSet                               - A set of inputs and their corresponding outputs. Used to calculate
     *                                                the expression that created them.
     * @return                                      - A list of expressions which one the competition against their
     *                                                opponent expression.
     * @throws InvalidExpressionOperationException  - Thrown when a malformed expression is detected.
     * @throws ExpressionFoundException             - Thrown when a solution is found. The matched solution may be
     *                                                accessed from the exception as a property.
     */
    private ArrayList<Expression> compete(ArrayList<Expression> expressions, LinkedHashMap<Float, Float> dataSet)
            throws InvalidExpressionOperationException, ExpressionFoundException {
        ArrayList<Expression> winners = new ArrayList<>();

        for (int x = 0; x < expressions.size() - 1; x += 2) {
            winners.add(determineWinner(expressions.get(x), expressions.get(x+1), dataSet));
        }

        return winners;
    }

    /**
     * Competes two expressions against each other.
     *
     * @param exp1      - An expression to compete.
     * @param exp2      - An expression to compete.
     * @param dataSet   - A set of inputs and their corresponding outputs. Used to calculate the expression
     *                    that created them.
     * @return          - The winning expression.
     * @throws InvalidExpressionOperationException - Thrown when a malformed expression is detected.
     * @throws ExpressionFoundException            - Thrown when a solution is found. The matched solution may be
     *                                               accessed from the exception as a property.
     */
    private Expression determineWinner(Expression exp1, Expression exp2, LinkedHashMap<Float, Float> dataSet)
            throws InvalidExpressionOperationException, ExpressionFoundException {
        float exp1Sum = 0;
        float exp2Sum = 0;

        for(Map.Entry<Float, Float> k : dataSet.entrySet()) {
            exp1Sum += Math.pow(exp1.evaluate(k.getKey()) - k.getValue(), 2);
            exp2Sum += Math.pow(exp2.evaluate(k.getKey()) - k.getValue(), 2);
        }

        float minValue = (exp1Sum < exp2Sum) ? exp1Sum : exp2Sum;
        Expression minExp = (exp1Sum < exp2Sum) ? exp1 : exp2;

        if(minValue < epsilon) {
            throw new ExpressionFoundException(minExp);
        }

        return minExp;
    }

    /**
     * Performs a crossover operation in groups of two.
     *
     * @param expressions                       - A population of expressions.
     * @return                                  - A population of expressions, including the new expressions generated
     *                                            by the crossover.
     * @throws InvalidExpressionInsertException - Thrown when a malformed expression is detected.
     */
    private ArrayList<Expression> crossOver(ArrayList<Expression> expressions) throws InvalidExpressionInsertException {
        OperandCrossover cross = new OperandCrossover();
        int numExpressions = expressions.size() - 1;

        for(int x = 0; x < numExpressions; x += 2) {
            cross.crossoverByReference(expressions.get(x),expressions.get(x+1));
            expressions.add(cross.lastExp1);
            expressions.add(cross.lastExp2);
        }

        return expressions;
    }

    /**
     * Mutate 5% of the population.
     *
     * @param expressions - A population of expressions.
     * @return A list of expressions includeding both the original and mutated sets.
     * @throws InvalidExpressionInsertException - Thrown when a malformed expression is detected.
     */
    private ArrayList<Expression> mutate(ArrayList<Expression> expressions) throws InvalidExpressionInsertException {

        int index;
        int numMutations = 0;
        Random rand = new Random();
        ExpressionMutator mutator = new ExpressionMutator(expBuilder);

        while(numMutations < (expressions.size() * .05)) {
            index = rand.nextInt(expressions.size() - 1);
            mutator.mutate(expressions.get(index));
            numMutations++;
        }

        return expressions;
    }

    /**
     * Get operators
     *
     * @return List of operators used in calculations.
     */
    char[] getOperators() {
        return this.operators;
    }

    /**
     * Get operands
     *
     * @return List of operands used in calculations.
     */
    float[] getOperands() {
        return this.operands;
    }

    /**
     * Get epsilon
     *
     * @return - Threshold value used to determine the accuracy of a potential solution.
     */
    float getEpsilon() { return this.epsilon; }
}