package ru.kmbo.numerical_methods.model.operand;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Num implements Operand {
    private Double number;

    public Num(Integer number) {
        this.number = Double.valueOf(number);
    }

    @Override
    public Double getResult() {
        return number;
    }
}
