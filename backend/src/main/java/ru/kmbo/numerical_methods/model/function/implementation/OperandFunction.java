package ru.kmbo.numerical_methods.model.function.implementation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.kmbo.numerical_methods.model.function.Function;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.implementation.Variable;
import ru.kmbo.numerical_methods.util.OperandUtils;

@Getter
@AllArgsConstructor
public class OperandFunction implements Function {
    private Operand operand;
    private Variable variable;

    @Override
    public Double apply(Double x) {
        OperandUtils.setOperand(variable, operand, x);
        Double result = operand.getResult();
        OperandUtils.setOperand(variable, operand, null);
        return result;
    }
}
