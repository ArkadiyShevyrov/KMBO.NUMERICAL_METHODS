package ru.kmbo.numerical_methods.calculate.derivative.operand;

import lombok.AllArgsConstructor;
import ru.kmbo.numerical_methods.model.operand.Operand;

@AllArgsConstructor
public abstract class OperandDerivativeStrategy {
    protected final OperandDerivative derivative;

    public abstract Operand differentiate(Operand operand);
}

