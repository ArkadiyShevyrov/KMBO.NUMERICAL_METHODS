package ru.kmbo.numerical_methods.core.model.operand.implementation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.kmbo.numerical_methods.core.model.operand.Operand;
import java.util.Objects;

@Getter
public class Num implements Operand {
    private final Double num;

    @JsonCreator
    public Num(@JsonProperty("num") Double num) {
        this.num = Double.valueOf(num);
    }

    public Num(Integer num) {
        this.num = Double.valueOf(num);
    }

    @Override
    public Double getResult() {
        return num;
    }

    @Override
    public String toString() {
        if (num % 1 == 0.) {
            return String.valueOf(num.intValue());
        }
        return num.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Num num1 = (Num) o;
        return Objects.equals(num, num1.num);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(num);
    }
}
