package ru.kmbo.numerical_methods.model.operand;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

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
        return "-" + operand.toString();
    }
}
