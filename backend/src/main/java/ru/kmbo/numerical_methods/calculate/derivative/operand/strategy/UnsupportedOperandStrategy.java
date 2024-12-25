package ru.kmbo.numerical_methods.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivativeStrategy;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;

public class UnsupportedOperandStrategy extends OperandDerivativeStrategy {
    public UnsupportedOperandStrategy() {
        super(null);
    }

    @Override
    public Operand differentiate(Operand operand, Variable diffVariable) {
        throw new UnsupportedOperationException("No strategy found for type: " + operand.getClass().getName());
    }
}
