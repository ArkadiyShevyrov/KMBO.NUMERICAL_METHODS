package ru.kmbo.numerical_methods.labs.service;

import org.springframework.stereotype.Service;
import ru.kmbo.numerical_methods.core.calculate.integration.numeral.one_dimensional.NumericalIntegration;
import ru.kmbo.numerical_methods.core.model.function.implementation.OperandFunction;
import ru.kmbo.numerical_methods.core.util.RoundUtils;

@Service
public class Lab_1_6_Service {

    public Double integrate(
        OperandFunction f,
        Double a, Double b, Double h,
        NumericalIntegration.TypeMethod typeMethod
    ) {
        return NumericalIntegration.integrate(f, a, b, h, typeMethod);
    }

    public Double tolerance(
        OperandFunction f,
        Double a, Double b, Double h,
        NumericalIntegration.TypeMethod typeMethod
    ) {
        Double tolerance = NumericalIntegration.tolerance(f, a, b, h, typeMethod);
        return RoundUtils.roundToPrecision(tolerance, 1e-13);
    }
}
