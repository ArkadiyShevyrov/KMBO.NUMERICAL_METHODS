package ru.kmbo.numerical_methods.model.operand.implementation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.kmbo.numerical_methods.model.operand.Operand;

@Getter
@AllArgsConstructor
public class Num implements Operand {
    private final Double num;

    @JsonCreator
    public Num(@JsonProperty("num") Integer num) {
        this.num = Double.valueOf(num);
    }

    @Override
    public Double getResult() {
        return num;
    }

    @Override
    public String toString() {
        return num.toString();
    }
}
