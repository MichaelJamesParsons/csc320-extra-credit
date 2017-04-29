package GeneticAlgorithm;

import GeneticAlgorithm.Expression.Expression;
import GeneticAlgorithm.Expression.InvalidExpressionInsertException;
import GeneticAlgorithm.Expression.InvalidExpressionOperationException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GeneticAlgorithm {

    public float[] operands = new float[]{1f, .9f, .8f, .7f, .6f, .5f, .4f, .3f, .2f, .1f, 0f,
                                            -0.1f, -0.2f, -0.3f, -0.4f, -0.5f, -0.6f, -0.7f, -0.8f, -0.9f};
    public char[] operators = new char[]{'+','-','*','/','^'};

    private ExpressionBuilder expBuilder;

    public GeneticAlgorithm() {
        this.expBuilder = new ExpressionBuilder(operators, operands);
    }

    public String getExpression(LinkedHashMap<Float, Float> dataSet) throws InvalidExpressionInsertException, InvalidExpressionOperationException {
        ArrayList<Expression> population = expBuilder.generatePopulations(100);
        compete(population, dataSet);

        return "";
    }

    private ArrayList<Expression> compete(ArrayList<Expression> expressions, LinkedHashMap<Float, Float> dataSet) throws InvalidExpressionOperationException {
        ArrayList<Expression> winners = new ArrayList<>();

        for (int x = 0; x < expressions.size() / 2; x++) {
            winners.add(determineWinner(expressions.get(x), expressions.get(x+1), dataSet));
        }

        return winners;
    }

    private Expression determineWinner(Expression exp1, Expression exp2, LinkedHashMap<Float, Float> dataSet) throws InvalidExpressionOperationException {
        float exp1Sum = 0;
        float exp2Sum = 0;

        for(Map.Entry<Float, Float> k : dataSet.entrySet()) {
            exp1Sum += Math.pow(exp1.evaluate(k.getValue()) - dataSet.get(k.getKey()), 2);
            exp2Sum += Math.pow(exp2.evaluate(k.getValue()) - dataSet.get(k.getKey()), 2);
        }

        return (exp1Sum < exp2Sum) ? exp1 : exp2;
    }

    private ArrayList<Expression> crossOver(ArrayList<Expression> expressions) {

        return expressions;
    }

    private ArrayList<Expression> mutate(ArrayList<Expression> expressions) {

        return expressions;
    }
}