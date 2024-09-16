package ru.kmbo.numerical_methods.model.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FunctionalOption {
    private double xMin;
    private double xMax;
    private double step;
}
