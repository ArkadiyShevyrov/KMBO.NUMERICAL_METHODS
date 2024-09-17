package ru.kmbo.numerical_methods.model.operand;

import lombok.Getter;
import ru.kmbo.numerical_methods.calculate.BasicCalculate;

@Getter
public class Pow implements Operand {
    private final Operand base;

    private final Operand exp;

    public Pow(Double base, Integer exp) {
        this.base = new Num(base);
        this.exp = new Num(exp);
    }

    public Pow(Operand base, Integer exp) {
        this.base = base;
        this.exp = new Num(exp);
    }

    public Pow(Operand base, Operand exp) {
        this.base = base;
        this.exp = exp;
    }

    public Pow(Double base, Double exp) {
        this.base = new Num(base);
        this.exp = new Num(exp);
    }

    public Pow(Operand base, Double exp) {
        this.base = base;
        this.exp = new Num(exp);
    }

    @Override
    public Double getResult() {
        return BasicCalculate.pow(base.getResult(), exp.getResult());
    }

    @Override
    public String toString() {
        return "((" + base + ")^" + exp + ')';
    }
}
