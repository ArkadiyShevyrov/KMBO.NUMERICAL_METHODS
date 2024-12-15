package ru.kmbo.numerical_methods.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Neg;

public class NegDerivativeStrategy extends OperandDerivativeStrategy {

    public NegDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand) {
        Neg neg = (Neg) operand;
        return differentiate(neg);
    }

    private Operand differentiate(Neg neg) {
        return new Neg(derivative.differentiate(neg.getOperand()));
    }
}
