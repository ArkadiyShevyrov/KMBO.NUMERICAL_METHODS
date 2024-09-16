package ru.kmbo.numerical_methods.model.operand;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Sqrt implements Operand {
    private Operand operand;

    @Override
    public Double getResult() {
        return Math.sqrt(operand.getResult());
    }
}
