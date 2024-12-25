package ru.kmbo.numerical_methods.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivativeStrategy;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Cos;
import ru.kmbo.numerical_methods.model.operand.implementation.Multiply;
import ru.kmbo.numerical_methods.model.operand.implementation.Neg;
import ru.kmbo.numerical_methods.model.operand.implementation.Sin;

public class CosDerivativeStrategy extends OperandDerivativeStrategy {

    public CosDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand) {
        Cos cos = (Cos) operand;
        return differentiate(cos);
    }

    private Operand differentiate(Cos cos) {
        return new Neg(
                new Multiply(
                        new Sin(cos.getOperand()),
                        derivative.differentiate(cos.getOperand())
                )
        );
    }
}
