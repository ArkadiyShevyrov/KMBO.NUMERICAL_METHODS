package ru.kmbo.numerical_methods.calculate.optimize.operand;

import lombok.AllArgsConstructor;
import ru.kmbo.numerical_methods.model.operand.Operand;

@AllArgsConstructor
public abstract class OperandOptimizationStrategy {
    protected final OperandOptimizer optimizer;

    public abstract Operand optimize(Operand operand);
}

