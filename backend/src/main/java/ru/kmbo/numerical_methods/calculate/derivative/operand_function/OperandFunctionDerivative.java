package ru.kmbo.numerical_methods.calculate.derivative.operand_function;

import lombok.experimental.UtilityClass;
import ru.kmbo.numerical_methods.calculate.derivative.operand.DefaultOperandDerivative;
import ru.kmbo.numerical_methods.calculate.optimize.operand.DefaultOperandOptimizer;
import ru.kmbo.numerical_methods.model.function.implementation.OperandFunction;

@UtilityClass
public class OperandFunctionDerivative {
    private final DefaultOperandDerivative defaultOperandDerivative = new DefaultOperandDerivative();
    private final DefaultOperandOptimizer defaultOperandOptimizer = new DefaultOperandOptimizer();

    public OperandFunction differentiate(OperandFunction operandFunction) {
        return new OperandFunction(
                defaultOperandOptimizer.optimize(
                        defaultOperandDerivative.differentiate(operandFunction.getOperand())),
                operandFunction.getVariable());
    }
}