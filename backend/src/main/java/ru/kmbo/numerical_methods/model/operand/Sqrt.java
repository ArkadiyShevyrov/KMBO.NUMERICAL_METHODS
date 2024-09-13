package ru.kmbo.numerical_methods.model.operand;

import lombok.AllArgsConstructor;
import ru.kmbo.numerical_methods.calculate.TaylorCalculate;

@AllArgsConstructor
public class Sqrt implements Operand {
    private Operand operand;

    public Sqrt() {
        this.operand = new Number();
    }

    @Override
    public Double getResult() {
        return Math.sqrt(operand.getResult());
    }

    @Override
    public Double getResult(Double arg) {
        return Math.sqrt(operand.getResult(arg));
    }
}
