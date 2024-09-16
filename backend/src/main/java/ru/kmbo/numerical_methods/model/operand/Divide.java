package ru.kmbo.numerical_methods.model.operand;

public class Divide implements Operand {
    private Operand operand1;

    private Operand operand2;

    public Divide(Double o1, Double o2) {
        this.operand1 = new Num(o1);
        this.operand2 = new Num(o2);
    }

    public Divide(Double o1, Operand o2) {
        this.operand1 = new Num(o1);
        this.operand2 = o2;
    }

    public Divide(Operand o1, Double o2) {
        this.operand1 = o1;
        this.operand2 = new Num(o2);
    }

    public Divide(Operand o1, Operand o2) {
        this.operand1 = o1;
        this.operand2 = o2;
    }

    @Override
    public Double getResult() {
        return operand1.getResult() / operand2.getResult();
    }
}