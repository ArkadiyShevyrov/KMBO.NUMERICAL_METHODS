package ru.kmbo.numerical_methods.model.operand;

import lombok.AllArgsConstructor;
import ru.kmbo.numerical_methods.calculate.TaylorCalculate;

@AllArgsConstructor
public class Exp implements Operand {
    private Operand operand;

    public Exp() {
        this.operand = new Number();
    }

    @Override
    public Double getResult() {
        return TaylorCalculate.exp(operand.getResult());
    }

    @Override
    public Double getResult(Double arg) {
        return TaylorCalculate.exp(operand.getResult(arg));
    }
}
