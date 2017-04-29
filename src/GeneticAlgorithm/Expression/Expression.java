package GeneticAlgorithm.Expression;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Expression {
    private LinkedList<IExpressionTerm> terms;
    private ExpressionEvaluator evaluator;

    public Expression() {
        this.terms = new LinkedList<>();
        this.evaluator = new ExpressionEvaluator();
    }

    ListIterator getIterator() {
        return terms.listIterator();
    }

    public void addTerm(IExpressionTerm term) throws InvalidExpressionInsertException {
        if(terms.size() > 0 && terms.getLast().getClass().equals(term.getClass())) {
            int a = 0;
            throw new InvalidExpressionInsertException();
        }

        terms.add(term);
    }

    public IExpressionTerm get(int index) {
        return terms.get(index);
    }

    public IExpressionTerm set(int index, IExpressionTerm term) {
        return terms.set(index, term);
    }

    public void remove(int index) {
        terms.remove(index);
    }

    public int getSize() {
        return terms.size();
    }

    public float evaluate(float val) throws InvalidExpressionOperationException {
        return this.evaluator.evaluate(this, val);
    }

    public Expression deepClone() throws InvalidExpressionInsertException {
        Expression exp = new Expression();
        Iterator iterator = this.getIterator();

        while(iterator.hasNext()) {
            IExpressionTerm t = (IExpressionTerm)iterator.next();
            IExpressionTerm clone;

            if(t instanceof Operator) {
                clone = new Operator((Character)t.getValue());
            } else if(t instanceof VariableOperand) {
                clone = new VariableOperand((Character)t.getValue());
            } else {
                clone = new Operand((Float)t.getValue());
            }

            exp.addTerm(clone);
        }

        return exp;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for(IExpressionTerm term : this.terms) {
            result.append(term.getValue());
        }

        return result.toString();
    }
}
