package ru.kmbo.numerical_methods.model.operand.implementation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.kmbo.numerical_methods.calculate.TaylorCalculate;
import ru.kmbo.numerical_methods.model.operand.Operand;

@Getter
public class Cos implements Operand {
    private final Operand operand;

    @JsonCreator
    public Cos(@JsonProperty("operand") Operand operand) {
        this.operand = operand;
    }

    @Override
    public Double getResult() {
        return TaylorCalculate.cos(operand.getResult());
    }

    @Override
    public String toString() {
        return "cos" + "(" + operand + ")";
    }
}
