package ru.kmbo.numerical_methods.model.operand;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class Variable implements Operand {
    private Double var;

    @Override
    public Double getResult() {
        return var;
    }

    @Override
    public String toString() {
        return var == null ? "x" : var.toString();
    }
}
