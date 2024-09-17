package ru.kmbo.numerical_methods.model.function;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.kmbo.numerical_methods.model.operand.Operand;
import ru.kmbo.numerical_methods.model.operand.Variable;

@Getter
@AllArgsConstructor
public class Function {
    private Operand operand;
    private Variable variable;

    public Double apply(Double x) {
        variable.setVar(x);
        Double result = operand.getResult();
        variable.setVar(null);
        return result;
    }
}
