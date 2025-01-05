package ru.kmbo.numerical_methods.core.model.operand.implementation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.kmbo.numerical_methods.core.calculate.TaylorCalculate;
import ru.kmbo.numerical_methods.core.model.operand.Operand;

@Getter
public class Sin implements Operand {
    private final Operand operand;

    @JsonCreator
    public Sin(@JsonProperty("operand") Operand operand) {
        this.operand = operand;
    }

    @Override
    public Double getResult() {
        return TaylorCalculate.sin(operand.getResult());
    }

    @Override
    public String toString() {
        return "sin" + "(" + operand + ")";
    }
}
