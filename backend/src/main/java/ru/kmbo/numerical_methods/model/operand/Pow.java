package ru.kmbo.numerical_methods.model.operand;

import ru.kmbo.numerical_methods.calculate.BasicCalculate;


public class Pow implements Operand {
    private Operand base;

    private Operand exp;

    public Pow(Double base, Integer exp) {
        this.base = new Num(base);
        this.exp = new Num(exp);
    }

    public Pow(Operand base, Integer exp) {
        this.base = base;
        this.exp = new Num(exp);
    }

    @Override
    public Double getResult() {
        return BasicCalculate.pow(base.getResult(), exp.getResult());
    }
}
