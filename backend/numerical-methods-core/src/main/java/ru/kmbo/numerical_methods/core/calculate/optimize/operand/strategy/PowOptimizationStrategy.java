package ru.kmbo.numerical_methods.core.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizationStrategy;
import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Num;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Pow;

public class PowOptimizationStrategy extends OperandOptimizationStrategy {

    public PowOptimizationStrategy(OperandOptimizer optimizer) {
        super(optimizer);
    }

    @Override
    public Operand optimize(Operand operand) {
        Pow pow = (Pow) operand;
        return optimize(pow);
    }

    private Operand optimize(Pow pow) {
        Operand optimizeBase = optimizer.optimize(pow.getBase());
        Operand optimizeExp = optimizer.optimize(pow.getExp());
        if (optimizeExp instanceof Num num) {
            if (num.getNum() == 0) {
                return new Num(1.);
            }
        }
        return new Pow(optimizeBase, optimizeExp);
    }
}
