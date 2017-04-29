package GeneticAlgorithm.Expression;

public class Operator implements IExpressionTerm{
    private Character value;

    public Operator(char value) {
        this.value = value;
    }

    @Override
    public Character getValue() {
        return value;
    }
}
