package ru.kmbo.numerical_methods.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivativeStrategy;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Neg;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;

public class NegDerivativeStrategy extends OperandDerivativeStrategy {

    public NegDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand, Variable diffVariable) {
        Neg neg = (Neg) operand;
        return differentiate(neg, diffVariable);
    }

    private Operand differentiate(Neg neg, Variable diffVariable) {
        return new Neg(derivative.differentiate(neg.getOperand(), diffVariable));
    }
}
