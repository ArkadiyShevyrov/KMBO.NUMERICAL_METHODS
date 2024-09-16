package ru.kmbo.numerical_methods.model.operand;

import lombok.AllArgsConstructor;
import ru.kmbo.numerical_methods.calculate.TaylorCalculate;

@AllArgsConstructor
public class Exp implements Operand {
    private Operand operand;

    public Exp() {
        this.operand = new Num();
    }

    @Override
    public Double getResult() {
        return TaylorCalculate.exp(operand.getResult());
    }
}
