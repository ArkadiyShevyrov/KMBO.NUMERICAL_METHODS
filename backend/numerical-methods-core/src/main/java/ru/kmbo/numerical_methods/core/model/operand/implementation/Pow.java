package ru.kmbo.numerical_methods.core.model.operand.implementation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.kmbo.numerical_methods.core.calculate.BasicCalculate;
import ru.kmbo.numerical_methods.core.model.operand.Operand;

@Getter
public class Pow implements Operand {
    private final Operand base;

    private final Operand exp;

    @JsonCreator
    public Pow(
        @JsonProperty("base") Operand base,
        @JsonProperty("exp") Operand exp
    ) {
        this.base = base;
        this.exp = exp;
    }

    public Pow(Double base, Integer exp) {
        this.base = new Num(base);
        this.exp = new Num(exp);
    }

    public Pow(Operand base, Integer exp) {
        this.base = base;
        this.exp = new Num(exp);
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
        StringBuilder br = new StringBuilder();
        if (base instanceof Num || base instanceof Variable) {
            br.append(base);
        } else {
            br.append("(");
            br.append(base);
            br.append(")");
        }
        br.append("^");
        if (exp instanceof Num || exp instanceof Variable) {
            br.append(exp);
        } else {
            br.append("(");
            br.append(exp);
            br.append(")");
        }
        return br.toString();

    }
}
