package GeneticAlgorithm.Expression;

import java.util.ListIterator;
import java.util.Stack;

public class ExpressionEvaluator {

    public float evaluate(Expression exp, float val) throws InvalidExpressionOperationException {
        Stack<IExpressionTerm> s = new Stack<>();
        ListIterator iter = exp.getIterator();
        IExpressionTerm term;

        while(iter.hasNext()) {
            term = (IExpressionTerm)iter.next();

            if(term instanceof Operator || s.empty()) {
                s.push(term);
            } else {
                Operator op = (Operator)s.pop();
                float t1 = getValueFromOperand(s.pop(), val);
                float t2 = getValueFromOperand(term, val);
                s.push(new Operand(
                    evaluate(t1, t2, op.getValue())
                ));
            }
        }

        return (float)s.pop().getValue();
    }

    private float getValueFromOperand(IExpressionTerm op, float variableVal) {
        return (op instanceof VariableOperand) ? variableVal : (float) op.getValue();
    }

    private float evaluate(float x, float y, char op) throws InvalidExpressionOperationException {
        switch (op) {
            case '*':
                return x*y;
            case '+':
                return x+y;
            case '-':
                return x-y;
            case '/':
                return x/y;
            case '^':
                return (float) Math.pow(x, y);
        }

        throw new InvalidExpressionOperationException();
    }
}
