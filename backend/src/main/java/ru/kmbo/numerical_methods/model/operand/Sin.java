package ru.kmbo.numerical_methods.model.operand;

import lombok.AllArgsConstructor;
import ru.kmbo.numerical_methods.calculate.TaylorCalculate;

@AllArgsConstructor
public class Sin implements Operand {
    private Operand operand;

    public Sin() {
        this.operand = new Number();
    }

    @Override
    public Double getResult() {
        return TaylorCalculate.sin(operand.getResult());
    }

    @Override
    public Double getResult(Double arg) {
        return TaylorCalculate.sin(operand.getResult(arg));
    }
}
