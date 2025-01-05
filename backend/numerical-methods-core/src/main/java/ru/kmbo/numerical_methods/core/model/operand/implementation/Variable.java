package ru.kmbo.numerical_methods.core.model.operand.implementation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import ru.kmbo.numerical_methods.core.model.operand.Operand;

public class Variable implements Operand {
    @Getter
    private final String name;
    @Setter
    private Double var;

    @JsonCreator
    public Variable(@JsonProperty("name") String name) {
        this.name = name;
    }

    @Override
    public Double getResult() {
        return var;
    }

    @Override
    public String toString() {
        return var == null ? name : var.toString();
    }
}
