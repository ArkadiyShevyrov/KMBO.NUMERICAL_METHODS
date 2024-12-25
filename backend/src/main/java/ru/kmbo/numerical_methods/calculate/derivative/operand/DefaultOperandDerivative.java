package ru.kmbo.numerical_methods.calculate.derivative.operand;

import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;

public class DefaultOperandDerivative implements OperandDerivative {
    private final OperandDerivativeRegistry registry = new OperandDerivativeRegistry(this);

    @Override
    public Operand differentiate(Operand operand, Variable diffVariable) {
        return registry.getStrategy(operand.getClass()).differentiate(operand, diffVariable);
    }
}
