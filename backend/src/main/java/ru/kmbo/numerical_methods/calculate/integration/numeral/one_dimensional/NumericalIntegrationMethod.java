package ru.kmbo.numerical_methods.calculate.integration.numeral.one_dimensional;

import ru.kmbo.numerical_methods.model.function.Function;

public interface NumericalIntegrationMethod {

    Double integrate(Function f, double a, double b, double h);
    Double tolerance(Function f, double a, double b, double h);
}
