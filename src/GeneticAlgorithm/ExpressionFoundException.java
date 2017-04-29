package GeneticAlgorithm;

import GeneticAlgorithm.Expression.Expression;

class ExpressionFoundException extends Exception {
    private Expression expression;

    ExpressionFoundException(Expression expression) {
        this.expression = expression;
    }

    Expression getExpression() {
        return this.expression;
    }
}
