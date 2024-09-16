package ru.kmbo.numerical_methods.model.operand;

import lombok.AllArgsConstructor;
import ru.kmbo.numerical_methods.calculate.TaylorCalculate;

@AllArgsConstructor
public class Cos implements Operand {
    private Operand operand;

    public Cos() {
        this.operand = new Num();
    }

    @Override
    public Double getResult() {
        return TaylorCalculate.cos(operand.getResult());
    }
}
