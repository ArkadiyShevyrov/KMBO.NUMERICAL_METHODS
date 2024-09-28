package ru.kmbo.numerical_methods.model.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SystemLinearEquations {
    private Matrix A;
    private Vector B;
}
