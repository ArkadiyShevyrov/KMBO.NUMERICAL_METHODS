package ru.kmbo.numerical_methods.core.calculate.integration.numeral.one_dimensional;

import ru.kmbo.numerical_methods.core.model.function.implementation.OperandFunction;

public interface NumericalIntegrationMethod {

    Double integrate(OperandFunction f, double a, double b, double h);

    Double tolerance(OperandFunction f, double a, double b, double h);
}
