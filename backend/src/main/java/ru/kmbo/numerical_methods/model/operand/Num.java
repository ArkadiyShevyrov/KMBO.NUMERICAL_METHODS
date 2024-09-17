package ru.kmbo.numerical_methods.model.operand;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Num implements Operand {
    private final Double num;

    public Num(Integer num) {
        this.num = Double.valueOf(num);
    }

    @Override
    public Double getResult() {
        return num;
    }

    @Override
    public String toString() {
        return num.toString();
    }
}
