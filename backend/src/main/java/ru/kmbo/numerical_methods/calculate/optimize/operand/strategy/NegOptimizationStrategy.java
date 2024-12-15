package ru.kmbo.numerical_methods.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Neg;

public class NegOptimizationStrategy extends OperandOptimizationStrategy {

    public NegOptimizationStrategy(OperandOptimizer optimizer) {
        super(optimizer);
    }

    @Override
    public Operand optimize(Operand operand) {
        Neg neg = (Neg) operand;
        return optimize(neg);
    }

    private Operand optimize(Neg neg) {
        return new Neg(optimizer.optimize(neg.getOperand()));
    }
}
