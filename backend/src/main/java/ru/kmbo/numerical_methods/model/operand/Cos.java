package ru.kmbo.numerical_methods.model.operand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.kmbo.numerical_methods.calculate.TaylorCalculate;

@Getter
@AllArgsConstructor
public class Cos implements Operand {
    private Operand operand;

    @Override
    public Double getResult() {
        return TaylorCalculate.cos(operand.getResult());
    }

    @Override
    public String toString() {
        return "cos" + "(" + operand + ")";
    }
}
