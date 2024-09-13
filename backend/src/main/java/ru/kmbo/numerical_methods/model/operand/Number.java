package ru.kmbo.numerical_methods.model.operand;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Number implements Operand {
    private Double number;

    public Number(Integer number) {
        this.number = Double.valueOf(number);
    }

    @Override
    public Double getResult() {
        return number;
    }

    @Override
    public Double getResult(Double arg) {
        return arg;
    }
}
