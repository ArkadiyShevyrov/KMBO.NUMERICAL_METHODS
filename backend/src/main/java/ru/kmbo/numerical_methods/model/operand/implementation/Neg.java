package ru.kmbo.numerical_methods.model.operand.implementation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.kmbo.numerical_methods.model.operand.Operand;

@Getter
public class Neg implements Operand {
    private final Operand operand;

    @JsonCreator
    public Neg(@JsonProperty("operand") Operand operand) {
        this.operand = operand;
    }

    @Override
    public Double getResult() {
        return -operand.getResult();
    }

    @Override
    public String toString() {
        StringBuilder br = new StringBuilder();
        br.append("-");
        if (operand instanceof Num || operand instanceof Variable) {
            br.append(operand);
        } else {
            br.append("(");
            br.append(operand);
            br.append(")");
        }
        return br.toString();
    }
}
