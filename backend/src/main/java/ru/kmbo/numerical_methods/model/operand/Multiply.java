package ru.kmbo.numerical_methods.model.operand;

public class Multiply implements Operand {
    private final Operand operand1;

    private final Operand operand2;

    public Multiply(Double o1, Double o2) {
        this.operand1 = new Num(o1);
        this.operand2 = new Num(o2);
    }

    public Multiply(Double o1, Operand o2) {
        this.operand1 = new Num(o1);
        this.operand2 = o2;
    }

    public Multiply(Operand o1, Double o2) {
        this.operand1 = o1;
        this.operand2 = new Num(o2);
    }

    public Multiply(Operand o1, Operand o2) {
        this.operand1 = o1;
        this.operand2 = o2;
    }

    @Override
    public Double getResult() {
        return operand1.getResult() * operand2.getResult();
    }
}