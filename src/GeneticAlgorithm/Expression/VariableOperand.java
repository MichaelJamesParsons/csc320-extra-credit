package GeneticAlgorithm.Expression;

public class VariableOperand implements IExpressionTerm {
    private Character value;

    public VariableOperand() {
        this('x');
    }

    public VariableOperand(Character value) {
        this.value = value;
    }

    @Override
    public Character getValue() {
        return this.value;
    }
}
