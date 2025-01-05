package ru.kmbo.numerical_methods.core.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizationStrategy;
import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Sin;

public class SinOptimizationStrategy extends OperandOptimizationStrategy {

    public SinOptimizationStrategy(OperandOptimizer optimizer) {
        super(optimizer);
    }

    @Override
    public Operand optimize(Operand operand) {
        Sin sin = (Sin) operand;
        return optimize(sin);
    }

    private Operand optimize(Sin sin) {
        return sin;
    }
}
