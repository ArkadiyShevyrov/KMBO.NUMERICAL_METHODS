package ru.kmbo.numerical_methods.core.calculate.derivative.operand;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class OperandDerivativeStrategy implements OperandDerivative {
    protected final OperandDerivative derivative;
}

