package ru.kmbo.numerical_methods.calculate.integration.numeral.one_dimensional.method;

import ru.kmbo.numerical_methods.calculate.BasicCalculate;
import ru.kmbo.numerical_methods.calculate.DerivativeCalculate;
import ru.kmbo.numerical_methods.calculate.integration.numeral.one_dimensional.NumericalIntegrationMethod;
import ru.kmbo.numerical_methods.model.function.implementation.OperandFunction;
import java.util.HashMap;
import java.util.Map;

public class TrapezoidalMethod implements NumericalIntegrationMethod {
    @Override
    public Double integrate(OperandFunction f, double a, double b, double h) {
        int N = (int) ((b - a) / h);
        Map<Integer, Double> xMap = new HashMap<>();
        for (int i = 0; i <= N; i++) {
            xMap.put(i, a + i * h);
        }
        double y_0 = f.apply(xMap.get(0));
        double y_N = f.apply(xMap.get(N));
        double y_i = bigSum(f, 1, N - 1, xMap);
        return h * (((y_0 + y_N) / 2) + y_i);
    }

    @Override
    public Double tolerance(OperandFunction f, double a, double b, double h) {
        double bFirstDerivative = DerivativeCalculate.derivative(f, b, 1);
        double aFirstDerivative = DerivativeCalculate.derivative(f, a, 1);
        return Math.abs(((b - a) / 12) * BasicCalculate.pow(h, 2) * (bFirstDerivative - aFirstDerivative));
    }

    private double bigSum(OperandFunction f, int iStart, int iEnd, Map<Integer, Double> xMap) {
        double sum = 0;
        for (int i = iStart; i <= iEnd; i++) {
            sum += f.apply(xMap.get(i));
        }
        return sum;
    }
}
