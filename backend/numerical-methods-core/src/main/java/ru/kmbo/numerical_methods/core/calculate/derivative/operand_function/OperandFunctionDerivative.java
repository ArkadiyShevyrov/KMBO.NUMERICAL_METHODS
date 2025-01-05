package ru.kmbo.numerical_methods.core.calculate.derivative.operand_function;

import lombok.experimental.UtilityClass;
import ru.kmbo.numerical_methods.core.calculate.derivative.operand.DefaultOperandDerivative;
import ru.kmbo.numerical_methods.core.calculate.derivative.operand.OperandDerivative;
import ru.kmbo.numerical_methods.core.model.function.implementation.OperandFunction;

@UtilityClass
public class OperandFunctionDerivative {
    private final OperandDerivative defaultOperandDerivative = new DefaultOperandDerivative();

    public OperandFunction differentiate(OperandFunction operandFunction) {
        return new OperandFunction(
            defaultOperandDerivative.differentiate(
                operandFunction.getOperand(), operandFunction.getVariable()
            ),
            operandFunction.getVariable()
        );
    }
}
