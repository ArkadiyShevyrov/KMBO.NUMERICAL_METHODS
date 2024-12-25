package ru.kmbo.numerical_methods.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivativeStrategy;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.*;

public class CosDerivativeStrategy extends OperandDerivativeStrategy {

    public CosDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand, Variable diffVariable) {
        Cos cos = (Cos) operand;
        return differentiate(cos, diffVariable);
    }

    private Operand differentiate(Cos cos, Variable diffVariable) {
        return new Multiply(
                new Neg(new Sin(cos.getOperand())),
                derivative.differentiate(cos.getOperand(), diffVariable)
        );
    }
}
