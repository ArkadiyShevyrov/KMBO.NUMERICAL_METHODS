package ru.kmbo.numerical_methods.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.calculate.optimize.operand.OperandOptimizationStrategy;
import ru.kmbo.numerical_methods.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Ln;

public class LnOptimizationStrategy extends OperandOptimizationStrategy {

    public LnOptimizationStrategy(OperandOptimizer optimizer) {
        super(optimizer);
    }

    @Override
    public Operand optimize(Operand operand) {
        Ln ln = (Ln) operand;
        return optimize(ln);
    }

    private Operand optimize(Ln ln) {
        return new Ln(optimizer.optimize(ln.getOperand()));
    }
}
