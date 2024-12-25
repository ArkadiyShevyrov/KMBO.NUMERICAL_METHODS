package ru.kmbo.numerical_methods.model.operand.implementation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.kmbo.numerical_methods.calculate.TaylorCalculate;
import ru.kmbo.numerical_methods.model.operand.Operand;
import java.util.Objects;

@Getter
public class Ln implements Operand {
    private final Operand operand;

    @JsonCreator
    public Ln(@JsonProperty("operand") Operand operand) {
        this.operand = operand;
    }

    @Override
    public Double getResult() {
        return TaylorCalculate.ln(operand.getResult());
    }

    @Override
    public String toString() {
        return "ln" + "(" + operand + ")";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ln ln = (Ln) o;
        return Objects.equals(operand, ln.operand);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(operand);
    }
}