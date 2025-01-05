package ru.kmbo.numerical_methods.core.model.function;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.kmbo.numerical_methods.core.model.basic.Vector;

@Getter
@AllArgsConstructor
public class Polynomial {
    private Vector coefficients;

    @Override
    public String toString() {
        return "Polynomial{\n" +
            "coefficients=" + coefficients + "\n" +
            '}';
    }
}
