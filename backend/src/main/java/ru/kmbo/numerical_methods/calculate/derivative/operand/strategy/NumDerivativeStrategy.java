package ru.kmbo.numerical_methods.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivativeStrategy;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Num;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;

public class NumDerivativeStrategy extends OperandDerivativeStrategy {

    public NumDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand, Variable diffVariable) {
        return differentiate();
    }

    private Operand differentiate() {
        return new Num(0.);
    }
}
