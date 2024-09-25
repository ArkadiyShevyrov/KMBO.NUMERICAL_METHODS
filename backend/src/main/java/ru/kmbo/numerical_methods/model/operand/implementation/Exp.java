package ru.kmbo.numerical_methods.model.operand.implementation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.kmbo.numerical_methods.calculate.TaylorCalculate;
import ru.kmbo.numerical_methods.model.operand.Operand;

@Getter
public class Exp implements Operand {
    private final Operand operand;

    @JsonCreator
    public Exp(@JsonProperty("operand") Operand operand) {
        this.operand = operand;
    }

    @Override
    public Double getResult() {
        return TaylorCalculate.exp(operand.getResult());
    }
}
