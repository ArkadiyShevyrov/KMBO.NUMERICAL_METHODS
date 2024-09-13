package ru.kmbo.numerical_methods.model.operand;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Add implements Operand {
    private Operand operand1;

    private Operand operand2;

    @Override
    public Double getResult() {
        return operand1.getResult() + operand2.getResult();
    }

    @Override
    public Double getResult(Double arg) {
        return operand1.getResult(arg) + operand2.getResult(arg);
    }
}
