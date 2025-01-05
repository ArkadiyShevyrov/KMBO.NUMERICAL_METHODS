package ru.kmbo.numerical_methods.core.calculate.derivative.operand;

import ru.kmbo.numerical_methods.core.model.operand.Operand;
import ru.kmbo.numerical_methods.core.model.operand.implementation.Variable;

public interface OperandDerivative {
    Operand differentiate(Operand operand, Variable diffVariable);
}
