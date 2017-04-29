package GeneticAlgorithm;

import GeneticAlgorithm.Expression.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class GeneticAlgorithm {

    public float[] operands = new float[]{1f, .9f, .8f, .7f, .6f, .5f, .4f, .3f, .2f, .1f, 0f,
                                            -0.1f, -0.2f, -0.3f, -0.4f, -0.5f, -0.6f, -0.7f, -0.8f, -0.9f};
    public char[] operators = new char[]{'+','-','*','/','^'};

    public float epsilon = .00001f;

    private ExpressionBuilder expBuilder;

    public GeneticAlgorithm() {
        this.expBuilder = new ExpressionBuilder(operators, operands);
    }

    public String getExpression(LinkedHashMap<Float, Float> dataSet) throws InvalidExpressionInsertException, InvalidExpressionOperationException, AttemptLimitReachedException {
        try {
            int attempts = 0;

            while(true) {
                int generations = 0;
                ArrayList<Expression> population = expBuilder.generatePopulations(100);

                while(generations < 30) {
                    population = mutate(crossOver(compete(population, dataSet)));
                    generations++;
                }

                if(attempts > 1000) {
                    break;
                }

                attempts++;
            }
        } catch (ExpressionFoundException e) {
            return e.getExpression().toString();
        }

        throw new AttemptLimitReachedException();
    }

    private ArrayList<Expression> compete(ArrayList<Expression> expressions, LinkedHashMap<Float, Float> dataSet) throws InvalidExpressionOperationException, ExpressionFoundException {
        ArrayList<Expression> winners = new ArrayList<>();

        for (int x = 0; x < expressions.size(); x += 2) {
            winners.add(determineWinner(expressions.get(x), expressions.get(x+1), dataSet));
        }

        return winners;
    }

    private Expression determineWinner(Expression exp1, Expression exp2, LinkedHashMap<Float, Float> dataSet) throws InvalidExpressionOperationException, ExpressionFoundException {
        float exp1Sum = 0;
        float exp2Sum = 0;

        for(Map.Entry<Float, Float> k : dataSet.entrySet()) {
            exp1Sum += Math.pow(exp1.evaluate(k.getValue()) - dataSet.get(k.getKey()), 2);
            exp2Sum += Math.pow(exp2.evaluate(k.getValue()) - dataSet.get(k.getKey()), 2);
        }

        float minValue = (exp1Sum < exp2Sum) ? exp1Sum : exp2Sum;
        Expression minExp = (exp1Sum < exp2Sum) ? exp1 : exp2;

        if(minValue < epsilon) {
            throw new ExpressionFoundException(minExp);
        }

        return minExp;
    }

    private ArrayList<Expression> crossOver(ArrayList<Expression> expressions) {
        for(int x = 0; x < expressions.size(); x += 2) {
            OperandCrossover.crossoverByReference(expressions.get(x),expressions.get(x+1));
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
        }

        return expressions;
    }
}