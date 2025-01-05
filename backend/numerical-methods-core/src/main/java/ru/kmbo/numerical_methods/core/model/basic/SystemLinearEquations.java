package ru.kmbo.numerical_methods.core.model.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SystemLinearEquations {
    private Matrix A;
    private Vector B;

    @Override
    public String toString() {
        return "SystemLinearEquations{\n" +
            "A=" + A + ",\n" +
            "B=" + B + "\n" +
            '}';
    }
}

