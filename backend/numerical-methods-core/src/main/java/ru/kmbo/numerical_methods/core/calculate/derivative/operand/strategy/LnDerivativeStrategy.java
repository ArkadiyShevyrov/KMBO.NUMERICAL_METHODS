package ru.kmbo.numerical_methods.core.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.core.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.core.calculate.derivative.operand.OperandDerivativeStrategy;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.*;

public class LnDerivativeStrategy extends OperandDerivativeStrategy {

    public LnDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand, Variable diffVariable) {
        Ln ln = (Ln) operand;
        return differentiate(ln, diffVariable);
    }

    private Operand differentiate(Ln ln, Variable diffVariable) {
        return new Multiply(
            new Pow(ln.getOperand(), new Neg(new Num(1))),
            derivative.differentiate(ln.getOperand(), diffVariable)
        );
    }
}
