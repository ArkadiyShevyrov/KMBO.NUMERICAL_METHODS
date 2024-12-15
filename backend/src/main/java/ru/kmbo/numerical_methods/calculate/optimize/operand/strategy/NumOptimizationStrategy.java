package ru.kmbo.numerical_methods.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Num;

public class NumOptimizationStrategy extends OperandOptimizationStrategy {

    public NumOptimizationStrategy(OperandOptimizer optimizer) {
        super(optimizer);
    }

    @Override
    public Operand optimize(Operand operand) {
        Num num = (Num) operand;
        return optimize(num);
    }

    private Operand optimize(Num num) {
        return num;
    }
}
