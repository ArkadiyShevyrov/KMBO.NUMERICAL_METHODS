package ru.kmbo.numerical_methods.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivativeStrategy;
import ru.kmbo.numerical_methods.model.operand.Operand;

public class UnsupportedOperandStrategy extends OperandDerivativeStrategy {
    public UnsupportedOperandStrategy() {
        super(null);
    }

    @Override
    public Operand differentiate(Operand operand) {
        throw new UnsupportedOperationException("No strategy found for type: " + operand.getClass().getName());
    }
}
