package ru.kmbo.numerical_methods.calculate.optimize.operand;

import ru.kmbo.numerical_methods.model.operand.Operand;

public class DefaultOperandOptimizer implements OperandOptimizer {
    private final OperandOptimizerRegistry registry = new OperandOptimizerRegistry(this);

    @Override
    public Operand optimize(Operand operand) {
        if (operand == null) return null;
        return registry.getStrategy(operand.getClass()).optimize(operand);
    }
}
