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
    public Operand differentiate(Operand operand, Variable deffierintiationVariable) {
        Neg neg = (Neg) operand;
        return differentiate(neg, deffierintiationVariable);
    }

    private Operand differentiate(Neg neg, Variable deffierintiationVariable) {
        return new Neg(derivative.differentiate(neg.getOperand(), deffierintiationVariable));
    }
}
