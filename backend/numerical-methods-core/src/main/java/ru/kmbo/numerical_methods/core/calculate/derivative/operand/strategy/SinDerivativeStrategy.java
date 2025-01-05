package ru.kmbo.numerical_methods.core.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.core.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.core.calculate.derivative.operand.OperandDerivativeStrategy;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Cos;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Multiply;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Sin;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;

public class SinDerivativeStrategy extends OperandDerivativeStrategy {

    public SinDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand, Variable diffVariable) {
        Sin sin = (Sin) operand;
        return differentiate(sin, diffVariable);
    }

    private Operand differentiate(Sin sin, Variable diffVariable) {
        return new Multiply(
            new Cos(sin.getOperand()),
            derivative.differentiate(sin.getOperand(), diffVariable)
        );
    }
}
