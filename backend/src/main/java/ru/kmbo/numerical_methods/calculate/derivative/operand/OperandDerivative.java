package ru.kmbo.numerical_methods.calculate.derivative.operand;

import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;

public interface OperandDerivative {
    Operand differentiate(Operand operand, Variable deffierintiationVariable);
}
