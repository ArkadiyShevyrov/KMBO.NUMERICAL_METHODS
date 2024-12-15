package ru.kmbo.numerical_methods.calculate.derivative.operand;

import ru.kmbo.numerical_methods.model.operand.Operand;

public class DefaultOperandDerivative implements OperandDerivative {
    private final OperandDerivativeRegistry registry = new OperandDerivativeRegistry(this);

    @Override
    public Operand differentiate(Operand operand) {
        if (operand == null) return null;
        return registry.getStrategy(operand.getClass()).differentiate(operand);
    }
}
