package ru.kmbo.numerical_methods.model.operand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.kmbo.numerical_methods.calculate.TaylorCalculate;

@Getter
@AllArgsConstructor
public class Sin implements Operand {
    private final Operand operand;

    @Override
    public Double getResult() {
        return TaylorCalculate.sin(operand.getResult());
    }

    @Override
    public String toString() {
        return "sin" + "(" + operand + ")";
    }
}
