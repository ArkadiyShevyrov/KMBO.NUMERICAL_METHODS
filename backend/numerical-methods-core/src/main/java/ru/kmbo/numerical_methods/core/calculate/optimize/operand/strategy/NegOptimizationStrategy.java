package ru.kmbo.numerical_methods.core.calculate.optimize.operand.strategy;

import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizationStrategy;
import ru.kmbo.numerical_methods.core.calculate.optimize.operand.OperandOptimizer;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Neg;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Num;

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
        if (optimizedOperand instanceof Num optimizedNum) {
            if (optimizedNum.getNum() == 0.) {
                return optimizedNum;
            }
        } else if (optimizedOperand instanceof Neg optimizedNeg) {
            return optimizedNeg.getOperand();
        }
        return new Neg(optimizedOperand);
    }
}
