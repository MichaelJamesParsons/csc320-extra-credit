package GeneticAlgorithm;

import GeneticAlgorithm.Expression.*;

import java.util.ArrayList;
import java.util.Random;

public class ExpressionBuilder {

    private Random random;
    private char[]  operators;
    private float[] operands;

    public ExpressionBuilder(char[] operators, float[] operands) {
        this.random = new Random();
        this.operators = operators;
        this.operands = operands;
    }

    public ArrayList<Expression> generatePopulations(int size) throws InvalidExpressionInsertException {
        ArrayList<Expression> expressions = new ArrayList<Expression>();

        for(int x = 0; x < size; x++) {
            expressions.add(generateExpression());
        }

        return expressions;
    }

    public Expression generateExpression() throws InvalidExpressionInsertException {
        Expression exp = new Expression();
        int length = this.random.nextInt(4) + 2;
        boolean containsX = false;
        int isX;
        int delta;

        for(int x = 0; x < length; x++) {
            delta = (containsX) ? 10 : calculateDelta(length, x);
            isX = this.random.nextInt(100) + 1;

            IExpressionTerm term;
            if(0 < isX && isX <= delta) {
                term = new VariableOperand();
                containsX = true;
            } else {
                term = new Operand(getRandomOperand());
            }

            exp.addTerm(term);

            if(x != length - 1) {
                exp.addTerm(new Operator(
                    getRandomOperator()
                ));
            }
        }

        return exp;
    }

    private int calculateDelta(int length, int iteration) {
        int offset = (length - iteration);
        return (offset > 0) ? 100 / offset : 100;
    }

    private char getRandomOperator() {
        int index = this.random.nextInt(this.operators.length);
        return this.operators[index];
    }

    private float getRandomOperand() {
        int index = this.random.nextInt(this.operators.length);
        return this.operands[index];
    }
}
