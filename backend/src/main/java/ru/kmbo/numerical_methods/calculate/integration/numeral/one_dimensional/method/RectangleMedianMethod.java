package ru.kmbo.numerical_methods.calculate.integration.numeral.one_dimensional.method;

import ru.kmbo.numerical_methods.calculate.BasicCalculate;
import ru.kmbo.numerical_methods.calculate.DerivativeCalculate;
import ru.kmbo.numerical_methods.calculate.integration.numeral.one_dimensional.NumericalIntegrationMethod;
import ru.kmbo.numerical_methods.model.function.implementation.OperandFunction;
import java.util.HashMap;
import java.util.Map;

public class RectangleMedianMethod implements NumericalIntegrationMethod {
    @Override
    public Double integrate(OperandFunction f, double a, double b, double h) {
        int N = (int) ((b - a) / h);
        Map<Integer, Double> xMap = new HashMap<>();
        for (int i = 0; i <= N; i++) {
            xMap.put(i, a + i * h);
        }
        double y_i = bigSumCustom(f, 0, N - 1, xMap);
        return h * y_i;
    }

    @Override
    public Double tolerance(OperandFunction f, double a, double b, double h) {
        double maxSecondDerivative = DerivativeCalculate.findMaxDerivative(f,2, a, b, h);
        return ((b - a) / 24) * BasicCalculate.pow(h, 1) * maxSecondDerivative;
    }

    private double bigSumCustom(OperandFunction f, int iStart, int iEnd, Map<Integer, Double> xMap) {
        double sum = 0;
        for (int i = iStart; i <= iEnd; i++) {
            sum += f.apply((xMap.get(i) + xMap.get(i + 1)) / 2);
        }
        return sum;
    }
}
