package ru.kmbo.numerical_methods.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.calculate.optimize.operand.OperandOptimizationStrategy;
import ru.kmbo.numerical_methods.model.operand.Operand;

public class UnsupportedOperandStrategy extends OperandOptimizationStrategy {
    public UnsupportedOperandStrategy() {
        super(null);
    }

    @Override
    public Operand optimize(Operand operand) {
        throw new UnsupportedOperationException("No strategy found for type: " + operand.getClass().getName());
    }
}
