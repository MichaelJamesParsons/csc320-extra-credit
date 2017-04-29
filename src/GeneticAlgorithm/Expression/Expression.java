package GeneticAlgorithm.Expression;

import java.util.LinkedList;
import java.util.ListIterator;

public class Expression {
    private LinkedList<IExpressionTerm> terms;
    private ExpressionEvaluator evaluator;

    public Expression() {
        this.terms = new LinkedList<IExpressionTerm>();
        this.evaluator = new ExpressionEvaluator();
    }

    ListIterator getIterator() {
        return terms.listIterator();
    }

    public boolean addTerm(IExpressionTerm term) throws InvalidExpressionInsertException {
        if(terms.size() > 0 && terms.getLast().getClass().equals(term.getClass())) {
            throw new InvalidExpressionInsertException();
        }

        return terms.add(term);
    }

    public float evaluate(float val) throws InvalidExpressionOperationException {
        return this.evaluator.evaluate(this, val);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for(IExpressionTerm term : this.terms) {
            result.append(term.getValue());
        }

        return result.toString();
    }
}
