package ru.kmbo.numerical_methods.model.function;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.Variable;
import ru.kmbo.numerical_methods.util.OperandUtils;

@Getter
@AllArgsConstructor
public class Function {
    private Operand operand;
    private Variable variable;

    public Double apply(Double x) {
        OperandUtils.setOperand(variable, operand, x);
        Double result = operand.getResult();
        OperandUtils.setOperand(variable, operand, null);
        return result;
    }
}
