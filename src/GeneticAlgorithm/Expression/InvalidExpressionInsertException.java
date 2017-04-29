package GeneticAlgorithm.Expression;

public class InvalidExpressionInsertException extends Exception {
    public InvalidExpressionInsertException() {
        super("Expressions may not have two consecutive terms of the same type.");
    }
}
