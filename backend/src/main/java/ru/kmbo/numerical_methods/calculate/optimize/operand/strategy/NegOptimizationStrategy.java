package ru.kmbo.numerical_methods.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.calculate.optimize.operand.OperandOptimizationStrategy;
import ru.kmbo.numerical_methods.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Neg;
import ru.kmbo.numerical_methods.model.operand.implementation.Num;

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
        Operand optimizedOperand = optimizer.optimize(neg.getOperand());
        if (optimizedOperand instanceof Num num) {
            if (num.getNum() == 0.) {
                return num;
            }
        }
        return new Neg(optimizedOperand);
    }
}
