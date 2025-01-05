package ru.kmbo.numerical_methods.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivativeStrategy;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.*;

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
