package GeneticAlgorithm;

import GeneticAlgorithm.Expression.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class GeneticAlgorithm {

    private float[] operands = new float[]{1f, .9f, .8f, .7f, .6f, .5f, .4f, .3f, .2f, .1f, 0f,
                                            -0.1f, -0.2f, -0.3f, -0.4f, -0.5f, -0.6f, -0.7f, -0.8f, -0.9f};
    private char[] operators = new char[]{'+','-','*','/','^'};
    private float epsilon = .00001f;
    private ExpressionBuilder expBuilder;

    public GeneticAlgorithm() {
        this.expBuilder = new ExpressionBuilder(operators, operands);
    }

    public GeneticAlgorithm(float[] operands) {
        this.operands = operands;
        this.expBuilder = new ExpressionBuilder(operators, operands);
    }

    Expression getExpression(LinkedHashMap<Float, Float> dataSet) throws InvalidExpressionInsertException, InvalidExpressionOperationException, AttemptLimitReachedException {
        try {
            int attempts = 0;

            while(true) {
                int generations = 0;
                ArrayList<Expression> population = expBuilder.generatePopulations(100);

                while(generations < 30) {
                    System.out.println("Attempt " + attempts + " : Generation " + generations);

                    population = mutate(crossOver(compete(population, dataSet)));
                    generations++;
                }

                if(attempts > 1000) {
                    break;
                }

                attempts++;
            }
        } catch (ExpressionFoundException e) {
            return e.getExpression();
        }

        throw new AttemptLimitReachedException();
    }

    private ArrayList<Expression> compete(ArrayList<Expression> expressions, LinkedHashMap<Float, Float> dataSet) throws InvalidExpressionOperationException, ExpressionFoundException {
        ArrayList<Expression> winners = new ArrayList<>();

        for (int x = 0; x < expressions.size() - 1; x += 2) {
            winners.add(determineWinner(expressions.get(x), expressions.get(x+1), dataSet));
        }

        return winners;
    }

    private Expression determineWinner(Expression exp1, Expression exp2, LinkedHashMap<Float, Float> dataSet) throws InvalidExpressionOperationException, ExpressionFoundException {
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

    char[] getOperators() {
        return this.operators;
    }

    float[] getOperands() {
        return this.operands;
    }
}