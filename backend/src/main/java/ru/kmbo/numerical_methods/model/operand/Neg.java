package ru.kmbo.numerical_methods.model.operand;

import lombok.Getter;

@Getter
public class Neg implements Operand {
    private final Operand neg;

    public Neg(Operand neg) {
        this.neg = neg;
    }

    @Override
    public Double getResult() {
        return -neg.getResult();
    }

    @Override
    public String toString() {
        return "-" + neg.toString();
    }
}
