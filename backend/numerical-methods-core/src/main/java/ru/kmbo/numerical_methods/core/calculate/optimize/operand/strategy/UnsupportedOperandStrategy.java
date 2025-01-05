package ru.kmbo.numerical_methods.core.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizationStrategy;
import ru.kmbo.numerical_methods.core.model.operand.Operand;

public class UnsupportedOperandStrategy extends OperandOptimizationStrategy {
    public UnsupportedOperandStrategy() {
        super(null);
    }

    @Override
    public Operand optimize(Operand operand) {
        throw new UnsupportedOperationException("No strategy found for type: " + operand.getClass().getName());
    }
}
