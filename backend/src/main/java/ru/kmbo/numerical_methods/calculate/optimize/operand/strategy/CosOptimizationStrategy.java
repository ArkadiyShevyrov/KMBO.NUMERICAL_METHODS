package ru.kmbo.numerical_methods.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.calculate.optimize.operand.OperandOptimizationStrategy;
import ru.kmbo.numerical_methods.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Cos;

public class CosOptimizationStrategy extends OperandOptimizationStrategy {

    public CosOptimizationStrategy(OperandOptimizer optimizer) {
        super(optimizer);
    }

    @Override
    public Operand optimize(Operand operand) {
        Cos cos = (Cos) operand;
        return optimize(cos);
    }

    private Operand optimize(Cos cos) {
        return new Cos(optimizer.optimize(cos.getOperand()));
    }
}
