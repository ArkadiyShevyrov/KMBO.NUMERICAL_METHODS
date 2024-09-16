package ru.kmbo.numerical_methods.model.function;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class Polynomial {
    private List<Double> coefficients;
}
