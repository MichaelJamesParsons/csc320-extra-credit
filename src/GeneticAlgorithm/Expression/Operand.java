package GeneticAlgorithm.Expression;

public class Operand implements IExpressionTerm {
    private float value;

    public Operand(float value) {
        this.value = value;
    }

    @Override
    public Float getValue() {
        return value;
    }
}
