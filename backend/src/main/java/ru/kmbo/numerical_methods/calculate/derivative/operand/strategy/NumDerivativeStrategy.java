package ru.kmbo.numerical_methods.calculate.derivative.operand.strategy;

import ru.kmbo.numerical_methods.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Num;
import java.util.ArrayList;
import java.util.List;

public class NumDerivativeStrategy extends OperandDerivativeStrategy {

    public NumDerivativeStrategy(OperandDerivative derivative) {
        super(derivative);
    }

    @Override
    public Operand differentiate(Operand operand) {
        Num num = (Num) operand;
        return differentiate(num);
    }

    private Operand differentiate(Num num) {
        return new Num(0.);
    }
}
