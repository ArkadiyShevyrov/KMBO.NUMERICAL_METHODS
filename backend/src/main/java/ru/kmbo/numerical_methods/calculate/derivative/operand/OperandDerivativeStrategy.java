package ru.kmbo.numerical_methods.calculate.derivative.operand;

import lombok.AllArgsConstructor;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;

@AllArgsConstructor
public abstract class OperandDerivativeStrategy implements OperandDerivative {
    protected final OperandDerivative derivative;
}

