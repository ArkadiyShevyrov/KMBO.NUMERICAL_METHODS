package ru.kmbo.numerical_methods.calculate.derivative.operand;

import ru.kmbo.numerical_methods.calculate.optimize.operand.DefaultOperandOptimizer;
import ru.kmbo.numerical_methods.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;

public class DefaultOperandDerivative implements OperandDerivative {
    private final OperandDerivativeRegistry registry = new OperandDerivativeRegistry(this);
    private final OperandOptimizer operandOptimizer = new DefaultOperandOptimizer();

    @Override
    public Operand differentiate(Operand operand, Variable diffVariable) {
        OperandDerivativeStrategy strategy = registry.getStrategy(operand.getClass());
        Operand differentiate = strategy.differentiate(operand, diffVariable);
        return operandOptimizer.optimize(differentiate);
    }
}
