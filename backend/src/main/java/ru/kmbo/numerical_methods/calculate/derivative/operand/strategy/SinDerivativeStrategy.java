package ru.kmbo.numerical_methods.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Cos;
import ru.kmbo.numerical_methods.model.operand.implementation.Multiply;
import ru.kmbo.numerical_methods.model.operand.implementation.Sin;

public class SinDerivativeStrategy extends OperandDerivativeStrategy {

    public SinDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand) {
        Sin sin = (Sin) operand;
        return differentiate(sin);
    }

    private Operand differentiate(Sin sin) {
        return new Multiply(
                new Cos(sin.getOperand()),
                derivative.differentiate(sin.getOperand())
        );
    }
}
